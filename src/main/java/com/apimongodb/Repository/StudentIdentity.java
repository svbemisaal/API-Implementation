package com.apimongodb.Repository;


import com.apimongodb.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentIdentity extends MongoRepository<Student,Integer> {


    Student findById(int id);


}
