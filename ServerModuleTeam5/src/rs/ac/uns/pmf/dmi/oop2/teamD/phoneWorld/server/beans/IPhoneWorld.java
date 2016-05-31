package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.AdTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.BidTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.StatusTeam5;
import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.UserTeam5;

import java.util.List;
/**
 * Created by UserPC on 31.05.2016..
 */
public interface IPhoneWorld {

    /*List<AdTeam5> getAllAds();*/

    List<BidTeam5> getUserBids(UserTeam5 user);

    List<AdTeam5> getUserAds(UserTeam5 user);

    /*List<AdTeam5> getAllAdsBelowPrice(int price);

    List<AdTeam5> getAllAdsAbovePrice(int price);*/

    List<AdTeam5> getAllAdsByStatus(StatusTeam5 status);

    void removeAd(int id);

    void removeBid(int id);


}
