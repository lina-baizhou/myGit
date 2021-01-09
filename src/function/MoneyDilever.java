/*
 * Created by JFormDesigner on Tue Jan 05 19:36:46 CST 2021
 */

package function;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import imformation.*;

/**
 * 转账
 * 1.先查询是否存在该账户
 * 2.再判断金额是否足够
 * 3.足够则修改数据库，一个减一个加，并且把记录存储
 */
public class MoneyDilever extends JFrame {

    private String[] account;//本账号
    private JPanel contentPane;
    private JLabel lblM;//金额输入提示框
    private JLabel lblA;//账户输入提示框
    private JTextField txtM;//金额输入框
    private JTextField txtA;//账号输入框
    private JButton btn;//确认按钮
    private JButton btnR;//返回按钮


    /**
     * Launch the application.
     */


    /**
     * Create the frame.
     */
    public MoneyDilever(String[] account) {
        this.account=account;

        //设置背景
        JPanel panel=new JPanel();
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

        txtM = new JTextField();
        txtM.setFont(new Font("宋体", Font.PLAIN, 25));
        txtM.setColumns(10);

        lblM = new JLabel("\u8BF7\u8F93\u5165\u60A8\u5C06\u8981\u8F6C\u5165\u7684\u91D1\u989D:");
        lblM.setFont(new Font("宋体", Font.PLAIN, 25));

        btnR = new JButton("\u8FD4\u56DE");
        btnR.setFont(new Font("宋体", Font.PLAIN, 15));

        btn = new JButton("\u786E\u5B9A");
        btn.setFont(new Font("宋体", Font.PLAIN, 15));

        lblA = new JLabel("\u8BF7\u8F93\u5165\u60A8\u5C06\u8981\u8F6C\u5165\u7684\u5361\u53F7:");
        lblA.setFont(new Font("宋体", Font.PLAIN, 25));

        txtA = new JTextField();
        txtA.setFont(new Font("宋体", Font.PLAIN, 25));
        txtA.setColumns(10);

        //加入监听器
        ActionListener actionListener=new MyActionListener1();
        btn.addActionListener(actionListener);
        btnR.addActionListener(actionListener);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap(290, Short.MAX_VALUE)
                                                .addComponent(btn, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                                .addGap(74))
                                        .addGroup(GroupLayout.Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addGap(124)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblM, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblA, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
                                                .addGap(30)))
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(82)
                                                .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(7)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtA)
                                                        .addComponent(txtM, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))))
                                .addContainerGap(53, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(202)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblA, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtA, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(39)
                                                .addComponent(lblM, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtM, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
                                .addGap(179)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn)
                                        .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                .addGap(54))
        );
        contentPane.setLayout(gl_contentPane);
        contentPane.setOpaque(false);
        setVisible(true);
        setResizable(false);
    }
    private class MyActionListener1 implements ActionListener{

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn) {
                Boolean flag = false;
                String account1 = txtA.getText();
                double money = Double.parseDouble(txtM.getText());

                ResultSet resultSet;
                double balancy1;//转账账号

                UserAndAdminDao dao=new UserAndAdminDao();

                //查询金额和账号

                //查询金额并进行判断
                try {
                    List<User> userList=new LinkedList<User>();
                    userList=dao.findUsers("select * from bankuser where account=?",account);
                    if (!userList.isEmpty()) {
                        balancy1 = userList.get(0).getBalancy();
                        if (balancy1 < money) {
                            JOptionPane.showMessageDialog(null, "金额不够,转账失败", "标题", JOptionPane.WARNING_MESSAGE);
                            setVisible(false);
                            new UserMainMenu(account).setVisible(true);
                        } else {
                            Object[] o = new Object[1];
                            o[0] = account1;
                            userList=dao.findUsers("select * from bankuser where account=?", o);
                            if (!userList.isEmpty()) {
                                flag = true;
                            }
                            if (flag == true) {
                         /*
                        转账
                        1.A卡转B卡C元
                        （1）A卡余额减C元;
                        （2）B卡余额加C元
                         */
                                //A卡减C元
                                Object[] o1 = new Object[2];
                                o1[0] = money;
                                o1[1] = account[0];
                                dao.updateUser("update bankuser set balancy=balancy-? where account=?", o1);

                                //B卡加C元
                                Object[] o2 = new Object[2];
                                o2[0] = money;
                                o1[1] = account1;
                               dao.excuteSQL2("update bankuser set balancy=balancy+? where account=?", o1);

                               //--------------存储记录---------------

                                //--------获取时间-------
                                String pattern ="yyyy-MM-dd HH:mm:ss";
                                String time=new SimpleDateFormat(pattern).format(System.currentTimeMillis());

                                Object[] o3=new Object[4];
                                o3[0]=account[0];
                                o3[1]=account1;
                                o3[2]=money;
                                o3[3]=time;

                                int num=dao.updateRecordDilever("insert into dilevertable values(?,?,?,?)",o3);

                                JOptionPane.showMessageDialog(null, "转账成功", "", JOptionPane.CLOSED_OPTION);

                                dispose();
                                new UserMainMenu(account).setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "", "输入的账号不存在，转账失败", JOptionPane.INFORMATION_MESSAGE);
                                dispose();
                                new UserMainMenu(account).setVisible(true);
                            }
                        }
                    }
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }else if(e.getSource()==btnR){
                dispose();
                new UserMainMenu(account).setVisible(true);
            }
        }
    }
}
