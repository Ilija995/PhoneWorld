package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents one phone advertisement
 */
@Entity
@Table(name = "AD_TEAM_5", schema = "PUBLIC", catalog = "TEST")
@NamedQueries({
		@NamedQuery(name = "Ads.getAdsByStatus", query = "SELECT ad FROM AdTeam5 ad WHERE ad.status = :status"),
		@NamedQuery(name = "Ads.getUserOwnedAds", query = "SELECT ad FROM AdTeam5 ad WHERE ad.owner.username = :username"),
})
public class AdTeam5 implements Serializable {
	private int adId;
	private String title;
	private String description;
	private String status;
	private Timestamp timestamp;
	private UserTeam5 owner;
	private PhoneTeam5 phone;
	private Set<BidTeam5> bids;
	private Set<CommentTeam5> comments;

	public AdTeam5() {
		bids = new HashSet<>();
		comments = new HashSet<>();
	}

	@Id
	@Column(name = "AD_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	@Basic
	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Basic
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Basic
	@Column(name = "TIMESTAMP")
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AdTeam5 adTeam5 = (AdTeam5) o;

		if (adId != adTeam5.adId) return false;
		if (title != null ? !title.equals(adTeam5.title) : adTeam5.title != null) return false;
		if (description != null ? !description.equals(adTeam5.description) : adTeam5.description != null) return false;
		if (status != null ? !status.equals(adTeam5.status) : adTeam5.status != null) return false;
		if (timestamp != null ? !timestamp.equals(adTeam5.timestamp) : adTeam5.timestamp != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = adId;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "OWNER_ID", referencedColumnName = "USER_ID")
	public UserTeam5 getOwner() {
		return owner;
	}

	public void setOwner(UserTeam5 owner) {
		this.owner = owner;
	}

	@OneToOne
	@JoinColumn(name = "PHONE_ID", referencedColumnName = "PHONE_ID")
	public PhoneTeam5 getPhone() {
		return phone;
	}

	public void setPhone(PhoneTeam5 phone) {
		this.phone = phone;
	}

	@OneToMany(mappedBy = "ad")
	public Set<BidTeam5> getBids() {
		return bids;
	}

	public void setBids(Set<BidTeam5> bids) {
		this.bids = bids;
	}

	@OneToMany(mappedBy = "ad")
	public Set<CommentTeam5> getComments() {
		return comments;
	}

	public void setComments(Set<CommentTeam5> comments) {
		this.comments = comments;
	}
}
