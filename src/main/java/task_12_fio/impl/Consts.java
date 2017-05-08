package task_12_fio.impl;

import java.io.File;

public class Consts {
    public static String getUsersFilePath() {
        return new StringBuilder()
                .append(System.getProperty("user.home"))
                .append(File.separator)
                .append(".config/cpsmi/task_12_users.xml")
                .toString();
    }
}
