package fr.formation.booking;

import javax.persistence.*;

import fr.formation.Event.Event;
import fr.formation.user.User;

@Entity
@Table(name = "Booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne()
	private User user;
	
	@ManyToOne()
	private Event event;
	
	@Column(name = "nbrTickets")
	private int nbrTickets;
	
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

}
