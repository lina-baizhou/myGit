package loginandregister;

import imformation.UserAndAdminDao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
用户注册界面2
1.账号由系统生成
2.分为密码和确认密码，六位数，且两者相等，不相等则需要重新输入，相等且符合情况就存入数据库
 */
public class UserRegister1 extends JFrame {
    //组件
    private JLabel lblA;//账号提示框
    private JLabel lblP;//密码提示框
    private JLabel lblP1;//确认密码提示框
    private JTextField txtA;//账号输入框
    private JPasswordField passwordField1;//密码输入框
    private JPasswordField passwordField2;//确认密码输入框
    private JButton btn;//登录按钮
    private String ID;//身份证号
    private String account;//账号
    private String randomTxt;//验证码
    private JButton btnE;//退出按钮
    private JPanel contentPane;
    private JLabel lbl;//验证码输入提示框
    private JTextField txt;//验证码输入框
    private String txt1;//验证码
    private String Qq;//QQ邮箱

    public UserRegister1(String account, String ID,String randomTxt,String Qq) {


        this.ID = ID;
        this.account = account;
        this.randomTxt=randomTxt;
        this.Qq=Qq;

        //----------背景------------
        JPanel panel = new JPanel();
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
        txtA.setText(account);
        txtA.setFont(new Font("宋体", Font.PLAIN, 20));
        txtA.setColumns(10);

        btn = new JButton("注册");
        btn.setFont(new Font("宋体", Font.PLAIN, 25));


        passwordField1 = new JPasswordField();
        passwordField1.setFont(new Font("宋体", Font.PLAIN, 20));

        passwordField2 = new JPasswordField();
        passwordField2.setFont(new Font("宋体", Font.PLAIN, 20));

        lbl = new JLabel("\u9A8C\u8BC1\u7801");
        lbl.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl.setFont(new Font("宋体", Font.PLAIN, 20));

        txt = new JTextField();
        txt.setFont(new Font("宋体", Font.PLAIN, 20));
        txt.setColumns(10);

        //----------加入监听器------------

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
                                        .addComponent(lbl, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblA, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                                .addGap(76)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passwordField2)
                                        .addComponent(passwordField1, GroupLayout.Alignment.TRAILING)
                                        .addComponent(txt)
                                        .addComponent(txtA, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                                .addContainerGap(264, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(345)
                                .addComponent(btn, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(389, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(65)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblA)
                                        .addComponent(txtA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(46)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(38)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblP, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(316)
                                                .addComponent(btnE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addContainerGap(10, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(46)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblP1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                                                .addComponent(btn)
                                                .addGap(120))))
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
            double balancy = 0;
            String txt1=null;
            if (e.getSource() == btn) {
                if(passwordField1.getText().matches("[0-9]{6}")) {
                    if (passwordField1.getText().equals(passwordField2.getText()) && passwordField2.getText().length() == 6 && (txt.getText().equals(randomTxt))) {
                        password = passwordField1.getText();
                        UserAndAdminDao dao = new UserAndAdminDao();

                        Object[] o = new Object[5];
                        o[0] = account;
                        o[1] = password;
                        o[2] = ID;
                        o[3] = balancy;
                        o[4] = Qq;

                        int num = 0;
                        String sql = "insert into bankuser values(?,?,?,?,?)";
                        try {
                            num = dao.updateUser(sql, o);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        if (num != 0) {
                            JOptionPane.showMessageDialog(null, "注册成功", "标题", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                            new UserLogin();
                        } else {//重新输入
                            JOptionPane.showMessageDialog(null, "密码和确认密码不一致或者验证码错误，注册失败", "标题", JOptionPane.WARNING_MESSAGE);
                            dispose();
                            new UserRegister1(account, ID, randomTxt, Qq);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"你输入的密码格式错误，密码为6个数字，请修改",null,JOptionPane.INFORMATION_MESSAGE);
                }
            }else if (e.getSource() == btnE) {
                System.exit(0);
            }
        }
    }
}

