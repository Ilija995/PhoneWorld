package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.*;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.utilities.ImageStorage;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.utilities.PasswordAuthentication;

import javax.ejb.Stateless;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
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

    private PasswordAuthentication passwordAuthentication;


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

    @Override
    public boolean authenticateUser(String username, char[] password) {
        TypedQuery<UserTeam5> q = em.createNamedQuery("Users.getUser", UserTeam5.class);
        q.setParameter("username", username);
        UserTeam5 user = q.getSingleResult();
        if(user != null) {
            return passwordAuthentication.authenticate(password, user.getPasswordToken());
        }
        return false;
    }

    @Override
    public boolean checkCredentialsAvailability(String username, String email) {
        TypedQuery<UserTeam5> q = em.createNamedQuery("Users.getUser", UserTeam5.class);
        q.setParameter("username", username);
        UserTeam5 user = q.getSingleResult();
        if(user != null) {
            return false;
        }
        else {
            TypedQuery<UserTeam5> q1 = em.createNamedQuery("Users.getUserByEmail", UserTeam5.class);
            q1.setParameter("email", email);
            UserTeam5 user1 = q.getSingleResult();
            return user1 == null;
        }
    }

    @Override
    public byte[] getUserAvatar(String avatarPath) throws IOException {
        return ImageStorage.getAvatar(avatarPath);
    }

    @Override
    public String addUserAvatar(String username, byte[] avatar) throws IOException {
        return ImageStorage.addAvatar(username, avatar);
    }

    @Override
    public List<byte[]> getPhonePhotos(String photosPath) throws IOException {
        return ImageStorage.getPhonePhotos(photosPath);
    }

    @Override
    public String addPhonePhotos(String username, String adId, List<byte[]> photos) throws IOException {
        return ImageStorage.addPhonePhotos(username, adId, photos);
    }

    @Override
    public AdTeam5 addAd(UserTeam5 owner,
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

    @Override
    public BidTeam5 addBid(AdTeam5 ad, UserTeam5 bidder, Integer amount)
    {
        BidTeam5 bid = new BidTeam5();
        bid.setAd(ad);
        bid.setBidder(bidder);
        bid.setAmount(amount);
        em.persist(bid);
        return bid;
    }

    @Override
    public UserTeam5 addUser(String username,
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

    @Override
    public PhoneTeam5 addPhone(String brand,
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

    @Override
    public CommentTeam5 addComment(String content,
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
