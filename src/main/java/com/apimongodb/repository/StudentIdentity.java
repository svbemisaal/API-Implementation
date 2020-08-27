package com.apimongodb.repository;


import com.apimongodb.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentIdentity extends MongoRepository<Student,Integer> {


    Student findById(int id);


}
