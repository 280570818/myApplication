package swing.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import swing.sys.model.Student;
import swing.sys.service.StudentService;

@Controller
@Scope(value="prototype")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/save.html")
	public String save (Student student){
		studentService.save(student);
		return "success";
	}
	
	@RequestMapping(value="/registUI.html")
	public String registUI (){
		return "regist";
	}
}
