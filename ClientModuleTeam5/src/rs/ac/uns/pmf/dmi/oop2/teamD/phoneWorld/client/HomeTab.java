package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.AdTeam5;

import javax.swing.JPanel;
import java.awt.*;
import java.util.List;
import javax.swing.JScrollPane;

/**
 * Created by Aleksandar on 6/3/2016.
 */

public class HomeTab extends JPanel {

    private List<AdPreview> ads;

    /**
     *
     */
    private static final long serialVersionUID = 8062118153854194871L;

    public HomeTab(List<AdPreview> ads) {

        this.ads = ads;

        setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane((Component) ads);
        add(scrollPane, BorderLayout.CENTER);
    }


}
