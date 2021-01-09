package LoginAndRegister;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 查询用户记录菜单
 */

public class RecordSearchView extends JFrame {
    private String[] account;//管理员密码

    //-----------组件-------------
    private JPanel contentPane;
    private JButton btnS;//查询用户存款记录按钮
    private JButton btnW;//查询用户取款记录按钮
    private JButton btnD;//查询用户转账记录按钮
    private JButton btn;//确定按钮
    private JButton btnR;//返回按钮
    private JButton btnE;//退出按钮



    /**
     * Create the frame.
     */
    public RecordSearchView(String[] account) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 10, 906, 627);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        btnS = new JButton("\u67E5\u8BE2\u7528\u6237\u5B58\u6B3E\u8BB0\u5F55");
        btnS.setFont(new Font("华文新魏", Font.PLAIN, 30));

        btnW = new JButton("\u67E5\u8BE2\u7528\u6237\u53D6\u6B3E\u8BB0\u5F55");
        btnW.setFont(new Font("华文新魏", Font.PLAIN, 30));

        btnD = new JButton("\u67E5\u8BE2\u7528\u6237\u8F6C\u8D26\u8BB0\u5F55");
        btnD.setFont(new Font("华文新魏", Font.PLAIN, 30));

        btn = new JButton("\u786E\u5B9A");
        btn.setFont(new Font("宋体", Font.PLAIN, 15));

        btnR = new JButton("\u8FD4\u56DE");
        btnR.setFont(new Font("宋体", Font.PLAIN, 15));

        btnE = new JButton("\u9000\u51FA");
        btnE.setFont(new Font("宋体", Font.PLAIN, 15));


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
    }
}
