package fr.formation.event;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.formation.artist.Artist;
import fr.formation.user.User;

@Entity
@Table(name = "events")
public class Event {
    /**
     *
     * @param user
     * @param event_date
     * @param event_nbPlace
     * @param artist_id
     */
    public Event(User user, Date event_date, int event_nbPlace, Artist artist_id) {
        this.event_date = event_date;
        this.event_nbPlace = event_nbPlace;
        this.artist = artist_id;
        this.user = user;
    }
    public Event() {

    }

    @Id
    @GeneratedValue
    private Long Id;

    @Temporal(TemporalType.DATE)
    @Column(name = "event_date", nullable = false)
    private Date event_date;

    @Column(nullable = false)
    private int event_nbPlace;

    @ManyToOne(optional = false)
    private Artist artist;

    @ManyToOne(optional = false)
    private User user;

    /**
     * @return the id
     */
    public Long getId() {
        return Id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        Id = id;
    }

    /**
     * @return the event_date
     */
    public Date getEvent_date() {
        return event_date;
    }

    /**
     * @param event_date the event_date to set
     */
    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    /**
     * @return the event_nbPerson
     */
    public int getEvent_nbPerson() {
        return event_nbPlace;
    }

    /**
     * @param event_nbPerson the event_nbPerson to set
     */
    public void setEvent_nbPerson(int event_nbPerson) {
        this.event_nbPlace = event_nbPerson;
    }

    /**
     * @return the artist
     */
    public Artist getArtist() {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

}
