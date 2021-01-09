package function;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import imformation.*;

/**
 * 查询用户信息
 * 1.从输入框里获取用户账号和管理员密码
 * 2.查询表进行比较
 * 3.比较成功则显示用户信息
 * */

public class SearchUserAdmin extends JFrame {
    //----管理员账号---
    String[] account;

    //组件
    private JPanel contentPane;
    private JTextField txtA;//用户账号输入框
    private JPasswordField txtPA;//管理员密码输入框
    private JLabel lblA;//用户账号输入提示框
    private JLabel lblPA;//管理员账号输入提示框
    private JButton btn;//确认按钮
    private JButton btnR;//返回按钮；


    /**
     * Create the frame.
     */
    public SearchUserAdmin(String[] account) {
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

        lblA = new JLabel("\u8BF7\u8F93\u5165\u4F60\u60F3\u8981\u67E5\u8BE2\u7684\u8D26\u53F7\uFF1A");
        lblA.setFont(new Font("宋体", Font.PLAIN, 25));

        lblPA = new JLabel("\u8BF7\u8F93\u5165\u7BA1\u7406\u5458\u5BC6\u7801\uFF1A");
        lblPA.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPA.setFont(new Font("宋体", Font.PLAIN, 25));

        txtA = new JTextField();
        txtA.setFont(new Font("宋体", Font.PLAIN, 25));
        txtA.setColumns(10);

        txtPA = new JPasswordField();
        txtPA.setFont(new Font("宋体", Font.PLAIN, 25));
        txtPA.setColumns(10);

        btn = new JButton("\u786E\u5B9A");
        btn.setFont(new Font("宋体", Font.PLAIN, 15));

        btnR = new JButton("\u8FD4\u56DE");
        btnR.setFont(new Font("宋体", Font.PLAIN, 14));

        //------------添加监听器-------------
        ActionListener actionListener=new MyActionListener();
        btn.addActionListener(actionListener);
        btnR.addActionListener(actionListener);


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
                                                .addGap(71)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblPA, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblA))
                                                .addGap(58)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtPA, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtA, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(150, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(160, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblA)
                                        .addComponent(txtA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(96)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblPA, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPA, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addGap(176)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btn)
                                        .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                .addGap(39))
        );
        contentPane.setLayout(gl_contentPane);
        contentPane.setOpaque(false);
        setVisible(true);
        setResizable(false);
    }
    private class MyActionListener implements ActionListener{

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btn){
                //------------输入框获取信息--------------
                String account1=txtA.getText();
                String passwordA=txtPA.getText();

                //----------查询数据库进行比较-------------
                UserAndAdminDao dao=new UserAndAdminDao();//获得对数据库的操作权限
                Object[] o=new Object[2];
                o[0]=account[0];
                o[1]=passwordA;
                Object[] o1=new Object[1];
                o1[0]=account1;
                List<User> userList=new LinkedList<User>();
                List<Admin> adminList=new LinkedList<Admin>();

                //-----1.对管理员密码进行查询比较-----
                try {
                    adminList=dao.findAdmin("select * from bankadmin where account=? and password=?",o);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                if(!adminList.isEmpty()){//输入正确
                    try {
                        //--------2.对用户账号进行查询比较--------
                        userList=dao.findUsers("select * from bankuser where account=?",o1);
                        if(!userList.isEmpty()){
                            dispose();
                            new SearchUserView(account,userList);
                        }else{
                            JOptionPane.showMessageDialog(null,"输入账号不存在，请重新输入！","",JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"输入密码不存在，请重新输入！","",JOptionPane.WARNING_MESSAGE);
                }
            }else if(e.getSource()==btnR){
                dispose();
                new AdminMainMenu(account);
            }
        }
    }
}
