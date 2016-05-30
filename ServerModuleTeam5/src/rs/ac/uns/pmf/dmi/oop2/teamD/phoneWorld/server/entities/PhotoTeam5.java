package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * User avatar or phone photo
 */
@Entity(name = "PHOTOS_TEAM_5")
public class PhotoTeam5 implements Serializable {

	private Integer id;
	private UserTeam5 user;
	private PhoneTeam5 phone;

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne
	public UserTeam5 getUser() {
		return user;
	}

	public void setUser(UserTeam5 user) {
		this.user = user;
	}

	@ManyToOne
	public PhoneTeam5 getPhone() {
		return phone;
	}

	public void setPhone(PhoneTeam5 phone) {
		this.phone = phone;
	}
}
