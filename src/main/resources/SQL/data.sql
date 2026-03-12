
INSERT INTO tag (id, name) VALUES
    (1, 'FREE'),
    (2, 'HISTORY'),
    (3, 'MUSEUM'),
    (4, 'ENTERTAINMENT'),
    (5, 'KID_FRIENDLY');


INSERT INTO tourist_attraction (id, name, description, city, price) VALUES
    (1, 'Nyhavn', 'En historisk havn med farverige huse, restauranter og caféer', 'COPENHAGEN', 0.0),
    (2, 'ARoS Kunstmuseum', 'Et moderne kunstmuseum kendt for den cirkulære regnbue på taget', 'AARHUS', 150.0),
    (3, 'Den Gamle By', 'Et frilandsmuseum der viser dansk byliv gennem historien', 'AARHUS', 120.0),
    (4, 'Odense Zoo', 'En populær zoologisk have med dyr fra hele verden', 'ODENSE', 100.0),
    (5, 'Aalborg Zoo', 'En familievenlig zoologisk have med fokus på naturbevarelse', 'AALBORG', 150.0),
    (6, 'Legoland Billund', 'En forlystelsespark bygget af LEGO-klodser for hele familien', 'BILLUND', 299.0),
    (7, 'Ribe Vikingecenter', 'Et levende museum der genskaber vikingernes liv og hverdag', 'ESBJERG', 150.0),
    (8, 'Frederiksborg Slot', 'Et imponerende renæssanceslot omgivet af søer og haver', 'HILLEROED', 99.95),
    (9, 'Himmelbjerget', 'Et af Danmarks højeste punkter med flot udsigt over landskabet', 'SILKEBORG', 0.0),
    (10, 'H.C. Andersens Hus', 'Et museum dedikeret til forfatteren H.C. Andersens liv og værker', 'ODENSE', 115.0);

-- Nyhavn: FREE, HISTORY
INSERT INTO tourist_attraction_tag (attraction_id, tag_id) VALUES
    (1, 1),
    (1, 2);

-- ARoS Kunstmuseum: MUSEUM, ENTERTAINMENT
INSERT INTO tourist_attraction_tag (attraction_id, tag_id) VALUES
    (2, 3),
    (2, 4);

-- Den Gamle By: MUSEUM, HISTORY, KID_FRIENDLY
INSERT INTO tourist_attraction_tag (attraction_id, tag_id) VALUES
    (3, 3),
    (3, 2),
    (3, 5);

-- Odense Zoo: KID_FRIENDLY, ENTERTAINMENT
INSERT INTO tourist_attraction_tag (attraction_id, tag_id) VALUES
    (4, 5),
    (4, 4);

-- Aalborg Zoo: KID_FRIENDLY, ENTERTAINMENT
INSERT INTO tourist_attraction_tag (attraction_id, tag_id) VALUES
    (5, 5),
    (5, 4);

-- Legoland Billund: KID_FRIENDLY, ENTERTAINMENT
INSERT INTO tourist_attraction_tag (attraction_id, tag_id) VALUES
    (6, 5),
    (6, 4);

-- Ribe Vikingecenter: HISTORY, MUSEUM, KID_FRIENDLY
INSERT INTO tourist_attraction_tag (attraction_id, tag_id) VALUES
    (7, 2),
    (7, 3),
    (7, 5);

-- Frederiksborg Slot: HISTORY, MUSEUM
INSERT INTO tourist_attraction_tag (attraction_id, tag_id) VALUES
    (8, 2),
    (8, 3);

-- Himmelbjerget: FREE, HISTORY
INSERT INTO tourist_attraction_tag (attraction_id, tag_id) VALUES
    (9, 1),
    (9, 2);

-- H.C. Andersens Hus: MUSEUM, HISTORY
INSERT INTO tourist_attraction_tag (attraction_id, tag_id) VALUES
    (10, 3),
    (10, 2);