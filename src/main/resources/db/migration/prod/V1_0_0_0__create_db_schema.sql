-- ordinary_user TABLE ------------------------------------------------------------------------
CREATE TABLE "ordinary_user"
(
    id         SERIAL      NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(70) NOT NULL,
    age        INTEGER     NOT NULL
);

CREATE
UNIQUE INDEX ordinary_user_id_index
    ON "ordinary_user" (id);

ALTER TABLE "ordinary_user"
    ADD CONSTRAINT ordinary_user_pk
        PRIMARY KEY (id);

-- coach TABLE ------------------------------------------------------------------------
CREATE TABLE coach
(
    id                  SERIAL      NOT NULL,
    first_name          VARCHAR(50) NOT NULL,
    last_name           VARCHAR(50) NOT NULL,
    email               VARCHAR(70) NOT NULL,
    age                 INTEGER     NOT NULL,
    description         VARCHAR(255),
    years_of_experience VARCHAR(10)
);

CREATE
UNIQUE INDEX coach_id_uindex
    ON coach (id);

ALTER TABLE coach
    ADD CONSTRAINT coach_pk
        PRIMARY KEY (id);


-- coach_ordinary_user TABLE ------------------------------------------------------------------------
CREATE TABLE coach_ordinary_user
(
    coach_id         INTEGER NOT NULL,
    ordinary_user_id INTEGER NOT NULL,
    CONSTRAINT coach_ordinary_user_coach_fk
        FOREIGN KEY (coach_id) REFERENCES coach (id) ON DELETE CASCADE,
    CONSTRAINT coach_ordinary_user_ordinary_user_fk
        FOREIGN KEY (ordinary_user_id) REFERENCES ordinary_user (id) ON DELETE CASCADE
);

CREATE
UNIQUE INDEX coach_ordinary_user_id_uindex
    ON coach_ordinary_user (coach_id, ordinary_user_id);

ALTER TABLE coach_ordinary_user
    ADD CONSTRAINT coach_ordinary_user_pk
        PRIMARY KEY (coach_id, ordinary_user_id);

-- sport_dictionary TABLE ------------------------------------------------------------------------
CREATE TABLE sport_dictionary
(
    id          SERIAL      NOT NULL,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(50) NOT NULL
);

CREATE
UNIQUE INDEX sport_dictionary_id_uindex
    ON sport_dictionary (id);

ALTER TABLE sport_dictionary
    ADD CONSTRAINT sport_dictionary_pk
        PRIMARY KEY (id);

-- specialization_dictionary TABLE ------------------------------------------------------------------------
CREATE TABLE specialization_dictionary
(
    id          SERIAL      NOT NULL,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(50) NOT NULL
);

CREATE
UNIQUE INDEX specialization_dictionary_id_uindex
    ON specialization_dictionary (id);

ALTER TABLE specialization_dictionary
    ADD CONSTRAINT specialization_dictionary_pk
        PRIMARY KEY (id);

-- classes_dictionary TABLE ------------------------------------------------------------------------
CREATE TABLE classes_dictionary
(
    id          SERIAL      NOT NULL,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(50) NOT NULL
);

CREATE
UNIQUE INDEX classes_dictionary_id_uindex
    ON classes_dictionary (id);

ALTER TABLE classes_dictionary
    ADD CONSTRAINT classes_dictionary_pk
        PRIMARY KEY (id);

-- coach_classes_dictionary TABLE ------------------------------------------------------------------------
CREATE TABLE coach_classes_dictionary
(
    coach_id              INTEGER NOT NULL,
    classes_dictionary_id INTEGER NOT NULL,
    CONSTRAINT coach_classes_dictionary_coach_fk
        FOREIGN KEY (coach_id) REFERENCES coach (id) ON DELETE CASCADE,
    CONSTRAINT coach_classes_dictionary_classes_dictionary_fk
        FOREIGN KEY (classes_dictionary_id) REFERENCES classes_dictionary (id) ON DELETE CASCADE
);

CREATE
UNIQUE INDEX coach_classes_dictionary_id_uindex
    ON coach_classes_dictionary (coach_id, classes_dictionary_id);

ALTER TABLE coach_classes_dictionary
    ADD CONSTRAINT coach_classes_dictionary_pk
        PRIMARY KEY (coach_id, classes_dictionary_id);

-- coach_sport_dictionary TABLE ------------------------------------------------------------------------
CREATE TABLE coach_sport_dictionary
(
    coach_id            INTEGER NOT NULL,
    sport_dictionary_id INTEGER NOT NULL,
    CONSTRAINT coach_sport_dictionary_coach_fk
        FOREIGN KEY (coach_id) REFERENCES coach (id) ON DELETE CASCADE,
    CONSTRAINT coach_sport_dictionary_sport_dictionary_fk
        FOREIGN KEY (sport_dictionary_id) REFERENCES sport_dictionary (id) ON DELETE CASCADE
);

CREATE
UNIQUE INDEX coach_sport_dictionary_id_uindex
    ON coach_sport_dictionary (coach_id, sport_dictionary_id);

ALTER TABLE coach_sport_dictionary
    ADD CONSTRAINT coach_sport_dictionary_pk
        PRIMARY KEY (coach_id, sport_dictionary_id);

-- coach_specialization_dictionary TABLE ------------------------------------------------------------------------
CREATE TABLE coach_specialization_dictionary
(
    coach_id                     INTEGER NOT NULL,
    specialization_dictionary_id INTEGER NOT NULL,
    CONSTRAINT coach_specialization_dictionary_coach_fk
        FOREIGN KEY (coach_id) REFERENCES coach (id) ON DELETE CASCADE,
    CONSTRAINT coach_specialization_dictionary_specialization_dictionary_fk
        FOREIGN KEY (specialization_dictionary_id) REFERENCES specialization_dictionary (id) ON DELETE CASCADE
);

CREATE
UNIQUE INDEX coach_specialization_dictionary_id_uindex
    ON coach_specialization_dictionary (coach_id, specialization_dictionary_id);

ALTER TABLE coach_specialization_dictionary
    ADD CONSTRAINT coach_specialization_dictionary_pk
        PRIMARY KEY (coach_id, specialization_dictionary_id);