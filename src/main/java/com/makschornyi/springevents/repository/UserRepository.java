package com.makschornyi.springevents.repository;

import com.makschornyi.springevents.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    private final List<User> users = new ArrayList<>(
//            List.of(
//                    new User(0L,"Maks", 28),
//                    new User(1L,"NotMaks", 33),
//                    new User(2L,"MaybeMaks", 22)
//            )
//    );
//
//    public User createNewUser(User user) {
//        users.add(user.setId((long) users.size()));
//        return user;
//    }
//
//    public User findById(Long id) {
//        return users.stream().filter(u -> Objects.equals(u.getId(), id))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("User not found"));
//    }
//
//    public List<User> findAll() {
//        return this.users;
//    }
//
//    public User update(User user) {
//        users.set((int)(long)user.getId(), user);
//        return user;
//    }


}
