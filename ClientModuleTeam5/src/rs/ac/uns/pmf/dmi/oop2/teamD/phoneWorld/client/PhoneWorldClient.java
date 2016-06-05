package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans.IPhoneWorldRepository;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

/**
 * Content pane for a client side of the Phone World App
 */
public class PhoneWorldClient extends JPanel {

    private IPhoneWorldRepository repository;

    /**
     * Create the frame.
     */
    public PhoneWorldClient() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(0, 0));
        add(new Login(this));
    }

    public IPhoneWorldRepository getRepository() throws NamingException {
        if (repository == null) {
            InitialContext ctx = new InitialContext();

            String name = "ejb:/PHONE_WORLD_DB//PhoneWorldRepository!" + IPhoneWorldRepository.class.getName();
            repository = (IPhoneWorldRepository) ctx.lookup(name);
        }

        return repository;
    }

    public void showRegistrationPanel(){
        removeAll();
        add(new Registration(this));
        revalidate();
        repaint();
    }

    public void showMainPanel(String username) {
        removeAll();
        add(new MainPanel(this, repository.getUser(username)));
        revalidate();
        repaint();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JFrame frame = new JFrame();
                frame.setBounds(100, 100, 1000, 700);
                frame.setContentPane(new PhoneWorldClient());
                frame.setVisible(true);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

