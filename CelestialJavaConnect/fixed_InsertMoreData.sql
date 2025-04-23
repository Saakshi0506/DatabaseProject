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