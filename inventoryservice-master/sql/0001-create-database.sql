create table item (id integer not null, name varchar(255), pris integer not null, primary key (id)) engine=InnoDB;
create table item_seq (next_val bigint) engine=InnoDB;
insert into item_seq values ( 1 );