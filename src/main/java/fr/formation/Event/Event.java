/**
 * 
 */
package fr.formation.Event;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import fr.formation.artist.Artist;
import fr.formation.booking.Booking;
import fr.formation.user.User;




/**
 * the type event
 * @author adminHOC
 *
 */
@Entity
@Table(name = "event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@ManyToMany()
//	private  Collection<User> user;
//	
//	@ManyToMany()
//	private  Collection<Artist> artist;
//	
//	@OneToMany()
//	private Collection<Booking> booking;
//	
//	@Column(name = "number_of_tickets_Max")
//	private int nbrTicketMax;
//	
//	@Temporal(TemporalType.DATE)
//	@Column(name="CREATED_TIME")
//	private Date eventDate ;
	
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
//	public int getNumberOfTicketsMax() {
//		return nbrTicketMax;
//	}
//
//
//	/**
//	 * Sets nbrTicketMax.
//	 *
//	 * @param nbrTicketMax the nbrTicketMax
//	 */
//	public void setNumberOfTicketsMax(int nbrTicketMax ) {
//		this.nbrTicketMax= nbrTicketMax ;
//	}
}
