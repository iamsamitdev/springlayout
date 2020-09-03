package com.itgenius.springbootlayout.service;
import com.itgenius.springbootlayout.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.itgenius.springbootlayout.model.Student;

@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;

    // อ่านข้อมูล Student ทั้งหมด
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    // อ่านข้อมูลตามเลข id
    public Student getOne(Integer id){
        return studentRepository.getOne(id);
    }

    // การเพิ่มและแก้ไขข้อมูล
    public Student save(Student std){
        return studentRepository.save(std);
    }

    // การลบข้อมูล
    public void delete(Student std){
        studentRepository.delete(std);
    }
    
}