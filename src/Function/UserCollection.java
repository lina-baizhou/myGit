package Function;

import Imformation.User;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class UserCollection {
    private User user;
    public UserCollection(User user) throws IOException {
        this.user=user;
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\lina\\IdeaProjects\\BankManagementProject\\UserTxt\\user.txt"));
        oos.writeObject(user);
    }

}
