
    create table BATTLEBOATS.NAVY (
        ID integer not null,
        BUDGET integer,
        PLAYER integer,
        primary key (ID)
    );

    create table BATTLEBOATS.PLAYER (
        ID integer not null,
        AGE integer,
        AVATAR blob,
        DISPLAY_NAME varchar(25),
        EMAIL varchar(128),
        GENDER varchar(12),
        LOCATION varchar(50),
        PASSWORD varchar(40),
        RANKING integer,
        SUBSCRIPTION_LEVEL integer,
        USERNAME varchar(40) not null,
        primary key (ID)
    );

    create table Ship (
        id integer generated by default as identity,
        appearance varchar(255),
        armor float,
        captain varchar(255),
        crew integer,
        crewMorale integer,
        detectability float,
        flagShip smallint,
        foodStores double,
        fuel double,
        health float,
        location varchar(255),
        maxCrew integer,
        radar smallint,
        sonar smallint,
        speedInKnots float,
        navy_ID integer,
        primary key (id)
    );

    alter table Ship 
        add constraint FK_kva3rqm0h7rm01p3h98fwk5h5 
        foreign key (navy_ID) 
        references BATTLEBOATS.NAVY;
