CREATE TABLE tb_transaction(
    id int auto_increment,
    origin_account varchar(10) not null,
    destination_account varchar(10) not null,
    tranfer_value float not null,
    appointment_date date not null,
    tranfer_date date not null,
    tax float null
);

CREATE TABLE tb_users(
    id int auto_increment,
    username varchar(50) not null,
    pass varchar(50) not null,
    email varchar(100) not null
);
