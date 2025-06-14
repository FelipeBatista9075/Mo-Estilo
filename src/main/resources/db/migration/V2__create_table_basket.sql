CREATE TABLE basket(
    id VARCHAR(100) PRIMARY KEY NOT NULL,
    client BIGSERIAL,
    total_price NUMERIC(10,2) NOT NULL,
    status VARCHAR(10) NOT NULL,
       CHECK(status IN ('SOLD', 'OPEN'))
)