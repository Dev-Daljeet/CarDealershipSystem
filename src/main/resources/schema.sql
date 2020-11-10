CREATE TABLE Deals_on_Wheels (id INT NOT NULL Primary Key AUTO_INCREMENT, make VARCHAR(100), model VARCHAR(100), colour VARCHAR(100), price DECIMAL(12,2), vin VARCHAR(100));

INSERT INTO Deals_on_Wheels (make, model, colour, price, vin) VALUES 
('Audi','Q5 Kmofort','Black',31900.00,'2FMZA53441BB85939'),
('Arctic Cat',' JAGUAR Z1 1100 EFI SNO PRO','Silver',5555.11,'1C3EL554X1N596684'),
('Sterling Truck','CONDOR','Grey',12500.00,'5TDZK3EH0AS022676'),
('John Deere', 'GATOR HPX 4X4','Green',200000.00,'4T1BF3EKXAU500241'),
('Sea-Doo', 'GTX LIMITED IS 260' ,'Black',100000.00,'1FTWW3BR9AEA82577'),
('Ford', 'E-250 ECONOLINE','Brown',3342.50,'2G1WT58K469257903'),
('Audi', 'A3','Red',22200.00,'3GCPKSE78CG269227'),
('Can-Am', 'OUTLANDER MAX 500 HO EFI','Red',34000.50,'4T1BG22K4YU930756'),
('Kawasaki', 'KX65','White',44000.50,'JHMES155X5S093338'),
('Ski-Doo', 'ELITE', 'Blue',5000.00,'5N1AN08W15C645434');

CREATE TABLE Steals_and_Deals (id INT NOT NULL Primary Key AUTO_INCREMENT, make VARCHAR(100), model VARCHAR(100), colour VARCHAR(100), price DECIMAL(12,2), vin VARCHAR(100));

INSERT INTO Steals_and_Deals (make, model, colour, price, vin) VALUES 
('Sea-Doo', 'GTI RFI', 'Green', 12000.50, '1G8ZP128XXZ300334'),
('Ferrari', '599 GTB', 'Red', 22500.00, '1FTHF25M5RNB23608'),
('Ud', '2300DH', 'Black', 20000.00, '1FDKF37G0VEB60218'),
('Arctic Cat', 'JAGUAR Z1 1100 EFI SNO PRO','Silver',5555.11,'4T1BG22K1XU418953'),
('Arctic Cat', 'FIRECAT 600', 'Grey', 23300.50,'1GNSKCE04DR286926'),
('John Deere', 'GATOR HPX 4X4','Green',200000.00,'4T1BF3EKXAU500241'),
('Suzuki', 'GSX1300R HAYABUSA', 'Blue', 14000.00, '1J8HG58256C284291'),
('Sea-Doo', 'GTX LIMITED IS 260' ,'Black',100000.00,'KLATA52611B629899'),
('Honda', 'AQUATRAX R-12', 'Silver', 23000.00, '1C3CDFBA1DD312227'),
('Ford', 'E-250 ECONOLINE','Brown',3344.50,'5N1AA08A46N713649');

CREATE TABLE Rhyme_and_Crime (id INT NOT NULL Primary Key AUTO_INCREMENT, make VARCHAR(100), model VARCHAR(100), colour VARCHAR(100), price DECIMAL(12,2), vin VARCHAR(100));

INSERT INTO Rhyme_and_Crime (make, model, colour, price, vin) VALUES 
('Honda', 'GL1800 GOLD WING AIRBAG', 'Green',4000.00, '1FAFP66L0XK281117'),
('Sea-Doo', 'GTI RFI', 'Green', 12500.00, '1G8ZP128XXZ300334'),
('Aprilia', 'ETV 1000 CAPONORD', 'White', 23400.50, 'JF2SJADC9FH462228'),
('Ferrari', '599 GTB', 'Red', 22000.00, '5YFBURHE0EP122632'),
('Chevrolet', 'OPTRA', 'Yellow', 43000.00, '2CNFLEEW1A6241405'),
('Ud', '2300DH', 'Silver', 20000.00, '1FDKF37G0VEB60218'),
('Peugeot', 'PARTNER', 'Black', 34500.50, '4T4BE46K29R024916'),
('John Deere', 'GATOR HPX 4X4','Green',204000.00,'5XYZU3LB6EG175235'),
('Ford', 'E-250 ECONOLINE','Brown',3344.50,'1HTWEAAR94J033399'),
('Audi','Q5 Kmofort','Black',31900.00,'2T2HA31U44C082535');
