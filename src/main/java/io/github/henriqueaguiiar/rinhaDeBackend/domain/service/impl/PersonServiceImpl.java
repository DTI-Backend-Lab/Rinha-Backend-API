package io.github.henriqueaguiiar.rinhaDeBackend.domain.service.impl;

import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.PersonInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output.PersonOutputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.exception.CreatePersonException;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.exception.PersonNotFoundException;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.mapper.PersonMapper;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.model.Person;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.repository.PersonRepository;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.service.PersonService;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.service.validation.ValidateInputPersonStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service responsavel por realizar as operações dos endpoints de Person. Evitando Expor Repository
 * @author Henrique Pacheco
 * @version 1.1.0
 */

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final List<ValidateInputPersonStrategy> validateInputPersonStrategies;

    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper, List<ValidateInputPersonStrategy> validateInputPersonStrategies) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
        this.validateInputPersonStrategies = validateInputPersonStrategies;
    }

    @Override
    public PersonOutputDTO createPerson(PersonInputDTO personInputDTO) {
            validateInputPerson(personInputDTO);
            var personDatabase =  personMapper.toEntity(personInputDTO);
            log.info("Salvando nova pessoa. ID: {}", personDatabase.getId());
            personRepository.save(personDatabase);
            return personMapper.toOutputDTO(personDatabase);
    }


    @Override
    public List<PersonOutputDTO> getAllPerson(){
        List<Person> persons = personRepository.findAll();
        List<PersonOutputDTO> personOutputDTOList = new ArrayList<>();
        for(Person person : persons){
            personOutputDTOList.add(personMapper.toOutputDTO(person));
        }
        log.info("Recuperando todas as pessoas.  {}", personOutputDTOList);
        return  personOutputDTOList;
    }

    @Override
    public List<PersonOutputDTO> getAllByTerm(String term) {
        List<Person> personList = personRepository.search(term.toLowerCase());
        List<PersonOutputDTO> personOutputDTOList = new ArrayList<>();
        for(Person person : personList){
            personOutputDTOList.add(personMapper.toOutputDTO(person));
        }
        log.info("Recuperando todas as pessoas com o termo {}. {}",term, personOutputDTOList);
        return personOutputDTOList;
    }


    @Override
    public PersonOutputDTO getPersonById(String id){
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Pessoa Não Encontrada com este Id"));
        log.info("Recuperando pessoa com o ID: {}. {}", id, person);
        return personMapper.toOutputDTO(person);
    }

    @Override
    public PersonOutputDTO atualizarPerson(PersonInputDTO personInputDTO, String id) {
        Person person = personMapper.toEntity(personInputDTO);

        Person personExist = personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException("Pessoa Não Encontrada com este Id"));
        personExist.setName(person.getName());
        personExist.setSurName(person.getSurName());
        personExist.setBornDate(person.getBornDate());
        personExist.setStack(person.getStack());
        personRepository.save(personExist);
        log.info("Atualizando pessoa com o ID: {}. {}", id, personExist);
        return personMapper.toOutputDTO(personExist);
    }


    @Override
    public PersonOutputDTO atualizarItemPerson(String id, PersonInputDTO personInputDTO) {
        Person personExist = personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException("Pessoa Não Encontrada com este Id"));

        if(personInputDTO.getName() != null){
            personExist.setName(personInputDTO.getName());
        }
        if(personInputDTO.getSurName() != null){
            personExist.setSurName(personInputDTO.getSurName());
        }

        if(personInputDTO.getBornDate() != null){
            personExist.setBornDate(personInputDTO.getBornDate());
        }

        if(personInputDTO.getStack() != null){
            personExist.setStack(personInputDTO.getStack());
        }

        personRepository.save(personExist);
        log.info("Atualizando pessoa com o ID: {}. {}", id, personExist);
        return personMapper.toOutputDTO(personExist);
    }

    @Override
    public void deletarPerson(String id) {
        Person person = personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException("Pessoa Não Encontrada com este Id"));
        personRepository.delete(person);
        log.info("Deletando pessoa com o ID: {}. {}", id, person);
    }

    @Override
    public Integer contagemPessoas() {
        List<PersonOutputDTO> allPerson = getAllPerson();
        log.info("Contagem total de pessoas: {}", allPerson.size());
        return allPerson.size();
    }
    /**
     *Metodo para validar o input de DTO para POST/Criação de Recurso Person utilizando Patter Strategy .
     *Classes de validação dentro do package validation
     * @param personInputDTO
     *
     */
    @Override
    public void  validateInputPerson(PersonInputDTO personInputDTO){
        for(ValidateInputPersonStrategy strategy : validateInputPersonStrategies){
            strategy.validateInputPerson(personInputDTO);
        }
    }
}
