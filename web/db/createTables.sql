CREATE TABLE Shipment
(
    shipmentID       integer NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                    (START WITH 1, INCREMENT BY 1),
    userID         integer,
    preferName      varchar(30),					
    email           varchar(50),
    phone_number    integer,
    address         varchar(30),
    city            varchar(20),
    Territory       varchar(20),
    post_code       integer,
    startDate       date,
    shipmentMethod  varchar(20),
    currentStatus   varchar(20),
    FOREIGN KEY (userID) REFERENCES Users(userID)
);