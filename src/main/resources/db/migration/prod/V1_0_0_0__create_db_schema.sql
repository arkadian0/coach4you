-- ordinary_user TABLE ------------------------------------------------------------------------
CREATE TABLE "ordinary_user"
(
    id                SERIAL      NOT NULL,
    first_name        VARCHAR(50) NOT NULL,
    last_name         VARCHAR(50) NOT NULL,
    email             VARCHAR(70) NOT NULL UNIQUE,
    age               INTEGER     NOT NULL,
    create_date       TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modification_date TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version           BIGINT      NOT NULL DEFAULT (0)
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
    id                  SERIAL       NOT NULL,
    first_name          VARCHAR(50)  NOT NULL,
    last_name           VARCHAR(50)  NOT NULL,
    email               VARCHAR(70)  NOT NULL UNIQUE,
    age                 INTEGER      NOT NULL,
    professions         VARCHAR(255) NOT NULL,
    description         VARCHAR(255),
    years_of_experience VARCHAR(10),
    create_date         TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modification_date   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    version             BIGINT       NOT NULL DEFAULT (0)
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
    type        VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(50) NOT NULL,
    version     BIGINT      NOT NULL DEFAULT (0)
);

CREATE
UNIQUE INDEX sport_dictionary_id_uindex
    ON sport_dictionary (id);

ALTER TABLE sport_dictionary
    ADD CONSTRAINT sport_dictionary_pk
        PRIMARY KEY (id);

-- activity_dictionary TABLE ------------------------------------------------------------------------
CREATE TABLE activity_dictionary
(
    id          SERIAL      NOT NULL,
    type        VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(50) NOT NULL,
    version     BIGINT      NOT NULL DEFAULT (0)
);

CREATE
UNIQUE INDEX activity_dictionary_id_uindex
    ON activity_dictionary (id);

ALTER TABLE activity_dictionary
    ADD CONSTRAINT activity_dictionary_pk
        PRIMARY KEY (id);

-- coach_activity_dictionary TABLE ------------------------------------------------------------------------
CREATE TABLE coach_activity_dictionary
(
    coach_id               INTEGER NOT NULL,
    activity_dictionary_id INTEGER NOT NULL,
    CONSTRAINT coach_activity_dictionary_coach_fk
        FOREIGN KEY (coach_id) REFERENCES coach (id) ON DELETE CASCADE,
    CONSTRAINT coach_activity_dictionary_activity_dictionary_fk
        FOREIGN KEY (activity_dictionary_id) REFERENCES activity_dictionary (id) ON DELETE CASCADE
);

CREATE
UNIQUE INDEX coach_activity_dictionary_id_uindex
    ON coach_activity_dictionary (coach_id, activity_dictionary_id);

ALTER TABLE coach_activity_dictionary
    ADD CONSTRAINT coach_activity_dictionary_pk
        PRIMARY KEY (coach_id, activity_dictionary_id);

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