-- Insert into Universite
INSERT INTO universite (nom_universite, region) VALUES
                                                    ('Université de Tunis', 'Tunis'),
                                                    ('Université de Sfax', 'Sfax');

-- Insert into Faculte
INSERT INTO faculte (nom_faculte, id_universite) VALUES
                                                     ('Faculté des Sciences de Tunis', 1),
                                                     ('Faculté des Lettres de Sfax', 2);

-- Insert into Departement
INSERT INTO departement (nom_dept, id_faculte) VALUES
                                                   ('Informatique', 1),
                                                   ('Mathématiques', 1),
                                                   ('Langues', 2);

-- Insert into Grade
INSERT INTO grade (nom_grade, nb_heures_etude_a_faire, nb_heures_surveillance_a_faire) VALUES
                                                                                           ('Professeur', 150, 20),
                                                                                           ('Maître de conférences', 100, 15),
                                                                                           ('Assistant', 50, 10);

-- Insert into Enseignant
INSERT INTO enseignant (username, cin, email, id_departement, id_grade) VALUES
                                                                            ('jdoe', '12345678', 'jdoe@example.com', 1, 1),
                                                                            ('asmith', '87654321', 'asmith@example.com', 2, 2),
                                                                            ('bmiller', '23456789', 'bmiller@example.com', 3, 3);














-- Insert Universite
INSERT INTO universite (id, nom_universite, region) VALUES
    (1, 'Université de Tunis', 'Tunis');

-- Insert Faculte
INSERT INTO faculte (id, nom_faculte, id_universite) VALUES
    (1, 'Faculté des Sciences', 1);

-- Insert Departement
INSERT INTO departement (id, nom_dept, id_faculte) VALUES
                                                       (1, 'Département Informatique', 1),
                                                       (2, 'Département Mathématiques', 1);

-- Insert Salles with different capacities
INSERT INTO salle (id, no_salle, capacite, id_departement) VALUES
                                                               (1, 'S101', 30, 1),
                                                               (2, 'S102', 50, 1),
                                                               (3, 'S201', 100, 1),
                                                               (4, 'M101', 40, 2),
                                                               (5, 'M102', 60, 2);

-- Insert Grade (for teachers)
INSERT INTO grade (id, nom_grade, nb_heures_etude_a_faire, nb_heures_surveillance_a_faire) VALUES
                                                                                               (1, 'Professeur', 192, 40),
                                                                                               (2, 'Maître de conférences', 192, 30);

-- Insert Enseignant
INSERT INTO enseignant (enseignant_id, username, cin, email, id_departement, id_grade) VALUES
                                                                                           (1, 'prof.ahmed', '12345678', 'ahmed@univ.tn', 1, 1),
                                                                                           (2, 'prof.sarah', '87654321', 'sarah@univ.tn', 1, 2);

-- Insert sections
INSERT INTO section (id, nom, niveau, department_id, group_number) VALUES
                                                                       (1, 'L1-Info-G1', 1, 1, 1),
                                                                       (2, 'L1-Info-G2', 1, 1, 2);

-- Insert matiere (subjects)
INSERT INTO matiere (id, name, coeff) VALUES
                                          (1, 'Algorithmique', 3.0),
                                          (2, 'Base de données', 3.0),
                                          (3, 'Java', 2.5);

-- Insert section_matiere
INSERT INTO section_matiere (id, section_id, matiere_id) VALUES
                                                             (1, 1, 1),
                                                             (2, 1, 2),
                                                             (3, 1, 3),
                                                             (4, 2, 1),
                                                             (5, 2, 2),
                                                             (6, 2, 3);

-- Insert some existing reservations
INSERT INTO salle_reservation (id, begin_date_time, end_date_time, number_of_students, id_salle) VALUES
-- Room S101 (id=1) reservations
(1, '2024-01-16 09:00:00', '2024-01-16 11:00:00', 25, 1),  -- Morning session
(2, '2024-01-16 14:00:00', '2024-01-16 16:00:00', 28, 1),  -- Afternoon session

-- Room S102 (id=2) reservations
(3, '2024-01-16 09:00:00', '2024-01-16 12:00:00', 45, 2),  -- Morning session
(4, '2024-01-16 13:00:00', '2024-01-16 15:00:00', 40, 2),  -- Afternoon session

-- Room S201 (id=3) reservations
(5, '2024-01-16 10:00:00', '2024-01-16 13:00:00', 90, 3),  -- Large group session

-- Room M101 (id=4) reservations
(6, '2024-01-16 09:00:00', '2024-01-16 11:00:00', 35, 4),
(7, '2024-01-16 15:00:00', '2024-01-16 17:00:00', 38, 4),

-- Some future reservations
(8, '2024-01-17 09:00:00', '2024-01-17 11:00:00', 25, 1),
(9, '2024-01-17 14:00:00', '2024-01-17 16:00:00', 45, 2),
(10, '2024-01-17 10:00:00', '2024-01-17 12:00:00', 85, 3);