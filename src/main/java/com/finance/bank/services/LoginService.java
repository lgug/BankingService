package com.finance.bank.services;

import com.finance.bank.utils.exceptions.UserNotFoundException;
import com.finance.bank.utils.exceptions.WrongPasswordException;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

public interface LoginService {

    void verifyUserPassword(String username, String password) throws WrongPasswordException, UserNotFoundException;

    String createJwt(String subject, String name, String permission, Date date) throws UnsupportedEncodingException;

    Map<String, Object> verifyJwtAndGetData(HttpServletRequest request);

}
