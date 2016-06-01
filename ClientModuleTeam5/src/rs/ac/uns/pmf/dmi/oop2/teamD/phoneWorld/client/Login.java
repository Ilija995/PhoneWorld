package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class Login extends JPanel {
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Create the login panel.
     */
    public Login() {
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

        JLabel lblNewLabel_3 = new JLabel("Username");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.weightx = 3.0;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 2;
        gbc_lblNewLabel_3.gridy = 3;
        add(lblNewLabel_3, gbc_lblNewLabel_3);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.weightx = 8.0;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 3;
        gbc_textField.gridy = 3;
        add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Password");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 2;
        gbc_lblNewLabel_1.gridy = 5;
        add(lblNewLabel_1, gbc_lblNewLabel_1);

        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 3;
        gbc_textField_1.gridy = 5;
        add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("Login");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 4;
        gbc_btnNewButton.gridy = 7;
        add(btnNewButton, gbc_btnNewButton);

        JButton btnNewButton_1 = new JButton("Create account");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_1.gridx = 5;
        gbc_btnNewButton_1.gridy = 9;
        add(btnNewButton_1, gbc_btnNewButton_1);

    }

}

