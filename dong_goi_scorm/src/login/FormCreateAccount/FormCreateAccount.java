/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.FormCreateAccount;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import login.FrameLogin.da.ItemDA;
import login.FrameLogin.da.UserDA;
import net.miginfocom.swing.MigLayout;
import Account.User;

public class FormCreateAccount extends JDialog {
    
    private JTextField txtUsername;
    private JTextField txtPasswordAgain;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtAddress;
    private JTextField txtNameLogin;
    private JPasswordField txtPassword;
    private Checkbox  checkBoxMale;
    private Checkbox  checkBoxFeMale;
    private JButton btnResgister;
    private JButton btnCancel;
    private boolean isLoading=false;
    private int gender = -1;
    
    public FormCreateAccount(){
        this.setTitle("Tạo tài khoản");
        this.setSize(400,320);
        this.setLocationRelativeTo(null);
        this.setLayout(new MigLayout("", "[][grow]", "[][]"));
        
        JLabel lblUsername = new JLabel("Tên truy nhập*");
        this.add(lblUsername, "cell 0 0,alignx trailing");
        txtNameLogin = new JTextField();
        this.add(txtNameLogin, "cell 1 0,growx");

        JLabel lblPassword = new JLabel("Mật khẩu*");
        this.add(lblPassword, "cell 0 1,alignx trailing");
        txtPassword = new JPasswordField();
        this.add(txtPassword, "cell 1 1,growx");
        
        JLabel lblPasswordAgain = new JLabel("Gõ lại MK*");
        this.add(lblPasswordAgain, "cell 0 2,alignx trailing");
        txtPasswordAgain = new JPasswordField();
        this.add(txtPasswordAgain, "cell 1 2,growx");
        
        JLabel lblUserName = new JLabel("Họ và tên*");
        this.add(lblUserName, "cell 0 3,alignx trailing");
        txtUsername = new JTextField();
        this.add(txtUsername, "cell 1 3,growx");
        
        JLabel lblEmail = new JLabel("Email*");
        this.add(lblEmail, "cell 0 5,alignx trailing");
        txtEmail = new JTextField();
        this.add(txtEmail, "cell 1 5,growx");
     
        JLabel lblPhone = new JLabel("Điện thoại*");
        this.add(lblPhone, "cell 0 6,alignx trailing");
        txtPhone = new JTextField();
        this.add(txtPhone, "cell 1 6,growx");
        
        JLabel lblAddress = new JLabel("Địa chỉ*");
        this.add(lblAddress, "cell 0 4,alignx trailing");
        txtAddress = new JTextField();
        this.add(txtAddress, "cell 1 4,growx");
        
        JLabel lblGender = new JLabel("Giới tính*");
        this.add(lblGender, "cell 0 7,alignx trailing");
        CheckboxGroup cbg = new CheckboxGroup();  
        checkBoxFeMale = new Checkbox("Nữ",cbg,false);
        checkBoxMale = new Checkbox ("Nam",cbg,false);
        this.add(checkBoxMale, "cell 1 7,growx");
        this.add(checkBoxFeMale, "cell 1 7,growx");
 
        btnResgister = new JButton("Đăng Ký");
        btnCancel = new JButton("Thoát");
        this.add(btnResgister, "cell 1 8,growx");
        this.add(btnCancel, "cell 1 8,growx");
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
        btnResgister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDA userDa = new UserDA();
                ItemDA itemDa = new ItemDA();
                JDialog f=new JDialog();  
                try {
                    boolean isAddSucess = itemDa.addUser(
                        new User(txtUsername.getText(),txtPassword.getText(),txtAddress.getText(),Integer.parseInt(txtPhone.getText()),txtEmail.getText(),gender,txtNameLogin.getText()));
                    if(isAddSucess){
                        System.out.println("correct !");
                    }else{
                        JOptionPane.showMessageDialog(f,"Error");  
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(f,"Error");  
                }
            }
        });
        checkBoxMale.addItemListener(new ItemListener() {  
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getItem().toString().toUpperCase().equalsIgnoreCase("NAM")){
                    gender = 1;
                };
            }
        });  
        checkBoxFeMale.addItemListener(new ItemListener() { 
            @Override
            public void itemStateChanged(ItemEvent e) {   
                if(e.getItem().toString().toUpperCase().equalsIgnoreCase("NỮ")){
                    gender = 0;
                }
            }  
        });  
    }
    
    public static void main(String[] args){
        FormCreateAccount f = new FormCreateAccount();
        f.actionListener();
    }
}
