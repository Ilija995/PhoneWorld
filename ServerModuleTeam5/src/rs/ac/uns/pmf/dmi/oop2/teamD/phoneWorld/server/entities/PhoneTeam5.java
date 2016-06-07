package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class representing one cell phone
 */
@Entity
@Table(name = "PHONE_TEAM_5", schema = "PUBLIC", catalog = "TEST")
public class PhoneTeam5 implements Serializable {
	private int phoneId;
	private String model;
	private String brand;
	private String bodyDimensions;
	private String displaySize;
	private String displayResolution;
	private String cpu;
	private String batteryCapacity;
	private String photosFolderPath;
	private AdTeam5 ad;

	@Id
	@Column(name = "PHONE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	@Basic
	@Column(name = "MODEL")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Basic
	@Column(name = "BRAND")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Basic
	@Column(name = "BODY_DIMENSIONS")
	public String getBodyDimensions() {
		return bodyDimensions;
	}

	public void setBodyDimensions(String bodyDimensions) {
		this.bodyDimensions = bodyDimensions;
	}

	@Basic
	@Column(name = "DISPLAY_SIZE")
	public String getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}

	@Basic
	@Column(name = "DISPLAY_RESOLUTION")
	public String getDisplayResolution() {
		return displayResolution;
	}

	public void setDisplayResolution(String displayResolution) {
		this.displayResolution = displayResolution;
	}

	@Basic
	@Column(name = "CPU")
	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	@Basic
	@Column(name = "BATTERY_CAPACITY")
	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	@Basic
	@Column(name = "PHOTOS_FOLDER_PATH")
	public String getPhotosFolderPath() {
		return photosFolderPath;
	}

	public void setPhotosFolderPath(String photosFolderPath) {
		this.photosFolderPath = photosFolderPath;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PhoneTeam5 that = (PhoneTeam5) o;

		if (phoneId != that.phoneId) return false;
		if (model != null ? !model.equals(that.model) : that.model != null) return false;
		if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
		if (bodyDimensions != null ? !bodyDimensions.equals(that.bodyDimensions) : that.bodyDimensions != null)
			return false;
		if (displaySize != null ? !displaySize.equals(that.displaySize) : that.displaySize != null) return false;
		if (displayResolution != null ? !displayResolution.equals(that.displayResolution) : that.displayResolution != null)
			return false;
		if (cpu != null ? !cpu.equals(that.cpu) : that.cpu != null) return false;
		if (batteryCapacity != null ? !batteryCapacity.equals(that.batteryCapacity) : that.batteryCapacity != null)
			return false;
		if (photosFolderPath != null ? !photosFolderPath.equals(that.photosFolderPath) : that.photosFolderPath != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = phoneId;
		result = 31 * result + (model != null ? model.hashCode() : 0);
		result = 31 * result + (brand != null ? brand.hashCode() : 0);
		result = 31 * result + (bodyDimensions != null ? bodyDimensions.hashCode() : 0);
		result = 31 * result + (displaySize != null ? displaySize.hashCode() : 0);
		result = 31 * result + (displayResolution != null ? displayResolution.hashCode() : 0);
		result = 31 * result + (cpu != null ? cpu.hashCode() : 0);
		result = 31 * result + (batteryCapacity != null ? batteryCapacity.hashCode() : 0);
		result = 31 * result + (photosFolderPath != null ? photosFolderPath.hashCode() : 0);
		return result;
	}

	@OneToOne(mappedBy = "phone")
	public AdTeam5 getAd() {
		return ad;
	}

	public void setAd(AdTeam5 ad) {
		this.ad = ad;
	}
}
