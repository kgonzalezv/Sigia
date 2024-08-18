package com.ltp.sigia.service;

import com.ltp.sigia.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(String username, String passoword);
}
