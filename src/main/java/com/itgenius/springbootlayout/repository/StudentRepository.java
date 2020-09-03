package com.itgenius.springbootlayout.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.itgenius.springbootlayout.model.Student;
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}
