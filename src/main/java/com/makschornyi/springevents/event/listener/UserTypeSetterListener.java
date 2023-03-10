package com.makschornyi.springevents.event.listener;

import com.makschornyi.springevents.event.UserTypeSetterEvent;
import com.makschornyi.springevents.model.User;
import com.makschornyi.springevents.model.UserType;
import com.makschornyi.springevents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserTypeSetterListener implements ApplicationListener<UserTypeSetterEvent> {

    private final UserService userService;

    @Autowired
    public UserTypeSetterListener(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(UserTypeSetterEvent event) {
        setUserRandomType(event.getUser());
    }

    private void setUserRandomType(User user) {
        final UserType[] values = UserType.values();
        int randomValueIndex = (int) ((Math.random() * (values.length)));
        user.setType(values[randomValueIndex]);
        userService.updateUser(user);
    }
}
