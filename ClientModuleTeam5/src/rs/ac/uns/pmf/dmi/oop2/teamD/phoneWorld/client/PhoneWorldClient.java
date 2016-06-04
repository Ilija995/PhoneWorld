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
    public PhoneWorldClient() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
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
        return true;
    }

    public boolean registration(){
        return true;
    }

    public boolean insertUser(List<String> data, Icon avatar){
        return true;
    }

}

