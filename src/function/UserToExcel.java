package function;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import imformation.*;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * 用户记录写入Excel文件
 */

public class UserToExcel {
    // ----------------写入的Excel工作薄--------------
    private static String fileName = "C:\\Users\\lina\\IdeaProjects\\BankManagementProject\\User.xlsx";

    public static void toExcel() {
        try {
            WritableWorkbook excelBook = null;
            //--------------- 打开文件，因为文件为手动创建的，不需要判断是否存在
            File file = new File(fileName);


            //----------以fileName为文件名来创建一个Workbook-------
            excelBook = Workbook.createWorkbook(file);

            //------------创建工作表---------------
            WritableSheet excelSheet = excelBook.createSheet("Test 1", 0);

            //--------------导出数据中所有数据-----------
            //-------查询用户信息--------
            UserAndAdminDao dao=new UserAndAdminDao();
            List<User> userList=new LinkedList<>();
            userList=dao.findUsers("select * from bankuser",null);


            //要插入到的Excel表格的行号，默认从0开始
            Label labelAccount = new Label(0, 0 , "account");
            Label labelPassword = new Label(1, 0 , "password");
            Label labelID= new Label(2, 0 , "id");
            Label labelBalancy = new Label(3, 0 , "balancy");
            Label labelEmail = new Label(4, 0 , "email");

            //添加标题
            excelSheet.addCell(labelAccount);
            excelSheet.addCell(labelPassword);
            excelSheet.addCell(labelID);
            excelSheet.addCell(labelBalancy);
            excelSheet.addCell(labelEmail);

            // 导入
            for(int i = 0; i < userList.size(); i++) {
                //要插入到的Excel表格的行号，默认从0开始
                Label labelAccount1 = new Label(0, i+1 , userList.get(i).getAccount());
                Label labelPassword1 = new Label(1, i+1 , userList.get(i).getPassword() + "");
                Label labelID1 = new Label(2, i+1 , userList.get(i).getID());
                Label labelBalancy1 = new Label(3, i+1 , String.valueOf(userList.get(i).getBalancy()));
                Label labelEmail1=new Label(4,i+1,userList.get(i).getEmail());

                //添加第一列到单元格
                excelSheet.addCell(labelAccount1);
                excelSheet.addCell(labelPassword1);
                excelSheet.addCell(labelID1);
                excelSheet.addCell(labelBalancy1);
                excelSheet.addCell(labelEmail1);
            }

            //写入文档
            excelBook.write();
            //关闭Excel工作薄对象
            excelBook.close();
            System.out.println("A");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        toExcel();
    }
}
