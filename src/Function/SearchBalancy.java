/*
 * Created by JFormDesigner on Tue Jan 05 16:18:54 CST 2021
 */

package Function;

import java.awt.*;
import java.awt.event.*;
import java.nio.file.attribute.AttributeView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Imformation.*;

import Base.*;

/**
 *查询余额
 */
public class SearchBalancy extends JFrame {

    private JPanel contentPane;
    private String[] account;
    private double balancy;
    private JTextField txtB;
    private JLabel lblB;
    private JButton btnE;
    private JButton btnR;


    public SearchBalancy(String[] account) throws Exception {
        this.account=account;
        System.out.println(account.length);

        UserAndAdminDao dao=new UserAndAdminDao();//或得对数据库的操作
        List<User> userList=new LinkedList<User>();
        userList=dao.findUsers("select * from bankuser where account=?",account);
        if(!userList.isEmpty()){
            balancy=userList.get(0).getBalancy();
        }

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
        txtB.setText(String.valueOf(balancy));

        lblB = new JLabel("\u60A8\u7684\u4F59\u989D\u4E3A\uFF1A");
        lblB.setFont(new Font("宋体", Font.PLAIN, 25));

        btnE = new JButton("\u9000\u51FA");
        btnE.setFont(new Font("宋体", Font.PLAIN, 15));

        btnR = new JButton("\u8FD4\u56DE");
        btnR.setFont(new Font("宋体", Font.PLAIN, 15));

        //添加监听器
        ActionListener actionListener=new MyActionListener();
        btnE.addActionListener(actionListener);
        btnR.addActionListener(actionListener);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(209)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblB)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(40)
                                                .addComponent(txtB, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(102)
                                                .addComponent(btnE, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(221, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(195)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtB, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnR)
                                        .addComponent(btnE, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                .addGap(54))
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
            if(e.getSource()==btnE){
                System.exit(0);
            }else if(e.getSource()==btnR){
                dispose();
                new UserMainMenu(account).setVisible(true);
            }
        }
    }
}
