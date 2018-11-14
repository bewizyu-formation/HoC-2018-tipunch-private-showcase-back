package fr.formation.rating;

import javax.persistence.*;

import fr.formation.artist.Artist;
import fr.formation.user.User;

@Entity
@Table(name = "rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne()
	private Artist artist;
	
	@ManyToOne()
	private User user;
	
	@Column(name = " rate")
	private int rate;

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
	 * Gets rate.
	 *
	 * @return the rate
	 */
	public int getRate() {
		return rate;
	}


	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}


}
