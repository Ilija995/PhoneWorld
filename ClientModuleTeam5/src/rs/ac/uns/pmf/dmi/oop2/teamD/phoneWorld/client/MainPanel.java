package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.AdTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.StatusTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.UserTeam5;

import javax.naming.NamingException;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


/**
 * Created by Aleksandar on 6/3/2016.
 */

public class MainPanel extends JPanel {

    private HomeTab homeTab;
    private AdsTab adsTab;
    private AdFullViewTab adFullViewTab;

    /**
     *
     */
    private static final long serialVersionUID = -6464481852682239882L;

    private PhoneWorldClient client;
    private UserTeam5 user;

    public UserTeam5 getUserFromMain() {
        return user;
    }

    public PhoneWorldClient getClientFromMain() {
        return client;
    }

    public MainPanel(PhoneWorldClient client, UserTeam5 user) {

        this.client = client;
        this.user = user;

        setLayout(new BorderLayout(0, 0));

        JPanel panelCenter = new JPanel();
        add(panelCenter, BorderLayout.CENTER);
        panelCenter.setLayout(new CardLayout());
        panelCenter.add(homeTab, 0);
        panelCenter.add(adsTab, 1);
        panelCenter.add(adFullViewTab, 2);

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
        rdbtnAll.addActionListener(e -> {
            List<AdTeam5> allAdsByStatus = null;
            try {
                allAdsByStatus = client.getRepository().getAdsByStatus(StatusTeam5.ACTIVE);
                allAdsByStatus.addAll(client.getRepository().getAdsByStatus(StatusTeam5.CLOSED));
                allAdsByStatus.addAll(client.getRepository().getAdsByStatus(StatusTeam5.INACTIVE));
            } catch (NamingException ne) {
                ne.printStackTrace();
            }

            List<AdPreview> adsPreview = new ArrayList<>();
            for (AdTeam5 ad : allAdsByStatus) {
                adsPreview.add(new AdPreview(ad));
            }

            homeTab = new HomeTab(adsPreview);
            panelCenter.add(homeTab);

        });

        JRadioButton rdbtnActive = new JRadioButton("Active");
        panelWestThree.add(rdbtnActive);
        rdbtnActive.addActionListener(e -> {
            List<AdTeam5> activeAds = null;
            try {
                activeAds = client.getRepository().getAdsByStatus(StatusTeam5.ACTIVE);
            } catch (NamingException ne) {
                ne.printStackTrace();
            }

            List<AdPreview> adsPreview = new ArrayList<>();
            for (AdTeam5 ad : activeAds) {
                adsPreview.add(new AdPreview(ad));
            }

            if (adsTab == null) {
                adsTab = new AdsTab(adsPreview);
                panelCenter.add(adsTab, 1);
                validate();
                repaint();
            } else {
                panelCenter.remove(1);
                adsTab = new AdsTab(adsPreview);
                panelCenter.add(adsTab, 1);
                validate();
                repaint();
            }
        });

        JRadioButton rdbtnInactive = new JRadioButton("Inactive");
        panelWestThree.add(rdbtnInactive);
        rdbtnInactive.addActionListener(e -> {
            List<AdTeam5> inactiveAds = null;
            try {
                inactiveAds = client.getRepository().getAdsByStatus(StatusTeam5.INACTIVE);
            } catch (NamingException ne) {
                ne.printStackTrace();
            }

            List<AdPreview> adsPreview = new ArrayList<>();
            for (AdTeam5 ad : inactiveAds) {
                adsPreview.add(new AdPreview(ad));
            }

            if (adsTab == null) {
                adsTab = new AdsTab(adsPreview);
                panelCenter.add(adsTab, 1);
                validate();
                repaint();
            } else {
                panelCenter.remove(1);
                adsTab = new AdsTab(adsPreview);
                panelCenter.add(adsTab, 1);
                validate();
                repaint();
            }
        });

        JRadioButton rdbtnClosed = new JRadioButton("Closed");
        panelWestThree.add(rdbtnClosed);
        rdbtnClosed.addActionListener(e -> {
            List<AdTeam5> closedAds = null;
            try {
                closedAds = client.getRepository().getAdsByStatus(StatusTeam5.CLOSED);
            } catch (NamingException ne) {
                ne.printStackTrace();
            }

            List<AdPreview> adsPreview = new ArrayList<>();
            for (AdTeam5 ad : closedAds) {
                adsPreview.add(new AdPreview(ad));
            }

            if (adsTab == null) {
                adsTab = new AdsTab(adsPreview);
                panelCenter.add(adsTab, 1);
                validate();
                repaint();
            } else {
                panelCenter.remove(1);
                adsTab = new AdsTab(adsPreview);
                panelCenter.add(adsTab, 1);
                validate();
                repaint();
            }
        });

        JLabel lblByType = new JLabel("By type:");
        panelWestThree.add(lblByType);

        JRadioButton rdbtnAllType = new JRadioButton("All");
        panelWestThree.add(rdbtnAllType);
        rdbtnAllType.addActionListener(e -> {
            List<AdTeam5> allAds = null;
            try {
                allAds = client.getRepository().getAllUserAds(user.getUsername());
            } catch (NamingException ne) {
                ne.printStackTrace();
            }

            List<AdPreview> adsPreview = new ArrayList<>();
            for (AdTeam5 ad : allAds) {
                adsPreview.add(new AdPreview(ad));
            }

            if (adsTab == null) {
                adsTab = new AdsTab(adsPreview);
                panelCenter.add(adsTab, 1);
                validate();
                repaint();
            } else {
                panelCenter.remove(1);
                adsTab = new AdsTab(adsPreview);
                panelCenter.add(adsTab, 1);
                validate();
                repaint();
            }
        });

        JRadioButton rdbtnOwned = new JRadioButton("Owned");
        panelWestThree.add(rdbtnOwned);
        rdbtnOwned.addActionListener(e -> {
            List<AdTeam5> ownedAds = null;
            try {
                ownedAds = client.getRepository().getUserOwnedAds(user.getUsername());
            } catch (NamingException ne) {
                ne.printStackTrace();
            }

            List<AdPreview> adsPreview = new ArrayList<>();
            for (AdTeam5 ad : ownedAds) {
                adsPreview.add(new AdPreview(ad));
            }

            if (adsTab == null) {
                adsTab = new AdsTab(adsPreview);
                panelCenter.add(adsTab, 1);
                validate();
                repaint();
            } else {
                panelCenter.remove(1);
                adsTab = new AdsTab(adsPreview);
                panelCenter.add(adsTab, 1);
                validate();
                repaint();
            }
        });

        JRadioButton rdbtnBid = new JRadioButton("Bid");
        panelWestThree.add(rdbtnBid);
        rdbtnBid.addActionListener(e -> {
            List<AdTeam5> bidedAds = null;
            try {
                bidedAds = client.getRepository().getUserBidAds(user.getUsername());
            } catch (NamingException ne) {
                ne.printStackTrace();
            }

            List<AdPreview> adsPreview = new ArrayList<>();
            for (AdTeam5 ad : bidedAds) {
                adsPreview.add(new AdPreview(ad));
            }

            if (adsTab == null) {
                adsTab = new AdsTab(adsPreview);
                panelCenter.add(adsTab, 1);
                validate();
                repaint();
            } else {
                panelCenter.remove(1);
                adsTab = new AdsTab(adsPreview);
                panelCenter.add(adsTab, 1);
                validate();
                repaint();
            }
        });

        JRadioButton rdbCommented = new JRadioButton("Commented");
        panelWestThree.add(rdbCommented);
        rdbCommented.addActionListener(e -> {
            List<AdTeam5> commentedAds = null;
            try {
                commentedAds = client.getRepository().getUserCommentedAds(user.getUsername());
            } catch (NamingException ne) {
                ne.printStackTrace();
            }

            List<AdPreview> adsPreview = new ArrayList<>();
            for (AdTeam5 ad : commentedAds) {
                adsPreview.add(new AdPreview(ad));
            }

            if (adsTab == null) {
                adsTab = new AdsTab(adsPreview);
                panelCenter.add(adsTab, 1);
                validate();
                repaint();
            } else {
                panelCenter.remove(1);
                adsTab = new AdsTab(adsPreview);
                panelCenter.add(adsTab, 1);
                validate();
                repaint();
            }
        });

    }

}

