package View;

import Controller.LoginController;
import Entity.Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class LoginGui {
    JFrame LogReg = new JFrame();
    JLabel top;
    JTextField textidlogin;
    JLabel idLogin,labelpass;
    JButton btnlogin;
    JPasswordField passwordlogin;

    public LoginGui(){
        LogReg.setSize(900,700);
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.LIGHT_GRAY);
        top = new JLabel("E-Wallet");
        top.setBounds(130,10,600,50);
        top.setFont(new Font("Times New Roman", Font.BOLD,40));
        LogReg.add(top);

        idLogin = new JLabel("ID");
        idLogin.setBounds(250,180,100,30);
        LogReg.add(idLogin);

        textidlogin = new JTextField();
        textidlogin.setBounds(250,210,200,30);
        LogReg.add(textidlogin);

        labelpass = new JLabel("Password");
        labelpass.setBounds(250,240,100,30);
        LogReg.add(labelpass);

        passwordlogin = new JPasswordField();
        passwordlogin.setBounds(250,270,200,30);
        LogReg.add(passwordlogin);

        btnlogin = new JButton("Login");
        btnlogin.setBounds(280,320,100,40);
        btnlogin.setBackground(Color.GREEN);
        LogReg.add(btnlogin);

        LogReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogReg.setVisible(true);
        LogReg.setLocationRelativeTo(null);

        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    allobjcontroller.loginController.datalogin();
                    allobjcontroller.loginController.ceklogin(textidlogin.getText(),passwordlogin.getText());
                    String nama = allobjcontroller.loginController.loginEntity().getNama();
                    JOptionPane.showMessageDialog(null,"Selamat Datang "+nama+" Di E-Wallet","information",JOptionPane.INFORMATION_MESSAGE);
                    MenuGui menuGui = new MenuGui();
                    LogReg.dispose();
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Nama atau password salah","information",JOptionPane.INFORMATION_MESSAGE);
                    reset();
                }
            }
        });
    }
    void reset(){
        textidlogin.setText(null);
        passwordlogin.setText(null);
    }
}