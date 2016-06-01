package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Represents one phone advertisement
 */
@Entity(name = "ADS_TEAM_5")
@NamedQueries({
		@NamedQuery(name = "Ads.getAdsByStatus", query = "SELECT ad FROM ADS_TEAM_5 ad WHERE ad.status = :status"),
		@NamedQuery(name = "Ads.getUserOwnedAds", query = "SELECT ad FROM ADS_TEAM_5 ad WHERE ad.owner.username = :username"),
})
public class AdTeam5 implements Serializable {

	private Integer id;
	private UserTeam5 owner;
	private PhoneTeam5 phone;
	private String title;
	private String description;
	private StatusTeam5 status;
	private Collection<BidTeam5> bids;
	private Collection<CommentTeam5> comments;
	private Timestamp timestamp;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	public UserTeam5 getOwner() {
		return owner;
	}

	public void setOwner(UserTeam5 owner) {
		this.owner = owner;
	}

	@OneToOne
	public PhoneTeam5 getPhone() {
		return phone;
	}

	public void setPhone(PhoneTeam5 phone) {
		this.phone = phone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatusTeam5 getStatus() {
		return status;
	}

	public void setStatus(StatusTeam5 status) {
		this.status = status;
	}

	@OneToMany
	public Collection<BidTeam5> getBids() {
		return bids;
	}

	public void setBids(Collection<BidTeam5> bids) {
		this.bids = bids;
	}

	@OneToMany(mappedBy = "ad")
	public Collection<CommentTeam5> getComments() {
		return comments;
	}

	public void setComments(Collection<CommentTeam5> comments) {
		this.comments = comments;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
