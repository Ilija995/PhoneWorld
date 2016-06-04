package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * Created by Aleksandar on 6/3/2016.
 */
public class AdsTab extends JPanel {

    private List<AdPreview> ads;

    /**
     *
     */
    private static final long serialVersionUID = -7575592963793340993L;

    public AdsTab(List<AdPreview> ads) {

        this.ads = ads;

        setLayout(new BorderLayout(0, 0));

        JLabel lblNorth = new JLabel("SELECTED ADS");
        add(lblNorth, BorderLayout.NORTH);

        /**
         * Maybe, I dan add List<JPanel> to ScrollPane like this, if not there is backup :D
         */

        JScrollPane centarScrollPane = new JScrollPane((Component) ads);

        add(centarScrollPane, BorderLayout.CENTER);

    }
}
