
package fr.formation.artist;

import java.util.Collection;

import javax.persistence.*;

import fr.formation.Event.Event;
import fr.formation.booking.Booking;
import fr.formation.image.Image;
import fr.formation.user.User;

/**
 * the type Artist
 * @author adminHOC
 *
 */
@Entity
@Table(name = "artist")
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ OneToOne()
	private User user;
	
	@OneToOne()
	private Image image;
	
	@ManyToMany()
	private Collection<Event> event;
	
	@Column(name = "artistName")
	private String artistName;
	
	
	@Column(name = "short_Description")
	private String ShortDesc;
	
	@Column(name = "long_Description")
	private String longDesc;
	
	@Column(name = "phone")
	private String phone ;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "website")
	private String website;
	
	
	
	
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
		return artistName;
	}


	/**
	 * Sets artistName.
	 *
	 * @param artistName the artistName
	 */
	public void setArtistName( String artistName) {
		this.artistName = artistName;
	}
	
	/**
	 * Gets short_Description.
	 *
	 * @return the short_Description
	 */
	public String getShortDescription() {
		return ShortDesc;
	}


	/**
	 * Sets short_Description.
	 *
	 * @param short_Description the short_Description
	 */
	public void setShortDescription( String ShortDesc) {
		this.ShortDesc = ShortDesc ;
	}
	
	/**
	 * Gets long_Description.
	 *
	 * @return long_Description
	 */
	public String getlongDescription() {
		return longDesc;
	}


	/**
	 * Sets long_Description.
	 *
	 * @param long_Description the long_Description
	 */
	public void setlongDescription( String longDesc) {
		this.longDesc = longDesc ;
	}
	
	/**
	 * Gets phone.
	 *
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}


	/**
	 * Sets phone.
	 *
	 * @param phone the phone
	 */
	public void setPhone( String phone) {
		this.phone = phone ;
	}
	
	/**
	 * Gets email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets email.
	 *
	 * @param email the email
	 */
	public void setEmail(String email ) {
		this.email = email;
	}
	
	/**
	 * Gets website.
	 * @return website
	 */
	public String getWebsite() {
		return website;
	}
	
	/**
	 * Sets website.
	 *
	 * @param website the website
	 */
	public void setWebsite(String website ) {
		this.website = website;
	}
	

}
