package br.edu.ifms.crudspring.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.model.Teacher;
import br.edu.ifms.crudspring.services.TeacherService;

@Controller
@RequestMapping("/teacher")

public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping ("/")
    public String save(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.save(teacher);
        return "redirect:/teacher/";
    }

    @GetMapping("/")
    public String locAll(Model model) {
        List<Teacher> teachers = teacherService.getTeachers();
        model.addAttribute("teachers", teachers);
        return "indexTeacher";
    }

    @GetMapping("/cadastrarTeacher")
    public String newTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "cadastrarTeacher";


    }
    @GetMapping("/remove/{id}")
  public String deleteTeacher(@PathVariable("id") UUID id)
  {
      teacherService.deleteById(id);
      return "redirect:/teacher/";
      
  }
// para chamar a pagina de edit-teacher.html
 @GetMapping("/edit/{id}")
 public String editTeacher (@PathVariable("id") UUID id, Model model){
     Teacher teacher = teacherService.findById(id);
     model.addAttribute("teacher", teacher);
     return "edit-teacher";
 } 

 //aqui chama a função para dar uptade no aluno vulgo editar
 @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") UUID id, @ModelAttribute Teacher teacher){
        teacherService.save(teacher);

        return "redirect:/teacher/";
 
    }
 

}