import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client.PhoneWorldClient;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Registration extends JPanel {
    private JTextField textFieldMail;
    private JTextField textFieldLName;
    private JTextField textFieldName;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JTextField textFieldDesc;
    private PhoneWorldClient frame;

    /**
     * Create the registration panel.
     */
    public Registration() {

        frame = new PhoneWorldClient();

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{86, 62, 73, 86, 109, 0};
        gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 55, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblPhoneWorldregistration = new JLabel("Phone World~registration:");
        GridBagConstraints gbc_lblPhoneWorldregistration = new GridBagConstraints();
        gbc_lblPhoneWorldregistration.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblPhoneWorldregistration.insets = new Insets(0, 0, 5, 5);
        gbc_lblPhoneWorldregistration.gridwidth = 3;
        gbc_lblPhoneWorldregistration.gridx = 1;
        gbc_lblPhoneWorldregistration.gridy = 0;
        add(lblPhoneWorldregistration, gbc_lblPhoneWorldregistration);

        JLabel lblName = new JLabel("Name:");
        GridBagConstraints gbc_lblIme = new GridBagConstraints();
        gbc_lblIme.insets = new Insets(0, 0, 5, 5);
        gbc_lblIme.anchor = GridBagConstraints.WEST;
        gbc_lblIme.gridx = 1;
        gbc_lblIme.gridy = 1;
        add(lblName, gbc_lblIme);

        textFieldName = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 1;
        add(textFieldName, gbc_textField);
        textFieldName.setColumns(10);

        JLabel lblLastName = new JLabel("Last name:");
        GridBagConstraints gbc_lblPrezime = new GridBagConstraints();
        gbc_lblPrezime.insets = new Insets(0, 0, 5, 5);
        gbc_lblPrezime.anchor = GridBagConstraints.WEST;
        gbc_lblPrezime.gridx = 1;
        gbc_lblPrezime.gridy = 2;
        add(lblLastName, gbc_lblPrezime);

        textFieldLName = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 2;
        gbc_textField_1.gridy = 2;
        add(textFieldLName, gbc_textField_1);
        textFieldLName.setColumns(10);

        JLabel lblEmail = new JLabel("email");
        GridBagConstraints gbc_lblEmail = new GridBagConstraints();
        gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmail.anchor = GridBagConstraints.WEST;
        gbc_lblEmail.gridx = 1;
        gbc_lblEmail.gridy = 3;
        add(lblEmail, gbc_lblEmail);

        textFieldMail = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 5);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 2;
        gbc_textField_2.gridy = 3;
        add(textFieldMail, gbc_textField_2);
        textFieldMail.setColumns(10);

        JLabel lblUsername = new JLabel("Username:");
        GridBagConstraints gbc_lblUsername = new GridBagConstraints();
        gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
        gbc_lblUsername.anchor = GridBagConstraints.WEST;
        gbc_lblUsername.gridx = 1;
        gbc_lblUsername.gridy = 4;
        add(lblUsername, gbc_lblUsername);

        textFieldUsername = new JTextField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.insets = new Insets(0, 0, 5, 5);
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 2;
        gbc_textField_3.gridy = 4;
        add(textFieldUsername, gbc_textField_3);
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
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.insets = new Insets(0, 0, 5, 5);
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.gridx = 2;
        gbc_textField_4.gridy = 5;
        add(textFieldPassword, gbc_textField_4);
        textFieldPassword.setColumns(10);

        JLabel lblDescription = new JLabel("Description:");
        GridBagConstraints gbc_lblDescription = new GridBagConstraints();
        gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescription.anchor = GridBagConstraints.WEST;
        gbc_lblDescription.gridx = 1;
        gbc_lblDescription.gridy = 6;
        add(lblDescription, gbc_lblDescription);

        textFieldDesc = new JTextField();
        GridBagConstraints gbc_textField_5 = new GridBagConstraints();
        gbc_textField_5.insets = new Insets(0, 0, 5, 5);
        gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_5.gridx = 2;
        gbc_textField_5.gridy = 6;
        add(textFieldDesc, gbc_textField_5);
        textFieldDesc.setColumns(10);

        JLabel lblAvatar = new JLabel("Avatar:");
        GridBagConstraints gbc_lblAvatar = new GridBagConstraints();
        gbc_lblAvatar.gridheight = 2;
        gbc_lblAvatar.insets = new Insets(0, 0, 0, 5);
        gbc_lblAvatar.anchor = GridBagConstraints.WEST;
        gbc_lblAvatar.gridx = 1;
        gbc_lblAvatar.gridy = 7;
        add(lblAvatar, gbc_lblAvatar);

        JComboBox comboBox = new JComboBox();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.gridheight = 2;
        gbc_comboBox.fill = GridBagConstraints.BOTH;
        gbc_comboBox.insets = new Insets(0, 0, 0, 5);
        gbc_comboBox.gridx = 2;
        gbc_comboBox.gridy = 7;
        add(comboBox, gbc_comboBox);

        JButton btnNewButton = new JButton("Create account");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                String lastname = textFieldLName.getText();
                String username = textFieldUsername.getText();
                String password = textFieldPassword.getText();
                String description = textFieldDesc.getText();
                Icon avatar = (Icon)comboBox.getSelectedItem();
                List<String> data = new ArrayList<String>();
                data.add(0, name);
                data.add(1, lastname);
                data.add(2, username);
                data.add(3, password);
                data.add(4, description);
                frame.insertUser(data, avatar);
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton.gridx = 4;
        gbc_btnNewButton.gridy = 8;
        add(btnNewButton, gbc_btnNewButton);

    }
}

