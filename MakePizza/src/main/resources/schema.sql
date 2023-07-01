drop table if exists Pizza_order cascade;

create table if not exists Pizza_order (
    id bigint primary key,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City varchar(50) not null,
    delivery_State varchar(2) not null,
    delivery_Zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cw varchar(3) not null,
    placed_at timestamp not null
);

drop table if exists Pizza;

create table if not exists Pizza (
    id bigint primary key,
    name varchar(50) not null,
    pizza_order bigint not null,
    pizza_order_key bigint not null,
    created_at timestamp not null
);

drop table if exists Ingredient_Ref;

create table if not exists Ingredient_Ref (
    ingredient varchar(4) not null,
    pizza bigint not null,
    pizza_key bigint not null
);

drop table if exists Ingredient;

create table if not exists Ingredient (
    id varchar(4) not null primary key,
    name varchar(25) not null,
    type varchar(10) not null
);

alter table Pizza
add foreign key (pizza_order) references Pizza_Order(id);
alter table Ingredient_Ref
add foreign key (ingredient) references Ingredient(id);