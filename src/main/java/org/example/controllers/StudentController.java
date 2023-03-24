package org.example.controllers;

import org.example.models.StudentDTO;
import org.example.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final static Logger LOGGER= LoggerFactory.getLogger(StudentController.class);


    private StudentService studentService;

    public StudentController(@Qualifier("service1") StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Long save(  @RequestBody StudentDTO dto) {
        LOGGER.debug("start method save");
        return studentService.save(dto);
    }

    @PutMapping
    public Long update(  @RequestBody  StudentDTO dto) {
        LOGGER.debug("start method update");
        return studentService.update(dto);
    }

    @DeleteMapping("/{ids}")
    public Boolean delete( @PathVariable("ids")  Long id) {
        LOGGER.debug("start method delete");
        return studentService.delete(id);
    }

    @GetMapping
    public List<StudentDTO> selectAll() {
        LOGGER.debug("start method select All");
        return studentService.selectAll();
    }

}
