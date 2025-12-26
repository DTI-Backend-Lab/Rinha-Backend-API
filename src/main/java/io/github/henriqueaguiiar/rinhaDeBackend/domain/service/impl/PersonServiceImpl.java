package io.github.henriqueaguiiar.rinhaDeBackend.domain.service.impl;

import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.PersonInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output.PersonOutputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.mapper.PersonMapper;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.repository.PersonRepository;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;

    }

    @Override
    public PersonOutputDTO createPerson(PersonInputDTO personInputDTO) {
       var personDatabase =  PersonMapper.toEntity(personInputDTO);
       personRepository.save(personDatabase);
       return PersonMapper.toOutputDTO(personDatabase);

    }
}
