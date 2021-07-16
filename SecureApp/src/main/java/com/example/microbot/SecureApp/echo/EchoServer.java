/**
 * 
 */
package com.example.microbot.SecureApp.echo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author biswajit
 *
 */

@RestController
public class EchoServer {
	
	@GetMapping("/ping")
    public String ping() {
        return "Hello, from Server!";
    }

}
