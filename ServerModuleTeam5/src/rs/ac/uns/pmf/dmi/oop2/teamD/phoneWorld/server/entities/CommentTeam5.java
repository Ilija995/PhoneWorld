package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Represents one comment in the ad
 */
@Entity(name = "COMMENTS_TEAM_5")
@NamedQuery(name = "Comments.getUserCommentAds", query = "SELECT DISTINCT comment.ad FROM COMMENTS_TEAM_5 comment WHERE comment.user.username = :username")
public class CommentTeam5 implements Serializable {

	private Integer id;
	private String content;
	private UserTeam5 user;
	private AdTeam5 ad;
	private Timestamp timestamp;

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne
	public UserTeam5 getUser() {
		return user;
	}

	public void setUser(UserTeam5 user) {
		this.user = user;
	}

	@ManyToOne
	public AdTeam5 getAd() {
		return ad;
	}

	public void setAd(AdTeam5 ad) {
		this.ad = ad;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
