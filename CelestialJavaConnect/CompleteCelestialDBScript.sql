
-- Drop existing tables to start fresh
DROP TABLE IF EXISTS Exoplanets;
DROP TABLE IF EXISTS Stars;
DROP TABLE IF EXISTS Galaxies;

-- Create Galaxies table
CREATE TABLE Galaxies (
    GalaxyID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL UNIQUE,
    Type VARCHAR(50),
    Distance INT -- Distance in light years
);

-- Create Stars table
CREATE TABLE Stars (
    StarID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL UNIQUE,
    Type VARCHAR(50),
    Mass DOUBLE,
    Distance DOUBLE,
    GalaxyID INT NOT NULL,
    FOREIGN KEY (GalaxyID) REFERENCES Galaxies(GalaxyID)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Create Exoplanets table
CREATE TABLE Exoplanets (
    PlanetID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL UNIQUE,
    Mass DOUBLE,
    OrbitalPeriod DOUBLE,
    StarID INT NOT NULL,
    FOREIGN KEY (StarID) REFERENCES Stars(StarID)
        ON DELETE CASCADE ON UPDATE CASCADE
);


-- Insert Galaxies
INSERT INTO Galaxies (GalaxyID, Name, Type, Distance) VALUES (6, 'Large Magellanic Cloud', 'Dwarf Irregular', 160000);  
INSERT INTO Galaxies (GalaxyID, Name, Type, Distance) VALUES (7, 'Small Magellanic Cloud', 'Dwarf Irregular', 200000);  
INSERT INTO Galaxies (GalaxyID, Name, Type, Distance) VALUES (8, 'Messier 81', 'Spiral', 12000000);  
INSERT INTO Galaxies (GalaxyID, Name, Type, Distance) VALUES (9, 'Messier 82 (Cigar Galaxy)', 'Starburst', 12000000);  
INSERT INTO Galaxies (GalaxyID, Name, Type, Distance) VALUES (10, 'Messier 87', 'Elliptical', 53000000);  
INSERT INTO Galaxies (GalaxyID, Name, Type, Distance) VALUES (11, 'Sombrero Galaxy (M104)', 'Spiral', 29000000);  
INSERT INTO Galaxies (GalaxyID, Name, Type, Distance) VALUES (12, 'Pinwheel Galaxy (M101)', 'Spiral', 21000000);  
INSERT INTO Galaxies (GalaxyID, Name, Type, Distance) VALUES (13, 'IC 1101', 'Elliptical', 1040000000);  
INSERT INTO Galaxies (GalaxyID, Name, Type, Distance) VALUES (14, 'Cartwheel Galaxy', 'Ring', 500000000);  
INSERT INTO Galaxies (GalaxyID, Name, Type, Distance) VALUES (15, 'NGC 1300', 'Barred Spiral', 61000000);  
INSERT INTO Galaxies (GalaxyID, Name, Type, Distance) VALUES (16, 'Whirlpool Galaxy (M51)', 'Spiral', 31000000);  


-- Insert Stars
INSERT INTO Stars (StarID, Name, Type, Mass, Distance, GalaxyID) VALUES (18, 'Kepler-90', 'G0V main-sequence star', 1.2, 2790, 1);  
INSERT INTO Stars (StarID, Name, Type, Mass, Distance, GalaxyID) VALUES (19, 'HD 10180', 'G1V main-sequence star', 1.06, 127, 1);  
INSERT INTO Stars (StarID, Name, Type, Mass, Distance, GalaxyID) VALUES (20, 'Gliese 667 C', 'M1.5V red dwarf star', 0.33, 23, 1);  
INSERT INTO Stars (StarID, Name, Type, Mass, Distance, GalaxyID) VALUES (21, 'Kepler-11', 'G-type main-sequence star', 1.04, 2110, 1);  
INSERT INTO Stars (StarID, Name, Type, Mass, Distance, GalaxyID) VALUES (22, 'M51 ULS-1', 'High-mass X-ray binary', NULL, 27000000, 16);  
INSERT INTO Stars (StarID, Name, Type, Mass, Distance, GalaxyID) VALUES (23, 'PSR B1257+12', 'Pulsar (neutron star)', 1.4, 2300, 1);  
INSERT INTO Stars (StarID, Name, Type, Mass, Distance, GalaxyID) VALUES (24, 'Mu Arae', 'G3IV subgiant star', 1.1, 50, 1);  
INSERT INTO Stars (StarID, Name, Type, Mass, Distance, GalaxyID) VALUES (25, 'Gliese 581', 'M3V red dwarf star', 0.31, 20, 1);  
INSERT INTO Stars (StarID, Name, Type, Mass, Distance, GalaxyID) VALUES (26, 'Kepler-62', 'K2V main-sequence star', 0.69, 1200, 1);  
INSERT INTO Stars (StarID, Name, Type, Mass, Distance, GalaxyID) VALUES (27, 'Kapteyn''s Star', 'M1 subdwarf star', 0.28, 12.8, 1);  
INSERT INTO Stars (StarID, Name, Type, Mass, Distance, GalaxyID) VALUES (28, 'LHS 1140', 'M4.5V red dwarf star', 0.18, 41, 1);  
INSERT INTO Stars (StarID, Name, Type, Mass, Distance, GalaxyID) VALUES (29, 'Ross 128', 'M4V red dwarf star', 0.17, 11, 1);  
INSERT INTO Stars (StarID, Name, Type, Mass, Distance, GalaxyID) VALUES (30, 'Barnard''s Star', 'M4V red dwarf star', 0.16, 6, 1);  
INSERT INTO Stars (StarID, Name, Type, Mass, Distance, GalaxyID) VALUES (31, 'Wolf 1061', 'M3V red dwarf star', 0.25, 14, 1);  


-- Insert Exoplanets
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (21, 'Kepler-90b', 2, 7, 18);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (22, 'Kepler-90c', 3, 8.7, 18);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (23, 'Kepler-90i', 15, 14.4, 18);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (24, 'Kepler-90d', 25, 59.7, 18);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (25, 'Kepler-90e', 20, 91.9, 18);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (26, 'Kepler-90f', 28, 124.9, 18);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (27, 'Kepler-90g', 15, 210.6, 18);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (28, 'Kepler-90h', 203, 331.6, 18);  

INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (29, 'HD 10180 b', 1.3, 1.2, 19);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (30, 'HD 10180 c', 13, 5.8, 19);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (31, 'HD 10180 d', 25, 16.4, 19);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (32, 'HD 10180 e', 20, 50, 19);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (33, 'HD 10180 f', 26, 120, 19);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (34, 'HD 10180 g', 23, 600, 19);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (35, 'HD 10180 h', 46, 2202, 19);  

INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (36, 'Gliese 667 Cb', 5.7, 7.2, 20);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (37, 'Gliese 667 Cc', 3.8, 28.1, 20);  

INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (38, 'Kepler-11b', 2.8, 10.3, 21);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (39, 'Kepler-11c', 13.5, 13, 21);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (40, 'Kepler-11d', 8.1, 22.7, 21);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (41, 'Kepler-11e', 9.5, 32, 21);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (42, 'Kepler-11f', 2.3, 46.7, 21);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (43, 'Kepler-11g', 8, 118.4, 21);  

INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (44, 'M51 ULS-1b', 95, 25550, 22);  

INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (45, 'PSR B1257+12 b', 0.02, 25.3, 23);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (46, 'PSR B1257+12 c', 4.3, 66.6, 23);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (47, 'PSR B1257+12 d', 3.9, 98.2, 23);  

INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (48, 'Mu Arae b', 533, 643, 24);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (49, 'Mu Arae c', 10.6, 9.6, 24);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (50, 'Mu Arae d', 165.9, 311, 24);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (51, 'Mu Arae e', 577, 4206, 24);  

INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (52, 'Gliese 581 b', 15, 5.4, 25);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (53, 'Gliese 581 c', 5.6, 12.9, 25);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (54, 'Gliese 581 d', 7, 66.8, 25);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (55, 'Gliese 581 e', 1.9, 3.1, 25);  

INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (56, 'Kepler-62b', 2, 5.7, 26);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (57, 'Kepler-62c', 0.1, 12.4, 26);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (58, 'Kepler-62d', 6, 18.2, 26);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (59, 'Kepler-62e', 5, 122.4, 26);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (60, 'Kepler-62f', 3, 267.3, 26);  

INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (61, 'Kapteyn b', 4.8, 48.6, 27);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (62, 'Kapteyn c', 7, 121.5, 27);  

INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (63, 'LHS 1140 b', 6.6, 24.7, 28);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (64, 'LHS 1140 c', 1.8, 3.8, 28);  

INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (65, 'Ross 128 b', 1.8, 9.9, 29);  

INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (66, 'Barnard''s Star b', 3.2, 233, 30);  

INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (67, 'Wolf 1061 b', 1.4, 4.9, 31);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (68, 'Wolf 1061 c', 4.3, 17.9, 31);  
INSERT INTO Exoplanets (PlanetID, Name, Mass, OrbitalPeriod, StarID) VALUES (69, 'Wolf 1061 d', 5.2, 67.3, 31);  


-- Extra Insertions (Optional)
-- dml statements
-- Insert stars-35 entries

INSERT INTO Stars (name, type, distance_light_years, constellation) VALUES
('Gliese 876', 'Red Dwarf', 15.2, 'Aquarius'),
('HD 82943', 'G-type', 90.3, 'Hydra'),
('XO-2', 'K-type', 1300, 'Pegasus'),
('CoRoT-7', 'K-type', 480, 'Monoceros'),
('HAT-P-13', 'G-type', 1300, 'Lynx'),
('HD 69830', 'K-type', 41, 'Puppis'),
('Gliese 581', 'Red Dwarf', 20.3, 'Libra'),
('Kepler-22', 'G-type', 600, 'Cygnus'),
('Kepler-10', 'G-type', 560, 'Draco'),
('Kepler-11', 'G-type', 620, 'Cygnus'),
('Kepler-20', 'G-type', 950, 'Lyra'),
('Kepler-33', 'G-type', 1200, 'Cygnus'),
('Kepler-62', 'K-type', 1200, 'Lyra'),
('Kepler-69', 'G-type', 2700, 'Cygnus'),
('TRAPPIST-1', 'M-type', 39.5, 'Aquarius'),
('Proxima Centauri', 'M-type', 4.24, 'Centaurus'),
('Tau Ceti', 'G-type', 11.9, 'Cetus'),
('Epsilon Eridani', 'K-type', 10.5, 'Eridanus'),
('GJ 1214', 'M-type', 42, 'Ophiuchus'),
('Kapteyn’s Star', 'M-type', 12.8, 'Pictor'),
('TOI-700', 'M-type', 101, 'Dorado'),
('Teegarden’s Star', 'M-type', 12.5, 'Aries'),
('Wolf 1061', 'M-type', 14.1, 'Ophiuchus'),
('YZ Ceti', 'M-type', 12.0, 'Cetus'),
('Ross 128', 'M-type', 11.0, 'Virgo'),
('HD 219134', 'K-type', 21.3, 'Cassiopeia'),
('Kepler-442', 'K-type', 1200, 'Lyra'),
('Gliese 667', 'M-type', 23.6, 'Scorpius');

-- Insert exoplanets (with star_id references)- 45 exoplanets

INSERT INTO Exoplanets (star_id, name, type, mass, mass_unit, distance_AU, orbital_period_days) VALUES
(1, 'Gliese 876 b', 'Gas Giant', 0.76, 'MJ', 0.21, 61.1),
(1, 'Gliese 876 c', 'Gas Giant', 0.56, 'MJ', 0.13, 30.1),
(1, 'Gliese 876 d', 'Super-Earth', 6.9, 'ME', 0.02, 1.9),
(2, 'HD 82943 b', 'Gas Giant', 1.68, 'MJ', 1.18, 441.5),
(3, 'XO-2 b', 'Gas Giant', 0.57, 'MJ', 0.04, 3.6),
(4, 'CoRoT-7 b', 'Rocky Planet', 4.8, 'ME', 0.017, 0.85),
(5, 'HAT-P-13 b', 'Gas Giant', 0.53, 'MJ', 0.05, 4.6),
(6, 'HD 69830 b', 'Neptune-like', 0.16, 'MJ', 0.08, 8.7),
(7, 'Gliese 581 b', 'Gas Giant', 0.35, 'MJ', 0.07, 5.6),
(8, 'Kepler-22 b', 'Super-Earth', 2.4, 'ME', 0.85, 290.0),
(9, 'Kepler-10 b', 'Rocky Planet', 3.3, 'ME', 0.0168, 0.84),
(10, 'Kepler-11 b', 'Gas Giant', 0.095, 'MJ', 0.091, 10.3),
(11, 'Kepler-20 b', 'Super-Earth', 1.7, 'ME', 0.045, 3.7),
(12, 'Kepler-33 b', 'Neptune-like', 0.3, 'MJ', 0.08, 5.7),
(13, 'TRAPPIST-1 b', 'Terrestrial', 1.4, 'ME', 0.011, 1.51);

INSERT INTO Galaxies (name, num_planetary_systems) VALUES
('Triangulum', 3000);


INSERT INTO Galaxies (name, num_planetary_systems) VALUES
('Milky Way', 4000),
('Andromeda', 5000),
('Triangulum', 3000);