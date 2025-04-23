-- Recreate Database
DROP DATABASE IF EXISTS CelestialDB;
CREATE DATABASE CelestialDB;
USE CelestialDB;

DROP TABLE IF EXISTS galaxies;

CREATE TABLE galaxies (
    galaxy_id INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Type VARCHAR(50),
    distanceLY INT
);

-- Insert galaxies again
INSERT INTO galaxies (galaxy_id, Name, Type, distanceLY) VALUES 
(1, 'Milky Way', 'Spiral', 0),
(6, 'Large Magellanic Cloud', 'Dwarf Irregular', 160000),  
(7, 'Small Magellanic Cloud', 'Dwarf Irregular', 200000),  
(8, 'Messier 81', 'Spiral', 12000000),  
(9, 'Messier 82 (Cigar Galaxy)', 'Starburst', 12000000),  
(10, 'Messier 87', 'Elliptical', 53000000),  
(11, 'Sombrero Galaxy (M104)', 'Spiral', 29000000),  
(12, 'Pinwheel Galaxy (M101)', 'Spiral', 21000000),  
(13, 'IC 1101', 'Elliptical', 1040000000),  
(14, 'Cartwheel Galaxy', 'Ring', 500000000),  
(15, 'NGC 1300', 'Barred Spiral', 61000000),  
(16, 'Whirlpool Galaxy (M51)', 'Spiral', 31000000);

