package com.ravinder.springsecuritytuts.auth;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
