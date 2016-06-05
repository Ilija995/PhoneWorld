package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for repository that communicates with database
 */
public interface IPhoneWorldRepository {

    List<AdTeam5> getAllUserAds(String username);

    UserTeam5 getUser(String username);

    UserTeam5 getUserByEmail(String email);

    List<AdTeam5> getUserOwnedAds(String username);

    List<AdTeam5> getUserCommentedAds(String username);

    List<AdTeam5> getUserBidAds(String username);

    List<AdTeam5> getAdsByStatus(StatusTeam5 status);

    String getHashedPassword(char[] password);

    void removeAd(int id);

    boolean authenticateUser(String username, char[] password);

    boolean checkCredentialsAvailability(String username, String email);

    byte[] getUserAvatar(String avatarPath) throws IOException;

    String addUserAvatar(String username, byte[] avatar) throws IOException;

    List<byte[]> getPhonePhotos(String photosPath) throws IOException;

    String addPhonePhotos(String username, String adId, List<byte[]> photos) throws IOException;

    AdTeam5 addAd(UserTeam5 owner,
                          PhoneTeam5 phone,
                          String title,
                          String description,
                          StatusTeam5 status,
                          Timestamp timestamp
    );

    BidTeam5 addBid(AdTeam5 ad, UserTeam5 bidder, Integer amount);

    UserTeam5 addUser(String username,
                      String firstName,
                      String secondName,
                      String email,
                      String passwordToken,
                      String avatarPath,
                      String userInfo
    );

    PhoneTeam5 addPhone(String brand,
                        String model,
                        String bodyDimensions,
                        String displaySize,
                        String displayResolution,
                        String cpu,
                        int batteryCapacity,
                        String photosFolderPath
    );

    CommentTeam5 addComment(String content,
                            UserTeam5 user,
                            AdTeam5 ad,
                            Timestamp timestamp
    );
}
