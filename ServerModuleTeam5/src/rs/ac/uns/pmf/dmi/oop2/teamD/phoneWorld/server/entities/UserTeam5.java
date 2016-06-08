package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents one user account
 */
@Entity
@Table(name = "USER_TEAM_5", schema = "PUBLIC", catalog = "TEST")
@NamedQueries({
		@NamedQuery(name = "Users.getUser", query = "SELECT user FROM UserTeam5 user WHERE username = :username"),
		@NamedQuery(name = "Users.getUserByEmail", query = "SELECT user FROM UserTeam5 user WHERE email = :email"),
		@NamedQuery(name = "Users.getByAd", query = "SELECT user FROM UserTeam5 user WHERE :ad MEMBER OF user.ads"),
		@NamedQuery(name = "Users.getByBid", query = "SELECT user FROM UserTeam5 user WHERE :bid MEMBER OF user.bids"),
})
public class UserTeam5 implements Serializable {
	private int userId;
	private String passwordToken;
	private String userInfo;
	private String avatarPath;
	private String username;
	private Set<AdTeam5> ads;
	private Set<CommentTeam5> comments;
	private Set<BidTeam5> bids;
	private String firstName;
	private String lastName;
	private String email;

	public UserTeam5() {
		ads = new HashSet<>();
		bids = new HashSet<>();
		comments = new HashSet<>();
	}

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Basic
	@Column(name = "PASSWORD_TOKEN")
	public String getPasswordToken() {
		return passwordToken;
	}

	public void setPasswordToken(String passwordToken) {
		this.passwordToken = passwordToken;
	}

	@Basic
	@Column(name = "USER_INFO")
	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	@Basic
	@Column(name = "AVATAR_PATH")
	public String getAvatarPath() {
		return avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	@Basic
	@Column(name = "USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserTeam5 userTeam5 = (UserTeam5) o;

		if (userId != userTeam5.userId) return false;
		if (firstName != null ? !firstName.equals(userTeam5.firstName) : userTeam5.firstName != null) return false;
		if (lastName != null ? !lastName.equals(userTeam5.lastName) : userTeam5.lastName != null) return false;
		if (email != null ? !email.equals(userTeam5.email) : userTeam5.email != null) return false;
		if (passwordToken != null ? !passwordToken.equals(userTeam5.passwordToken) : userTeam5.passwordToken != null)
			return false;
		if (userInfo != null ? !userInfo.equals(userTeam5.userInfo) : userTeam5.userInfo != null) return false;
		if (avatarPath != null ? !avatarPath.equals(userTeam5.avatarPath) : userTeam5.avatarPath != null) return false;
		if (username != null ? !username.equals(userTeam5.username) : userTeam5.username != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = userId;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (passwordToken != null ? passwordToken.hashCode() : 0);
		result = 31 * result + (userInfo != null ? userInfo.hashCode() : 0);
		result = 31 * result + (avatarPath != null ? avatarPath.hashCode() : 0);
		result = 31 * result + (username != null ? username.hashCode() : 0);
		return result;
	}

	@OneToMany(mappedBy = "owner")
	public Set<AdTeam5> getAds() {
		return ads;
	}

	public void setAds(Set<AdTeam5> ads) {
		this.ads = ads;
	}

	@OneToMany(mappedBy = "user")
	public Set<CommentTeam5> getComments() {
		return comments;
	}

	public void setComments(Set<CommentTeam5> comments) {
		this.comments = comments;
	}

	@OneToMany(mappedBy = "bidder")
	public Set<BidTeam5> getBids() {
		return bids;
	}

	public void setBids(Set<BidTeam5> bids) {
		this.bids = bids;
	}

	@Basic
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Basic
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Basic
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
