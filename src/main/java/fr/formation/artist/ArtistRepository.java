package fr.formation.artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * The interface Artist repository.
 */
public interface ArtistRepository extends  JpaRepository<Artist, Long>  {

    @Query(value = "Select * from artist INNER JOIN users ON artist.user_id = users.id WHERE users.department_code = :deptcode",
            nativeQuery = true)

    List<Artist> findArtistsByUser_DepartmentCode(@Param("deptcode") String department_code);
	
	/**
	 * Find by Artist_name user.
	 *
	 * @param Artist_name theArtist_name
	 *
	 * @return Artist_name
	 */
	public Artist findByArtstName( String artist_name);
}
