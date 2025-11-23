package in.app.service;

import java.util.List;

import in.app.DTO.StudentDTO;
import in.app.DTO.StudentDTO_1;
import in.app.entity.Student;

public interface StudentService {
	
	List<StudentDTO> getAllStudents(); //method1

	StudentDTO getId(Long id); //method2

	StudentDTO createNewStudent(StudentDTO_1 studentDTO_1);  //post-map-method-application

	void deleteStudentByID(Long id);

	StudentDTO updateStudentByID(Long id, StudentDTO_1 studentDTO_1);

	
	


}
