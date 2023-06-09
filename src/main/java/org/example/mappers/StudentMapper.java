package org.example.mappers;

import org.example.entities.StudentEntity;
import org.example.entities.StudentId;
import org.example.models.StudentDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component(value = "mapper1")
public class StudentMapper {



    public StudentEntity studentDtoToEntity(StudentDTO dto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(new StudentId(dto.getId(),""));
        studentEntity.setName(dto.getName());
        return studentEntity;
    }

    public StudentDTO studentEntityToDto(StudentEntity studentEntity) {
        StudentDTO dto = new StudentDTO();
        dto.setId(studentEntity.getStudentId().getId());
        dto.setName(studentEntity.getName());
        return dto;
    }

    public List<StudentDTO> studentEntiesToDtos(List<StudentEntity> studentEntities) {
        if(studentEntities!=null&&!studentEntities.isEmpty()){
            return studentEntities.stream().map(studentEntity -> studentEntityToDto(studentEntity)).collect(Collectors.toList());
        }else {
            return new ArrayList<>();
        }
    }
}
