package com.apimongodb.Controller;


import com.apimongodb.Model.Student;
import com.apimongodb.Sevice.StudentService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@org.springframework.web.bind.annotation.RestController
@RequestMapping ("/student")
@Slf4j
public class RestController {

    public static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);

    @Autowired
    StudentService studentService;


    @RequestMapping(value = "/save",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public  String create(@RequestBody Student student)
    {
             LOGGER.info("The data is {}",student);
           return studentService.SaveStudent(student);
    }


    @GetMapping(value = "/save/{id}")
    public  Student getById(@PathVariable int id)
    {
        LOGGER.info("The id is {}",id);
        return studentService.getStudent(id);
    }


    @GetMapping(value = "/getAll")
    public List<Student> getAllById( )
    {
        LOGGER.info("The id is");
        return studentService.getAllStudent();
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public  String update(@PathVariable int id)
    {
        LOGGER.info("The data is {}",id);
        return studentService.deleteStudent(id);
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public  String updateStudent(@RequestBody Student student)
    {
        LOGGER.info("The data is {}",student);
        return studentService.updateStudent(student);
    }
}
