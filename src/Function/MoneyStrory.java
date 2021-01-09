/*
 * Created by JFormDesigner on Tue Jan 05 14:54:42 CST 2021
 */

package Function;

import Base.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.*;
import Imformation.*;

/**
 * @author unknown
 */
public class MoneyStrory extends JFrame {
    private JPanel contentPane;
    private String[] account;
    private JTextField txtM;//金额输入框
    private JLabel lblM;//提示框
    private JButton btn;//确认按钮
    private JButton btnR;//返回按钮

    public MoneyStrory(String[] account) {
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

        lblM = new JLabel("\u8BF7\u8F93\u5165\u60A8\u60F3\u8981\u5B58\u50A8\u7684\u91D1\u989D:");
        lblM.setFont(new Font("宋体", Font.PLAIN, 25));

        btnR = new JButton("\u8FD4\u56DE");
        btnR.setFont(new Font("宋体", Font.PLAIN, 15));

        btn = new JButton("\u786E\u5B9A");
        btn.setFont(new Font("宋体", Font.PLAIN, 15));

        //加入监听器
        ActionListener actionListener=new MyActionListener();
        btn.addActionListener(actionListener);
        btnR.addActionListener(actionListener);


        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(122)
                                                .addComponent(lblM)
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
                                                .addComponent(txtM, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(119, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(195)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblM, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtM, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
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
    private class MyActionListener implements ActionListener{

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btn) {

                //-----------存钱信息------------
                String Text = txtM.getText();
                double balary1 = Double.parseDouble(Text);
                UserAndAdminDao dao = new UserAndAdminDao();

                //-----------存钱记录信息----------
                String pattern ="yyyy-MM-dd HH:mm:ss";
                String time=new SimpleDateFormat(pattern).format(System.currentTimeMillis());

                Object[] o1 = new Object[2];
                o1[0] = balary1;
                o1[1] = account[0];

                Object[] o2=new Object[3];
                o2[0]=account[0];
                o2[1]=balary1;
                o2[2]=time;
                int flat = 0;
                try {
                    //存入金额
                    flat = dao.updateUser("update bankuser set balancy=balancy+? where account=?", o1);
                    //存入数据
                    dao.updateRecordStore("insert into storetable values(?,?,?)",o2);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                if (flat != 0) {
                    JOptionPane.showMessageDialog(null, "成功存入" + balary1 + "元", "", JOptionPane.CLOSED_OPTION);
                    dispose();
                    new UserMainMenu(account);
                } else {
                    JOptionPane.showMessageDialog(null, "存储失败", "", JOptionPane.WARNING_MESSAGE);
                    dispose();
                    new UserMainMenu(account);
                }
            }else if(e.getSource()==btnR){
                dispose();
                new UserMainMenu(account);
            }
        }
    }
}
