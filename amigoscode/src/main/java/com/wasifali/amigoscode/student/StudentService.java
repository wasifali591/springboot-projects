package com.wasifali.amigoscode.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional= studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email is taken!");
        }else{
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (exists){
            studentRepository.deleteById(studentId);
        }else{
            throw new IllegalStateException("Student with id " + studentId + " is not exists!");
        }
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email){
        Student student = studentRepository.findById(studentId).orElseThrow(
                ()-> new IllegalStateException("Student with Id " + studentId + " does not exists!")
        );

        if (name != null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if (email != null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Email is taken!");
            }
            student.setEmail(email);
        }
        System.out.println("start");
        System.out.println(student);
        studentRepository.save(student);
        System.out.println("end");
    }
}
