package LoginAndRegister;

import com.mysql.cj.protocol.x.XProtocolRowInputStream;

import Function.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import Imformation.*;
import Base.*;

/*
用户登录界面
 */
public class UserLogin {

    private JFrame jFrame;
    private JLabel lblA;
    private JLabel lblP;
    private JTextField txtAcount;
    private JPasswordField passwordField;
    private JButton btn;

    public UserLogin(){
        jFrame=new JFrame();
        JPanel panel=new JPanel();
        ImageIcon backIcon = new ImageIcon("C:\\Users\\lina\\IdeaProjects\\BankManagementProject\\src\\LoginAndRegister\\txt1.jpg");// 加载图片
        JLabel backLabel = new JLabel(backIcon);// 将图片放入label中
        backLabel.setBounds(0, 0, 906, 627);// 设置label的大小

        jFrame.getLayeredPane().add(backLabel, new Integer(Integer.MIN_VALUE));// 获取窗口的第二层，将label放入

        panel = (JPanel) jFrame.getContentPane();// 获取frame的顶层容器
        panel.setOpaque(false);// 设置为透明*/
        jFrame.setBounds(10,10,906,627);
        jFrame.setResizable(false);

        //准备组件
        lblA=new JLabel("账号：");
        lblA.setFont(new Font("隶书", Font.BOLD,30));
        lblP=new JLabel("密码：");
        lblP.setFont(new Font("隶书", Font.BOLD,30));
        txtAcount=new JTextField(20);
        txtAcount.setFont(new Font("隶书", Font.BOLD,30));
        passwordField=new JPasswordField(20);
        passwordField.setFont(new Font("隶书", Font.BOLD,30));
        passwordField.setEchoChar('*');
        btn=new JButton("登录");
        btn.setFont(new Font("隶书",Font.BOLD,30));

        //获得当前容器以及设置布局管理器
        Container container=jFrame.getContentPane();
        container.setLayout(new GridLayout(5,1));

        //设置监听器
        ActionListener actionListener=new MyActionListener();
        txtAcount.addActionListener(actionListener);
        passwordField.addActionListener(actionListener);
        btn.addActionListener(actionListener);


        //把当前组件加入
        JPanel panel01=new JPanel();
        panel01.setOpaque(false);
        container.add(panel01);
        JPanel panel1=new JPanel();
        panel1.add(lblA);
        panel1.add(txtAcount);
        panel1.setOpaque(false);
        container.add(panel1);
        JPanel panel2=new JPanel();
        panel2.add(lblP);
        panel2.add(passwordField);
        panel2.setOpaque(false);
        container.add(panel2);
        JPanel panel3=new JPanel();
        panel3.add(btn);
        panel3.setOpaque(false);
        container.add(panel3);

        //设置为可见以及关闭模式
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private class MyActionListener implements ActionListener{

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btn){
                String accont=txtAcount.getText();
                String password=passwordField.getText();

                try{
                    Object[] o=new Object[2];//把信息放入数组
                    o[0]=accont;
                    o[1]=password;

                    UserAndAdminDao dao=new UserAndAdminDao();
                    List<User> userList=new LinkedList<User>();
                    String sql="select * from bankuser where account=? and password=?";
                    userList=dao.findUsers(sql,o);
                    if(!userList.isEmpty()){
                        jFrame.setVisible(false);
                        String[] account1=new String[1];
                        account1[0]=accont;
                        jFrame.dispose();
                        new UserMainMenu(account1).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"登录失败","",JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
