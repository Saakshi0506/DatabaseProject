DROP TABLE IF EXISTS stars;
CREATE TABLE stars (
    star_id INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Type VARCHAR(100),
    Mass DOUBLE,
    constellation VARCHAR(100),
    distanceLY DOUBLE,
    galaxy_id INT,
    FOREIGN KEY (galaxy_id) REFERENCES galaxies(galaxy_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES 
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
