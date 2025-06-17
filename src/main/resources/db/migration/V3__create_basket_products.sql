CREATE TABLE basket_products (
    basket_entity_id UUID NOT NULL,
    products_id BIGINT NOT NULL,
    PRIMARY KEY (basket_entity_id, products_id),
    FOREIGN KEY (basket_entity_id) REFERENCES basket(id),
    FOREIGN KEY (products_id) REFERENCES products(id)
);