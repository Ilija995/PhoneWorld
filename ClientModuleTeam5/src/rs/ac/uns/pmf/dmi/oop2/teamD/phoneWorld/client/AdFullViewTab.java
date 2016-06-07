package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.client;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.*;

import javax.naming.NamingException;
import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Aleksandar on 6/3/2016.
 */
public class AdFullViewTab extends JPanel {

    private static final long serialVersionUID = 9173229264965205982L;

    public AdFullViewTab(AdTeam5 ad, MainPanel main) {

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

        int currentPrice = ad.getBids().stream().max((b1, b2) -> b1.getAmount() - b2.getAmount()).get().getAmount();

        JLabel lblCurrentPrice = new JLabel(String.valueOf(currentPrice));
        lblCurrentPrice.setOpaque(true);
        switch (ad.getStatus()) {
            case "ACTIVE" :
                lblCurrentPrice.setBackground(Color.GREEN);
                break;
            case "INACTIVE" :
                lblCurrentPrice.setBackground(Color.LIGHT_GRAY);
                break;
            case "CLOSED" :
                lblCurrentPrice.setBackground(Color.RED);
                break;
        }

        JTextField txtNewPrice = new JTextField(5);

        pnlCenterTwo.add(txtNewPrice);

        JButton btnBid = new JButton("BID");
        btnBid.setEnabled(ad.getStatus().equals(StatusTeam5.ACTIVE.name()) && txtNewPrice.getText() != null);
        btnBid.addActionListener(e -> {
            int newPrice = Integer.parseInt(txtNewPrice.getText());
            if (newPrice > currentPrice) {
                lblCurrentPrice.setText(String.valueOf(newPrice));
                txtNewPrice.setText(null);
                try {
                    main.getClientFromMain().getRepository().addBid(ad, main.getUserFromMain(), newPrice);
                } catch (NamingException e1) {
                    e1.printStackTrace();
                }

                validate();
                repaint();
            }
        });

        pnlCenterTwo.add(btnBid);

        JTextField txtNewComment = new JTextField(30);
        pnlCenterTwo.add(txtNewComment);

        JButton btnSendComment = new JButton("SEND");
        btnSendComment.setEnabled(txtNewComment.getText() != null);
        btnSendComment.addActionListener(e -> {

            try {
                main.getClientFromMain().getRepository().addComment(txtNewComment.getText(), main.getUserFromMain(), ad, new Timestamp(System.currentTimeMillis()));
            } catch (NamingException e1) {
                e1.printStackTrace();
            }

        });

        pnlCenterTwo.add(btnSendComment);

        pnlCenter.add(pnlCenterTwo);

        Collection<CommentTeam5> comments = ad.getComments();

        java.util.List<Comment> commentList = new ArrayList<>();

        for (CommentTeam5 comment : comments) {
            commentList.add(new Comment(comment.getUser(), comment.getContent()));
        }

        JScrollPane southScrollPane = new JScrollPane((Component) commentList);

        add(southScrollPane, BorderLayout.SOUTH);



    }

}
