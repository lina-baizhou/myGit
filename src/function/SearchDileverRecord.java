package function;

import imformation.Admin;
import imformation.RecordDilever;
import imformation.UserAndAdminDao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 查询用户转账记录
 */
public class SearchDileverRecord extends JFrame{
    private String[] account;//管理员密码

    //-------------组件--------------
    private JPanel contentPane;
    private JTextField txtA;//用户账号输入框
    private JPasswordField txtP;//管理员密码输入框
    private JLabel lblA;//用户账号提示框
    private JLabel lblP;//管理员密码输入提示框
    private JButton btn;//确定按钮
    private JButton btnR;//返回按钮
    private JButton btnE;//退出按钮

    /**
     * Create the frame.
     */
    public SearchDileverRecord(String[] account) {
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

        btn = new JButton("\u786E\u5B9A");
        btn.setFont(new Font("宋体", Font.PLAIN, 15));

        btnR = new JButton("\u8FD4\u56DE");
        btnR.setFont(new Font("宋体", Font.PLAIN, 14));

        btnE = new JButton("\u9000\u51FA");
        btnE.setFont(new Font("宋体", Font.PLAIN, 14));

        lblA = new JLabel("\u8BF7\u8F93\u5165\u4F60\u60F3\u8981\u67E5\u8BE2\u7684\u7528\u6237\u8D26\u53F7\uFF1A");
        lblA.setFont(new Font("宋体", Font.PLAIN, 20));

        txtA = new JTextField();
        txtA.setFont(new Font("宋体", Font.PLAIN, 20));
        txtA.setColumns(10);

        lblP = new JLabel("\u8BF7\u8F93\u5165\u7BA1\u7406\u5458\u5BC6\u7801\uFF1A");
        lblP.setFont(new Font("宋体", Font.PLAIN, 20));

        txtP = new JPasswordField();
        txtP.setFont(new Font("宋体", Font.PLAIN, 20));
        txtP.setColumns(10);

        //-----------加入监听器-------------
        ActionListener actionListener=new MyActionListener();
        btn.addActionListener(actionListener);
        btnE.addActionListener(actionListener);
        btnR.addActionListener(actionListener);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(156)
                                                .addComponent(btn)
                                                .addGap(171)
                                                .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                .addGap(177)
                                                .addComponent(btnE, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(101)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblP, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtP, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblA, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtA, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(176, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(167)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtA)
                                        .addComponent(lblA, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                                .addGap(79)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblP, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtP, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnE, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn)
                                        .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                .addGap(42))
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
            if (e.getSource() == btnE) {
                System.exit(0);
            } else if (e.getSource() == btnR) {
                dispose();
                new AdminMainMenu(account).setVisible(true);
            }else if(e.getSource()==btn){
                //------------获取信息------------------
                String account1=txtA.getText();
                String password=txtP.getText();

                UserAndAdminDao dao=new UserAndAdminDao();//获得数据库操作

                //-----------查询管理员密码是否错误----------
                Object[] o1=new Object[2];
                o1[0]=account[0];
                o1[1]=password;
                java.util.List<Admin> adminList=new ArrayList<>();
                try {
                    adminList=dao.findAdmin("select * from bankadmin where account=? and password=?",o1);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                if(!adminList.isEmpty()){//密码正确
                    Object[] o2=new Object[1];
                    o2[0]=account1;
                    List<RecordDilever> dileverList=new LinkedList<RecordDilever>();
                    //List<RecordDilever> dileverList=new LinkedList<RecordDilever>();
                    try {
                        dileverList=dao.findRecordDilever("select * from dilevertable where accountA=? order by time desc",o2);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    if(!dileverList.isEmpty()){
                        dispose();
                        new DileverRecordView(account,dileverList);
                    }else{
                        JOptionPane.showMessageDialog(null,"该账号不存在转账记录，请重新输入！","",JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"密码输入错误，请修改！","",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}
