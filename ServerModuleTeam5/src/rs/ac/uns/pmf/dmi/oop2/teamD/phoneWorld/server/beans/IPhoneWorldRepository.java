package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.AdTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.BidTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.StatusTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.UserTeam5;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * Interface for repository that communicates with database
 */
public interface IPhoneWorldRepository {

    List<AdTeam5> getAllUserAds(String username);

    List<AdTeam5> getUserOwnedAds(String username);

    List<AdTeam5> getUserCommentedAds(String username);

    List<AdTeam5> getUserBidAds(String username);

    List<AdTeam5> getAdsByStatus(StatusTeam5 status);

    void removeAd(int id);

    boolean authenticateUser(String username, char[] password);

    boolean checkCredentialsAvailability(String username, String email);

    byte[] getUserAvatar(String avatarPath) throws IOException;

    String addUserAvatar(String username, byte[] avatar) throws IOException;

    List<byte[]> getPhonePhotos(String photosPath) throws IOException;

    String addPhonePhotos(String username, String adId, List<byte[]> photos) throws IOException;
}
