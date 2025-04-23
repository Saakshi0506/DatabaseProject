
-- Drop existing tables if they exist
DROP TABLE IF EXISTS Exoplanets;
DROP TABLE IF EXISTS Stars;
DROP TABLE IF EXISTS Galaxies;

-- Create Galaxies table
CREATE TABLE Galaxies (
    GalaxyID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL UNIQUE,
    Type VARCHAR(50),
    Distance_Light_Years FLOAT
);

-- Create Stars table
CREATE TABLE Stars (
    StarID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL UNIQUE,
    Type VARCHAR(50),
    Mass DOUBLE,
    Distance_Light_Years FLOAT,
    GalaxyID INT NOT NULL,
    FOREIGN KEY (GalaxyID) REFERENCES Galaxies(GalaxyID)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Create Exoplanets table
CREATE TABLE Exoplanets (
    ExoplanetID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL UNIQUE,
    Type VARCHAR(50),
    Mass DOUBLE,
    OrbitalPeriod DOUBLE,
    StarID INT NOT NULL,
    FOREIGN KEY (StarID) REFERENCES Stars(StarID)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Insert Galaxies
INSERT INTO Galaxies (GalaxyID, Name, Type, Distance_Light_Years) VALUES
(1, 'Milky Way', 'Spiral', 0),
(2, 'Andromeda', 'Spiral', 2537000),
(3, 'Triangulum', 'Spiral', 3000000),
(4, 'Large Magellanic Cloud', 'Irregular', 163000),
(5, 'Small Magellanic Cloud', 'Irregular', 200000),
(6, 'Whirlpool Galaxy', 'Spiral', 23000000),
(7, 'Messier 87', 'Elliptical', 53000000),
(8, 'NGC 1300', 'Barred Spiral', 61000000),
(9, 'Sombrero Galaxy', 'Spiral', 29000000),
(10, 'Cartwheel Galaxy', 'Lenticular', 500000000),
(11, 'Pinwheel Galaxy', 'Spiral', 21200000),
(12, 'Sunflower Galaxy', 'Spiral', 37000000),
(13, 'Messier 81', 'Spiral', 12000000),
(14, 'Messier 82', 'Irregular', 12000000),
(15, 'Centaurus A', 'Elliptical', 13000000),
(16, 'Messier 51', 'Spiral', 23000000);

-- Insert Stars
INSERT INTO Stars (StarID, Name, Type, Mass, Distance_Light_Years, GalaxyID) VALUES
(18, 'Kepler-90', 'G0V main-sequence star', 1.2, 2790, 1),
(19, 'HD 10180', 'G1V main-sequence star', 1.06, 127, 1),
(20, 'Gliese 667 C', 'M1.5V red dwarf star', 0.33, 23, 1),
(21, 'Kepler-11', 'G-type main-sequence star', 1.04, 2110, 1),
(22, 'M51 ULS-1', 'High-mass X-ray binary', NULL, 27000000, 16),
(23, 'PSR B1257+12', 'Pulsar (neutron star)', 1.4, 2300, 1),
(24, 'Mu Arae', 'G3IV subgiant star', 1.1, 50, 1),
(25, 'Gliese 581', 'M3V red dwarf star', 0.31, 20, 1),
(26, 'Kepler-62', 'K2V main-sequence star', 0.69, 1200, 1),
(27, 'Kapteyn''s Star', 'M1 subdwarf star', 0.28, 12.8, 1),
(28, 'LHS 1140', 'M4.5V red dwarf star', 0.18, 41, 1),
(29, 'Ross 128', 'M4V red dwarf star', 0.17, 11, 1),
(30, 'Barnard''s Star', 'M4V red dwarf star', 0.16, 6, 1),
(31, 'Wolf 1061', 'M3V red dwarf star', 0.25, 14, 1);

-- Insert Exoplanets (Sample)
INSERT INTO Exoplanets (ExoplanetID, Name, Type, Mass, OrbitalPeriod, StarID) VALUES
(21, 'Kepler-90b', NULL, 2, 7, 18),
(22, 'Kepler-90c', NULL, 3, 8.7, 18),
(23, 'Kepler-90i', NULL, 15, 14.4, 18),
(24, 'Kepler-90d', NULL, 25, 59.7, 18),
(25, 'Kepler-90e', NULL, 20, 91.9, 18);
