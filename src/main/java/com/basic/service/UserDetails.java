package com.basic.service;

import com.basic.domain.User;

public interface UserDetails {
    User findByEmail(String email);
}
