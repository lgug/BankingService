package com.finance.bank.services;

import com.finance.bank.daos.UserDao;
import com.finance.bank.entities.User;
import com.finance.bank.utils.exceptions.UserNotFoundException;
import com.finance.bank.utils.jwtmanagement.JwtManager;
import com.finance.bank.utils.exceptions.WrongPasswordException;
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
    private UserDao userDao;

    @Override
    public void verifyUserPassword(String username, String password) throws WrongPasswordException, UserNotFoundException {
        Optional<User> user = userDao.findById(username);
        if (user.isPresent()) {
            if (!user.get().getPassword().equals(password))
                throw new WrongPasswordException();
        } else {
            throw new UserNotFoundException();
        }
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
