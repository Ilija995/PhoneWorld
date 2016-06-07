package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Represents one bid on an ad
 */
@Entity
@Table(name = "BID_TEAM_5", schema = "PUBLIC", catalog = "TEST")
@NamedQuery(name = "Bids.getUserBidAds", query = "SELECT DISTINCT bid.ad FROM BidTeam5 bid WHERE bid.bidder.username = :username")
public class BidTeam5 implements Serializable {
	private int bidId;
	private Integer amount;
	private AdTeam5 ad;
	private UserTeam5 bidder;

	@Id
	@Column(name = "BID_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	@Basic
	@Column(name = "AMOUNT")
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BidTeam5 bidTeam5 = (BidTeam5) o;

		if (bidId != bidTeam5.bidId) return false;
		if (amount != null ? !amount.equals(bidTeam5.amount) : bidTeam5.amount != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = bidId;
		result = 31 * result + (amount != null ? amount.hashCode() : 0);
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "AD_ID", referencedColumnName = "AD_ID")
	public AdTeam5 getAd() {
		return ad;
	}

	public void setAd(AdTeam5 ad) {
		this.ad = ad;
	}

	@ManyToOne
	@OneToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	public UserTeam5 getBidder() {
		return bidder;
	}

	public void setBidder(UserTeam5 bidder) {
		this.bidder = bidder;
	}
}
