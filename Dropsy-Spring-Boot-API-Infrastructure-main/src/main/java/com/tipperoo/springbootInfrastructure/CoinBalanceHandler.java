package com.tipperoo.springbootInfrastructure;

import com.tipperoo.springbootInfrastructure.dao.User;
import com.tipperoo.springbootInfrastructure.repos.UserRepository;

public class CoinBalanceHandler {

    private final UserRepository userRepository;

    public CoinBalanceHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateUserBalance(Integer userId, Integer amountGiven) throws Exception {
        return getUserEntityById(userId).getCoinBalance() - amountGiven >= 0;
    }

    public void changeGiftUsersBalances(Integer gifterId, Integer gifteeId, Integer amountGiven) throws Exception {
        Integer gifterBalanceChange = -amountGiven;
        changeUserCoinBalance(gifterId, gifterBalanceChange);
        changeUserCoinBalance(gifteeId, amountGiven);
    }

    private User getUserEntityById(Integer userId) throws Exception {
        User user;
        try {
            user = userRepository.findById(userId).get();
        } catch (Exception ex) {
            throw new Exception("Failed to get User: " + userId + ", with error: " + ex);
        }
        return user;
    }

    public void changeUserCoinBalance(Integer userId, Integer amountGiven) throws Exception {
        User user = getUserEntityById(userId);
        user.setCoinBalance(user.getCoinBalance()+amountGiven);
        try {
            userRepository.save(user);
        } catch (Exception ex) {
            throw new Exception("Failed to update User: " + userId + ", with error: " + ex);
        }
    }
}
