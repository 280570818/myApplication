package swing.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swing.sys.mapper.StudentMapper;
import swing.sys.model.Student;

@Service
public class StudentService {
	@Autowired
	private StudentMapper studentMapper;
	
	public void save(Student s) {
		studentMapper.save(s);
	}

}
