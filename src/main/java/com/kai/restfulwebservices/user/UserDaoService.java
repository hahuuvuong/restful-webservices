package com.kai.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.BiPredicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;
    private final BiPredicate<User, Integer> isTheSameId = (user, id) -> user.getId() == id;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        return users.stream().filter(x -> isTheSameId.test(x, id)).findFirst().orElse(null);
    }

    public boolean deleteById(int id) {
        return users.removeIf(x -> !isTheSameId.test(x, id));
    }
}
