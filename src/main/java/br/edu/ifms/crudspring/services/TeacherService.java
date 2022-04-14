package br.edu.ifms.crudspring.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Teacher;
import br.edu.ifms.crudspring.repository.TeacherRepository;

@Service
public class TeacherService {
    
    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();

    }
    public void save(Teacher teacher){
    teacherRepository.save(teacher);
    }

    public void deleteById(UUID id){
        teacherRepository.deleteById(id);
    }

    public Teacher findById(UUID id){
        return teacherRepository.findById(id).get();
    }
    public void updateTeacher(Teacher teacher){
        teacherRepository.save(teacher);
   
               
           
   
       }
       
}
