# List Products API
- List authenticated merchant's products
- Swagger documentation can be generated with provided annotations.
- It uses in memory database H2.

## API Properties 
- Server port is defined in `application.properties`.
- Sample data can be found in `data.sql`. This is executed during startup automatically.

# Sample Requests
```shell script
curl --location --request GET 'http://localhost:8080/v1/products?userId=10001&size=10&page=0&sort=price,asc,inventory,desc' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnZWVldyIsImlhdCI6MTYwMDM2MDQ3MCwiZXhwIjoxNjAwMzgyMDcwfQ.kDlZ-tj6-URO8VVBLdstUwCxADHXKwo32Dbbj4pGdgA'
```

# Further points to develop
- Merchant/user id authorization check.
  - Merchant/user id can be read from JWT or if more advanced Authorzation mechanism is used, it can be retrieved from the Authorization server.
  - This is also can be done on API Gateway by passing/overriding userId.
- Return json error when parameter validation fails.