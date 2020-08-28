/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  admin
 * Created: 28/08/2020
 */

CREATE TABLE Users (
    ID int,
    Password varchar(30),
    Email varchar(100),
    FirstName varchar(30),
    LastName varchar(30),
    DOB Date(10),
    Address varchar(100),
    PRIMARY KEY (ID)
);

CREATE TABLE ADdmin (
    AdminID int,
    UserID int,
    AdminEmail varchar(30),
    PRIMARY KEY(AdminID),
    FOREIGN KEY(UserID) REFERENCES Users(ID)
);

CREATE TABLE TripPlanner (
    _id int,
    cost Double,
    Ttime time(20),
    destination varchar(20),
    departure varchar(20),
    PRIMARY KEY(_id)
);

CREATE TABLE Reporting (
    R_id int,
    description varchar(100),
    Rtime time(20),
    PRIMARY KEY(R_id)
);

CREATE TABLE ShipmentManagement  (
    ShipmentID int,
    StartDate varchar(30),
    EstArrDate varchar(30),
    DeliveryAddress varchar(30),
    CurrentStatus varchar(20),
    PRIMARY KEY(ShipmentID),
    FOREIGN KEY(UserID) REFERENCES Users(ID)
);

CREATE TABLE Card (
    cardNumber int,
    securityCode varchar(255),
    userId varchar(255),
    cardType varchar(255),
    cardBalance varchar(255)
    cardStatus  varchar(30),
    isLinked  boolean (1),
    PRIMARY KEY(cardNumber),
    FOREIGN KEY(UserId) REFERENCES Users(ID)
);

CREATE TABLE SOrder (
    orderId int,
    userId int,
    cardNumber int,
    orderTime date (20),
    topUpOrConsume boolean (1)
    orderAmount  double(10),
    orderLocation  varchar (50),
    PRIMARY KEY(orderID),
    FOREIGN KEY(userId) REFERENCES Users(ID)
);


CREATE TABLE BillingManagement (
    OrderID int,
    CustomerID int,
    PaymentMethod varchar(30),
    PaymentDate varchar(30)
    BillDateGenerated  varchar(30),
    Tax  double (10),
    FOREIGN KEY(OrderID) REFERENCES SOrder(ID),
    FOREIGN KEY(CustomerID) REFERENCES Users(ID)
);


CREATE TABLE NotificationManagement (
    CustomerID int,
    CreatedDate date (30),
    NotificationDate date (30),
    NType varchar(10),
    Urgency varchar(20)
    NotificationMessage  varchar(20),
    FOREIGN KEY(CustomerID) REFERENCES Users(ID)
);


CREATE TABLE Promotion (
    PromoID int,
    Title varchar(30),
    PDate date(10),
    Author varchar(30),
    Status varchar(15)
    Description  varchar(200),
    PRIMARY KEY(PromoID)
);


