package fr.formation.rating;

import javax.persistence.*;

import fr.formation.artist.Artist;
import fr.formation.user.User;

@Entity
public class Rating {


	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "artistId", nullable = false)
	private Artist artistId;
	
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User userId;
	
	@Column(nullable = false)
	private int rating_rate;
	
	
	public Rating(Long id, Artist artistId, User userId, int rating_rate) {
		this.id = id;
		this.artistId = artistId;
		this.userId = userId;
		this.rating_rate = rating_rate;
	}
	
	
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
	 * get Artist Id.
	 * @return the artistId
	 */
	public Artist getArtistId() {
		return artistId;
	}


	/**
	 * set Artist Id.
	 * @param artistId the artistId to set
	 */
	public void setArtistId(Artist artistId) {
		this.artistId = artistId;
	}


	/**
	 * get User Id.
	 * @return the userId
	 */
	public User getUserId() {
		return userId;
	}


	/**
	 * set Artist Id.
	 * @param userId the userId to set
	 */
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	
	/**
	 * Gets rate.
	 *
	 * @return the rate
	 */
	public int getRate() {
		return rating_rate;
	}


	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setRate(int rating_rate) {
		this.rating_rate = rating_rate;
	}


}
