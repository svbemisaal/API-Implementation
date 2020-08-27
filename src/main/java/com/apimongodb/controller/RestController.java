package com.apimongodb.controller;


import com.apimongodb.model.Student;
import com.apimongodb.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping ("/student")
@Slf4j
public class RestController {

    public static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);

    @Autowired
    StudentService studentService;


    @RequestMapping(value = "/info",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public  String create(@RequestBody Student student)
    {
             LOGGER.info("The data is {}",student);
           return studentService.SaveStudent(student);
    }


    @RequestMapping (value = "/info/{id}",method = RequestMethod.GET)
    public  Student getById(@PathVariable int id)
    {
        LOGGER.info("The id is {}",id);
        return studentService.getStudent(id);
    }


    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public List<Student> getAll()
    {
        LOGGER.info("The data from the db for all the enteries is ");
        return studentService.getAllStudent();
    }

    @RequestMapping(value = "/info/{id}",method = RequestMethod.DELETE)
    public  String update(@PathVariable int id)
    {
        LOGGER.info("The data is {}",id);
        return studentService.deleteStudent(id);
    }


    @RequestMapping(value = "/info",method = RequestMethod.PUT)
    public  String updateStudent(@RequestBody Student student)
    {
        LOGGER.info("The data is {}",student);
        return studentService.updateStudent(student);
    }
}
