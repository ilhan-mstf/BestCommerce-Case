# Sign in API
- Checks user credentials and return success or error http status.
- Passes JWT variables on the http header.
- Uses in-memory database H2.

## API Properties 
- Server port is defined in `application.properties`.
- Sample data can be found in `data.sql`. This is executed during startup automatically.

## Sample request
```
curl --location --request POST 'http://localhost:8080/v1/signin' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "mustafa@softtech.com.tr",
    "password": "pass",
    "remember": "true"
}'
```

# Open points to further development
- Encrypt user password
- Move `JwtConstants` to a shared lib to be used in `apigateway`
- Integrate this API to Authentication and Authorization solution such as KeyCloak
- `id` and `email` can be added to JWT

# Notes
- There is no need to check password length during sign in. It should be done on sign up.