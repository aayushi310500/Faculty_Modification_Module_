USE employees_courses_3;

INSERT INTO department (department_id, name, capacity) VALUES
                                                           (1, 'Computer Science', 100),
                                                           (2, 'Mathematics', 80),
                                                           (3, 'Physics', 50),
                                                           (4, 'Chemistry', 60),
                                                           (5, 'Business Administration', 70);


INSERT INTO employee(employee_id, first_name, last_name, email, title, photograph_path, department,password) VALUES
 (1, 'Alice', 'Smith', 'alicesmith@example.com', 'Professor', '/images/employees/alice_smith.jpg', 1,"$2a$10$As1r89LkxmONRwvfHUSH8eC1ezI5Y2F35II0Dq2JbW3IZdQgylGJO"),
 (2, 'Bob', 'Johnson', 'bobjohnson@example.com', 'Lecturer', '/images/employees/bob_johnson.jpg', 2, "$2a$10$vDM4bHGey4tgh8TKU9ifVuNITZVK3mbJmnVv4mbLtvOvK5KZ6mmTe"),
 (3, 'Charlie', 'Brown', 'charliebrown@example.com', 'Senior Lecturer', '/images/employees/charlie_brown.jpg', 3,  "$2a$10$JZuxI/GTHhbxAfGqOoM.huXW6lRoULzxOkpgUMjY9dUq8r3qVhC1i"),
 (4, 'Diana', 'Wilson', 'dianawilson@example.com', 'Assistant Professor', '/images/employees/diana_wilson.jpg', 1, "$2a$10$ySccge/.pDmpAXqv2b2pCuNDxGTFjWd6DBFOb0wVqLKbidIfflz72"),
 (5, 'Edward', 'Taylor', 'edwardtaylor@example.com', 'Associate Professor', '/images/employees/edward_taylor.jpg', 4, "$2a$10$.R/B5MBdMdDcmF6FDfNaYezPPx4d2JVeDK4CpCXiywV2P/ki7iinG"),
 (6, 'Fiona', 'Clark', 'fionaclark@example.com', 'Lecturer', '/images/employees/fiona_clark.jpg', 5,  "$2a$10$HEJmBnLKENsuiPgAZuDD2eTh1VjuMQInA3Fbv/PImpFTQWpNcyrs2"),
 (7, 'George', 'Martin', 'georgemartin@example.com', 'Professor', '/images/employees/george_martin.jpg', 3, "$2a$10$yZ8Yseoo/vUbS873Yns55.yweloSJD.Szwo14nFpIA97lRX6uX1SO"),
 (8, 'Hannah', 'Lee', 'hannahlee@example.com', 'Assistant Professor', '/images/employees/hannah_lee.jpg', 2, "$2a$10$YfkKQ31MeQoiODNuW/61KO99nxgkshmVt1puUEX5nmQf0SUK3dL9K"),
 (9, 'Ian', 'Walker', 'ianwalker@example.com', 'Lecturer', '/images/employees/ian_walker.jpg', 1, "$2a$10$gLV428CYvjAOHMqwpv667u.MjtPi3ke/Fug0EwzxFRiHz2mQJ7FzW"),
 (10, 'Julia', 'Adams', 'juliaadams@example.com', 'Senior Lecturer', '/images/employees/julia_adams.jpg', 5,  "$2a$10$gLV428CYvjAOHMqwpv667u.MjtPi3ke/Fug0EwzxFRiHz2mQJ7FzW");





INSERT INTO faculty_courses(id, faculty_id, course_id) VALUES
     (1, 1, 1),   -- Alice Smith teaching CS101
     (2, 1, 9),   -- Alice Smith teaching CS401
     (3, 4, 2),   -- Diana Wilson teaching CS201
     (4, 2, 3),   -- Bob Johnson teaching MATH101
     (5, 8, 4),   -- Hannah Lee teaching MATH201
     (6, 3, 5),   -- Charlie Brown teaching PHYS101
     (7, 3, 10),  -- Charlie Brown teaching PHYS201
     (8, 5, 6),   -- Edward Taylor teaching CHEM101
     (9, 6, 7),   -- Fiona Clark teaching BUS101
     (10, 7, 8);  -- George Martin teaching CS301





INSERT INTO courses (course_id, course_code, name, description, year, term, faculty, credits, capacity) VALUES
      (1, 'CS101', 'Introduction to Programming', 'Learn basic programming concepts using Python.', 2024, 'Fall', 'Alice Smith', 3, 40),
      (2, 'CS201', 'Data Structures and Algorithms', 'Understand and implement various data structures.', 2024, 'Spring', 'Diana Wilson', 4, 30),
      (3, 'MATH101', 'Calculus I', 'An introduction to differential and integral calculus.', 2024, 'Fall', 'Bob Johnson', 3, 50),
      (4, 'MATH201', 'Linear Algebra', 'Explore vector spaces, matrices, and linear transformations.', 2024, 'Spring', 'Hannah Lee', 3, 40),
      (5, 'PHYS101', 'Mechanics', 'Fundamentals of classical mechanics.', 2024, 'Fall', 'Charlie Brown', 4, 20),
      (6, 'CHEM101', 'Organic Chemistry', 'Introduction to organic molecules and reactions.', 2024, 'Spring', 'Edward Taylor', 4, 25),
      (7, 'BUS101', 'Principles of Management', 'Basic principles and practices in management.', 2024, 'Fall', 'Fiona Clark', 3, 50),
      (8, 'CS301', 'Operating Systems', 'Dive into the design and implementation of operating systems.', 2024, 'Spring', 'George Martin', 4, 30),
      (9, 'CS401', 'Artificial Intelligence', 'Introduction to AI concepts and applications.', 2024, 'Fall', 'Alice Smith', 4, 20),
      (10, 'PHYS201', 'Quantum Physics', 'Study the principles of quantum mechanics.', 2024, 'Spring', 'Charlie Brown', 4, 15);


