/**
 * Dummy backend service. This service is protected by OAuth2. 
 * Clients required to present an access token to access resources from this service.
 */
package com.example.microbot.SecureApp.echoserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author biswajit
 *
 */

@RestController
@RequestMapping("/application")
public class ResourceController {
	
	/**
	 * Dummy service to return a static response.
	 * @return String
	 *
	 */
	@GetMapping("/ping")
    public String ping() {
        return "Hello, from Server!";
    }

}
