package task_12_fio.impl;

import java.util.HashMap;

public class UsersData {
    private HashMap<String, UserVO> users;
    private boolean isDirty;


    public UsersData(HashMap<String, UserVO> users) {
        this.users = users;
        isDirty = false;
    }


    public boolean isDirty() {
        return isDirty;
    }


    public UserVO getUser(String userId) {
        return users.get(userId);
    }


    public UsersDataWriter createWriter() {
        return new UsersDataWriter(users);
    }
}
