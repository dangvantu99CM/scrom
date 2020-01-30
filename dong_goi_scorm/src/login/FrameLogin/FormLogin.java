package login.FrameLogin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ConnectDB.Connect;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import login.FormCreateAccount.FormCreateAccount;
import login.FrameLogin.da.UserDA;
import net.miginfocom.swing.MigLayout;

public class FormLogin extends JDialog{
	
    public FormLogin() {initFormLogin();};

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JCheckBox checkBoxMemoryAccount;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean isLoading=false;
    private JLabel lblForgetPassword;
    private JLabel lblCreateAccount;

    public void initFormLogin() {	

        this.setTitle("Đăng nhập");
        this.setSize(350,200);
        this.setLocationRelativeTo(null);
        this.setLayout(new MigLayout("", "[][grow]", "[][]"));

        JLabel lblUsername = new JLabel("Tài khoản");
        this.add(lblUsername, "cell 0 0,alignx trailing");
        txtUsername = new JTextField();
        this.add(txtUsername, "cell 1 0,growx");

        JLabel lblPassword = new JLabel("Mật khẩu");
        this.add(lblPassword, "cell 0 1,alignx trailing");
        txtPassword = new JPasswordField();
        this.add(txtPassword, "cell 1 1,growx");

        checkBoxMemoryAccount = new JCheckBox("Ghi nhớ mật khẩu");
        this.add(checkBoxMemoryAccount,"cell 1 2,growx");

       
        lblForgetPassword = new JLabel("Quên mật khẩu");
        lblCreateAccount = new JLabel("Tạo tài khoản");
        lblForgetPassword.setForeground(Color.BLUE);
        lblCreateAccount.setForeground(Color.BLUE);
        
        this.add(lblForgetPassword, "cell 1 3,growx");
        this.add(lblCreateAccount, "cell 1 3,growx");

        btnLogin = new JButton("Đăng nhập");
        btnCancel = new JButton("Thoát");

        this.add(btnLogin, "cell 1 4,growx");
        this.add(btnCancel, "cell 1 4,growx");
        
        this.setVisible(true);
    }

    public void actionListener() {
        JDialog self = this;
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.dispose();
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDA userDa = new UserDA();
                JDialog f=new JDialog();  
                try {
                    if(userDa.checkLogin(txtUsername.getText(),txtPassword.getText())){
                        System.out.println("Login correct !");
                    }else{
                        JOptionPane.showMessageDialog(f,"Error");  
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(f,"Error");  
                }
            }
        });
        lblForgetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
            }
        });
        lblCreateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                self.dispose();
                FormCreateAccount formCreateAcount = new FormCreateAccount();
            }
        });
    }

    public static void main(String []args) {
        FormLogin formLogin = new FormLogin();
        formLogin.actionListener();
    }
	
}
