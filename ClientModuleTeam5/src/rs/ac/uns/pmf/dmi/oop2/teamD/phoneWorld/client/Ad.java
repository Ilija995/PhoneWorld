package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * Created by Aleksandar on 6/3/2016.
 */
public class Ad extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 2579675749216879576L;

    public Ad() {

        setLayout(new BorderLayout(0, 0));

        JPanel panelWest = new JPanel();
        add(panelWest, BorderLayout.WEST);

        JPanel pnlThumbnail = new JPanel();
        panelWest.add(pnlThumbnail);

        JPanel panelEast = new JPanel();
        add(panelEast, BorderLayout.EAST);

        JLabel lblPrice = new JLabel();
        lblPrice.setOpaque(true);
        panelEast.add(lblPrice);

        JPanel panelCenter = new JPanel();
        add(panelCenter, BorderLayout.CENTER);
        panelCenter.setLayout(new GridLayout(4, 2));

        JLabel lblAdTitle = new JLabel();
        panelCenter.add(lblAdTitle);

        JLabel lblOwner = new JLabel();
        panelCenter.add(lblOwner);

        JLabel[] lblPhoneSpecs = new JLabel[6];

        for (int i = 0; i < 6; i++) {
            JLabel lblPhoneSpec = new JLabel();
            lblPhoneSpecs[i] = lblPhoneSpec;
        }

        for (JLabel lbl : lblPhoneSpecs)
            panelCenter.add(lbl);
    }

}