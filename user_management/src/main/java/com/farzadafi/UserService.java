package com.farzadafi;

import com.farzadafi.model.User;
import com.farzadafi.model.enumoration.Role;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User registerUser(User user) {
        setDefaultField(user);
        setDefaultAvatar(user);
        try {
            user = repository.save(user);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("duplicate key value violates unique constraint"))
                throw new UserNameDuplicateException
                        (String.format("%s is duplicate", user.getUsername()));
        }
        return user;
    }
}
