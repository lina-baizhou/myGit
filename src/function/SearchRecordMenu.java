package function;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 查询用户记录菜单
 */

public class SearchRecordMenu extends JFrame {
    private String[] account;//管理员账号

    //----------------------组件------------------------
    private JPanel contentPane;

    private JButton btnS;//查询用户存钱按钮
    private JButton btnW;//查询用户取钱按钮
    private JButton btnD;//查询用户转账记录
    private JButton btn;//确认按钮
    private JButton btnR;//返回按钮
    private JButton btnE;//退出按钮

    /**
     * Create the frame.
     */
    public SearchRecordMenu(String[] account) {
        this.account = account;

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

        btnS = new JButton("\u67E5\u8BE2\u7528\u6237\u5B58\u6B3E\u8BB0\u5F55");
        btnS.setFont(new Font("华文新魏", Font.PLAIN, 30));

        btnW = new JButton("\u67E5\u8BE2\u7528\u6237\u53D6\u6B3E\u8BB0\u5F55");
        btnW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnW.setFont(new Font("华文新魏", Font.PLAIN, 29));

        btnD = new JButton("\u67E5\u8BE2\u7528\u6237\u8F6C\u8D26\u8BB0\u5F55");
        btnD.setFont(new Font("华文新魏", Font.PLAIN, 29));

        btn = new JButton("\u786E\u5B9A");
        btn.setFont(new Font("宋体", Font.PLAIN, 15));

        btnR = new JButton("\u8FD4\u56DE");
        btnR.setFont(new Font("宋体", Font.PLAIN, 14));

        btnE = new JButton("\u9000\u51FA");
        btnE.setFont(new Font("宋体", Font.PLAIN, 14));

        //------------加入监听器----------------
        ActionListener actionListener=new MyActionListener();
        btn.addActionListener(actionListener);
        btnD.addActionListener(actionListener);
        btnE.addActionListener(actionListener);
        btnR.addActionListener(actionListener);
        btnS.addActionListener(actionListener);
        btnW.addActionListener(actionListener);

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
                                                .addGap(281)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnW, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnD, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnS))))
                                .addContainerGap(189, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addGap(122)
                                .addComponent(btnS)
                                .addGap(60)
                                .addComponent(btnW, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addGap(62)
                                .addComponent(btnD, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
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
            }else if(e.getSource()==btnS){
                dispose();
                new SearchStoreRecord(account);
            }else if(e.getSource()==btnW){
                dispose();
                new SearchWithdrawRecord(account);
            }else if(e.getSource()==btnD){
                dispose();
                System.out.println("你好");
                new SearchDileverRecord(account);
                System.out.println("你好");
            }
        }
    }
}
