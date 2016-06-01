package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.*;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void postConstruct() {
        //TODO;
    }

    private AdTeam5 addAd(Integer id,
                               UserTeam5 owner,
                               PhoneTeam5 phone,
                               String title,
                               String description,
                               StatusTeam5 status,
                               Collection<BidTeam5> bids,
                               Timestamp timestamp,
                               Collection<CommentTeam5> comments
    ) {
        AdTeam5 ad = em.find(AdTeam5.class, id);
        if (ad != null)
            return ad;

        ad = new AdTeam5();
        ad.setId(id);
        ad.setOwner(owner);
        ad.setPhone(phone);
        ad.setTitle(title);
        ad.setDescription(description);
        ad.setStatus(status);
        ad.setBids(bids);
        ad.setTimestamp(timestamp);
        ad.setComments(comments);
        em.persist(ad);
        return ad;
    }

    private BidTeam5 addBid(Integer id, AdTeam5 ad, UserTeam5 bidder, Integer amount)
    {
        BidTeam5 bid = em.find(BidTeam5.class, id);
        if (bid != null)
            return bid;
        bid = new BidTeam5();
        bid.setAd(ad);
        bid.setId(id);
        bid.setBidder(bidder);
        bid.setAmount(amount);
        em.persist(bid);
        return bid;
    }

    private UserTeam5 addUser(Integer id,
                                   String username,
                                   String firstName,
                                   String secondName,
                                   String email,
                                   String passwordToken,
                                   String avatarPath,
                                   String userInfo,
                                   Collection<AdTeam5> ads,
                                   Collection<BidTeam5> bids,
                                   Collection<CommentTeam5> comments
    ) {
        UserTeam5 u = em.find(UserTeam5.class, id);
        if (u != null)
            return u;

        u = new UserTeam5();
        u.setId(id);
        u.setUsername(username);
        u.setFirstName(firstName);
        u.setSecondName(secondName);
        u.setEmail(email);
        u.setPasswordToken(passwordToken);
        u.setAvatarPath(avatarPath);
        u.setUserInfo(userInfo);
        u.setAds(ads);
        u.setBids(bids);
        u.setComments(comments);
        em.persist(u);
        return u;
    }

    private PhoneTeam5 addPhone(Integer id,
                                    String brand,
                                    String model,
                                    String bodyDimensions,
                                    String displaySize,
                                    String displayResolution,
                                    String cpu,
                                    int batteryCapacity,
                                    String photosFolderPath
    ) {
        PhoneTeam5 p = em.find(PhoneTeam5.class, id);
        if(p != null)
            return p;

        p = new PhoneTeam5();
        p.setId(id);
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

    private CommentTeam5 addComment(Integer id,
                                        String content,
                                        UserTeam5 user,
                                        AdTeam5 ad,
                                        Timestamp timestamp
    ) {
        CommentTeam5 c = em.find(CommentTeam5.class, id);
        if(c != null)
            return c;

        c = new CommentTeam5();
        c.setId(id);
        c.setContent(content);
        c.setUser(user);
        c.setAd(ad);
        c.setTimestamp(timestamp);
        em.persist(c);
        return c;
    }
}