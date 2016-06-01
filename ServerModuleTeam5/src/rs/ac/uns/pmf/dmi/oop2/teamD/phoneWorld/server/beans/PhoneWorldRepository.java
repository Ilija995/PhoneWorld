package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.AdTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.BidTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.StatusTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.UserTeam5;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        List<AdTeam5> ownedAds = getUserOwnedAds(username);
        List<AdTeam5> bidAds = getUserCommentedAds(username);
        List<AdTeam5> commentAds = getUserBidAds(username);
        List<AdTeam5> allAds = new ArrayList<>();
        allAds.addAll(ownedAds);
        allAds.addAll(bidAds);
        allAds.addAll(commentAds);
        Collections.sort(allAds, (a1, a2) -> a1.getTimestamp().compareTo(a2.getTimestamp()));
        return allAds;
    }

    @Override
    public List<AdTeam5> getUserOwnedAds(String username) {
        TypedQuery<AdTeam5> q = em.createNamedQuery("Ads.getUserOwnedAds", AdTeam5.class);
        q.setParameter("username", username);
        return q.getResultList();
    }

    @Override
    public List<AdTeam5> getUserCommentedAds(String username) {
        TypedQuery<AdTeam5> q = em.createNamedQuery("Comments.getUserCommentAds", AdTeam5.class);
        q.setParameter("username", username);
        return q.getResultList();
    }

    @Override
    public List<AdTeam5> getUserBidAds(String username) {
        TypedQuery<AdTeam5> q = em.createNamedQuery("Bids.getUserBidAds", AdTeam5.class);
        q.setParameter("username", username);
        return q.getResultList();
    }

    @Override
    public List<AdTeam5> getAdsByStatus(StatusTeam5 status) {
        TypedQuery<AdTeam5> q = em.createNamedQuery("Ads.getAdsByStatus", AdTeam5.class);
        q.setParameter("status", status);
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
}
