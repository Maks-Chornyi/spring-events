package com.makschornyi.springevents.event.publisher;

import com.makschornyi.springevents.event.UserTypeSetterEvent;
import com.makschornyi.springevents.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UserTypeSetterPublisher {

    private final ApplicationEventPublisher publisher;

    @Autowired
    public UserTypeSetterPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishCustomEvent(final User user) {
        System.out.println("Publishing custom event. ");
        UserTypeSetterEvent customSpringEvent = new UserTypeSetterEvent(this, user);
        publisher.publishEvent(customSpringEvent);
    }
}
