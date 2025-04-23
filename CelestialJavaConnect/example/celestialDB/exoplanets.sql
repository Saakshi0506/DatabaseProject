
DROP TABLE IF EXISTS Exoplanets;
-- Exoplanet Table
CREATE TABLE Exoplanets (
    exoplanet_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(100),
    mass DOUBLE,
    mass_unit VARCHAR(100),
    distance_AU DOUBLE,
    orbital_period DOUBLE,
    star_id INT NOT NULL,
    FOREIGN KEY (star_id) REFERENCES Stars(star_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    UNIQUE(name)
);