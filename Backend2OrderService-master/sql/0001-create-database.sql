create table orders (id bigint not null, date datetime(6), customer_Id bigint, primary key (id)) engine=InnoDB;
create table orders_items (order_id bigint not null, items_id bigint not null) engine=InnoDB;
create table orders_seq (next_val bigint) engine=InnoDB;
insert into orders_seq values (1);