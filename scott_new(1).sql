
CREATE TABLE item(
itemID integer PRIMARY KEY NOT NULL, 
name VARCHAR(20),
type  VARCHAR(10),
payment integer NOT NULL,
Renewtimes integer NOT NULL,
borrowtime integer not null,
Amount integer NOT NULL,
Fine integer NOT NULL
);

insert into item values(01, 'Daily Magazine', 'Magazine', 3, 0 ,0,3, 1);
insert into item values(02, 'Daily Magazine', 'Magazine', 3, 0 ,0,3, 1);
insert into item values(03, 'Daily Magazine', 'Magazine', 3, 0 ,0,3, 1);

insert into item values(06, 'Global View', 'Newspaper', 2, 0,0, 2, 1);
insert into item values(07, 'Global View', 'Newspaper', 2, 0,0, 2, 1);
insert into item values(08, 'Pop Music', 'Tape', 5, 0,0, 3, 2);
insert into item values(09, 'Pop Music', 'Tape', 5, 0,0, 3, 2);
insert into item values(10, 'Pop Music', 'Tape', 5, 0,0, 3, 2);






CREATE TABLE Patrons(
LibrarycardID integer PRIMARY KEY NOT NULL, 
PatronAdderss VARCHAR(100),
Name VARCHAR(20),
phoneNumber varchar(20),
ExpDate DATE
);

insert into Patrons values(01, '1211 Dickinson Dr.', 'Bruce', 3054966100, '01-OCT-2021');
insert into Patrons values(02, '8040 SW 72nd AVE', 'CC', 3051233214, '04-OCT-2021');
insert into Patrons values(03, '1122 NW 100th ST.', 'Cindy', 3057949100, '18-OCT-2021');

CREATE TABLE Borrow (
borrowid integer PRIMARY KEY,
itemid integer NOT NULL,
LibrarycardID integer NOT NULL,
StartDate DATE,
TrueReturnDate DATE,
ExpReturnDate DATE,
renewtimes integer default 0,
checks integer default 0, 
cost integer NOT NULL,
cost_detail varchar(255),
FOREIGN KEY(itemID) REFERENCES item(itemID),
FOREIGN KEY(LibrarycardID) REFERENCES Patrons(LibrarycardID)
);
insert into Borrow values(01, 01, 01, '01-Mar-2012', '04-Mar-2012','04-Mar-2012',0,1,9,'Three days without passdue. 3*3');
insert into Borrow values(02, 07, 02, '18-Feb-2012', '20-Feb-2012','19-Feb-2012',1,0,5,'One day borrowed and one day extend. Didnnot pay yet');
insert into Borrow values(03, 10, 03, '15-Mar-2012', '31-Mar-2012','31-Mar-2012',0,1,80,'16 days withou passdue. 16*5');
	insert into Borrow values(04, 08, 03, '01-May-2021', '','03-May-2021',0,0,99,'10 days with passdue for 7 days. Didnnot pay yet.5*10+7*7');

CREATE TABLE Request(
RequestID integer PRIMARY KEY,
itemid integer NOT NULL,
LibrarycardID integer NOT NULL,
RequestDetail varchar(255),
checks integer default 0,
FOREIGN KEY(itemID) REFERENCES item(itemID),
FOREIGN KEY(LibrarycardID) REFERENCES Patrons(LibrarycardID)
);
insert into Request values(01,01,03,'Request item-01 in 05-Mar-2012',0);
insert into Request values(02,07,02,'Request item-07 in 20-Feb-2012',1);
insert into Request values(03,10,01,'Request item-10 in 30-Mar-2012',0);
