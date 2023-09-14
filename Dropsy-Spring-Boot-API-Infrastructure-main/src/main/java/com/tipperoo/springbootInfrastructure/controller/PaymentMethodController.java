package com.tipperoo.springbootInfrastructure.controller;

import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.BankAccount;
import com.stripe.model.Card;
import com.stripe.model.ExternalAccount;
import com.stripe.param.AccountCreateParams;
import com.stripe.param.AccountUpdateParams;
import com.tipperoo.springbootInfrastructure.dao.Address;
import com.tipperoo.springbootInfrastructure.dao.PaymentMethod;
import com.tipperoo.springbootInfrastructure.dao.User;
import com.tipperoo.springbootInfrastructure.repos.PaymentMethodRepository;
import com.tipperoo.springbootInfrastructure.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping(path="/payment_method")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add/card")
    public @ResponseBody String addNewPaymentCard(@RequestParam Integer userId, @RequestParam String paymentCardToken,
                                                   @RequestParam String paymentEmail, @RequestBody Address customerAddress,
                                                  @RequestParam String phone, HttpServletRequest request) throws StripeException {
        Card card = (Card) addPaymentMethodToAccount(paymentCardToken, produceConnectedAccount(paymentEmail, userId,
                request.getRemoteAddr(), customerAddress, phone));
        PaymentMethod paymentMethod = addPaymentMethodToDB(card.getId(), userId, card.getName(), card.getBrand(), card.getLast4());
        return "Saved card with PaymentMethodId: " + paymentMethod.getPaymentMethodId();
    }

    @PostMapping(path="/add/bank")
    public @ResponseBody String addNewPaymentBank(@RequestParam Integer userId, @RequestParam String paymentBankToken,
                                                  @RequestParam String paymentEmail, @RequestBody Address customerAddress,
                                                  @RequestParam String phone, HttpServletRequest request) throws StripeException {
        BankAccount bankAccount = (BankAccount) addPaymentMethodToAccount(paymentBankToken,
                produceConnectedAccount(paymentEmail, userId, request.getRemoteAddr(), customerAddress, phone));
        PaymentMethod paymentMethod = addPaymentMethodToDB(bankAccount.getId(), userId, bankAccount.getAccountHolderName(),
                bankAccount.getBankName(), bankAccount.getLast4());
        return "Saved bank with PaymentMethodId: " + paymentMethod.getPaymentMethodId();
    }

    @DeleteMapping(path="/delete/{paymentMethodId}")
    public ResponseEntity<Object> deletePaymentMethod(@PathVariable String paymentMethodId, @RequestParam Integer userId) {
        try {
            String accountId = Objects.requireNonNull(userRepository.findById(userId).orElse(null)).getPaymentAccountId();
            Account account = Account.retrieve(accountId);
            ExternalAccount bankAccount = account.getExternalAccounts().retrieve(paymentMethodId);
            //Delete payment method in Stripe
            bankAccount.delete();
            //Delete payment method in our MySQL DB
            paymentMethodRepository.deleteById(paymentMethodId);
        } catch (EmptyResultDataAccessException | NullPointerException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deletion failed because entity not found: " + ex);
        } catch (StripeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Stripe failed with exception: " + ex);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete failed with exception: " + ex);
        }
        return ResponseEntity.ok("Deleted paymentMethod: " + paymentMethodId);
    }

    @GetMapping(path="/get/{id}")
    public @ResponseBody Optional<PaymentMethod> getPaymentMethod(@PathVariable String id) {
        return paymentMethodRepository.findById(id);
    }

    @GetMapping(path="/user/get/{userId}")
    public @ResponseBody Iterable<PaymentMethod> getPaymentMethodsByUserId(@PathVariable Integer userId) {
        Iterable<PaymentMethod> allPaymentMethods = paymentMethodRepository.findAll();
        List<PaymentMethod> searchResults = new ArrayList<>();
        for (PaymentMethod paymentMethod: allPaymentMethods) {
            if (paymentMethod.getUserId().equals(userId)) {
                searchResults.add(paymentMethod);
            }
        }
        return searchResults;
    }

    private Account produceConnectedAccount(String paymentEmail, Integer userId, String remoteAddr,
                                            Address customerAddress, String phone) throws StripeException {
        User user = userRepository.findById(userId).orElse(null);
        assert user != null;
        if (user.getPaymentAccountId() == null) {
            Map<String, Object> cardPayments = new HashMap<>();
            cardPayments.put("requested", true);
            Map<String, Object> transfers = new HashMap<>();
            transfers.put("requested", true);
            Map<String, Object> capabilities = new HashMap<>();
            capabilities.put("card_payments", cardPayments);
            capabilities.put("transfers", transfers);
            Map<String, Object> params = new HashMap<>();
            params.put("type", "custom");
            params.put("country", "US");
            params.put("email", paymentEmail);
            params.put("capabilities", capabilities);
            params.put("business_type", AccountCreateParams.BusinessType.INDIVIDUAL);
            Account account = Account.create(params);
            AccountUpdateParams accountUpdateParams = addCustomerPersonalInfoToAccount(customerAddress, phone,
                    remoteAddr, user.getFirstName(), user.getLastName(), user.getEmail());
            account = account.update(accountUpdateParams);
            user.setPaymentAccountId(account.getId());
            userRepository.save(user);
            return account;
        } else {
            return Account.retrieve(user.getPaymentAccountId());
        }
    }

    private AccountUpdateParams addCustomerPersonalInfoToAccount(Address newAddress, String phone, String remoteAddr,
                                                                 String firstName, String lastName, String email) {
        AccountUpdateParams.Individual.Address address = AccountUpdateParams.Individual.Address.builder()
                .setCity(newAddress.getCity()).setCountry(newAddress.getCountry().name())
                .setLine1(newAddress.getStreetAddress()).setLine2(newAddress.getStreetAddress2())
                .setPostalCode(newAddress.getZipcode()).setState(newAddress.getState().name()).build();
        AccountUpdateParams.Individual individual = new AccountUpdateParams.Individual.Builder().setAddress(address)
                .setDob(new AccountUpdateParams.Individual.Dob.Builder().setDay(13L).setMonth(6L).setYear(1996L).build())
                .setFirstName(firstName).setLastName(lastName).setEmail(email).setPhone(phone).build();
        AccountUpdateParams.BusinessProfile.SupportAddress supportAddress = AccountUpdateParams.BusinessProfile
                .SupportAddress.builder().setCity(newAddress.getCity()).setCountry(newAddress.getCountry().name())
                .setLine1(newAddress.getStreetAddress()).setLine2(newAddress.getStreetAddress2())
                .setPostalCode(newAddress.getZipcode()).setState(newAddress.getState().name()).build();
        AccountUpdateParams.BusinessProfile businessProfile = AccountUpdateParams.BusinessProfile.builder()
                .setSupportAddress(supportAddress).setMcc("5734").setProductDescription("customer").build();
        return AccountUpdateParams.builder()
                .setTosAcceptance(AccountUpdateParams.TosAcceptance.builder()
                        .setDate(System.currentTimeMillis() / 1000L).setIp(remoteAddr).build())
                .setIndividual(individual).setBusinessProfile(businessProfile)
                .build();
    }

    private ExternalAccount addPaymentMethodToAccount(String paymentToken, Account connectedAccount)
            throws StripeException {
        Map<String, Object> params = new HashMap<>();
        params.put("external_account", paymentToken);
        return connectedAccount.getExternalAccounts().create(params);
    }

    private PaymentMethod addPaymentMethodToDB(String paymentMethodId, Integer userId, String nameOnPayment,
                                               String institutionName, String paymentNumLast4Digits) {
        PaymentMethod newPaymentMethod = new PaymentMethod();
        newPaymentMethod.setPaymentMethodId(paymentMethodId);
        newPaymentMethod.setUserId(userId);
        newPaymentMethod.setNameOnPayment(nameOnPayment);
        newPaymentMethod.setInstitutionName(institutionName);
        newPaymentMethod.setPaymentNumLast4Digits(paymentNumLast4Digits);
        newPaymentMethod.setDateCreated(new Timestamp(System.currentTimeMillis()));
        return paymentMethodRepository.save(newPaymentMethod);
    }

}
