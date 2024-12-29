INSERT INTO lecture (id,name, professor, lecture_date, max_capacity, current_capacity, created_at, updated_at)
VALUES
    ('1','Spring Boot Basics', 'Dr. Smith', '2024-01-01', 30, 25, NOW(), NOW()),
    ('2','Advanced Hibernate', 'Prof. Johnson', '2024-01-15', 30, 27, NOW(), NOW()),
    ('3','REST API Development', 'Ms. Lee', '2024-02-10', 30, 0, NOW(), NOW());


 INSERT INTO student (id, name,tot_lecture_join,created_at, updated_at)
  VALUES
      ('1', 'a',0,NOW(), NOW()),
      ('2', 'b',0,NOW(), NOW()),
      ('3', 'c',0,NOW(), NOW()),
      ('4', 'd',0,NOW(), NOW());


