package Function;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Imformation.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

/**
 * 查询到的用户信息显示界面
 */

public class SearchUserView extends JFrame {
    private List<User> list;//用户信息
    private String[]  account;
    //---------组件------------
    private JPanel contentPane;
    private JTextField txtA;//账号
    private JTextField txtID;//身份证号
    private JTextField txtB;//余额
    private JLabel lblA;//账号提示框
    private JLabel lblID;//身份证提示框
    private JLabel lblB;//余额提示框
    private JLabel lblU;//信息提示框
    private JButton btnC;//收藏按钮
    private JButton btnR;//返回按钮
    private JLabel lblQq;
    private JTextField textQq;
    private User user;//收藏的用户
    /**
     * Create the frame.
     */
    public SearchUserView(String[] account,List<User> list) {

        this.account=account;
        this.list=list;

        user=list.get(0);
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

        lblA = new JLabel("\u8D26\u53F7\uFF1A");
        lblA.setFont(new Font("宋体", Font.PLAIN, 25));

        lblID = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
        lblID.setHorizontalAlignment(SwingConstants.RIGHT);
        lblID.setFont(new Font("宋体", Font.PLAIN, 25));

        txtA = new JTextField();
        txtA.setFont(new Font("宋体", Font.PLAIN, 25));
        txtA.setColumns(10);

        txtID = new JTextField();
        txtID.setFont(new Font("宋体", Font.PLAIN, 25));
        txtID.setColumns(10);

        lblB = new JLabel("\u4F59\u989D\uFF1A");
        lblB.setHorizontalAlignment(SwingConstants.RIGHT);
        lblB.setFont(new Font("宋体", Font.PLAIN, 25));

        txtB = new JTextField();
        txtB.setFont(new Font("宋体", Font.PLAIN, 25));
        txtB.setColumns(10);

        lblU = new JLabel("\u7528\u6237\u4FE1\u606F");
        lblU.setFont(new Font("华文中宋", Font.BOLD, 30));

        textQq = new JTextField();
        textQq.setText((String) null);
        textQq.setFont(new Font("宋体", Font.PLAIN, 25));
        textQq.setColumns(10);


        //---------------显示信息----------------
        txtA.setText(list.get(0).getAccount());
        txtID.setText(list.get(0).getID());
        txtB.setText(String.valueOf(list.get(0).getBalancy()));
        textQq.setText(list.get(0).getEmail());


        btnC = new JButton("\u6536\u85CF");
        btnC.setFont(new Font("宋体", Font.PLAIN, 16));

        btnR = new JButton("\u8FD4\u56DE");
        btnR.setFont(new Font("宋体", Font.PLAIN, 16));


        //-------------------------添加监听器------------------
        ActionListener actionListener=new MyActionListener();
        btnR.addActionListener(actionListener);
        btnC.addActionListener(actionListener);

        lblQq = new JLabel("QQ\u90AE\u7BB1\uFF1A");
        lblQq.setHorizontalAlignment(SwingConstants.RIGHT);
        lblQq.setFont(new Font("宋体", Font.PLAIN, 25));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(358)
                                                .addComponent(lblU, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addGap(289)
                                                                        .addComponent(btnC, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addGap(71)
                                                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(lblID, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lblA)
                                                                                .addComponent(lblB, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(52)
                                                                .addComponent(lblQq, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(58)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(textQq, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtB, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtID, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtA, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(155))))))
                                .addContainerGap(160, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(52)
                                .addComponent(lblU)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblA)
                                        .addComponent(txtA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(40)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblID, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtID, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addGap(46)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblB, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtB, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addGap(45)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblQq, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textQq, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(btnC, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                                .addGap(31))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                                .addGap(33))))
        );
        contentPane.setLayout(gl_contentPane);
        contentPane.setOpaque(false);
        setVisible(true);
        setResizable(false);
    }
    private class MyActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnR){
                dispose();
                new AdminMainMenu(account);
            }else if(e.getSource()==btnC){
                try {
                    new UserCollection(user);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,"收藏成功！","",JOptionPane.CLOSED_OPTION);
                dispose();
                new AdminMainMenu(account);
            }
        }
    }
}
