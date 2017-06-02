create table CONSUMER (
    ID  SERIAL PRIMARY KEY,
    NAME varchar(100) not null ,
    PHONE_NUMBER varchar(100),
    LOCATION varchar(100) not null,
    EMAIL_ID varchar(100),
    UNIQUE(NAME,LOCATION)
);