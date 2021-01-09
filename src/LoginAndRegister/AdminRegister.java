package LoginAndRegister;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Imformation.*;

public class AdminRegister extends JFrame{
    private JLabel lblA;//账号提示框
    private JLabel lblP;//密码提示框
    private JLabel lblP1;//确认密码提示框
    private JTextField txtA;//账号输入框
    private JPasswordField passwordFiled1;//密码输入框
    private JPasswordField passwordFiled2;//确认密码输入框
    private JButton btn;//登录按钮
    private String ID;//身份证号
    private String account;//账号
    private JButton btnE;//退出按钮
    private JPanel contentPane;



    public AdminRegister() {
        account = new CreateAccount("select account from bankadmin").account;
        //设置背景
        JPanel panel=new JPanel();
        ImageIcon backIcon = new ImageIcon("C:\\Users\\lina\\IdeaProjects\\BankManagementProject\\src\\LoginAndRegister\\txt1.jpg");// 加载图片
        JLabel backLabel = new JLabel(backIcon);// 将图片放入label中
        backLabel.setBounds(0, 0, 906, 627);// 设置label的大小

        getLayeredPane().add(backLabel, new Integer(Integer.MIN_VALUE));// 获取窗口的第二层，将label放入

        panel = (JPanel) getContentPane();// 获取frame的顶层容器
        panel.setOpaque(false);// 设置为透明*/


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 10, 906, 627);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        btnE = new JButton("\u9000\u51FA");
        btnE.setFont(new Font("宋体", Font.PLAIN, 20));

        lblA = new JLabel("\u8D26\u53F7");
        lblA.setHorizontalAlignment(SwingConstants.RIGHT);
        lblA.setFont(new Font("宋体", Font.PLAIN, 20));

        lblP = new JLabel("\u5BC6\u7801");
        lblP.setHorizontalAlignment(SwingConstants.RIGHT);
        lblP.setFont(new Font("宋体", Font.PLAIN, 20));

        lblP1 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
        lblP1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblP1.setFont(new Font("宋体", Font.PLAIN, 20));

        txtA = new JTextField();
        txtA.setFont(new Font("宋体", Font.PLAIN, 20));
        txtA.setText(account);
        txtA.setColumns(10);

        btn = new JButton("\u6CE8\u518C");
        btn.setFont(new Font("宋体", Font.PLAIN, 25));

        passwordFiled1 = new JPasswordField();
        passwordFiled1.setFont(new Font("宋体", Font.PLAIN, 20));

        passwordFiled2 = new JPasswordField();
        passwordFiled2.setFont(new Font("宋体", Font.PLAIN, 20));

        ActionListener actionListener=new MyActionListener();
        btn.addActionListener(actionListener);
        btnE.addActionListener(actionListener);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(799, Short.MAX_VALUE)
                                .addComponent(btnE)
                                .addContainerGap())
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(161)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblP1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblP, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblA, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                                .addGap(76)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passwordFiled2)
                                        .addComponent(txtA, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                        .addComponent(passwordFiled1))
                                .addContainerGap(262, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(330)
                                .addComponent(btn, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(404, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(147)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblA)
                                        .addComponent(txtA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(51)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblP, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordFiled1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(43)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblP1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordFiled2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(83)
                                .addComponent(btn)
                                .addGap(104)
                                .addComponent(btnE)
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
        contentPane.setOpaque(false);
        //设置为可见以及关闭模式
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private class MyActionListener implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String password = null;
            if (e.getSource() == btn) {
                if (passwordFiled1.getText().equals(passwordFiled2.getText()) && passwordFiled2.getText().length() == 6) {
                    password = passwordFiled1.getText();
                    try {
                        Object[] o=new Object[2];
                        o[0]=account;
                        o[1]=password;

                        UserAndAdminDao dao = new UserAndAdminDao();

                        String sql="insert into bankadmin values(?,?)";//插入的SQL语句

                        int num=dao.updateAdmin(sql,o);
                        if(num!=0) {
                            JOptionPane.showMessageDialog(null, "注册成功", "", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                            new AdminLogin();
                        }else{
                            JOptionPane.showMessageDialog(null,"注册失败","",JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else {//重新输入
                    JOptionPane.showMessageDialog(null,"密码和确认密码不一致，注册失败","标题",JOptionPane.WARNING_MESSAGE);
                    dispose();
                    new AdminRegister();
                }
            }else if(e.getSource()==btnE){
                System.exit(0);
            }
        }
    }
}
