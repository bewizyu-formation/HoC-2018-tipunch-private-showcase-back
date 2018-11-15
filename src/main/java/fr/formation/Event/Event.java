/**
 * 
 */
package fr.formation.Event;


import java.util.Date;

import java.util.Set;

import javax.persistence.*;


import fr.formation.booking.Booking;
import fr.formation.user.User;




/**
 * the type event
 * @author adminHOC
 *
 */
@Entity
public class Event {
	
	/**
	 * @param id
	 * @param user
	 * @param booking
	 * @param nbrTicketMax
	 * @param eventDate
	 */
	protected Event( Set<User> user, Set<Booking> booking, int nbrTicketMax, Date eventDate) {
		super();
		this.user = user;
		this.booking = booking;
		this.nbrTicketMax = nbrTicketMax;
		this.eventDate = eventDate;
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany()
	private Set<User> user;

	@OneToMany(mappedBy = "event")
	private Set<Booking> booking;
	
	


	@Column(nullable = false)
	private int nbrTicketMax;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_TIME")
	private Date eventDate ;
	
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
	 * Gets nbrTicketMax.
	 *
	 * @return the ndrTicketMax
	 */
	public int getNumberOfTicketsMax() {
		return nbrTicketMax;
	}


	/**
	 * Sets nbrTicketMax.
	 *
	 * @param nbrTicketMax the nbrTicketMax
	 */
	public void setNumberOfTicketsMax(int nbrTicketMax ) {
		this.nbrTicketMax= nbrTicketMax ;
	}
}
