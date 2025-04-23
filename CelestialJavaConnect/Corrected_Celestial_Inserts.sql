-- Corrected Galaxy Inserts
INSERT INTO galaxies (galaxy_id, Name, Type, distance) VALUES (6, 'Large Magellanic Cloud', 'Dwarf Irregular', 160000);  
INSERT INTO galaxies (galaxy_id, Name, Type, distance) VALUES (7, 'Small Magellanic Cloud', 'Dwarf Irregular', 200000);  
INSERT INTO galaxies (galaxy_id, Name, Type, distance) VALUES (8, 'Messier 81', 'Spiral', 12000000);  
INSERT INTO galaxies (galaxy_id, Name, Type, distance) VALUES (9, 'Messier 82 (Cigar Galaxy)', 'Starburst', 12000000);  
INSERT INTO galaxies (galaxy_id, Name, Type, distance) VALUES (10, 'Messier 87', 'Elliptical', 53000000);  
INSERT INTO galaxies (galaxy_id, Name, Type, distance) VALUES (11, 'Sombrero Galaxy (M104)', 'Spiral', 29000000);  
INSERT INTO galaxies (galaxy_id, Name, Type, distance) VALUES (12, 'Pinwheel Galaxy (M101)', 'Spiral', 21000000);  
INSERT INTO galaxies (galaxy_id, Name, Type, distance) VALUES (13, 'IC 1101', 'Elliptical', 1040000000);  
INSERT INTO galaxies (galaxy_id, Name, Type, distance) VALUES (14, 'Cartwheel Galaxy', 'Ring', 500000000);  
INSERT INTO galaxies (galaxy_id, Name, Type, distance) VALUES (15, 'NGC 1300', 'Barred Spiral', 61000000);  
INSERT INTO galaxies (galaxy_id, Name, Type, distance) VALUES (16, 'Whirlpool Galaxy (M51)', 'Spiral', 31000000);  


-- Corrected Star Inserts
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES (18, 'Kepler-90', 'G0V main-sequence star', 1.2, 2790, 1);  
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES (19, 'HD 10180', 'G1V main-sequence star', 1.06, 127, 1);  
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES (20, 'Gliese 667 C', 'M1.5V red dwarf star', 0.33, 23, 1);  
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES (21, 'Kepler-11', 'G-type main-sequence star', 1.04, 2110, 1);  
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES (22, 'M51 ULS-1', 'High-mass X-ray binary', NULL, 27000000, 16);  
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES (23, 'PSR B1257+12', 'Pulsar (neutron star)', 1.4, 2300, 1);  
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES (24, 'Mu Arae', 'G3IV subgiant star', 1.1, 50, 1);  
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES (25, 'Gliese 581', 'M3V red dwarf star', 0.31, 20, 1);  
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES (26, 'Kepler-62', 'K2V main-sequence star', 0.69, 1200, 1);  
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES (27, 'Kapteyn''s Star', 'M1 subdwarf star', 0.28, 12.8, 1);  
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES (28, 'LHS 1140', 'M4.5V red dwarf star', 0.18, 41, 1);  
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES (29, 'Ross 128', 'M4V red dwarf star', 0.17, 11, 1);  
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES (30, 'Barnard''s Star', 'M4V red dwarf star', 0.16, 6, 1);  
INSERT INTO stars (star_id, Name, Type, Mass, distanceLY, galaxy_id) VALUES (31, 'Wolf 1061', 'M3V red dwarf star', 0.25, 14, 1);  


-- Corrected Exoplanet Inserts
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (21, 'Kepler-90b', 2, 7, 18);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (22, 'Kepler-90c', 3, 8.7, 18);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (23, 'Kepler-90i', 15, 14.4, 18);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (24, 'Kepler-90d', 25, 59.7, 18);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (25, 'Kepler-90e', 20, 91.9, 18);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (26, 'Kepler-90f', 28, 124.9, 18);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (27, 'Kepler-90g', 15, 210.6, 18);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (28, 'Kepler-90h', 203, 331.6, 18);  

INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (29, 'HD 10180 b', 1.3, 1.2, 19);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (30, 'HD 10180 c', 13, 5.8, 19);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (31, 'HD 10180 d', 25, 16.4, 19);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (32, 'HD 10180 e', 20, 50, 19);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (33, 'HD 10180 f', 26, 120, 19);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (34, 'HD 10180 g', 23, 600, 19);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (35, 'HD 10180 h', 46, 2202, 19);  

INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (36, 'Gliese 667 Cb', 5.7, 7.2, 20);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (37, 'Gliese 667 Cc', 3.8, 28.1, 20);  

INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (38, 'Kepler-11b', 2.8, 10.3, 21);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (39, 'Kepler-11c', 13.5, 13, 21);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (40, 'Kepler-11d', 8.1, 22.7, 21);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (41, 'Kepler-11e', 9.5, 32, 21);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (42, 'Kepler-11f', 2.3, 46.7, 21);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (43, 'Kepler-11g', 8, 118.4, 21);  

INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (44, 'M51 ULS-1b', 95, 25550, 22);  

INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (45, 'PSR B1257+12 b', 0.02, 25.3, 23);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (46, 'PSR B1257+12 c', 4.3, 66.6, 23);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (47, 'PSR B1257+12 d', 3.9, 98.2, 23);  

INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (48, 'Mu Arae b', 533, 643, 24);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (49, 'Mu Arae c', 10.6, 9.6, 24);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (50, 'Mu Arae d', 165.9, 311, 24);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (51, 'Mu Arae e', 577, 4206, 24);  

INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (52, 'Gliese 581 b', 15, 5.4, 25);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (53, 'Gliese 581 c', 5.6, 12.9, 25);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (54, 'Gliese 581 d', 7, 66.8, 25);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (55, 'Gliese 581 e', 1.9, 3.1, 25);  

INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (56, 'Kepler-62b', 2, 5.7, 26);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (57, 'Kepler-62c', 0.1, 12.4, 26);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (58, 'Kepler-62d', 6, 18.2, 26);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (59, 'Kepler-62e', 5, 122.4, 26);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (60, 'Kepler-62f', 3, 267.3, 26);  

INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (61, 'Kapteyn b', 4.8, 48.6, 27);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (62, 'Kapteyn c', 7, 121.5, 27);  

INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (63, 'LHS 1140 b', 6.6, 24.7, 28);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (64, 'LHS 1140 c', 1.8, 3.8, 28);  

INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (65, 'Ross 128 b', 1.8, 9.9, 29);  

INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (66, 'Barnard''s Star b', 3.2, 233, 30);  

INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (67, 'Wolf 1061 b', 1.4, 4.9, 31);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (68, 'Wolf 1061 c', 4.3, 17.9, 31);  
INSERT INTO exoplanets (exoplanet_id, Name, mass, orbital_period, star_id) VALUES (69, 'Wolf 1061 d', 5.2, 67.3, 31);  
