

package fr.formation.event;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.formation.controllers.AbstractController;
import fr.formation.user.User;


@RestController
@RequestMapping("/events")
public class EventController extends AbstractController {

    /**
     *
     */
    @Autowired
    private EventService eventService;

    /**
     *
     * @param event_date
     * @param event_nbPlace
     * @param artist_id
     * @return
     */
    @PutMapping("/add")
    public Event addEvent(@RequestParam("date") Date event_date, @RequestParam("places") int event_nbPlace,
            @RequestParam("id") Long artist_id) {

        User user = super.getAuthenticatedUser();

        Event event = eventService.addNewEvent(user, event_date, event_nbPlace, artist_id);

        return event;

    }

    @PostMapping("/update/{id}")
    public Event updateEvent (@PathVariable Long id, @RequestParam("date") Date event_date, @RequestParam("places") int event_nbPlace,
                              @RequestParam("id") Long artist_id) {

        User user = super.getAuthenticatedUser();

        Event event = eventService.updateEvent(user, id, event_date, event_nbPlace, artist_id);

        return event;
    }




}


