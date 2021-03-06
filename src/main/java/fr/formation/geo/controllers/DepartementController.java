package fr.formation.geo.controllers;

import fr.formation.geo.model.Departement;
import fr.formation.geo.services.DepartementService;
import fr.formation.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Departement controller.
 */
@RestController
@Secured(SecurityConstants.ROLE_USER)
@RequestMapping("/departements")
public class DepartementController {

	private DepartementService departementService;

	/**
	 * Instantiates a new Departement controller.
	 *
	 * @param departementService the departement service
	 */
	@Autowired
	public DepartementController(DepartementService departementService) {
		this.departementService = departementService;
	}

	/**
	 * Gets departement.
	 *
	 * @param value the nom
	 *
	 * @return the departement
	 */
	@GetMapping("/nom")
	public ResponseEntity<List<Departement>> getDepartement(@RequestParam final String value) {
		final List<Departement> departements = this.departementService.getDepartement(value);
		return new ResponseEntity<>(departements, HttpStatus.OK);
	}

	/**
	 * Gets departement by code.
	 *
	 * @param value the code
	 *
	 * @return the departement by code
	 */
	@GetMapping("/code")
	public ResponseEntity<List<Departement>> getDepartementByCode(@RequestParam final String value) {
		final List<Departement> departements = this.departementService.getDepartementByCode(value);
		return new ResponseEntity<>(departements, HttpStatus.OK);
	}
}
