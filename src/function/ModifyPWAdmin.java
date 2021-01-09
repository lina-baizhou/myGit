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
 */
public class ModifyPWAdmin extends JFrame {
    private String[] account;
    //组件
    private JPanel contentPane;
    private JPasswordField txtID;//身份证输入框
    private JButton btn;//确认按钮
    private JButton btnR;//返回按钮
    private JLabel lblID;//身份证输入提示框
    private JLabel lblA;//账号输入提示框
    private JLabel lblQq;//邮箱输入提示框
    private String random;
    private JTextField txtA;
    private JTextField txtQq;

    /**
     * Create the frame.
     */
    public ModifyPWAdmin(String[] account) {
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

        btn = new JButton("\u786E\u8BA4");
        btn.setFont(new Font("宋体", Font.PLAIN, 20));

        lblID = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u5BC6\u7801\u7684\u7528\u6237\u7684\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
        lblID.setFont(new Font("宋体", Font.PLAIN, 20));

        txtID = new JPasswordField();
        txtID.setFont(new Font("宋体", Font.PLAIN, 40));
        txtID.setColumns(10);

        lblA = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u5BC6\u7801\u7684\u7528\u6237\u7684\u8D26\u53F7\uFF1A");
        lblA.setHorizontalAlignment(SwingConstants.RIGHT);
        lblA.setFont(new Font("宋体", Font.PLAIN, 20));

        lblQq = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u5BC6\u7801\u7684\u7528\u6237\u7684QQ\u90AE\u7BB1:");
        lblQq.setHorizontalAlignment(SwingConstants.RIGHT);
        lblQq.setFont(new Font("宋体", Font.PLAIN, 20));

        JButton btnR = new JButton("\u8FD4\u56DE");
        btnR.setFont(new Font("宋体", Font.PLAIN, 20));

        //加入监听器
        ActionListener actionListener=new MyactionListener();
        btn.addActionListener(actionListener);
        btnR.addActionListener(actionListener);

        txtA = new JTextField();
        txtA.setFont(new Font("宋体", Font.PLAIN, 40));
        txtA.setColumns(10);

        txtQq = new JTextField();
        txtQq.setFont(new Font("宋体", Font.PLAIN, 40));
        txtQq.setColumns(10);


        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(64)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblID)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtID, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblA, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(14)
                                                                .addComponent(lblQq)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtQq, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtA, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(77, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(149)
                                .addComponent(btn, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                                .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addGap(165))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(182)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblID, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                        .addComponent(txtID, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addGap(54)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblA, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtA, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addGap(51)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(txtQq, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblQq, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addGap(106)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btn)
                                        .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
        contentPane.setOpaque(false);
        setVisible(true);
        setResizable(false);
    }
    private class MyactionListener implements ActionListener{

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btn){
                String acountUser=txtA.getText();
                String ID=txtID.getText();
                String email=txtQq.getText();

                UserAndAdminDao dao=new UserAndAdminDao();//获得数据库操作

                //对用户表进行查询
                Object[] o=new Object[3];
                o[0]=acountUser;
                o[1]=ID;
                o[2]=email;
                List<User> userList=new LinkedList<User>();


                try {
                    userList= dao.findUsers("select * from bankuser where account=? and ID=? and email=?", o);
                }catch (Exception e1){
                    e1.printStackTrace();
                }
                if((!userList.isEmpty())){
                    //--------随机生成验证码------
                    Random random1 = new Random();
                    int rand = random1.nextInt(100000) + 99999;
                    random=String.valueOf(rand);

                    //------------------发送验证码--------------



                    HtmlEmail email1 = new HtmlEmail();//不用更改
                    email1.setHostName("smtp.qq.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
                    email1.setCharset("UTF-8");
                    email1.setAuthentication("2923904910@qq.com", "rprfmptudragdgfj");//此处填写邮箱地址和客户端授权码
                    email1.setFrom("2923904910@qq.com", "");//此处填邮箱地址和用户名,用户名可以任意填写
                    email1.setSSLCheckServerIdentity(true);
                    email1.addTo(txtQq.getText());// 收件地址
                    email1.setSubject("验证码");//此处填写邮件名，邮件名可任意填写
                    email1.setMsg("尊敬的用户您好,您本次注册的验证码是:" + random);//此处填写邮件内容
                    email1.send();
                    dispose();
                    new ModifyPWAdmin1(account,acountUser,random);
                }else {
                    JOptionPane.showMessageDialog(null,"输入信息有误，不能修改密码！请修改！","",JOptionPane.WARNING_MESSAGE);
                }
            }else{
                dispose();
                new AdminMainMenu(account);
            }
        }
    }
}
