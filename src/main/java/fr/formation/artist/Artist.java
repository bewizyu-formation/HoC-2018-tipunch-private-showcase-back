package fr.formation.artist;

//import java.util.Set;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import fr.formation.user.User;

/**
 * the type Artist
 * @author adminHOC
 */
@Entity
@Table(name = "artist")
public class Artist {
	
	@Id

	@GeneratedValue
	private Long id;	
	
	@Column(unique = true, nullable = false)
	private String artist_name;
		
	@Column(nullable = true)
	private String artist_shortDesc;
	
	@Column(nullable = true)
	private String artist_longDesc;
	
	@Column(nullable = true)
	private String artist_phone ;
	
	@Column(nullable = true)
	private String artist_email;
	
	@Column(nullable = true)
	private String artist_website;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(unique = true, nullable = false, name="imageId")
//	private Image image;
	
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	public Artist(String artist_name, String artist_shortDesc, String artist_longDesc, 
			String artist_phone, String artist_email, String artist_website, User user) {
		this.artist_name = artist_name;
		this.artist_shortDesc = artist_shortDesc;
		this.artist_longDesc = artist_longDesc;
		this.artist_phone = artist_phone;
		this.artist_email = artist_email;
		this.artist_website = artist_website;
		this.user = user;
	}
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private Set<Rating> ratings;
//	
//	@ManyToMany(cascade = CascadeType.ALL)
//	private Set<Event> events;
//	
//	@ManyToMany(cascade = CascadeType.ALL)
//	private Set<Department> departments;
//	
//	
	
	
	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
	/**
	 * Gets artistName.
	 *
	 * @return artistName
	 */
	public String getArtistName() {
		return artist_name;
	}


	/**
	 * Sets artistName.
	 *
	 * @param artistName the artistName
	 */
	public void setArtistName( String artistName) {
		this.artist_name = artistName;
	}
	
	/**
	 * Gets short_Description.
	 *
	 * @return the short_Description
	 */
	public String getShortDescription() {
		return artist_shortDesc;
	}


	/**
	 * Sets short_Description.
	 *
	 * @param short_Description the short_Description
	 */
	public void setShortDescription( String shortDesc) {
		this.artist_shortDesc = shortDesc ;
	}
	
	/**
	 * Gets long_Description.
	 *
	 * @return long_Description
	 */
	public String getlongDescription() {
		return artist_longDesc;
	}


	/**
	 * Sets long_Description.
	 *
	 * @param long_Description the long_Description
	 */
	public void setlongDescription( String longDesc) {
		this.artist_longDesc = longDesc ;
	}
	
	/**
	 * Gets phone.
	 *
	 * @return phone
	 */
	public String getPhone() {
		return artist_phone;
	}


	/**
	 * Sets phone.
	 *
	 * @param phone the phone
	 */
	public void setPhone( String phone) {
		this.artist_phone = phone ;
	}
	
	/**
	 * Gets email
	 * @return email
	 */
	public String getEmail() {
		return artist_email;
	}
	
	/**
	 * Sets email.
	 *
	 * @param email the email
	 */
	public void setEmail(String email ) {
		this.artist_email = email;
	}
	
	/**
	 * Gets website.
	 * @return website
	 */
	public String getWebsite() {
		return artist_website;
	}
	
	/**
	 * Sets website.
	 *
	 * @param website the website
	 */
	public void setWebsite(String website ) {
		this.artist_website = website;
	}
	

}
