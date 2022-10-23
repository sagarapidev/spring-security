### Security-Service

### Motive
+ Create Custom authentication
+ which is User defined class which implements AuthenticationProvider(I)
    + which basically takes 3 args username,password,role
    + AthenticationProviderTokenType validator
+Passing this CustomAuthenticationProvide

#### POSTMAN (TEST IN LOCAL)
ROLE

http://localhost:8080/api/v1/role/save
+ [POST,PUT](https://github.com/sagarapidev/document/blob/main/springboot/Security-Service/ROLE.json)
+ [DELETE](https://github.com/sagarapidev/document/blob/main/springboot/Security-Service/user.json)

USER

http://localhost:8080/api/v1/user/save
+ [POST](https://github.com/sagarapidev/document/blob/main/springboot/Security-Service/user.json)
+ [PUT](https://github.com/sagarapidev/document/blob/main/springboot/Security-Service/user.json)

