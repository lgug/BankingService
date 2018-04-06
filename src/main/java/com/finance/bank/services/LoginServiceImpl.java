package com.finance.bank.services;


import com.finance.bank.daos.AccountDao;
import com.finance.bank.daos.UserDao;
import com.finance.bank.entities.Account;
import com.finance.bank.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    UserDao userDao;

    @Override
    public Optional<User> getUserFromDbAndVerifyPassword(String username, String password) {
        Optional<User> retrievedUser = userDao.findById(username);
        if (retrievedUser.isPresent()) {
            User user = retrievedUser.get();
            Optional<Account> account = accountDao.findByUserFiscalCode(null);
        }
        return null;
    }

    @Override
    public String createJwt(String subject, String name, String permission, Date date) {
        return null;
    }

    @Override
    public Map<String, Object> verifyJwtAndGetData(HttpServletRequest request) {
        return null;
    }
}
