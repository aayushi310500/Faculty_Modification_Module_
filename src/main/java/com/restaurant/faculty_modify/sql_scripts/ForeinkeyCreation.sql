USE employees_courses_3;
ALTER TABLE employee
    ADD CONSTRAINT fk_department
        FOREIGN KEY (department)
            REFERENCES department(department_id)
            ON DELETE SET NULL
            ON UPDATE CASCADE;


ALTER TABLE faculty_courses
    ADD CONSTRAINT fk_faculty
        FOREIGN KEY (faculty_id)
            REFERENCES employee(employee_id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE faculty_courses
    ADD CONSTRAINT fk_course
        FOREIGN KEY (course_id)
            REFERENCES courses(course_id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;
#
# alter table employee
#     add constraint UKfopic1oh5oln2khj8eat6ino0 unique (email);