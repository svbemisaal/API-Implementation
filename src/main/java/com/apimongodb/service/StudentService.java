package com.apimongodb.service;

import com.apimongodb.controller.RestController;
import com.apimongodb.model.Student;
import com.apimongodb.repository.StudentIdentity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentService {

    private final StudentIdentity studentIdentity;

   // private  final RedisTemplate redisTemplate;

    public static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);



    public StudentService (StudentIdentity studentIdentity,RedisTemplate redisTemplate)
    {
        this.studentIdentity=studentIdentity;
     //   this.redisTemplate=redisTemplate;
    }



    public String SaveStudent(Student student)
    {
        String done=null;

        try{

            studentIdentity.save(student);



            done ="data saved in database";
        }
        catch (Exception e)
        {
            done=e.getMessage();

        }

        return done;
    }


    public Student getStudent(int id)
    {
            String done=null;

            Student student= studentIdentity.findById(id);

            LOGGER.info("The student value is {}",student);


        return student;
    }



    public List<Student> getAllStudent()
    {
        String done=null;

        List<Student> student =studentIdentity.findAll();

        LOGGER.info("The student value is {}");
        return  student;
    }



    public String deleteStudent(int id)
    {
        String done=null;

        studentIdentity.deleteById(id);

        LOGGER.info("The id of student  is {}",id);

        return "The student with id " +id + " is deleted";

    }


    public String updateStudent(Student student) {
        studentIdentity.save(student);

        return "db updated with new entry";
    }


}
