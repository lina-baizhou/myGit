package LoginAndRegister;

import org.apache.commons.mail.EmailException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ConcurrentHashMap;

public class UserMenu extends JFrame{private JPanel contentPane;;
    private JLabel lblI;
    private JLabel lblI1;
    private JButton btnL;
    private JButton btnR;
    private JButton btnE;


    public UserMenu(){
        JPanel panel=new JPanel();
        ImageIcon backIcon = new ImageIcon("C:\\Users\\lina\\IdeaProjects\\BankManagementProject\\src\\LoginAndRegister\\txt1.jpg");// 加载图片
        JLabel backLabel = new JLabel(backIcon);// 将图片放入label中
        backLabel.setBounds(0, 0, 906, 627);// 设置label的大小

        getLayeredPane().add(backLabel, new Integer(Integer.MIN_VALUE));// 获取窗口的第二层，将label放入

        panel = (JPanel) getContentPane();// 获取frame的顶层容器
        panel.setOpaque(false);// 设置为透明*/

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 10, 906, 627);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        lblI = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u66B4\u5BCC\u94F6\u884C\uFF01");
        lblI.setBackground(Color.WHITE);
        lblI.setForeground(UIManager.getColor("Button.foreground"));
        lblI.setFont(new Font("华文中宋", Font.BOLD, 30));

        lblI1 = new JLabel("\u8BF7\u9009\u62E9\u4F60\u63A5\u4E0B\u6765\u7684\u64CD\u4F5C:");
        lblI1.setFont(new Font("宋体", Font.PLAIN, 20));

        btnL = new JButton("\u767B\u5F55");
        btnL.setFont(new Font("宋体", Font.PLAIN, 20));

        btnR = new JButton("\u6CE8\u518C");
        btnR.setFont(new Font("宋体", Font.PLAIN, 20));

        btnE = new JButton("\u9000\u51FA");
        btnE.setFont(new Font("宋体", Font.PLAIN, 20));

        //添加监听器
        ActionListener actionListener=new MyActionListener();
        btnE.addActionListener(actionListener);
        btnL.addActionListener(actionListener);
        btnR.addActionListener(actionListener);


        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(290, Short.MAX_VALUE)
                                .addComponent(lblI, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                                .addGap(266))
                        .addGroup(GroupLayout.Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGap(213)
                                .addComponent(btnL, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                                .addComponent(btnR, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                .addGap(218))
                        .addGroup(GroupLayout.Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGap(95)
                                .addComponent(lblI1)
                                .addContainerGap(577, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(779, Short.MAX_VALUE)
                                .addComponent(btnE)
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(44)
                                .addComponent(lblI)
                                .addGap(226)
                                .addComponent(lblI1)
                                .addGap(56)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnL)
                                        .addComponent(btnR))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                                .addComponent(btnE))
        );
        contentPane.setOpaque(false);
        contentPane.setLayout(gl_contentPane);

        setVisible(true);

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
            if(e.getSource()==btnL){
                dispose();
                new UserLogin();
            }else if(e.getSource()==btnR){
                dispose();
                try {
                    new UserRegister();
                } catch (EmailException emailException) {
                    emailException.printStackTrace();
                }
            }else if(e.getSource()==btnE){
                System.exit(0);
            }
        }
    }
}
