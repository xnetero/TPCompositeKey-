package org.example.services;

import org.example.mappers.StudentMapper;
import org.example.models.StudentDTO;
import org.example.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("service1")
public class StudentServiceImpl implements StudentService {
    private final static Logger LOGGER= LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    public StudentServiceImpl(@Qualifier("repo1") StudentRepository studentRepository, @Qualifier("mapper1") StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public Long save(StudentDTO dto) {
        LOGGER.debug("start method save");

       StudentDTO result= studentMapper.studentEntityToDto(studentRepository.save(studentMapper.studentDtoToEntity(dto)));
        return result.getId();
    }

    @Override
    public Long update(StudentDTO dto) {
        LOGGER.debug("start method update");
        StudentDTO result= studentMapper.studentEntityToDto(studentRepository.save(studentMapper.studentDtoToEntity(dto)));
        return result.getId();

    }

    @Override
    public Boolean delete(Long id) {
        LOGGER.debug("start method delete");
         studentRepository.deleteById(id);
        return true;
    }

    @Override
    public List<StudentDTO> selectAll() {
        LOGGER.debug("start method select All");
        return studentMapper.studentEntiesToDtos(studentRepository.findAll());
    }
}
