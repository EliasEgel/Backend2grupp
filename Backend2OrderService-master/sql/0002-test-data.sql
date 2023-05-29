INSERT INTO `orders` VALUES (1,'2023-05-17 10:30:00.000000',1);
INSERT INTO `orders` VALUES (2,'2023-01-01 00:00:00.000000',3);

INSERT INTO `orders_items` VALUES (1,1);
INSERT INTO `orders_items` VALUES (1,3);
INSERT INTO `orders_items` VALUES (2,4);
INSERT INTO `orders_items` VALUES (2,1);

UPDATE `orders_seq` SET next_val = 51;