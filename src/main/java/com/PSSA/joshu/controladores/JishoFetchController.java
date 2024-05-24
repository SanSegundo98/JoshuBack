package com.PSSA.joshu.controladores;

import com.PSSA.joshu.utilities.JishoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/proxy")
@Validated
public class JishoFetchController {

	private final RestTemplate restTemplate;

	@Autowired
	public JishoFetchController ( RestTemplate restTemplate ) {
		this.restTemplate = restTemplate;
	}

	@PostMapping
	public ResponseEntity<?> JishoFetchRequest ( @RequestBody JishoRequest request ) {
		try {
			ResponseEntity<String> response = restTemplate.exchange( request.getUrl(), request.getMethod(), null,
			                                                         String.class );
			return ResponseEntity.ok( response.getBody() );
		} catch ( Exception e ) {
			return ResponseEntity.status( 500 ).body( "Proxy error: " + e.getMessage() );
		}
	}
}

