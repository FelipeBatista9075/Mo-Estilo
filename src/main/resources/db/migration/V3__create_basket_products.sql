CREATE TABLE basket_products (
    basket_entity_id VARCHAR(100) NOT NULL,
    products_id BIGSERIAL NOT NULL,
    PRIMARY KEY (basket_entity_id, products_id),
    CONSTRAINT fk_basket FOREIGN KEY (basket_entity_id) REFERENCES basket(id),
    CONSTRAINT fk_products FOREIGN KEY (products_id) REFERENCES products(id)
);