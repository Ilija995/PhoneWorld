package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Represents one bid on an ad
 */
@Entity(name = "BIDS_TEAM_5")
@NamedQuery(name = "Bids.getUserBidAds", query = "SELECT DISTINCT bid.ad FROM BIDS_TEAM_5 bid WHERE bid.bidder.username = :username")
public class BidTeam5 implements Serializable {

	private Integer id;
	private AdTeam5 ad;
	private UserTeam5 bidder;
	private Integer amount;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	public AdTeam5 getAd() {
		return ad;
	}

	public void setAd(AdTeam5 ad) {
		this.ad = ad;
	}

	@ManyToOne
	public UserTeam5 getBidder() {
		return bidder;
	}

	public void setBidder(UserTeam5 bidder) {
		this.bidder = bidder;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer bid) {
		this.amount = bid;
	}
}
