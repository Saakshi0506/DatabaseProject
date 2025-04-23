-- Insert sample galaxies
INSERT INTO Galaxy (name, type, distance) VALUES
('Milky Way',   'Spiral',    0),           -- distance 0 since we are inside it
('Andromeda',   'Spiral',    2537000),     -- ~2.537 million light years
('Sombrero',    'Spiral',    29000000);    -- ~29 million light years

-- Insert sample stars (with galaxy_id references)
INSERT INTO Star (name, type, mass, galaxy_id) VALUES
('Sun',              'G-type (Yellow Dwarf)', 1.00, 1),  -- Sun in Milky Way
('Sirius',           'A-type',               2.02, 1),  -- Sirius in Milky Way
('Proxima Centauri', 'M-type (Red Dwarf)',   0.12, 1),  -- Proxima Centauri in Milky Way
('Kepler-22',        'G-type',               0.97, 1),  -- Kepler-22 in Milky Way
('Andromeda Star 1', 'Blue Giant',           5.50, 2);  -- A star in Andromeda galaxy

-- Insert sample exoplanets (with star_id references)
INSERT INTO Exoplanet (name, type, orbital_period, star_id) VALUES
('Proxima Centauri b', 'Terrestrial', 11.2, 3),   -- Orbits Proxima Centauri (star_id 3)
('Kepler-22b',         'Super-Earth', 289.9, 4);  -- Orbits Kepler-22 (star_id 4)
