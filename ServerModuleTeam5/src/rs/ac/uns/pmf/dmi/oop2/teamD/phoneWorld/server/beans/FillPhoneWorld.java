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
public class FillPhoneWorld {

    @PersistenceContext(name = "PHONE_WORLD_DB")
    private EntityManager em;

    @PostConstruct
    public void postConstruct() {
        //TODO;
    }

    private AdTeam5 getOrAddAd(Integer id,
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

    private BidTeam5 getOrAddBid(Integer id, AdTeam5 ad, UserTeam5 bidder, Integer amount)
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

    private UserTeam5 getOrAddUser(Integer id,
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

    private PhoneTeam5 getOrAdPhone() {
        throw new UnsupportedOperationException();
    }

    private CommentTeam5 getOrAddComment() {
        throw new UnsupportedOperationException();
    }
}