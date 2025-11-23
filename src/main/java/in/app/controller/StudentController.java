package in.app.controller;

import in.app.DTO.*;

import java.net.http.HttpHeaders;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.app.DTO.StudentDTO;
//import in.app.repository.StudentRepository;
import in.app.service.StudentService;

//api bana rehe honge

@RestController
public class StudentController<Student> {

    

	
	private StudentService studentService; //StudentService seh baat karwayega taki uske through access mile
	
	public StudentController(StudentService studentService) {
		
		this.studentService=studentService;
	}
//	@GetMapping("/students")
//	public List<StudentDTO> getStudent()
//	{
//		return  studentService.getAllStudents();
//		
//	}
//	@GetMapping("/students/{id}")
//	public StudentDTO getStudent(@PathVariable  Long id)
//	{
//		return  studentService.getId(id);
//		
//	}
	
	
	@GetMapping("/students")
	public ResponseEntity<StudentDTO> getStudent()
	{
		Student s=(Student) studentService.getAllStudents();
		
		return (ResponseEntity<StudentDTO>) ResponseEntity.status(200).body(s);
	}
	
	
//	@PostMapping("/students")
//	public ResponseEntity<StudentDTO> createStudent(@Validated @RequestBody StudentDTO_1 studentDTO_1)
//	{
//		return (ResponseEntity<StudentDTO>)ResponseEntity.status(HttpStatus.CREATED)
//				.body(studentService.createNewStudent(studentDTO_1));
//	
//	}
	
	

	@PostMapping("/students")
	public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO_1 studentDTO_1) {
		StudentDTO studentDTO = studentService.createNewStudent(studentDTO_1);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentDTO);
	}
	
	
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id)
	{
		studentService.deleteStudentByID(id);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id,@RequestBody StudentDTO_1 studentDTO_1 )
	{   
		
		return ResponseEntity.ok(studentService.updateStudentByID(id,studentDTO_1));
	}
	
	
//	@GetMapping("/student")
//	public List<Student> getStudent()
//	{
//		return (List<Student>) studentRepository.findAll();
//	}




//	@GetMapping("/student")
//	public StudentDTO getDetails() {
//		return new StudentDTO(10,"Arna","example@gmail.com");
//	}
//	
	

}
