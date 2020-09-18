# Sign in API
Checks user credentials and return success or error http status.
Passes JWT variables on the http header.

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

# Notes
- There is no need to check password length during sign in. It should be done on sign up.