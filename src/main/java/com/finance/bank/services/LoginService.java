package com.finance.bank.services;

import com.finance.bank.entities.User;
import com.finance.bank.utils.UserNotFoundException;
import com.finance.bank.utils.WrongPasswordException;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

public interface LoginService {

    Optional<User> verifyUserPassword(String username, String password) throws WrongPasswordException;

    String createJwt(String subject, String name, String permission, Date date) throws UnsupportedEncodingException;

    Map<String, Object> verifyJwtAndGetData(HttpServletRequest request);

}
