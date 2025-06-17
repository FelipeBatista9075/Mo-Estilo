CREATE TABLE basket (
    id UUID PRIMARY KEY NOT NULL,
    client BIGINT,
    total_price NUMERIC(10,2) NOT NULL,
    status VARCHAR(10) NOT NULL,
    CHECK(status IN ('SOLD', 'OPEN'))
);