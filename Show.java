package spjz.viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import spjz.viewer.contrl.Controller;

public class Show extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JPasswordField passwordField;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JPasswordField passwordField_1;
    private Controller controller;
    private static Show frame ;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        /*EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {*/
                    frame = new Show();
                    frame.setVisible(true);
               /* } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });*/
    }

    /**
     * Create the frame.
     */
    public Show() {
        controller = new Controller();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnHdms = new JButton("hdms执行");
        btnHdms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String HdmsIp = textField_3.getText().trim();
                String HdmsPort = textField_4.getText().trim();
                String HdmsUserName = textField_5.getText().trim();
                String HdmsPsWord = new String(passwordField_1.getPassword());
                String url = "jdbc:mysql://"+HdmsIp+":"+HdmsPort+"/db_hdms";
                if(controller.execute(url, HdmsUserName, HdmsPsWord,true,false)){
                    JOptionPane.showMessageDialog(frame.getContentPane(),
                        "hdms矫正成功", "系统信息", JOptionPane.INFORMATION_MESSAGE);  
                }else{
                    JOptionPane.showMessageDialog(frame.getContentPane(),
                        "hdms矫正失败", "系统信息", JOptionPane.ERROR_MESSAGE);    
                }
            }
        });
        btnHdms.setBounds(319, 196, 93, 23);
        contentPane.add(btnHdms);
        
        textField = new JTextField();
        textField.setBounds(99, 24, 163, 23);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblCasip = new JLabel("cas数据库ip");
        lblCasip.setBounds(10, 26, 93, 19);
        contentPane.add(lblCasip);
        
        textField_1 = new JTextField();
        textField_1.setBounds(305, 25, 66, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel label = new JLabel("端口");
        label.setBounds(272, 28, 54, 15);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel("用户名");
        label_1.setBounds(10, 64, 54, 15);
        contentPane.add(label_1);
        
        textField_2 = new JTextField();
        textField_2.setBounds(60, 60, 106, 19);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel label2 = new JLabel("密码");
        label2.setBounds(176, 64, 54, 15);
        contentPane.add(label2);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(212, 57, 159, 25);
        contentPane.add(passwordField);
        
        JLabel lblHdmsip = new JLabel("hdms数据库ip");
        lblHdmsip.setBounds(10, 118, 93, 19);
        contentPane.add(lblHdmsip);
        
        textField_3 = new JTextField();
        textField_3.setBounds(99, 117, 163, 21);
        contentPane.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel label_2 = new JLabel("端口");
        label_2.setBounds(272, 122, 54, 15);
        contentPane.add(label_2);
        
        textField_4 = new JTextField();
        textField_4.setBounds(305, 117, 66, 21);
        contentPane.add(textField_4);
        textField_4.setColumns(10);
        
        JLabel label_3 = new JLabel("用户名");
        label_3.setBounds(10, 166, 54, 15);
        contentPane.add(label_3);
        
        textField_5 = new JTextField();
        textField_5.setBounds(60, 163, 106, 23);
        contentPane.add(textField_5);
        textField_5.setColumns(10);
        
        JLabel label_4 = new JLabel("密码");
        label_4.setBounds(176, 171, 54, 15);
        contentPane.add(label_4);
        
        JButton btnCas = new JButton("cas执行");
        btnCas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String casIp = textField.getText().trim();
                String casPort = textField_1.getText().trim();
                String casUserName = textField_2.getText().trim();
                String casPsWord = new String(passwordField.getPassword());
                String url = "jdbc:mysql://"+casIp+":"+casPort+"/db_cas";
                if(controller.execute(url, casUserName, casPsWord,true,false)){
                    JOptionPane.showMessageDialog(frame.getContentPane(),
                        "cas矫正成功", "系统信息", JOptionPane.INFORMATION_MESSAGE);  
                }else{
                    JOptionPane.showMessageDialog(frame.getContentPane(),
                        "cas矫正失败", "系统信息", JOptionPane.ERROR_MESSAGE);    
                }
            }
        });
        btnCas.setBounds(319, 92, 93, 23);
        contentPane.add(btnCas);
        
        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(212, 163, 159, 21);
        contentPane.add(passwordField_1);
    }
}
