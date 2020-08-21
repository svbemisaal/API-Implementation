package com.apimongodb.Sevice;

import com.apimongodb.Controller.RestController;
import com.apimongodb.Model.Student;
import com.apimongodb.Repository.StudentIdentity;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {

    private final StudentIdentity studentIdentity;

    public static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);



    public StudentService (StudentIdentity studentIdentity)
    {
        this.studentIdentity=studentIdentity;
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
        List<Student> student= studentIdentity.findAll();

        LOGGER.info("The student value is {}",student);
        return  student;
    }



    public String deleteStudent(int id)
    {
        String done=null;

        studentIdentity.deleteById(id);

        LOGGER.info("The id of student  is {}",id);

        return "The student with id "+id+"is deleted";

    }


    public String updateStudent(Student student) {

        studentIdentity.save(student);

        return "db updated with new entry";
    }


}
