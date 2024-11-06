package com.example.data;

import java.util.ArrayList;
import java.util.List;
class User {
    private String userId;
    private int fineAmount;

    public User(String userId, int fineAmount) {
        this.userId = userId;
        this.fineAmount = fineAmount;
    }

    public String getUserId() {
        return userId;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }
}

public class UserDAO implements IUserDAO {
    private List<User> users = new ArrayList<>();

    public UserDAO() {
        users.add(new User("U001", 0));
        users.add(new User("U002", 50));
    }

    @Override
    public int getUserFine(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user.getFineAmount();
            }
        }
        return 0;
    }

    @Override
    public void updateUserFine(String userId, int fineAmount) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                user.setFineAmount(fineAmount);
                return;
            }
        }
        users.add(new User(userId, fineAmount));
    }
}
