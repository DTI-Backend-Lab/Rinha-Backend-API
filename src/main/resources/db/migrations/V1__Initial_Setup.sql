CREATE TABLE tb_person (
                           id VARCHAR(36) PRIMARY KEY,
                           sur_name VARCHAR(32) NOT NULL,
                           name VARCHAR(100) NOT NULL,
                           born_date VARCHAR(10) NOT NULL,
                           stack TEXT
);

CREATE INDEX idx_person_name ON tb_person(name);
CREATE INDEX idx_person_sur_name ON tb_person(sur_name);
CREATE INDEX idx_person_stack ON tb_person(stack);


CREATE TABLE person_stack (
                                 person_id VARCHAR(36) NOT NULL,
                                 stack VARCHAR(50) NOT NULL,
                                 FOREIGN KEY (person_id) REFERENCES tb_person(id) ON DELETE CASCADE
);

CREATE INDEX idx_person_stack_value ON person_stack(stack);
