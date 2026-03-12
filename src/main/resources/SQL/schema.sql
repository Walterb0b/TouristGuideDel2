-- Opret database hvis den ikke findes
CREATE DATABASE IF NOT EXISTS touristguide
  CHARACTER SET utf8mb4;

USE touristguide;

-- Drop tabeller hvis de findes

DROP TABLE IF EXISTS tourist_attraction_tag;
DROP TABLE IF EXISTS tourist_attraction;
DROP TABLE IF EXISTS tag;

CREATE TABLE tag (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE tourist_attraction (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(255) NOT NULL UNIQUE,
                                    description TEXT,
                                    city VARCHAR(50) NOT NULL,
                                    price DECIMAL(8,2) NOT NULL
);

CREATE TABLE tourist_attraction_tag (
                                        attraction_id INT NOT NULL,
                                        tag_id INT NOT NULL,
                                        PRIMARY KEY (attraction_id, tag_id),
                                        FOREIGN KEY (attraction_id) REFERENCES tourist_attraction(id) ON DELETE CASCADE,
                                        FOREIGN KEY (tag_id) REFERENCES tag(id) ON DELETE CASCADE
);