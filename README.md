# Banking Example
Banking Example is an REST API responsible for banking operations built on Spring and Java 11.

## Before you commit
Please ensure:
 - README.MD is updated
 - The project built successfully
 - No previous tests were broken
 - Test coverage

## Libraries
 - Spring Boot 2.5.8
 - Lombok
 - SpringFox 3.0.0
 - H2 Database
 - JUnit 5.4.0

## Docs
Available at endpoint: ``/swagger-ui/``

## Features
This API can perform:
* Banking account creation
```
Request:
POST /accounts
Body:
{
  "document_number": "string"
}

Response: 
201 - CREATED
{
  "account_id": 0,
  "document_number": "string"
}
```
- Banking account search
```
Request:
GET /account/{accountId}
Response: 
200 - OK
{
  "account_id": 0,
  "document_number": "string"
}
```
- Make a transaction
```
Request:
POST /transactions
Body:
{
  "account_id": 0,
  "amount": 0,
  "operation_type_id": 0
}

Response: 
201 - CREATED
{
  "account_id": 0,
  "amount": 0,
  "operation_type_id": 0,
  "transaction_id": 0
}
```

## Deployment
### Local maven

- Build and run
> mvn clean package && java -DDATABASE_JDBC_URL=jdbc:mysql://localhost:3306/pismo -DDATABASE_PASSWORD=pismopass -DDATABASE_USERNAME=pismo -jar target/*.jar

### Docker
- Build and run
> mvn clean package && docker compose up --build

## Developers
[Edilson Rodrigues](https://www.github.com/ew3g)

## License
[MIT](https://mit-license.org/)