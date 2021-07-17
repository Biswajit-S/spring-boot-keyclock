docker build -f Dockerfile -t secure-app:latest .

docker run -p 9090:9090 secure-app:latest


curl -X POST \
  http://localhost:8080/auth/realms/my_realm/protocol/openid-connect/token \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -H 'Postman-Token: c1453868-e7b2-48ed-8edc-2ef54a10e31a' \
  -H 'cache-control: no-cache' \
  -H 'client_id: my_client' \
  -H 'grant_type: password' \
  -H 'password: admin' \
  -H 'scope: openid' \
  -H 'username: admin' \
  -d 'client_id=my_client&grant_type=password&scope=openid&username=user&password=user&undefined='


curl -X GET \
  http://127.0.0.1:9090/echo-server/application/ping \
  -H 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJOQk54OFI1eS02QVNQTm1iV1cyRW1IcmJpdkRfUXhDSmVwQUVpeHRyN1BzIn0.eyJleHAiOjE2MjY1MzY1MjMsImlhdCI6MTYyNjUzNjIyMywianRpIjoiZjZmYmI4M2MtYzUyMS00ZmQ2LTkwYmEtMDFmMThmM2FkNTM2IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL215X3JlYWxtIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImE5MzEyYTgxLTMwOGYtNDU3Yy04YjY0LWVlMzU3OWM4NWI5OCIsInR5cCI6IkJlYXJlciIsImF6cCI6Im15X2NsaWVudCIsInNlc3Npb25fc3RhdGUiOiI2YzYwNDcwNi02NTA3LTQwMzUtYjVjOC1hZjcyYTY1NTRiN2YiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtbXlfcmVhbG0iLCJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIiwiVVNFUiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIHZ6X3Rlc3QgcHJvZmlsZSBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwicHJlZmVycmVkX3VzZXJuYW1lIjoidXNlciJ9.F4abDto6yW2t-SJScql0mvL-B09ocV16hoNO40kzC1Rsup6naP_XcVbonC4mIqtsEVv-cJQ9PXnnJ8_XJGpDZEZphusx1fhflzO90YoSK3COMMgofgJy8Q6r3gA2NDhQSdn3jBW6cFzEnQSTpe8V1sYf1TRG9ZIINnxZOjf5ZCDRfsUFOWGP-qqjd78yCDQ11gnnAjGNpF2lFlcefQKUaH1n1DeVle1PCxlcD44Jgtqg5kr53d4hBUogp5cbNKBLoG-Ley-xmfgHP5RxnDVMKurIbngknxZfnlXIjAJhLV5xGQjrBcwIBr5wwVbULoKfPha63nk-ECfkuXlK45yNaQ' \
  -H 'Postman-Token: 2d30238b-fcdf-40f6-8239-a9f1b4a78a47' \
  -H 'cache-control: no-cache'
  
  
  
  
  