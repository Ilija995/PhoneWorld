package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Represents one user account
 */
@Entity(name = "USERS_TEAM_5")
@NamedQuery(name = "Users.getUser", query = "SELECT user FROM USERS_TEAM_5 user WHERE username = :username")
public class UserTeam5 implements Serializable {

	private Integer id;
	private String username;
	private String firstName;
	private String secondName;
	private String email;
	private String passwordToken; // Not storing raw password for security reasons
	private PhotoTeam5 avatar;
	private String userInfo;
	private Collection<AdTeam5> ads;
	private Collection<BidTeam5> bids;
	private Collection<CommentTeam5> comments;

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(unique = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	@Column(unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordToken() {
		return passwordToken;
	}

	public void setPasswordToken(String passwordToken) {
		this.passwordToken = passwordToken;
	}

	@OneToOne(mappedBy = "user")
	public PhotoTeam5 getAvatar() {
		return avatar;
	}

	public void setAvatar(PhotoTeam5 avatar) {
		this.avatar = avatar;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	@OneToMany(mappedBy = "owner")
	public Collection<AdTeam5> getAds() {
		return ads;
	}

	public void setAds(Collection<AdTeam5> ads) {
		this.ads = ads;
	}

	@OneToMany(mappedBy = "bidder")
	public Collection<BidTeam5> getBids() {
		return bids;
	}

	public void setBids(Collection<BidTeam5> bids) {
		this.bids = bids;
	}

	@OneToMany(mappedBy = "user")
	public Collection<CommentTeam5> getComments() {
		return comments;
	}

	public void setComments(Collection<CommentTeam5> comments) {
		this.comments = comments;
	}
}
