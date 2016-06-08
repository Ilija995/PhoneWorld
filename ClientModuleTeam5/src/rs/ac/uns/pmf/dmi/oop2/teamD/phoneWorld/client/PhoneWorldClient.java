package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans.IPhoneWorldRepository;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans.PhoneWorldRepository;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.util.Properties;

/**
 * Content pane for a client side of the Phone World App
 */
public class PhoneWorldClient extends JPanel {

    private IPhoneWorldRepository repository;

    private static Context initialContext;

    private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";

    /**
     * Create the frame.
     */
    public PhoneWorldClient() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(0, 0));
        add(new Login(this));
    }

    public static Context getInitialContext() throws NamingException {
        if (initialContext == null) {
            Properties properties = new Properties();
            properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
            properties.put("jboss.naming.client.ejb.context", true);

            initialContext = new InitialContext(properties);
        }
        return initialContext;
    }

    public IPhoneWorldRepository getRepository() throws NamingException {
        if (repository == null) {

            //String name = "ejb:ServerModuleTeam5/PhoneWorldPersistence//PhoneWorldRepository!rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans.IPhoneWorldRepository";
            //String name = "ejb:ServerModuleTeam5//PhoneWorldRepository!rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans.IPhoneWorldRepository";
            //String name = "ejb:PhoneWorldPersistence//PhoneWorldRepository!rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans.IPhoneWorldRepository";
            //String name = "ejb:PhoneWorld/ServerModuleTeam5//PhoneWorldRepository!rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans.IPhoneWorldRepository";
            String name = "ejb:/ServerModuleTeam5_ejb_exploded//PhoneWorldRepository!rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans.IPhoneWorldRepository";
            repository = (IPhoneWorldRepository) getInitialContext().lookup(name);
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

