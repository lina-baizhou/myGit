package Function;

import Imformation.Admin;
import Imformation.User;
import Imformation.UserAndAdminDao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * 验证码输入界面，输入正确则进行注销账号
 */
public class DeleteUserTextView extends JFrame {

    private String accountU; //用户账号
    private String txt;//验证码
    private String[] account;//管理员账号

    //组件
    private JPanel contentPane;
    private JButton btn;//确定按钮
    private JButton btnR;//退出按钮
    private JLabel lblText;//验证码输入提示框
    private JTextField txtText;//验证码输入框


    /**
     * Create the frame.
     */
    public DeleteUserTextView(String[] account,String accountU,String txt) {
        this.account=account;
        this.txt=txt;
        this.accountU=accountU;

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

        btn = new JButton("\u786E\u5B9A");
        btn.setFont(new Font("宋体", Font.PLAIN, 15));

        btnR = new JButton("返回");
        btnR.setFont(new Font("宋体", Font.PLAIN, 14));

        lblText = new JLabel("\u8BF7\u8F93\u5165\u9A8C\u8BC1\u7801\uFF1A");
        lblText.setHorizontalAlignment(SwingConstants.RIGHT);
        lblText.setFont(new Font("宋体", Font.PLAIN, 25));

        txtText = new JTextField();
        txtText.setFont(new Font("宋体", Font.PLAIN, 25));
        txtText.setColumns(10);
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
                                                .addGap(67)
                                                .addComponent(lblText, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
                                                .addGap(62)
                                                .addComponent(txtText, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(160, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(157)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(txtText, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btn)
                                        .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                .addGap(39))
        );

        //-----------------------添加监听器-----------------------
        ActionListener actionListener=new MyActionListner();
        btn.addActionListener(actionListener);
        btnR.addActionListener(actionListener);
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
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btn){
                //------------------验证码比较是否一致-----------------
                if(txt.equals(txtText.getText())){//一致则进行注销

                    //--------------进行注销--------------
                    UserAndAdminDao dao=new UserAndAdminDao();
                    int num=0;
                    Object[] o=new Object[1];
                    o[0]=accountU;
                    try {
                        num= dao.updateUser("delete from bankuser where account=?",o);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    if(num!=0){
                        JOptionPane.showMessageDialog(null,"注销成功！","",JOptionPane.CLOSED_OPTION);
                        dispose();
                        new AdminMainMenu(account);
                    }else{
                        JOptionPane.showMessageDialog(null,"注销失败！","",JOptionPane.WARNING_MESSAGE);
                        dispose();
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"验证码输入错误，请重新输入！","",JOptionPane.WARNING_MESSAGE);
                }
            }else if(e.getSource()==btnR){
                dispose();
                new AdminMainMenu(account);
            }
        }
    }
}
