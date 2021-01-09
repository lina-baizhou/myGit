package Function;

import Imformation.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class DileverRecordView extends JFrame{
    private String[] account;
    private List<RecordDilever>  dileverList;//记录
    private JPanel contentPane;// 定义窗体内容面板，放置各组件
    private JTable table;// 定义表格
    private DefaultTableModel model;//定义表格数据模型
    private JButton btnR;//返回按钮
    private JButton btnE;//退出按钮


    /**
     * Create the frame.
     */
    public DileverRecordView(String[] account,List<RecordDilever>  dileverList) {
        this.account=account;
        this.dileverList=dileverList;

        //设置背景
        JPanel panel = new JPanel();
        ImageIcon backIcon = new ImageIcon("C:\\Users\\lina\\IdeaProjects\\BankManagementProject\\src\\LoginAndRegister\\txt1.jpg");// 加载图片
        JLabel backLabel = new JLabel(backIcon);// 将图片放入label中
        backLabel.setBounds(0, 0, 906, 627);// 设置label的大小

        //setLayout(new GridLayout(5,2));
        getLayeredPane().add(backLabel, new Integer(Integer.MIN_VALUE));// 获取窗口的第二层，将label放入

        panel = (JPanel) getContentPane();// 获取frame的顶层容器
        panel.setOpaque(false);// 设置为透明*/

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭按钮
        setBounds(10, 10, 906, 627);// 设置窗体位置与大小
        contentPane = new JPanel();// 实例化内容面板
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
        contentPane.setLayout(null);// 设置面板布局为绝对布局
        setContentPane(contentPane);// 将窗体默认面板

        //设置滚动面板
        JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
        scrollPane.setBounds(143, 87, 623, 357);// 设置大小与位置
        contentPane.add(scrollPane);// 将滚动面板加入到内容面板中
        contentPane.setOpaque(false);

        //使用动态数组数据（列标题与行数据）
        Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题

        Collections.addAll(titles, "转卡账号","金额", "时间");

        Vector<Vector> stuInfo = new Vector<Vector>();//定义动态数组表示行数据

        for (int i = 0; i < dileverList.size(); i++) {
            Vector<Object> row1 = new Vector<>();
            Collections.addAll(row1, dileverList.get(i).getAccountB(),dileverList.get(i).getMoney(), dileverList.get(i).getTime());
            Collections.addAll(stuInfo, row1);//增加行数据
        }
        //		使用静态数据创建DefaultTableModel数据模型
        model = new DefaultTableModel(stuInfo, titles);
        table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
        table.setFont(new Font("宋体", Font.PLAIN, 20));

        scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示

        JLabel lblNewLabel = new JLabel("用户转账记录");
        lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 30));
        lblNewLabel.setBounds(347, 37, 225, 42);

        //-----------------添加监听器----------------
        ActionListener actionListener=new MyActionListener();

        btnR=new JButton("返回");
        btnR.setFont(new Font("宋体", Font.PLAIN, 15));
        btnR.setBounds(189, 527, 115, 27);
        btnR.addActionListener(actionListener);
        contentPane.add(btnR);

        btnE = new JButton("\u9000\u51FA");
        btnE.setFont(new Font("宋体", Font.PLAIN, 15));
        btnE.setBounds(611, 527, 115, 27);
        btnE.addActionListener(actionListener);

        contentPane.add(btnE);
        contentPane.add(lblNewLabel);
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
            if (e.getSource() == btnR) {
                dispose();
                new AdminMainMenu(account);
            }else if(e.getSource()==btnE){
                System.exit(0);
            }
        }
    }
}
