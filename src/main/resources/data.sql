DROP TABLE IF EXISTS STUDENTS;

CREATE TABLE STUDENTS (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              name VARCHAR(250) NOT NULL,
                              email VARCHAR(250) NOT NULL,
                              phoneNo VARCHAR(250) DEFAULT NULL
);

INSERT INTO STUDENTS (name, email, phoneNo) VALUES
('Jean', 'jeanmelvinlp27@gmail.com', '829-817-9117');