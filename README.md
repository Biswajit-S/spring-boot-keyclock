# spring-boot-keyclock
This appliacation demonstrates a Spring-boot application integrated with Keycloak. The spring boot APIs are protected with OAuth2 and Keycloak acts as the authorization server.

## Pre-requisite
* Keycloak realm export by default does not export the user account. For simplicity of this application the scripts to export the user account in the realm has not been included.
* So a test user account needs to be created first in Keycloak, before testing these API.

# API Specification

## Getting Tokens

### Sample Request
```
POST http://{{token_url}}/auth/realms/VFZ/protocol/openid-connect/token

POST Body:
grant_type:password
client_id: CLIENT_ID
client_secret: CLIENT_SECRET (if confidential client)
username: USERANME
password: USER_PASSWORD


```

### Sample Response

```
{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5c....",
    "expires_in": 300,
    "refresh_expires_in": 1800,
    "refresh_token": "eyJhbGciOiJIUzI1N....",
    "token_type": "Bearer",
    "not-before-policy": 0,
    "session_state": "bfe41f84-43f2-4696-965a-9f2bf2b41e74",
    "scope": "<defined scopes>"
}
```

## Accessing Services 

### Sample Request

```
GET http://{{applcation_server_url}}/echo-server/application/ping

Request Header:
Authorization:  Bearer <Access Token>
Accept: application/json

```
### Sample Response

```
Hello, from Server!
```
