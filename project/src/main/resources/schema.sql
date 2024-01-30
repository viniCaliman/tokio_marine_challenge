CREATE TABLE tb_transaction(
    id int auto_increment,
    originAccount varchar(10) not null,
    destinationAccount varchar(10) not null,
    tranferValue float not null,
    appointmentDate date not null,
    tranferDate date not null,
    tax float null
);