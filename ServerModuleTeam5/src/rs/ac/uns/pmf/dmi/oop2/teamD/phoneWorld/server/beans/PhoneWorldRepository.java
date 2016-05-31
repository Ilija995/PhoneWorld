package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.AdTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.BidTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.StatusTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.UserTeam5;

import javax.ejb.Stateless;
import java.util.List;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Repository class that communicates with database
 */
@Stateless
@Remote(IPhoneWorldRepository.class)
public class PhoneWorldRepository implements IPhoneWorldRepository {

    @PersistenceContext(name = "PHONE_WORLD_DB")
    private EntityManager em;

    @Override
    public List<AdTeam5> getAllUserAds(String username) {
        return null;
    }

    @Override
    public List<AdTeam5> getUserOwnedAds(String username) {
        return null;
    }

    @Override
    public List<AdTeam5> getUserCommentedAds(String username) {
        return null;
    }

    @Override
    public List<AdTeam5> getUserBidAds(String username) {
        return null;
    }

    @Override
    public List<AdTeam5> getAdsByStatus(StatusTeam5 status) {
        return null;
    }

    @Override
    public void removeAd(int id) {

    }

    /*
    @Override
    public List<AdTeam5> getAllAdsByStatus(StatusTeam5 status) {
        TypedQuery<AdTeam5> q = em.createNamedQuery("Ads.getAdsByStatus", AdTeam5.class);
        q.setParameter("status", status);
        return q.getResultList();
    }

    @Override
    public List<BidTeam5> getUserBids(UserTeam5 user) {
        TypedQuery<BidTeam5> q = em.createNamedQuery("Bids.getUserBidAds", BidTeam5.class);
        q.setParameter("username", user.getUsername());
        return q.getResultList();
    }

    @Override
    public List<AdTeam5> getUserAds(UserTeam5 user) {
        TypedQuery<AdTeam5> q = em.createNamedQuery("Ads.getUserOwnedAds", AdTeam5.class);
        q.setParameter("username", user.getUsername());
        return q.getResultList();
    }

    @Override
    public void removeAd(int id) {
        AdTeam5 ad = em.find(AdTeam5.class, id);
        if (ad == null)
            return;
        TypedQuery<UserTeam5> q = em.createNamedQuery("Users.getByAd", UserTeam5.class);
        q.setParameter("ad", ad);
        List<UserTeam5> list = q.getResultList();
        for (UserTeam5 u : list)
        {
            u.getAds().remove(ad);
            em.merge(u);
        }
        em.remove(ad);
    }

    @Override
    public void removeBid(int id) {
        BidTeam5 bid = em.find(BidTeam5.class, id);
        if (bid == null)
            return;
        TypedQuery<UserTeam5> q = em.createNamedQuery("Users.getByBid", UserTeam5.class);
        q.setParameter("bid", bid);
        List<UserTeam5> list = q.getResultList();
        for (UserTeam5 u : list)
        {
            u.getBids().remove(bid);
            em.merge(u);
        }
        em.remove(bid);
    }
    */
}
