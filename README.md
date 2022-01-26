# Currency converter up

# How to build and run

project can be compiled with JDK 8 and above 

To compile just do `mvn clean package`.

To launch the datebase, you should do "docker-compose up" in "docker" package


## Exploring the Rest APIs

The application contains the following REST APIs

```

1. POST /currency/rates - To get currency rate

```

## Aditional information

Base currency always EUR. So you can get currency rates only in pair with EUR.

**Avalieble currency for convert to:**

RUB, UAH, USD, INR

**Example request:**

```
curl --location --request POST 'http://localhost:8080/currency/rates' \
--header 'Content-Type: application/json' \
--data-raw '{
    "convertTo" : "USD, UAH, RUB"
}'
```
