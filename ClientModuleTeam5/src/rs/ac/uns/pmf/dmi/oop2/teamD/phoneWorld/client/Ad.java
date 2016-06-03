package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.AdTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.BidTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.PhoneTeam5;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

/**
 * Created by Aleksandar on 6/3/2016.
 */

public class Ad extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 2579675749216879576L;

    public Ad(BidTeam5 bid) {

        AdTeam5 ad = bid.getAd();
        PhoneTeam5 phone = ad.getPhone();

        setLayout(new BorderLayout(0, 0));

        JPanel panelWest = new JPanel();
        add(panelWest, BorderLayout.WEST);

        JLabel lblThumbnail = new JLabel();
        panelWest.add(lblThumbnail);
        lblThumbnail.setIcon(null);

        JPanel panelEast = new JPanel();
        add(panelEast, BorderLayout.EAST);

        JLabel lblPrice = new JLabel();
        lblPrice.setOpaque(true);
        panelEast.add(lblPrice);
        switch (ad.getStatus()) {
            case ACTIVE :
                lblPrice.setBackground(Color.GREEN);
                break;
            case INACTIVE :
                lblPrice.setBackground(Color.LIGHT_GRAY);
                break;
            case CLOSED :
                lblPrice.setBackground(Color.RED);
                break;
        }

        lblPrice.setText(bid.getAmount().toString());


        JPanel panelCenter = new JPanel();
        add(panelCenter, BorderLayout.CENTER);
        panelCenter.setLayout(new GridLayout(4, 2));

        JLabel lblAdTitle = new JLabel();
        panelCenter.add(lblAdTitle);
        lblAdTitle.setText(ad.getTitle());

        JLabel lblOwner = new JLabel();
        panelCenter.add(lblOwner);
        lblOwner.setText(ad.getOwner().getUsername());

        JLabel[] lblPhoneSpecs = new JLabel[6];

        for (int i = 0; i < 6; i++) {
            JLabel lblPhoneSpec = new JLabel();
            lblPhoneSpecs[i] = lblPhoneSpec;
        }

        for (JLabel lbl : lblPhoneSpecs)
            panelCenter.add(lbl);

        lblPhoneSpecs[0].setText(phone.getBrand());
        lblPhoneSpecs[1].setText(phone.getModel());
        lblPhoneSpecs[2].setText(phone.getBodyDimensions());
        lblPhoneSpecs[3].setText(phone.getCpu());
        lblPhoneSpecs[4].setText(phone.getDisplaySize());
        lblPhoneSpecs[5].setText(phone.getBatteryCapacity() + "");
    }

}