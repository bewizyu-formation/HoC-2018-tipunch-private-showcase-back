package fr.formation.artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * The interface Artist repository.
 */
public interface ArtistRepository extends  JpaRepository<Artist, Long>  {

    @Query(value = "Select * from artist INNER JOIN users ON artist.user_id = users.id WHERE users.department_code = :deptcode AND artist.user_id <> :id",
            nativeQuery = true)
    List<Artist> findArtistsByUser_DepartmentCode(@Param("deptcode") String department_code, @Param("id") Long user_authenticated_id);
	
	/**
	 * Find Artist by user_id.
	 *
	 * @param id the user_id
	 * @return Artist artist
	 */
    @Query(value = "SELECT * from artist WHERE artist.user_id = :id",
    		nativeQuery = true)
	 Artist findArtistByUser_Id(@Param("id") Long id);

	@Query(value = "SELECT * from artist WHERE artist.id = :id",
			nativeQuery = true)
	Artist findArtistByArtist_Id(@Param("id") Long id);
}
