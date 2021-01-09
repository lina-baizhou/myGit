package function;

import imformation.User;

import java.io.*;

/**
 * 用户信息存入文件，收藏用户信息
 */
public class UserCollection {
    private User user;
    public UserCollection(User user) throws IOException {
        this.user=user;
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\lina\\IdeaProjects\\BankManagementProject\\UserTxt\\user.txt"));
        oos.writeObject(user);
    }

}
