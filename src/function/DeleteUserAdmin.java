package function;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import imformation.*;
import lombok.SneakyThrows;
import org.apache.commons.mail.HtmlEmail;
/**
修改用户密码
1.从输入框里获取要修改的账号，身份证，账号密码，管理员密码
2.查询表，进行比较全部一致则进行注销操作
3.注销操作，在表中删除用户
 */

public class DeleteUserAdmin extends JFrame{

    private String[] account; //管理员账号

    //组件
    private JPanel contentPane;
    private JTextField txtA;//账号输入框
    private JPasswordField txtID;//身份证输入框
    private JPasswordField txtPU;//用户密码输入框
    private JPasswordField txtPA;//管理员密码输入框
    private JLabel lblA;//账号输入提示框
    private JLabel lblID;//身份证输入提示框
    private JLabel lblPU;//用户密码输入提示框
    private JLabel lblPA;//管理员密码输入提示框
    private JButton btn;//确定按钮
    private JButton btnR;//退出按钮
    private JLabel lblQq;//QQ邮箱输入提示框
    private JTextField txtQq;//QQ邮箱输入框


    /**
     * Create the frame.
     */
    public DeleteUserAdmin(String[]account) {
        this.account=account;


        //设置背景
        JPanel panel = new JPanel();
        ImageIcon backIcon = new ImageIcon("C:\\Users\\lina\\IdeaProjects\\BankManagementProject\\src\\LoginAndRegister\\txt1.jpg");// 加载图片
        JLabel backLabel = new JLabel(backIcon);// 将图片放入label中
        backLabel.setBounds(0, 0, 906, 627);// 设置label的大小

        //setLayout(new GridLayout(5,2));
        getLayeredPane().add(backLabel, new Integer(Integer.MIN_VALUE));// 获取窗口的第二层，将label放入

        panel = (JPanel) getContentPane();// 获取frame的顶层容器
        panel.setOpaque(false);// 设置为透明*/


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 10, 906, 627);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        lblA = new JLabel("\u8BF7\u8F93\u5165\u4F60\u60F3\u8981\u6CE8\u9500\u7684\u8D26\u53F7\uFF1A");
        lblA.setFont(new Font("宋体", Font.PLAIN, 25));

        lblID = new JLabel("\u8BF7\u8F93\u5165\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
        lblID.setHorizontalAlignment(SwingConstants.RIGHT);
        lblID.setFont(new Font("宋体", Font.PLAIN, 25));

        lblPU = new JLabel("\u8BF7\u8F93\u5165\u8D26\u53F7\u5BC6\u7801\uFF1A");
        lblPU.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPU.setFont(new Font("宋体", Font.PLAIN, 25));

        lblPA = new JLabel("\u8BF7\u8F93\u5165\u7BA1\u7406\u5458\u5BC6\u7801\uFF1A");
        lblPA.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPA.setFont(new Font("宋体", Font.PLAIN, 25));

        txtA = new JTextField();
        txtA.setFont(new Font("宋体", Font.PLAIN, 25));
        txtA.setColumns(10);

        txtID = new JPasswordField();
        txtID.setFont(new Font("宋体", Font.PLAIN, 25));
        txtID.setColumns(10);

        txtPU = new JPasswordField();
        txtPU.setFont(new Font("宋体", Font.PLAIN, 25));
        txtPU.setColumns(10);

        txtPA = new JPasswordField();
        txtPA.setFont(new Font("宋体", Font.PLAIN, 25));
        txtPA.setColumns(10);

        btn = new JButton("\u786E\u5B9A");
        btn.setFont(new Font("宋体", Font.PLAIN, 15));

        btnR = new JButton("返回");
        btnR.setFont(new Font("宋体", Font.PLAIN, 14));

        lblQq = new JLabel("\u8BF7\u8F93\u5165\u6CE8\u518CQQ\u90AE\u7BB1\uFF1A");
        lblQq.setHorizontalAlignment(SwingConstants.RIGHT);
        lblQq.setFont(new Font("宋体", Font.PLAIN, 25));

        txtQq = new JTextField();
        txtQq.setFont(new Font("宋体", Font.PLAIN, 25));
        txtQq.setColumns(10);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(249)
                                                .addComponent(btn)
                                                .addGap(186)
                                                .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(67)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblID, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblPU, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblPA, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblQq, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblA))
                                                .addGap(62)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtQq, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtA, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtPU, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtID, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtPA, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(160, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(81)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblA))
                                .addGap(41)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(GroupLayout.Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addComponent(txtQq, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtID, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblQq, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                .addGap(43)
                                                .addComponent(lblID, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
                                .addGap(48)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblPU, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPU, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addGap(45)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPA, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPA, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btn)
                                        .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                .addGap(39))
        );

        //-----------------------添加监听器-----------------------
        ActionListener actionListener=new MyActionListner();
        btn.addActionListener(actionListener);
        btnR.addActionListener(actionListener);
        contentPane.setLayout(gl_contentPane);
        contentPane.setOpaque(false);
        setVisible(true);
        setResizable(false);
    }
    private class MyActionListner implements ActionListener{

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btn){
                //-------------------获取信息---------------------------
                String accountU=txtA.getText();
                String ID=txtID.getText();
                String passwordU=txtPU.getText();
                String passwordA=txtPA.getText();

                //------------------查询数据库进行比较-----------------------
                UserAndAdminDao dao=new UserAndAdminDao();
                List<User> userList=new LinkedList<User>();
                List<Admin> adminList=new LinkedList<Admin>();

                //----1.比较用户信息是否正确
                Object[] o=new Object[4];
                o[0]=accountU;
                o[1]=ID;
                o[2]=passwordU;
                o[3]=txtQq.getText();
                try {
                    userList=dao.findUsers("select * from bankuser where account=? and ID=? and password=? and email=?",o);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                if(!userList.isEmpty()){//用户信息输入正确
                    //-----2.比较管理员信息是否正确
                    Object[] o1=new Object[2];
                    o1[0]=account[0];
                    o1[1]=passwordA;

                    try {
                        adminList=dao.findAdmin("select * from bankadmin where account=? and password=?",o1);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    if(!adminList.isEmpty()){//管理员密码正确
                        //--------随机生成验证码------
                        Random random1 = new Random();
                        int rand = random1.nextInt(100000) + 99999;

                        //------------------发送验证码--------------


                        HtmlEmail email1 = new HtmlEmail();//不用更改
                        email1.setHostName("smtp.qq.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
                        email1.setCharset("UTF-8");
                        email1.setAuthentication("2923904910@qq.com", "rprfmptudragdgfj");//此处填写邮箱地址和客户端授权码
                        email1.setFrom("2923904910@qq.com", "");//此处填邮箱地址和用户名,用户名可以任意填写
                        email1.setSSLCheckServerIdentity(true);
                        email1.addTo(txtQq.getText());// 收件地址
                        email1.setSubject("验证码");//此处填写邮件名，邮件名可任意填写
                        email1.setMsg("尊敬的用户您好,您本次注册的验证码是:" + rand);//此处填写邮件内容
                        email1.send();
                        dispose();


                         new DeleteUserTextView(account,accountU,String.valueOf(rand));
                    }else{
                        JOptionPane.showMessageDialog(null,"管理员密码输入错误，请修改！","",JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"用户信息输入错误，请修改！","",JOptionPane.WARNING_MESSAGE);
                }
            }else if(e.getSource()==btnR){
                dispose();
                new AdminMainMenu(account);
            }
        }
    }
}
