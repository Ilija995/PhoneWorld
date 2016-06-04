package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.AdTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.CommentTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.PhoneTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.StatusTeam5;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Aleksandar on 6/3/2016.
 */

public class FullViewTab extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 9173229264965205982L;

    public FullViewTab(AdTeam5 ad) {

        setLayout(new BorderLayout(0, 0));

        JPanel pnlNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitle = new JLabel(ad.getTitle());
        JLabel lblOwner = new JLabel(ad.getOwner().getUsername());
        pnlNorth.add(lblTitle);
        pnlNorth.add(lblOwner);

        add(pnlNorth, BorderLayout.NORTH);

        JPanel pnlCenter = new JPanel(new GridLayout(2, 1));

        JPanel pnlCenterOne = new JPanel(new GridLayout(2, 4));
        PhoneTeam5 phone = ad.getPhone();

        JLabel[] lblPhoneSpec = new JLabel[7];

        for (int i = 0; i < 7; i++) {
            lblPhoneSpec[i] = new JLabel();
        }

        for (JLabel lbl : lblPhoneSpec) {
            pnlCenterOne.add(lbl);
        }

        lblPhoneSpec[0].setText(phone.getBrand());
        lblPhoneSpec[1].setText(phone.getModel());
        lblPhoneSpec[2].setText(phone.getDisplaySize());
        lblPhoneSpec[3].setText(phone.getBatteryCapacity() + "");
        lblPhoneSpec[4].setText(phone.getCpu());
        lblPhoneSpec[5].setText(phone.getBodyDimensions());
        lblPhoneSpec[6].setText(phone.getDisplayResolution());

        pnlCenter.add(pnlCenterOne);

        JPanel pnlCenterTwo = new JPanel(new GridLayout(2, 3));

        int currectPrice = ad.getBids().stream().max((b1, b2) -> b1.getAmount() - b2.getAmount()).get().getAmount();

        JLabel lblCurrectPrice = new JLabel(String.valueOf(currectPrice));
        lblCurrectPrice.setOpaque(true);
        switch (ad.getStatus()) {
            case ACTIVE :
                lblCurrectPrice.setBackground(Color.GREEN);
                break;
            case INACTIVE :
                lblCurrectPrice.setBackground(Color.LIGHT_GRAY);
                break;
            case CLOSED :
                lblCurrectPrice.setBackground(Color.RED);
                break;
        }

        JTextField txtNewPrice = new JTextField(5);

        pnlCenterTwo.add(txtNewPrice);

        JButton btnBid = new JButton("BID");
        btnBid.setEnabled(ad.getStatus() == StatusTeam5.ACTIVE && txtNewPrice.getText() != null);
        btnBid.addActionListener(e -> {
            int newPrice = Integer.parseInt(txtNewPrice.getText());
            if (newPrice > currectPrice) {
                lblCurrectPrice.setText(String.valueOf(newPrice));
                txtNewPrice.setText(null);
                // TODO: add new bid to datebase

                validate();
                repaint();
            }
        });

        pnlCenterTwo.add(btnBid);

        JTextField txtNewComment = new JTextField(30);
        pnlCenterTwo.add(txtNewComment);

        JButton btnSendCommnet = new JButton("SEND");
        btnSendCommnet.setEnabled(txtNewComment.getText() != null);
        btnSendCommnet.addActionListener(e -> {
            // TODO: Create new commnent add it to datebase and add it to scrollpane
        });

        pnlCenterTwo.add(btnSendCommnet);

        pnlCenter.add(pnlCenterTwo);

        Collection<CommentTeam5> comments = ad.getComments();

        java.util.List<Comment> commentList = new ArrayList<>();

        for (CommentTeam5 comment : comments) {
            commentList.add(new Comment(comment.getUser(), comment.getContent()));
        }

        JScrollPane southScrollPane = new JScrollPane((Component) commentList);

        add(southScrollPane, BorderLayout.SOUTH);

    }

    public void updateScrollPaneWithNewComment() {
        // TODO:
    }

}
