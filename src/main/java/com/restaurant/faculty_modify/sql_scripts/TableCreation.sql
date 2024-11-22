USE employees_courses_2;
create table courses (
                         capacity integer not null,
                         course_id integer not null,
                         credits integer not null,
                         year integer not null,
                         course_code varchar(255) not null,
                         description varchar(255) not null,
                         faculty varchar(255) not null,
                         name varchar(255) not null,
                         term varchar(255) not null,
                         primary key (course_id)
) ;
create table courses_seq (
                             next_val bigint
);
create table department (
                            capacity integer not null,
                            department_id integer not null,
                            name varchar(255) not null,
                            primary key (department_id)
);
create table employee (
                          department integer,
                          employee_id integer not null,
                          email varchar(255) not null,
                          first_name varchar(255) not null,
                          last_name varchar(255) not null,
                          password varchar(255) not null,
                          photograph_path varchar(255),
                          title varchar(255),
                          primary key (employee_id)
);

create table faculty_courses (
                                 course_id integer not null,
                                 faculty_id integer not null,
                                 id integer not null,
                                 primary key (id)
)