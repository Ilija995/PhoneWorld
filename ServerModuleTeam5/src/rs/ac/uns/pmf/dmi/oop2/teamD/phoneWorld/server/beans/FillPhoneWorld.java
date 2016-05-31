package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans;

import com.sun.xml.internal.bind.v2.TODO;
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
 * Created by UserPC on 31.05.2016..
 */
@Singleton
@LocalBean
@Startup
public class FillPhoneWorld {
    @PersistenceContext(name = "TEAM5_EE")
    private EntityManager em;

    @PostConstruct
    public void postConstruct() {
        //TODO;
    }

    private AdTeam5 getOrAddAd(Integer id, UserTeam5 owner, PhoneTeam5 phone, String title, String description, StatusTeam5 status, Collection<BidTeam5> bids, Collection<CommentTeam5> comments)
    {
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
        ad.setComments(comments);
        ad.setBids(bids);
        ad.setTimestamp();
        em.persist(ad);
        return ad;
    }

    private BidTeam5 getOrAddBid(Integer id, AdTeam5 ad, UserTeam5 bidder, Integer bid1)
    {
        BidTeam5 bid = em.find(BidTeam5.class, id);
        if (bid != null)
            return bid;
        bid = new BidTeam5();
        bid.setAd(ad);
        bid.setId(id);
        bid.setBidder(bidder);
        bid.setBid(bid1);
        em.persist(bid);
        return bid;
    }

    private UserTeam5 getOrAddUser(Integer id, String username, String firstName, String secondName, String email, String passwordToken, PhotoTeam5 avatar, String userInfo, Collection<AdTeam5> ads, Collection<BidTeam5> bids, Collection<CommentTeam5> comments)
    {
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
        u.setAvatar(avatar);
        u.setUserInfo(userInfo);
        u.setAds(ads);
        u.setBids(bids);
        u.setComments(comments);
        em.persist(u);
        return u;
    }
}