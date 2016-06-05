package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans.IPhoneWorldRepository;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

/**
 * Bound class to GUI form
 * Shows client for Phone World App
 */

public class PhoneWorldClient extends JFrame {

    private JPanel contentPane;
    private IPhoneWorldRepository repository;
    private MainPanel mainPanel;
    private Registration registrationPanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
                try {
                    PhoneWorldClient frame = new PhoneWorldClient();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        });
    }

    /**
     * Create the frame.
     */
    public PhoneWorldClient(MainPanel mainPanel, Login loginPanel, Registration registrationPanel) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.add(loginPanel);
        setContentPane(contentPane);
        this.mainPanel = mainPanel;
        this.registrationPanel = registrationPanel;
    }

    public IPhoneWorldRepository getRepository() throws NamingException {
        if (repository == null) {
            InitialContext ctx = new InitialContext();

            String name = "ejb:/PHONE_WORLD_DB//PhoneWorldRepository!" + IPhoneWorldRepository.class.getName();
            repository = (IPhoneWorldRepository) ctx.lookup(name);
        }

        return repository;
    }

    public boolean login(String username, String password){
        boolean ok;
        ok = repository.authenticateUser(username, password.toCharArray());
        if(ok)
            contentPane.removeAll();
            contentPane.add(mainPanel);
            contentPane.revalidate();
            contentPane.repaint();
        return ok;
    }

    public void registration(){
        contentPane.removeAll();
        contentPane.add(registrationPanel);
        contentPane.revalidate();
        contentPane.repaint();
    }

    /*data.add(0, name);
                data.add(1, lastName);
                data.add(2, email);
                data.add(3, username);
                data.add(4, password);
                data.add(5, confirmPassword);
                data.add(6, description);*/

    public boolean insertUser(List<String> data, Icon avatar){
        boolean ok;
        boolean passwordMatch = data.get(4).equals(data.get(5));
        boolean checkingUserMail;
        if(passwordMatch)
            checkingUserMail = repository.checkCredentialsAvailability(data.get(3), data.get(2));
        return ok;
    }

}

