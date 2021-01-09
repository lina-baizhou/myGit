package loginandregister;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 主界面
 */
public class MainMenu extends JFrame{
    private JPanel contentPane;
    private JRadioButton rBtnU;//选择用户
    private JRadioButton rBtnA;//选择管理员
    private JLabel lblT;//提示信息
    private JLabel lblC;//提示信息
    private JLabel lblNewLabel;//提示信息
    private ActionEvent e;


    public MainMenu(){

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

        //准备组件
        lblT = new JLabel("\u6B22\u8FCE\u6765\u5230\u66B4\u5BCC\u94F6\u884C\uFF01");
        lblT.setFont(new Font("宋体", Font.PLAIN, 30));

        lblC = new JLabel("\u8BF7\u9009\u62E9\u4F60\u7684\u8EAB\u4EFD");
        lblC.setFont(new Font("宋体", Font.PLAIN, 20));

        rBtnU = new JRadioButton("\u7528\u6237");
        rBtnU.setFont(new Font("宋体", Font.PLAIN, 20));

        rBtnA = new JRadioButton("\u7BA1\u7406\u5458");
        rBtnA.setFont(new Font("宋体", Font.PLAIN, 20));


        lblNewLabel = new JLabel("\u8BF7\u7559\u610F\u8EAB\u8FB9\u7684\u72B6\u51B5\uFF0C\u65F6\u523B\u6CE8\u610F\u60A8\u7684\u8D22\u4EA7\u5B89\u5168");
        lblNewLabel.setForeground(Color.CYAN);
        lblNewLabel.setBackground(new Color(255, 0, 0));
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));

        //添加监听器
        ActionListener actionListener=new MyActionListener();
        rBtnA.addActionListener(actionListener);
        rBtnU.addActionListener(actionListener);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(338)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(rBtnU)
                                                .addGap(41)
                                                .addComponent(rBtnA))
                                        .addComponent(lblC, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(221, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(298, Short.MAX_VALUE)
                                .addComponent(lblT, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                                .addGap(294))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(378, Short.MAX_VALUE)
                                .addComponent(lblNewLabel)
                                .addGap(23))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(54)
                                .addComponent(lblT, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addGap(188)
                                .addComponent(lblC, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(42)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(rBtnA)
                                        .addComponent(rBtnU))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(lblNewLabel)
                                .addGap(54))
        );

        contentPane.setLayout(gl_contentPane);

        contentPane.setOpaque(false);

        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private class MyActionListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {//如果点击按钮则进入下一个页面
            if(e.getSource()==rBtnU) {
                //setVisible(false);
                dispose();
                new UserMenu();
            }
            else if(e.getSource()==rBtnA) {
                //setVisible(false);
                dispose();
                new AdminMenu();
            }
        }
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
