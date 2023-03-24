package org.example.services;

import org.example.models.StudentDTO;

import java.util.List;

public interface StudentService {
    Long save(StudentDTO s);

    Long update(StudentDTO s);

    Boolean delete(Long id);

    List<StudentDTO> selectAll();
}
