package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel {
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;

    /**
     * Create the login panel.
     */
    public Login(PhoneWorldClient frame) {

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblPhoneWorld = new JLabel("Phone World");
        lblPhoneWorld.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbc_lblPhoneWorld = new GridBagConstraints();
        gbc_lblPhoneWorld.gridheight = 2;
        gbc_lblPhoneWorld.insets = new Insets(0, 0, 5, 5);
        gbc_lblPhoneWorld.gridx = 3;
        gbc_lblPhoneWorld.gridy = 1;
        add(lblPhoneWorld, gbc_lblPhoneWorld);

        JLabel lblUsername = new JLabel("Username");
        GridBagConstraints gbc_lblUsername = new GridBagConstraints();
        gbc_lblUsername.weightx = 3.0;
        gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
        gbc_lblUsername.gridx = 2;
        gbc_lblUsername.gridy = 3;
        add(lblUsername, gbc_lblUsername);

        textFieldUsername = new JTextField();
        GridBagConstraints gbc_textFieldUsername = new GridBagConstraints();
        gbc_textFieldUsername.weightx = 8.0;
        gbc_textFieldUsername.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldUsername.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldUsername.gridx = 3;
        gbc_textFieldUsername.gridy = 3;
        add(textFieldUsername, gbc_textFieldUsername);
        textFieldUsername.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblPassword.gridx = 2;
        gbc_lblPassword.gridy = 5;
        add(lblPassword, gbc_lblPassword);

        textFieldPassword = new JTextField();
        GridBagConstraints gbc_textFieldPassword = new GridBagConstraints();
        gbc_textFieldPassword.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldPassword.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldPassword.gridx = 3;
        gbc_textFieldPassword.gridy = 5;
        add(textFieldPassword, gbc_textFieldPassword);
        textFieldPassword.setColumns(10);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> {
                String username = textFieldUsername.getText();
                String password = textFieldPassword.getText();
                boolean successfulLogin = frame.login(username, password);
                if(!successfulLogin)
                    JOptionPane.showMessageDialog(null, "Failed login! Check your username and password...");
        });
        GridBagConstraints gbc_btnLogin = new GridBagConstraints();
        gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
        gbc_btnLogin.gridx = 4;
        gbc_btnLogin.gridy = 7;
        add(btnLogin, gbc_btnLogin);

        JButton btnCreateAccount = new JButton("Create account");
        btnCreateAccount.addActionListener(e -> frame.registration());

        GridBagConstraints gbc_btnCreateAccount = new GridBagConstraints();
        gbc_btnCreateAccount.insets = new Insets(0, 0, 5, 0);
        gbc_btnCreateAccount.gridx = 5;
        gbc_btnCreateAccount.gridy = 9;
        add(btnCreateAccount, gbc_btnCreateAccount);

    }

}

