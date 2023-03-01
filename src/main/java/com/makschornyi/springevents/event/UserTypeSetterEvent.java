package com.makschornyi.springevents.event;

import com.makschornyi.springevents.model.User;
import org.springframework.context.ApplicationEvent;

public class UserTypeSetterEvent extends ApplicationEvent {

    private final User user;

    public UserTypeSetterEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
