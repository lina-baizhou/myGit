package loginandregister;

import lombok.SneakyThrows;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
用户注册界面1
 1.输入身份证号和QQ邮箱
 2.进行验证，是否符合规范
 3.发送验证码
 */
public class UserRegister extends JFrame{
    private String[] account;
    private String random;//验证码
    private JPasswordField txtID;//身份证输入框
    private JTextField txtQq;//QQ邮箱输入框
    private JButton btn;//确定按钮
    private JButton btnR;//返回按钮
    private JButton btnE;//退出
    private String Qq;
    public UserRegister() throws EmailException {
        //----------背景------------
        JPanel panel = new JPanel();
        ImageIcon backIcon = new ImageIcon("C:\\Users\\lina\\IdeaProjects\\BankManagementProject\\src\\LoginAndRegister\\txt1.jpg");// 加载图片
        JLabel backLabel = new JLabel(backIcon);// 将图片放入label中
        backLabel.setBounds(0, 0, 906, 627);// 设置label的大小

        getLayeredPane().add(backLabel, new Integer(Integer.MIN_VALUE));// 获取窗口的第二层，将label放入

        panel = (JPanel) getContentPane();// 获取frame的顶层容器
        panel.setOpaque(false);// 设置为透明*/

        txtID = new JPasswordField();
        txtID.setFont(new Font("宋体", Font.PLAIN, 25));
        txtID.setColumns(10);

        JLabel lblID = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
        lblID.setFont(new Font("宋体", Font.PLAIN, 30));

        JLabel lblQq = new JLabel("QQ\u90AE\u7BB1\uFF1A");
        lblQq.setFont(new Font("宋体", Font.PLAIN, 30));

        txtQq = new JTextField();
        txtQq.setFont(new Font("宋体", Font.PLAIN, 25));
        txtQq.setColumns(10);

        btn = new JButton("\u786E\u5B9A");
        btn.setFont(new Font("宋体", Font.PLAIN, 15));

        btnR = new JButton("\u8FD4\u56DE");
        btnR.setFont(new Font("宋体", Font.PLAIN, 15));

        btnE = new JButton("\u9000\u51FA");
        btnE.setFont(new Font("宋体", Font.PLAIN, 15));

        //加入监听器
        ActionListener actionListener=new MyActionListener();
        btn.addActionListener(actionListener);
        btnE.addActionListener(actionListener);
        btnR.addActionListener(actionListener);



        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(169)
                                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblID)
                                                        .addComponent(lblQq, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(208)
                                                .addComponent(btn, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
                                .addGap(54)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                                .addGap(107)
                                                .addComponent(btnE, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtQq, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtID, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(173, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(143)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtID, GroupLayout.Alignment.LEADING)
                                        .addComponent(lblID, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(45)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblQq, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtQq, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnE, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addGap(126))
        );
        getContentPane().setLayout(groupLayout);
        panel = (JPanel) getContentPane();// 获取frame的顶层容器
        panel.setOpaque(false);// 设置为透明*/
        setBounds(10,10,906,627);
        //设置为可见以及关闭模式
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private class MyActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btn) {
                //---------------正则表达式判断身份证号是否规范---------------
                String pattern = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
                if (txtID.getText().matches(pattern)) {//---------------正则表达式判断QQ邮箱号是否规范---------------
                    String pattern1="[1-9]\\d{5,10}+@qq.com";
                    if(txtQq.getText().matches(pattern1)) {
                        String accont = null;
                        try {
                            accont = new CreateAccount().account;
                            //--------随机生成验证码------
                            Random random1 = new Random();
                            int rand = random1.nextInt(100000) + 99999;
                            random = String.valueOf(rand);

                            //------------------发送验证码--------------


                            HtmlEmail email = new HtmlEmail();//不用更改
                            email.setHostName("smtp.qq.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
                            email.setCharset("UTF-8");
                            email.setAuthentication("2923904910@qq.com", "rprfmptudragdgfj");//此处填写邮箱地址和客户端授权码
                            email.setFrom("2923904910@qq.com", "");//此处填邮箱地址和用户名,用户名可以任意填写
                            email.setSSLCheckServerIdentity(true);
                            email.addTo(txtQq.getText());// 收件地址
                            email.setSubject("验证码");//此处填写邮件名，邮件名可任意填写
                            email.setMsg("尊敬的用户您好,您本次注册的验证码是:" + random);//此处填写邮件内容

                            email.send();

                            Qq = txtQq.getText();

                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        String ID = txtID.getText();
                        dispose();
                        try {
                            new UserRegister1(accont, ID, random, Qq);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"您输入的QQ邮箱错误，请重新输入","",JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"您输入的身份证号格式错误，请重新输入","",JOptionPane.INFORMATION_MESSAGE);
                }
            }else if(e.getSource()==btnR){
                dispose();
                new UserMenu();
            }else if(e.getSource()==btnE){
                System.exit(0);
            }
        }
    }
}
