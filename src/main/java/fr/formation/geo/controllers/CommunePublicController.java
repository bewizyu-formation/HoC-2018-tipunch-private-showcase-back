package fr.formation.geo.controllers;

import fr.formation.geo.model.Commune;
import fr.formation.geo.services.CommuneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Commune controller.
 */
@RestController
@RequestMapping("/public/communes")
public class CommunePublicController {

	private static final Logger log = LoggerFactory.getLogger(CommunePublicController.class);

	private CommuneService communeService;

	/**
	 * Instantiates a new Commune controller.
	 *
	 * @param communeService the commune service
	 */
	@Autowired
	public CommunePublicController(CommuneService communeService) {
		this.communeService = communeService;
	}

	/**
	 * Gets communes.
	 *
	 * @param value the nom
	 *
	 * @return the communes
	 */
	@GetMapping("/nom")
	public ResponseEntity<List<Commune>> getCommunes(@RequestParam final String value) {
		final List<Commune> communes = this.communeService.getCommunes(value);
		return new ResponseEntity<>(communes, HttpStatus.OK);
	}

	/**
	 * Gets communes by postal code.
	 *
	 * @param  value the postal code
	 *
	 * @return the communes
	 */
	@GetMapping("/codepostal")
	public ResponseEntity<List<Commune>> getCommunesByPostalCode(@RequestParam final String value) {
		final List<Commune> communes = this.communeService.getCommunesByPostalCode(value);
		return new ResponseEntity<>(communes, HttpStatus.OK);
	}

}
