DROP TABLE pelicula CASCADE CONSTRAINTS;

CREATE TABLE pelicula (
    id_pelicula     NUMBER(8) GENERATED ALWAYS AS IDENTITY
                          MAXVALUE 99999999
                          INCREMENT BY 1 
                          START WITH 1,
    titulo          VARCHAR2(100) NOT NULL,
    pelicula_year   NUMBER(4) NOT NULL,
    director        VARCHAR2(100) NOT NULL,
    genero          VARCHAR2(100) NOT NULL,
    sinopsis        VARCHAR2(250) NOT NULL
);

ALTER TABLE pelicula ADD CONSTRAINT pelicula_pk PRIMARY KEY ( id_pelicula );

INSERT INTO pelicula VALUES (DEFAULT,'Dune: Part Two',2024,'Denis Villeneuve','Drama','Paul Atreides unites with Chani and the Fremen while seeking revenge against the conspirators who destroyed his family.');
INSERT INTO pelicula VALUES (DEFAULT,'Deadpool and Wolverine',2024,'Shawn Levy','Accion','Wolverine is recovering from his injuries when he crosses paths with the loudmouth, Deadpool. They team up to defeat a common enemy.');
INSERT INTO pelicula VALUES (DEFAULT,'Godzilla Minus One',2023,'Takashi Yamazaki','Accion','Post war Japan is at its lowest point when a new crisis emerges in the form of a giant monster, baptized in the horrific power of the atomic bomb.');
INSERT INTO pelicula VALUES (DEFAULT,'Oppenheimer',2023,'Christopher Nolan','Biografia','The story of American scientist J. Robert Oppenheimer and his role in the development of the atomic bomb.');
INSERT INTO pelicula VALUES (DEFAULT,'The Creator',2023,'Gareth Edwards','Accion','Against the backdrop of a war between humans and robots with artificial intelligence, a former soldier finds the secret weapon, a robot in the form of a young child.');

COMMIT;