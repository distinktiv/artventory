package com.artventory.distinktiv.service;

import com.artventory.distinktiv.client.UserClient;
import com.artventory.distinktiv.config.UserAccountSettings;
import com.artventory.distinktiv.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    private final UserClient userClient;
    private final UserAccountSettings userAccountSettings;

    @Autowired
    public UserServiceImpl(UserClient userClient, UserAccountSettings userAccountSettings) {
        this.userClient = userClient;
        this.userAccountSettings = userAccountSettings;
    }

    @Override
    public Optional<Collection<User>> getAllUsers() {
        return Optional.of((Collection<User>) userClient.getAllUsers());
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userClient.getUserByEmail(email));
    }

    @Override
    public User createUser(User user) {
        return userClient.createUser(user);
    }


    @Override
    public void updateUserFailedLoginCount(User user) {
        int userFailedLoginCount = user.getFailedLoginCount();
        user.setFailedLoginCount(userFailedLoginCount + 1);
        user.setLastFailedLoginDate(new Date());
        if (!user.isAccountLocked() && user.getFailedLoginCount() > userAccountSettings.getMaxFailedLoginCount()) {
            user.setAccountLocked(true);
        }

        userClient.createUser(user);
    }

    @Override
    public void resetUserFailedLoginCount(User user) {
        user.setFailedLoginCount(0);
        userClient.createUser(user);
        //userRepository.save(user);
    }

    @Override
    public boolean unlockUserAccount(User user) {
        boolean unlockSuccess = false;
        long lastFailedLoginTime = user.getLastFailedLoginDate().getTime();
        long currentTime = new Date().getTime();
        long timeout = userAccountSettings.getLockTimeOut() * 1000 * 60;
        if ((currentTime - lastFailedLoginTime) > timeout) {
            user.setAccountLocked(false);
            userClient.createUser(user);
            //userRepository.save(user);
            unlockSuccess = true;
        }
        return unlockSuccess;
    }
}
