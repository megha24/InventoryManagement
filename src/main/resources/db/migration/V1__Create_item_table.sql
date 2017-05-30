create table ITEM (
    ID  SERIAL PRIMARY KEY,
    NAME varchar(100) not null ,
    QUALITY varchar(100) not null,
    PRICE DECIMAL,
    UNIQUE(NAME,QUALITY)
);