package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Represents one comment in the ad
 */
@Entity
@Table(name = "COMMENT_TEAM_5", schema = "PUBLIC", catalog = "TEST")
@NamedQuery(name = "Comments.getUserCommentAds", query = "SELECT DISTINCT comment.ad FROM CommentTeam5 comment WHERE comment.user.username = :username")
public class CommentTeam5 implements Serializable {
	private int commentId;
	private String content;
	private Timestamp timestamp;
	private AdTeam5 ad;
	private UserTeam5 user;

	@Id
	@Column(name = "COMMENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	@Basic
	@Column(name = "CONTENT")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

		CommentTeam5 that = (CommentTeam5) o;

		if (commentId != that.commentId) return false;
		if (content != null ? !content.equals(that.content) : that.content != null) return false;
		if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = commentId;
		result = 31 * result + (content != null ? content.hashCode() : 0);
		result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
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
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	public UserTeam5 getUser() {
		return user;
	}

	public void setUser(UserTeam5 user) {
		this.user = user;
	}
}
