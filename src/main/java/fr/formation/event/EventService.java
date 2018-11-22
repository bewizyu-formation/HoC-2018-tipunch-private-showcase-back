
package fr.formation.event;

import java.util.Date;
import fr.formation.artist.Artist;
import fr.formation.artist.ArtistRepository;
import fr.formation.user.User;
import org.springframework.stereotype.Service;

@Service
public class EventService  {

    private ArtistRepository artistRepository;
    private EventRepository eventRepository;

    public EventService(ArtistRepository artistRepository, EventRepository eventRepository) {
        this.artistRepository = artistRepository;
        this.eventRepository = eventRepository;
    }

    public Event addNewEvent(User user, Date event_date, int event_nbPlace, Long artist_id) {

        Artist artist = artistRepository.findArtistByArtist_Id(artist_id);
        Event event = new Event(user, event_date, event_nbPlace, artist );
        event = eventRepository.save(event);
        return event;

    }

    public Event updateEvent (User user, Long id, Date event_date, int event_nbPlace, Long artist_id) {


        Artist artist = artistRepository.findArtistByArtist_Id(artist_id);

        Event event = eventRepository.findEventsId(id);
        if(event_date != null) {event.setEvent_date(event_date);}
        if(event_nbPlace != 0) {event.setEvent_nbPerson(event_nbPlace);}
        if( artist_id != null) {event.setArtist(artist);}

        event = eventRepository.saveAndFlush(event);
        return event;
    }
}

