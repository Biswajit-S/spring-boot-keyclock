package com.example.microbot.SecureApp;

import static org.junit.Assert.assertEquals;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.microbot.SecureApp.SecureAppApplication;;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SecureAppApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class SecureAppApplicationTests {

	
	@Value( "${secure.app.pingurn}" )
	private String pingUrn;
	
	@Value( "${secure.app.pinghostname}" )
	private String pinghostname;
	
    private String tokenValue = null;
    
    @Value( "${secure.app.granttype}" )
    private String grantType;
    
    @Value( "${secure.app.clientId}" )
    private String clientId;
    
    @Value( "${secure.app.username}")
    private String username;
    
    @Value( "${secure.app.password}")
    private String password;
    
    @Value( "${secure.app.tokenurl}")
    private String tokenurl;

    @Before
    public void obtainAccessToken() {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", grantType);
        params.put("client_id", clientId);
        params.put("username", username);
        params.put("password", password);
        final Response response = RestAssured.given().auth().preemptive().basic(clientId, "secret")
        		.and().with().params(params).when().post(tokenurl);

        tokenValue = response.jsonPath().getString("access_token");
    }

    @Test
    public void testPingAuthorized() {
        
    	Response response = RestAssured.given().header("Authorization", "Bearer " + tokenValue).get(pinghostname + pingUrn);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }
    
    @Test
    public void testPingUnAuthorized() {
        Response response = RestAssured.get(pinghostname + pingUrn);
        assertEquals(HttpStatus.UNAUTHORIZED.value(), response.getStatusCode());

    }
    
}
