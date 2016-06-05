package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.*;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.utilities.ImageStorage;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Local bean that fills the database at startup
 */
@Singleton
@LocalBean
@Startup
public class FillPhoneWorldDb {

    @PersistenceContext(name = "PHONE_WORLD_DB")
    private EntityManager em;

    @EJB(beanName = "PhoneWorldRepository")
    private IPhoneWorldRepository repository;

    @PostConstruct
    public void postConstruct() {

        PhoneTeam5 p1 = addPhone("Nokia", "3310","20*70*40","1 inch","480*480 p","quad-core",2300,"res\\img\\defaultPhonePhoto.png");
        PhoneTeam5 p2 = addPhone("Nokia", "3210","20*75*40","1.1 inch","480*480 p","dual-core",2350,"res\\img\\defaultPhonePhoto.png");
        UserTeam5 u1 = addUser("Nokia lover", "Pera", "Peric","peraperic@gmail.com", "1234pass", "res\\img\\defaultAvatar.png", "i love nokias");
        UserTeam5 u2 = addUser("Nokia hater", "Mika", "Mikic","mikamikic@gmail.com", "12345pass", "res\\img\\defaultAvatar.png", "i hate nokias");
        AdTeam5 a1 = addAd(u1,p1,"selling nokia 3310","awesome phone",StatusTeam5.ACTIVE, Timestamp.valueOf("2016-09-23 11:10:10.0"));
        AdTeam5 a2 = addAd(u2,p2,"selling nokia 3210","bad phone",StatusTeam5.ACTIVE, Timestamp.valueOf("2016-09-22 10:16:10.0"));
        BidTeam5 b1 = addBid(a2,u1,1000);
        u1.getBids().add(b1);
        a2.getBids().add(b1);
        CommentTeam5 c1 = addComment("nokia is bad", u2, a1, Timestamp.valueOf("2007-09-24 10:10:10.0"));
        CommentTeam5 c2 = addComment("nokia is super cool", u1, a2, Timestamp.valueOf("2007-09-23 10:12:10.0"));
        u2.getComments().add(c1);
        a1.getComments().add(c1);
        u1.getComments().add(c2);
        a2.getComments().add(c2);

        em.merge(p1);
        em.merge(p2);
        em.merge(u1);
        em.merge(u2);
        em.merge(a1);
        em.merge(a2);
        em.merge(b1);
        em.merge(c1);
        em.merge(c2);
    }

    private AdTeam5 addAd(UserTeam5 owner,
                               PhoneTeam5 phone,
                               String title,
                               String description,
                               StatusTeam5 status,
                               Timestamp timestamp
    ) {
        AdTeam5 ad = new AdTeam5();
        ad.setOwner(owner);
        ad.setPhone(phone);
        ad.setTitle(title);
        ad.setDescription(description);
        ad.setStatus(status);
        ad.setTimestamp(timestamp);
        em.persist(ad);
        return ad;
    }

    private BidTeam5 addBid(AdTeam5 ad, UserTeam5 bidder, Integer amount)
    {
        BidTeam5 bid = new BidTeam5();
        bid.setAd(ad);
        bid.setBidder(bidder);
        bid.setAmount(amount);
        em.persist(bid);
        return bid;
    }

    private UserTeam5 addUser(String username,
                                   String firstName,
                                   String secondName,
                                   String email,
                                   String passwordToken,
                                   String avatarPath,
                                   String userInfo
    ) {
        UserTeam5 u = new UserTeam5();
        u.setUsername(username);
        u.setFirstName(firstName);
        u.setSecondName(secondName);
        u.setEmail(email);
        u.setPasswordToken(passwordToken);
        u.setAvatarPath(avatarPath);
        u.setUserInfo(userInfo);
        em.persist(u);
        return u;
    }

    private PhoneTeam5 addPhone(String brand,
                                    String model,
                                    String bodyDimensions,
                                    String displaySize,
                                    String displayResolution,
                                    String cpu,
                                    int batteryCapacity,
                                    String photosFolderPath
    ) {
        PhoneTeam5 p = new PhoneTeam5();
        p.setBrand(brand);
        p.setModel(model);
        p.setBodyDimensions(bodyDimensions);
        p.setDisplaySize(displaySize);
        p.setDisplayResolution(displayResolution);
        p.setCpu(cpu);
        p.setBatteryCapacity(batteryCapacity);
        p.setPhotosFolderPath(photosFolderPath);
        em.persist(p);
        return p;

    }

    private CommentTeam5 addComment(String content,
                                        UserTeam5 user,
                                        AdTeam5 ad,
                                        Timestamp timestamp
    ) {
        CommentTeam5 c = new CommentTeam5();
        c.setContent(content);
        c.setUser(user);
        c.setAd(ad);
        c.setTimestamp(timestamp);
        em.persist(c);
        return c;
    }
}