package fr.formation.artist;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * The interface Artist repository.
 */
public interface ArtistRepository extends  JpaRepository<Artist, Long>  {
	
}
