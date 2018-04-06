package com.finance.bank.services;


import com.finance.bank.daos.AccountDao;
import com.finance.bank.daos.UserDao;
import com.finance.bank.entities.Account;
import com.finance.bank.entities.User;
import com.finance.bank.utils.JwtManager;
import com.finance.bank.utils.UserNotFoundException;
import com.finance.bank.utils.WrongPasswordException;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Optional<User> verifyUserPassword(String username, String password) throws WrongPasswordException {
        Optional<Account> account = accountDao.findByUserFiscalCode(user.getFiscalCode());
        if (account.isPresent()) {
            if (!account.get().getPassword().equals(password))
                throw new WrongPasswordException();
        }
        return userDao.findById(username);
    }

    @Override
    public String createJwt(String subject, String name, String permission, Date date) throws UnsupportedEncodingException {
        Date expiringDate = new Date(date.getTime() + (1000 * 5 * 60));
        return JwtManager.generateJwt(subject, expiringDate, name, permission);
    }

    @Override
    public Map<String, Object> verifyJwtAndGetData(HttpServletRequest request) {
        return null;
    }
}
