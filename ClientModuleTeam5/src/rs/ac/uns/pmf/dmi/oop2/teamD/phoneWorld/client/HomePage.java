package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


/**
 * Created by Aleksandar on 6/3/2016.
 */

public class HomePage extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = -6464481852682239882L;

    public HomePage() {

        setLayout(new BorderLayout(0, 0));

        JPanel panelWest = new JPanel();
        add(panelWest, BorderLayout.WEST);
        panelWest.setLayout(new GridLayout(3, 1));

        JPanel panelWestOne = new JPanel();
        panelWest.add(panelWestOne);

        JLabel lblPhoto = new JLabel();
        lblPhoto.setIcon(null);
        panelWestOne.add(lblPhoto);

        JPanel panelWestTwo = new JPanel();
        panelWest.add(panelWestTwo);
        panelWestTwo.setLayout(new GridLayout(5, 1));

        JPanel panelAvatar = new JPanel();
        panelWestTwo.add(panelAvatar);

        JLabel lblNick = new JLabel();
        panelWestTwo.add(lblNick);

        JLabel lblName = new JLabel();
        panelWestTwo.add(lblName);

        JLabel lblEmail = new JLabel();
        panelWestTwo.add(lblEmail);

        JLabel lblDescription = new JLabel();
        panelWestTwo.add(lblDescription);

        JPanel panelWestThree = new JPanel();
        panelWest.add(panelWestThree);
        panelWestThree.setLayout(new GridLayout(11, 1));

        JLabel lblFilters = new JLabel("FILTERS:");
        panelWestThree.add(lblFilters);

        JLabel lblByStatus = new JLabel("By status:");
        panelWestThree.add(lblByStatus);

        JRadioButton rdbtnAll = new JRadioButton("All");
        panelWestThree.add(rdbtnAll);

        JRadioButton rdbtnActive = new JRadioButton("Active");
        panelWestThree.add(rdbtnActive);

        JRadioButton rdbtnInactive = new JRadioButton("Inactive");
        panelWestThree.add(rdbtnInactive);

        JRadioButton rdbtnClosed = new JRadioButton("Closed");
        panelWestThree.add(rdbtnClosed);

        JLabel lblByType = new JLabel("By type:");
        panelWestThree.add(lblByType);

        JRadioButton rdbtnAllType = new JRadioButton("All");
        panelWestThree.add(rdbtnAllType);

        JRadioButton rdbtnOwned = new JRadioButton("Owned");
        panelWestThree.add(rdbtnOwned);

        JRadioButton rdbtnBid = new JRadioButton("Bid");
        panelWestThree.add(rdbtnBid);

        JRadioButton rdbCommented = new JRadioButton("Commented");
        panelWestThree.add(rdbCommented);

        JPanel panelCenter = new JPanel();
        add(panelCenter, BorderLayout.CENTER);
        panelCenter.setLayout(new CardLayout());

		/*
		 * Here goes Home, Preview and Ads tab
		 */

    }


}

