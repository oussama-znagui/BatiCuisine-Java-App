#bonjour --
CREATE TYPE ProjectStatus AS ENUM('INPROGRESS','COMPLETED','CANCELLED');
CREATE TYPE ComponentType AS ENUM('LABOR','EQUIPMENT');

create table Clients(
    id SERIAL PRIMARY KEY,
    name varchar,
    email varchar,
    phone varchar,
    isPro boolean
);

create table Projects(
    id SERIAL PRIMARY KEY,
    projectName varchar,
    profitMargin decimal,
    totalCost decimal,
    projectStatus ProjectStatus,
    clientID int
);

create table Estimates(
   id SERIAL PRIMARY KEY,
   estimatedAmount decimal,
   issueDate decimal,
   expirationDate decimal,
   accepted boolean,
    projectID int,

);


create table components(
    id SERIAL PRIMARY KEY,
    name varchar,
    type ComponentType,
    tva int,
    projectID int
);

create table Labors(
    hourlyRate decimal,
    workingHours decimal,
    productivityCff decimal
) INHERITS (components);

create table Equipments(
    unitCost decimal,
    quantity decimal,
    transportCost decimal,
    qualityCoefficient decimal
) INHERITS (components);

ALTER TABLE Contracts
    ADD FOREIGN KEY (PartnerID) REFERENCES Partners(id);









