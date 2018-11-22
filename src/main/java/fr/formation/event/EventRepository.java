
package fr.formation.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Long> {

    /**
     * @param username
     * @return
     */
@Query(value = "Select * from events \n" +
            "INNER JOIN users \n" +
            "ON events.user_id = users.id \n" +
            "WHERE users.username = :username", nativeQuery = true)
    Event findEventsByUser_name(@Param("username") String username);


    @Query(value = "Select * from events WHERE events.id = id ", nativeQuery = true)
    Event findEventsId(@Param("id") Long id);


}

