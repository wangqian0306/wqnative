### Test

create native executable

```bash
./mvnw native:compile -Pnative
```

insert test

```bash
curl --location --request POST 'http://localhost:8080/demo' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "name": "wq"
}'
```

get test

```bash
curl http://localhost:8080/demo?id=1
```