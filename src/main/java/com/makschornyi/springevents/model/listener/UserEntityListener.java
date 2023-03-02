package com.makschornyi.springevents.model.listener;

import com.makschornyi.springevents.model.User;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserEntityListener {

    Logger log = LoggerFactory.getLogger(UserEntityListener.class);


    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(User user) {
        System.out.println(user);
        if (user.getId() == null || user.getId() == 0) {
            log.info("[USER AUDIT] About to add a user");
        } else {
            log.info("[USER AUDIT] About to update/delete user: " + user.getId());
        }
    }
}
