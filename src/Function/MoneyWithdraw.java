/*
 * Created by JFormDesigner on Tue Jan 05 17:33:38 CST 2021
 */

package Function;

import java.awt.event.*;
import Base.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Imformation.*;
import lombok.SneakyThrows;

/**
 * 取钱
 * 1.查询数据库里该账户的余额
 * 2.进行比较，如果比要取的金额大进行提醒，如果比要取得金额小，提示取钱成功
 * 3.修改数据库中用户余额，把存钱信息存入数据库中
 * 3.重新显示余额
 */
public class MoneyWithdraw extends JFrame {
    private double balancy1;//余额
    private String[] account;//用户账号
    private JLabel lblB;//余额提示框
    private JTextField txtB;//余额显示框
    private JButton btnR;//返回按钮
    private JButton btn;//确定按钮
    public MoneyWithdraw(String[] account) throws SQLException,ClassNotFoundException{
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

        txtB = new JTextField();
        txtB.setFont(new Font("宋体", Font.PLAIN, 25));
        txtB.setColumns(10);

        lblB = new JLabel("\u8BF7\u8F93\u5165\u60A8\u60F3\u8981\u53D6\u51FA\u7684\u91D1\u989D:");
        lblB.setFont(new Font("宋体", Font.PLAIN, 25));

        btnR = new JButton("\u8FD4\u56DE");
        btnR.setFont(new Font("宋体", Font.PLAIN, 15));

        btn = new JButton("\u786E\u5B9A");
        btn.setFont(new Font("宋体", Font.PLAIN, 15));

        //添加监听器
        ActionListener actionListener=new MyActionListner();
        btn.addActionListener(actionListener);
        btnR.addActionListener(actionListener);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(122)
                                                .addComponent(lblB)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(GroupLayout.Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addContainerGap(290, Short.MAX_VALUE)
                                                .addComponent(btn, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                                .addGap(74)))
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(82)
                                                .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtB, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(119, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(195)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtB, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
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

    private class MyActionListner implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn) {

                UserAndAdminDao dao=new UserAndAdminDao();//获得对数据库的操作

                //---------获得信息--------
                balancy1 = Double.parseDouble(txtB.getText());

                //--------查询余额信息---------
                double temp = 0;
                List<User> userList=new LinkedList<User>();
                try {
                    userList= dao.findUsers("select * from bankuser where account=?", account);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                if (!userList.isEmpty()){//查询成功
                    temp = userList.get(0).getBalancy();
                }
                //-------------比较是否足够-----------------
                if (temp >= balancy1) {
                    //-------------------修改数据库中的金额------------------
                    Object[] o1 = new Object[2];
                    o1[0] = balancy1;
                    o1[1] = account[0];
                    try {
                        dao.updateUser("update bankuser set balancy=balancy-? where account=?", o1);//从数据库里减去该金额
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    //-----------------存储取钱记录---------------------------

                    String pattern ="yyyy-MM-dd HH:mm:ss";
                    String time=new SimpleDateFormat(pattern).format(System.currentTimeMillis());

                    Object[] o2=new Object[3];
                    o2[0]=account[0];
                    o2[1]=balancy1;
                    o2[2]=time;

                    try {
                        dao.updateRecordWithdraw("insert into withdrawtable values(?,?,?)", o2);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null, "成功取出" + balancy1 + "元","", JOptionPane.CLOSED_OPTION);//提示信息
                    dispose();
                    new UserMainMenu(account);
                } else {
                    JOptionPane.showMessageDialog(null, "当前余额不足，无法取出", "", JOptionPane.WARNING_MESSAGE);//提示信息
                    setVisible(false);
                    try {
                        new SearchBalancy(account);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }else if(e.getSource()==btnR){
                dispose();
                new UserMainMenu(account);
            }
        }
    }
    private JPanel contentPane;
    private JTextField txtW;

}







