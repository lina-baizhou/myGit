/*
 * Created by JFormDesigner on Tue Jan 05 09:45:02 CST 2021
 */

package function;

import loginandregister.MainMenu;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.*;

/**
 *用户功能界面
 */
public class UserMainMenu extends JFrame {
    private String[] account;//账号

    private JPanel contentPane;

    private JLabel lbl;//提示信息框

    private JButton btnS;//存款按钮
    private JButton btnW;//取款按钮
    private JButton btnS1;//查询余额按钮
    private JButton btnE;//退出按钮
    private  JButton btnR;//返回按钮
    private JButton btnD;//转账按钮

    public String[] getAccount() {
        return account;
    }

    public UserMainMenu(String[] account) {
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

        lbl = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u66B4\u5BCC\u94F6\u884C");
        lbl.setFont(new Font("楷体", Font.BOLD, 30));

        //存款
        btnS = new JButton("\u5B58\u6B3E");
        btnS.setFont(new Font("宋体", Font.PLAIN, 20));

        btnW = new JButton("\u53D6\u6B3E");
        btnW.setFont(new Font("宋体", Font.PLAIN, 20));

        btnS1 = new JButton("\u67E5\u8BE2\u4F59\u989D");
        btnS1.setFont(new Font("宋体", Font.PLAIN, 20));

        btnD = new JButton("\u8F6C\u8D26");
        btnD.setFont(new Font("宋体", Font.PLAIN, 20));

        btnE = new JButton("\u9000\u51FA");
        btnE.setFont(new Font("宋体", Font.PLAIN, 20));

        btnR = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u4E2A\u754C\u9762");
        btnR.setFont(new Font("宋体", Font.PLAIN, 20));

        //加入监听器
        ActionListener actionListener=new MyActionListener();
        btnD.addActionListener(actionListener);
        btnE.addActionListener(actionListener);
        btnR.addActionListener(actionListener);
        btnW.addActionListener(actionListener);
        btnS.addActionListener(actionListener);
        btnS1.addActionListener(actionListener);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(lbl, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(517, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(10)
                                                .addComponent(btnW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnS, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnD, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnS1, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                                .addGap(42))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(310)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnR, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnE, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(376, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(lbl, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnS, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnS1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                .addGap(51)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnW, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnD, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                                .addComponent(btnE)
                                .addGap(47)
                                .addComponent(btnR))
        );
        contentPane.setLayout(gl_contentPane);
        contentPane.setOpaque(false);
        setVisible(true);
        setResizable(false);//设置为大小不可变
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private class MyActionListener implements ActionListener{

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnS) {//存款
                dispose();
                new MoneyStrory(account).setVisible(true);
            }else if(e.getSource()==btnW){//取款
                dispose();
                try {
                    new MoneyWithdraw(account).setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }else if(e.getSource()==btnD){//转账
                dispose();
                new MoneyDilever(account);
            }else if(e.getSource()==btnS1){//查询余额
                dispose();
                try {
                    new SearchBalancy(account).setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }else if(e.getSource()==btnE){//退出
                System.exit(0);
            }else if(e.getSource()==btnR){
                dispose();
                new MainMenu();
            }

        }
    }

}
