# Currency converter up

# How to build and run

the project can be compiled with JDK 8 and above 

To compile just do `mvn clean package`.

To launch the database, you should do "docker-compose up" in the "docker" package


## Exploring the Rest APIs

The application contains the following REST APIs

```

1. POST /currency/rates - To get currency rate

```

## Aditional information

The base currency is always EUR. So you can get currency rates only in pairs with EUR.

**Available currency for convertation:**

RUB, UAH, USD, INR

**Example request:**

```
curl --location --request POST 'http://localhost:8080/currency/rates' \
--header 'Content-Type: application/json' \
--data-raw '{
    "convertTo" : "USD, UAH, RUB"
}'
```
