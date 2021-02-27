package com.nathalie.oenofiles.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="wines")
public class Wine {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty
    private String name;
	
	private String region;
	private Double price;
	private Double abv;
	private String grape;
	private String photo;
	private Boolean enjoy;
	
	//sight
	private String clarity;
	private String brightness;
	private String concentration;
	private String color;
	private String tears;
	private String sightDescription;
	
	//nose
	private String intensity;
	private String noseFruit;
	private String noseDescription;
	
	//palate
	private String sweetness;
	private String tannin;
	private String acid;
	private String alcohol;
	private String body;
	private String palateFruit;
	private String finish;	
	private String palateDescription;
	
	
    @Column(updatable=false)
	@DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
	

	public Wine() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getGrape() {
		return grape;
	}

	public void setGrape(String grape) {
		this.grape = grape;
	}

	public Double getAbv() {
		return abv;
	}

	public void setAbv(Double abv) {
		this.abv = abv;
	}

	public Boolean getEnjoy() {
		return enjoy;
	}

	public void setEnjoy(Boolean enjoy) {
		this.enjoy = enjoy;
	}


	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
    
    public String getClarity() {
		return clarity;
	}


	public void setClarity(String clarity) {
		this.clarity = clarity;
	}


	public String getBrightness() {
		return brightness;
	}


	public void setBrightness(String brightness) {
		this.brightness = brightness;
	}


	public String getConcentration() {
		return concentration;
	}


	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getTears() {
		return tears;
	}


	public void setTears(String tears) {
		this.tears = tears;
	}


	public String getSightDescription() {
		return sightDescription;
	}


	public void setSightDescription(String sightDescription) {
		this.sightDescription = sightDescription;
	}


	public String getIntensity() {
		return intensity;
	}


	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}


	public String getNoseFruit() {
		return noseFruit;
	}


	public void setNoseFruit(String noseFruit) {
		this.noseFruit = noseFruit;
	}


	public String getNoseDescription() {
		return noseDescription;
	}


	public void setNoseDescription(String noseDescription) {
		this.noseDescription = noseDescription;
	}


	public String getSweetness() {
		return sweetness;
	}


	public void setSweetness(String sweetness) {
		this.sweetness = sweetness;
	}


	public String getTannin() {
		return tannin;
	}


	public void setTannin(String tannin) {
		this.tannin = tannin;
	}


	public String getAcid() {
		return acid;
	}


	public void setAcid(String acid) {
		this.acid = acid;
	}


	public String getAlcohol() {
		return alcohol;
	}


	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getPalateFruit() {
		return palateFruit;
	}


	public void setPalateFruit(String palateFruit) {
		this.palateFruit = palateFruit;
	}


	public String getFinish() {
		return finish;
	}


	public void setFinish(String finish) {
		this.finish = finish;
	}


	public String getPalateDescription() {
		return palateDescription;
	}


	public void setPalateDescription(String palateDescription) {
		this.palateDescription = palateDescription;
	}


	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
