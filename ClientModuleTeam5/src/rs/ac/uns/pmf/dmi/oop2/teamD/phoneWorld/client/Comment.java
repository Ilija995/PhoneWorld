package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Created by Aleksandar on 6/3/2016.
 */

public class Comment extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 5576228724011660009L;

    public Comment(UserTeam5 user, String comment) {

        setLayout(new GridLayout(1, 2));

        JLabel lblUser = new JLabel(user.getUsername() + ":");
        add(lblUser);

        JLabel lblComment = new JLabel(comment);
        add(lblComment);
    }

}

