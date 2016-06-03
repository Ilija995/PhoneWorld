package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

/**
 * Created by Aleksandar on 6/3/2016.
 */

public class HomeTab extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 8062118153854194871L;

    public HomeTab() {
        
        setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
    }


}
