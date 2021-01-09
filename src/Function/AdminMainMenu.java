package Function;

import LoginAndRegister.AdminLogin;
import LoginAndRegister.MainMenu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarEntry;

public class AdminMainMenu extends JFrame {
    private String[] account;
    private JPanel contentPane;
    private JButton btnC;
    private JButton btnD;
    private JButton btnS;
    private JButton btnS1;
    private JButton btnE;
    private JButton btnR;

    /**
     * Create the frame.
     */
    public AdminMainMenu(String[] account) {
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

        btnC = new JButton("\u4FEE\u6539\u7528\u6237\u5BC6\u7801");
        btnC.setFont(new Font("宋体", Font.PLAIN, 20));

        btnD = new JButton("\u6CE8\u9500\u7528\u6237\u8D26\u53F7");
        btnD.setFont(new Font("宋体", Font.PLAIN, 20));

        btnS = new JButton("\u67E5\u8BE2\u7528\u6237\u4FE1\u606F");
        btnS.setFont(new Font("宋体", Font.PLAIN, 20));

        btnS1= new JButton("\u67E5\u8BE2\u7528\u6237\u8BB0\u5F55");
        btnS1.setFont(new Font("宋体", Font.PLAIN, 20));

        btnE = new JButton("\u9000\u51FA");
        btnE.setFont(new Font("宋体", Font.PLAIN, 15));

        btnR = new JButton("\u8FD4\u56DE");
        btnR.setFont(new Font("宋体", Font.PLAIN, 15));


        //加入监听器
        ActionListener actionListener=new MyactionListener();
        btnC.addActionListener(actionListener);
        btnD.addActionListener(actionListener);
        btnE.addActionListener(actionListener);
        btnR.addActionListener(actionListener);
        btnS.addActionListener(actionListener);
        btnS1.addActionListener(actionListener);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(129)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnD, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnC, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnS, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnS1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                                .addGap(190))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(327)
                                .addContainerGap(400, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(245)
                                .addComponent(btnE, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addGap(149)
                                .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(306, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(155)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnS, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(btnC)
                                                .addGap(41)
                                                .addGap(30)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnD, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnS1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnE, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addGap(33))
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
            if(e.getSource()==btnC){
                dispose();
                new ModifyPWAdmin(account);
            }else if(e.getSource()==btnD){
                dispose();
                new DeleteUserAdmin(account);
            }else if(e.getSource()==btnS){
                dispose();
                new SearchUserAdmin(account);
            }else if(e.getSource()==btnR){
                dispose();
                new MainMenu();
            }else if(e.getSource()==btnE){
                System.exit(0);
            }else if(e.getSource()==btnS1){
                dispose();
                new SearchRecordMenu(account);
            }
        }
    }
}
