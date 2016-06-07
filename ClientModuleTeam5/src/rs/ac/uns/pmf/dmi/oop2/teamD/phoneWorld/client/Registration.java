package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import javax.naming.NamingException;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class Registration extends JPanel {
    private JTextField textFieldMail;
    private JTextField textFieldLastName;
    private JTextField textFieldName;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JTextField textFieldDescription;
    private JTextField textFieldConfirmPassword;
    private JTextField textFieldAvatarPath;

    /**
     * Create the showRegistrationPanel panel.
     */
    public Registration(PhoneWorldClient client) {

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{86, 62, 73, 86, 109, 0};
        gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 55, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblPhoneWorldregistration = new JLabel("Phone World~showRegistrationPanel:");
        GridBagConstraints gbc_lblPhoneWorldRegistration = new GridBagConstraints();
        gbc_lblPhoneWorldRegistration.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblPhoneWorldRegistration.insets = new Insets(0, 0, 5, 5);
        gbc_lblPhoneWorldRegistration.gridwidth = 3;
        gbc_lblPhoneWorldRegistration.gridx = 1;
        gbc_lblPhoneWorldRegistration.gridy = 0;
        add(lblPhoneWorldregistration, gbc_lblPhoneWorldRegistration);

        JLabel lblName = new JLabel("Name:");
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.anchor = GridBagConstraints.WEST;
        gbc_lblName.gridx = 1;
        gbc_lblName.gridy = 1;
        add(lblName, gbc_lblName);

        textFieldName = new JTextField();
        GridBagConstraints gbc_textFieldName = new GridBagConstraints();
        gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldName.gridx = 2;
        gbc_textFieldName.gridy = 1;
        add(textFieldName, gbc_textFieldName);
        textFieldName.setColumns(10);

        JLabel lblLastName = new JLabel("Last name:");
        GridBagConstraints gbc_lblLastName = new GridBagConstraints();
        gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
        gbc_lblLastName.anchor = GridBagConstraints.WEST;
        gbc_lblLastName.gridx = 1;
        gbc_lblLastName.gridy = 2;
        add(lblLastName, gbc_lblLastName);

        textFieldLastName = new JTextField();
        GridBagConstraints gbc_textFieldLastName = new GridBagConstraints();
        gbc_textFieldLastName.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldLastName.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldLastName.gridx = 2;
        gbc_textFieldLastName.gridy = 2;
        add(textFieldLastName, gbc_textFieldLastName);
        textFieldLastName.setColumns(10);

        JLabel lblEmail = new JLabel("E-mail:");
        GridBagConstraints gbc_lblEmail = new GridBagConstraints();
        gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmail.anchor = GridBagConstraints.WEST;
        gbc_lblEmail.gridx = 1;
        gbc_lblEmail.gridy = 3;
        add(lblEmail, gbc_lblEmail);

        textFieldMail = new JTextField();
        GridBagConstraints gbc_textFieldMail = new GridBagConstraints();
        gbc_textFieldMail.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldMail.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldMail.gridx = 2;
        gbc_textFieldMail.gridy = 3;
        add(textFieldMail, gbc_textFieldMail);
        textFieldMail.setColumns(10);

        JLabel lblUsername = new JLabel("Username:");
        GridBagConstraints gbc_lblUsername = new GridBagConstraints();
        gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
        gbc_lblUsername.anchor = GridBagConstraints.WEST;
        gbc_lblUsername.gridx = 1;
        gbc_lblUsername.gridy = 4;
        add(lblUsername, gbc_lblUsername);

        textFieldUsername = new JTextField();
        GridBagConstraints gbc_textFieldUsername = new GridBagConstraints();
        gbc_textFieldUsername.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldUsername.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldUsername.gridx = 2;
        gbc_textFieldUsername.gridy = 4;
        add(textFieldUsername, gbc_textFieldUsername);
        textFieldUsername.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblPassword.anchor = GridBagConstraints.WEST;
        gbc_lblPassword.gridx = 1;
        gbc_lblPassword.gridy = 5;
        add(lblPassword, gbc_lblPassword);

        textFieldPassword = new JTextField();
        GridBagConstraints gbc_textFieldPassword = new GridBagConstraints();
        gbc_textFieldPassword.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldPassword.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldPassword.gridx = 2;
        gbc_textFieldPassword.gridy = 5;
        add(textFieldPassword, gbc_textFieldPassword);
        textFieldPassword.setColumns(10);

        JLabel lblConfirmPassword = new JLabel("Confirm password:");
        GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
        gbc_lblConfirmPassword.anchor = GridBagConstraints.EAST;
        gbc_lblConfirmPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblConfirmPassword.gridx = 1;
        gbc_lblConfirmPassword.gridy = 6;
        add(lblConfirmPassword, gbc_lblConfirmPassword);

        textFieldConfirmPassword = new JTextField();
        GridBagConstraints gbc_textFieldConfirmPassword = new GridBagConstraints();
        gbc_textFieldConfirmPassword.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldConfirmPassword.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldConfirmPassword.gridx = 2;
        gbc_textFieldConfirmPassword.gridy = 6;
        add(textFieldConfirmPassword, gbc_textFieldConfirmPassword);
        textFieldConfirmPassword.setColumns(10);

        JLabel lblDescription = new JLabel("Description:");
        GridBagConstraints gbc_lblDescription = new GridBagConstraints();
        gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescription.anchor = GridBagConstraints.WEST;
        gbc_lblDescription.gridx = 1;
        gbc_lblDescription.gridy = 7;
        add(lblDescription, gbc_lblDescription);

        textFieldDescription = new JTextField();
        GridBagConstraints gbc_textFieldDescription = new GridBagConstraints();
        gbc_textFieldDescription.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldDescription.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldDescription.gridx = 2;
        gbc_textFieldDescription.gridy = 7;
        add(textFieldDescription, gbc_textFieldDescription);
        textFieldDescription.setColumns(10);

        JLabel lblAvatar = new JLabel("Avatar:");
        GridBagConstraints gbc_lblAvatar = new GridBagConstraints();
        gbc_lblAvatar.gridheight = 2;
        gbc_lblAvatar.insets = new Insets(0, 0, 0, 5);
        gbc_lblAvatar.anchor = GridBagConstraints.WEST;
        gbc_lblAvatar.gridx = 1;
        gbc_lblAvatar.gridy = 8;
        add(lblAvatar, gbc_lblAvatar);

        textFieldAvatarPath = new JTextField();
        GridBagConstraints gbc_textFieldAvatarPath = new GridBagConstraints();
        gbc_textFieldAvatarPath.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldAvatarPath.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldAvatarPath.gridx = 2;
        gbc_textFieldAvatarPath.gridy = 8;
        add(textFieldAvatarPath, gbc_textFieldAvatarPath);
        textFieldAvatarPath.setColumns(10);

        JButton btnCreateAccount = new JButton("Create account");
        btnCreateAccount.addActionListener(e -> {
            String firstName = textFieldName.getText();
            String lastName = textFieldLastName.getText();
            String email = textFieldMail.getText();
            String username = textFieldUsername.getText();
            String password = textFieldPassword.getText();
            String confirmPassword = textFieldConfirmPassword.getText();
            String description = textFieldDescription.getText();
            String avatarPath = textFieldAvatarPath.getText();

            try {
                if (!client.getRepository().checkCredentialsAvailability(username, email)) {
                    JOptionPane.showMessageDialog(null, "Username or email already exists");
                }
                else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords don't match");
                }
                else {
                    client.getRepository().addUser(username,
                                                    firstName,
                                                    lastName,
                                                    email,
                                                    client.getRepository().getHashedPassword(password.toCharArray()),
                                                    avatarPath,
                                                    description);

                    client.showMainPanel(username);
                }
            }
            catch (NamingException ex) {
                ex.printStackTrace();
            }
        });
        GridBagConstraints gbc_btnCreateAccount = new GridBagConstraints();
        gbc_btnCreateAccount.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnCreateAccount.gridx = 4;
        gbc_btnCreateAccount.gridy = 8;
        add(btnCreateAccount, gbc_btnCreateAccount);

    }
}

