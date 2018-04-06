package com.finance.bank.services;

import com.finance.bank.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

public interface LoginService {

    Optional<User> getUserFromDbAndVerifyPassword(String username, String password);

    String createJwt(String subject, String name, String permission, Date date);

    Map<String, Object> verifyJwtAndGetData(HttpServletRequest request);

}
