package com.lab12.model;
import java.util.*;

public class UserDataset {
    private List<User> userList = new ArrayList<User>();

    public UserDataset(){
        userList.add(new User("ngocha", "ngocha"));
    }
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user){
        userList.add(user);
    }
}
