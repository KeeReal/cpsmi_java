package task_12_fio;

import task_12_fio.impl.*;

// todo: put default info into file

// 0. create file if doesnt exists
// 1. parse into userVO
// 2. display users
// 3. draw gui

// 5. save, update, delete

public class main_12 {
    public static void main(String[] args) {
        UserDataReader userDataReader = new UserDataReader(Consts.getUsersFilePath());
        UsersData usersData = new UsersData(userDataReader.readUsers());


        // get user
        // update name
        // write into

        UserVO userVO = usersData.getUser("0");
        if (userVO != null) {
            userVO.setFullname("AAAAAAAAAAAAAAAAA");
        }

        UsersDataWriter usersDataWriter = usersData.createWriter();
        usersDataWriter.write();
    }
}
