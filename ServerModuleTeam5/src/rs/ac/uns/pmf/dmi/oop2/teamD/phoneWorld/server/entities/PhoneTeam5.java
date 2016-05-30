package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

/**
 * Class representing one cell phone
 */
@Entity(name = "PHONES_TEAM_5")
public class PhoneTeam5 implements Serializable {

	private Integer id;
	private String brand;
	private String model;
	private String bodyDimensions;
	private String displaySize;
	private String displayResolution;
	private String cpu;
	private int batteryCapacity;
	private Collection<PhotoTeam5> photos;

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBodyDimensions() {
		return bodyDimensions;
	}

	public void setBodyDimensions(String bodyDimensions) {
		this.bodyDimensions = bodyDimensions;
	}

	public String getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}

	public String getDisplayResolution() {
		return displayResolution;
	}

	public void setDisplayResolution(String displayResolution) {
		this.displayResolution = displayResolution;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	@OneToMany(mappedBy = "phone")
	public Collection<PhotoTeam5> getPhotos() {
		return photos;
	}

	public void setPhotos(Collection<PhotoTeam5> photos) {
		this.photos = photos;
	}
}