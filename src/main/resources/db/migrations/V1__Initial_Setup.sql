CREATE TABLE tb_stack (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE tb_person (
    id VARCHAR(36) PRIMARY KEY,
    sur_name VARCHAR(32) NOT NULL,
    name VARCHAR(100) NOT NULL,
    born_date VARCHAR(10) NOT NULL
);

CREATE TABLE person_stack (
    person_id VARCHAR(36) NOT NULL,
    stack_id UUID NOT NULL,
    PRIMARY KEY (person_id, stack_id),
    FOREIGN KEY (person_id) REFERENCES tb_person(id) ON DELETE CASCADE,
    FOREIGN KEY (stack_id) REFERENCES tb_stack(id) ON DELETE CASCADE
);

CREATE INDEX idx_person_name ON tb_person(name);
CREATE INDEX idx_person_sur_name ON tb_person(sur_name);
CREATE INDEX idx_stack_name ON tb_stack(name);
CREATE INDEX idx_person_stack_person_id ON person_stack(person_id);
CREATE INDEX idx_person_stack_stack_id ON person_stack(stack_id);
