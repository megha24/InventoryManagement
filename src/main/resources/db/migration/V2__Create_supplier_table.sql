create table SUPPLIER (
    ID  SERIAL PRIMARY KEY,
    NAME varchar(100) not null ,
    PHONE_NUMBER varchar(100),
    LOCATION varchar(100) not null,
    UNIQUE(NAME,LOCATION)
);