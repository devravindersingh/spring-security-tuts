package com.ravinder.springsecuritytuts.auth;

import com.google.common.collect.Lists;
import com.ravinder.springsecuritytuts.security.ApplicationUserRole;
import com.ravinder.springsecuritytuts.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import sun.security.util.Password;

import java.util.List;
import java.util.Optional;

import static com.ravinder.springsecuritytuts.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationDaoService implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationDaoService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUserList()
                .stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUserList(){
        List<ApplicationUser> applicationUserList = Lists.newArrayList(
              new ApplicationUser(
                      STUDENT.getGrantedAuthorities(),
                      "annasmith",
                      passwordEncoder.encode("password"),
                      true,
                      true,
                      true,
                      true
              ),
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        "linda",
                        passwordEncoder.encode("password123"),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMINTRAINEE.getGrantedAuthorities(),
                        "tom",
                        passwordEncoder.encode("password123"),
                        true,
                        true,
                        true,
                        true
                )
        );
        return applicationUserList;

    }
}
