package Function;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import Imformation.*;

public class ModifyPWAdmin1 extends JFrame {
    String[] account;
    private JPanel contentPane;
    private JPasswordField txtP;
    private JLabel lblIP;
    private JButton btn;
    private JButton btnR;
    private String txt;
    private JLabel lblIPA;
    private JPasswordField txtPA;
    private JLabel lblText;
    private JTextField txtText;
    private  String accountUser;


    /**
     * Create the frame.
     */
    public ModifyPWAdmin1(String[] account,String accountUser,String txt) {
        this.account=account;
        this.txt=txt;
        this.accountUser=accountUser;

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

        btn = new JButton("\u786E\u8BA4");
        btn.setFont(new Font("宋体", Font.PLAIN, 20));

        lblIP = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u6210\u7684\u5BC6\u7801\uFF1A");
        lblIP.setFont(new Font("宋体", Font.PLAIN, 20));

        txtPA = new JPasswordField();
        txtPA.setFont(new Font("宋体", Font.PLAIN, 40));
        txtPA.setColumns(10);

        btnR = new JButton("\u8FD4\u56DE");
        btnR.setFont(new Font("宋体", Font.PLAIN, 20));

        //加入监听器
        ActionListener actionListener=new MyactionListener();
        btn.addActionListener(actionListener);
        btnR.addActionListener(actionListener);

        lblIPA = new JLabel("\u8BF7\u8BF7\u8F93\u5165\u7BA1\u7406\u5458\u5BC6\u7801\uFF1A");
        lblIPA.setHorizontalAlignment(SwingConstants.CENTER);
        lblIPA.setFont(new Font("宋体", Font.PLAIN, 20));

        txtP = new JPasswordField();
        txtP.setFont(new Font("宋体", Font.PLAIN, 40));
        txtP.setColumns(10);

        lblText = new JLabel("\u8BF7\u8F93\u5165\u9A8C\u8BC1\u7801\uFF1A");
        lblText.setHorizontalAlignment(SwingConstants.CENTER);
        lblText.setFont(new Font("宋体", Font.PLAIN, 20));

        txtText = new JTextField();
        txtText.setFont(new Font("宋体", Font.PLAIN, 40));
        txtText.setColumns(10);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(95)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblIP)
                                                                .addGap(18)
                                                                .addComponent(txtPA, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblText, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18)
                                                                                .addComponent(txtText))
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblIPA, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18)
                                                                                .addComponent(txtP, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE))))))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(149)
                                                .addComponent(btn, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
                                                .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
                                .addGap(165))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(182)
                                                .addComponent(lblIP, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(txtPA, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
                                .addGap(47)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtP, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblIPA, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                                .addGap(40)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblText, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtText, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                .addGap(117)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btn)
                                        .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
        contentPane.setOpaque(false);
        setVisible(true);
        setResizable(false);
    }
    private class MyactionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btn) {
                String password = txtP.getText();
                UserAndAdminDao dao=new UserAndAdminDao();
                //---------------查询管理员信息--------------
                Object[] o1=new Object[2];
                o1[0]=account[0];
                o1[1]=password;

                List<Admin> adminList=new LinkedList<>();
                try{
                    adminList=dao.findAdmin("select * from bankadmin where account=? and password=?",o1);
                }catch (Exception e1){
                    e1.printStackTrace();
                }

                if((!adminList.isEmpty())&&txtText.getText().equals(txt)) {
                    Object[] o2 = new Object[2];
                    o2[0] = txtPA.getText();
                    o2[1] = accountUser;
                    int num = 0;
                    try {
                        num = dao.updateUser("update bankuser set password=? where account=?", o2);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    if (num != 0) {
                        JOptionPane.showMessageDialog(null, "修改成功！", "", JOptionPane.CLOSED_OPTION);
                        dispose();
                        new AdminMainMenu(account);
                    } else {
                        JOptionPane.showMessageDialog(null, "修改失败！", "", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new AdminMainMenu(account);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "管理员密码或验证码输入错误，请修改！", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }else if(e.getSource()==btnR){
                dispose();
                new AdminMainMenu(account);
            }
        }
    }
}
