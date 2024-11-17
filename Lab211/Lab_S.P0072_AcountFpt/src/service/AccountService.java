package service;

import entity.Account;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private final List<Account> accountList = new ArrayList<>();

    public List<Account> getAccountList() {
        return accountList;
    }

    public boolean addAccount(Account accountNew) {
        if (checkUserNameExist(accountNew.getUsername())) {
            return false;
        }
        accountNew.setPassword(MD5Encryption(accountNew.getPassword()));
        accountList.add(accountNew);
        return true;
    }

    private boolean checkUserNameExist(String userNameCheck) {
        for (Account account : accountList) {
            if (account.getUsername().equalsIgnoreCase(userNameCheck)) {
                return true;
            }
        }
        return false;
    }

    public Account login(String accountNameCheck, String passwordCheck) {
        for (Account account : accountList) {
            if (account.getUsername().equalsIgnoreCase(accountNameCheck)
                    && account.getPassword().equalsIgnoreCase(MD5Encryption(passwordCheck))) {
                return account;
            }
        }
        return null;
    }

    public String MD5Encryption(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(password.getBytes());

            byte[] digest = messageDigest.digest();

            BigInteger bigInt = new BigInteger(1, digest);

            return bigInt.toString(16);

        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
