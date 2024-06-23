package com.tipperoo.springbootInfrastructure.controller;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Transfer;
import com.tipperoo.springbootInfrastructure.CoinBalanceHandler;
import com.tipperoo.springbootInfrastructure.dao.User;
import com.tipperoo.springbootInfrastructure.enums.CurrencyType;
import com.tipperoo.springbootInfrastructure.dao.Transaction;
import com.tipperoo.springbootInfrastructure.enums.TransactionType;
import com.tipperoo.springbootInfrastructure.repos.TransactionRepository;
import com.tipperoo.springbootInfrastructure.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping(path="/transaction")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewTransaction (@RequestParam Integer userId, @RequestParam String currencyType,
                              @RequestParam Integer amount, @RequestParam String stripeToken,
                              @RequestParam String description, @RequestParam String transactionType)
            throws Exception {
        String transactionId;
        CoinBalanceHandler coinBalanceHandler = new CoinBalanceHandler(userRepository);
        if (TransactionType.valueOf(transactionType) == TransactionType.Buying) {
            transactionId = preformCharge(userId, stripeToken, amount, coinBalanceHandler);
        } else {
            transactionId = preformTransfer(userId, stripeToken, amount, coinBalanceHandler);
        }
        Transaction newTransaction = new Transaction();
        newTransaction.setTransactionId(transactionId);
        newTransaction.setUserId(userId);
        newTransaction.setCurrencyType(CurrencyType.valueOf(currencyType));
        newTransaction.setAmountPaid(amount);
        newTransaction.setStripeToken(stripeToken);
        newTransaction.setDescription(description);
        newTransaction.setTransactionType(TransactionType.valueOf(transactionType));
        newTransaction.setDateCreated(new Timestamp(System.currentTimeMillis()));
        Transaction newCreatedTransaction = transactionRepository.save(newTransaction);
        return "Saved with TransactionId: " + newCreatedTransaction.getTransactionId();
    }

    private String preformCharge(Integer userId, String stripeToken, Integer amount, CoinBalanceHandler coinBalanceHandler)
            throws Exception {
        User user = userRepository.findById(userId).orElse(null);
        assert user != null;
        Map<String, Object> params = new HashMap<>();
        params.put("amount", amount);
        params.put("currency", "usd");
        params.put("source", stripeToken);
        params.put("receipt_email", user.getEmail());
        params.put("description", "My First Test Charge");
        coinBalanceHandler.changeUserCoinBalance(user.getUserId(), amount);
        return Charge.create(params).getId();
    }

    private String preformTransfer(Integer userId, String stripeToken, Integer amount, CoinBalanceHandler coinBalanceHandler)
            throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("amount", amount);
        params.put("currency", "usd");
        params.put("destination", stripeToken);
        params.put("description", "Cash-out for user: " + userId + ", of amount: " + amount);
        if (coinBalanceHandler.validateUserBalance(userId, amount)) {
            coinBalanceHandler.changeUserCoinBalance(userId, -amount);
        } else {
            throw new Exception("Failed to cash-out userId: " + userId + ", balance too low");
        }
        return Transfer.create(params).getId();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateTransaction(@RequestBody Transaction transaction, @PathVariable String id) {
        Optional<Transaction> studentOptional = transactionRepository.findById(id);
        if (studentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        transaction.setTransactionId(id);
        transaction.setDateUpdated(new Timestamp(System.currentTimeMillis()));
        transactionRepository.save(transaction);
        return ResponseEntity.ok("Updated transaction: " + id + "\nwith new details:\n" + transaction);
    }

    @GetMapping(path="/get/{id}")
    public @ResponseBody
    Optional<Transaction> getTransaction(@PathVariable String id) {
        return transactionRepository.findById(id);
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<Object> deleteTransaction(@PathVariable String id) {
        try {
            transactionRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deletion failed: transaction entity not found");
        }
        return ResponseEntity.ok("Deleted transaction: " + id);
    }

    @GetMapping(path="/get/all/{userId}")
    public @ResponseBody Iterable<Transaction> getTransactionsByUserId(@PathVariable Integer userId) {
        Iterable<Transaction> allTransactions = transactionRepository.findAll();
        List<Transaction> searchResults = new ArrayList<>();
        for (Transaction transaction: allTransactions) {
            if (transaction.getUserId().equals(userId)) {
                searchResults.add(transaction);
            }
        }
        return searchResults;
    }
    
}
