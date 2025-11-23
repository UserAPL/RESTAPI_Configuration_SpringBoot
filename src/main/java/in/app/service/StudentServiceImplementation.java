package in.app.service;

import java.util.List;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import in.app.DTO.StudentDTO;
import in.app.DTO.StudentDTO_1;
import in.app.entity.Student;
import in.app.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;

//iss class ka kam hai business logic likhna


@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService{
	
	private static final Object StudentDTO_1 = null;
	//persistence layer se baat karegi
	
	
	
	private final StudentRepository studentRepository;
	private final ModelMapper modelMapper;
	

@Override
    public List<StudentDTO> getAllStudents() {     //method 1 implementation
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .toList();
    }

	
	@Override
    public StudentDTO getId(Long id) {    //method 2 implementation
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + id));
        return modelMapper.map(student, StudentDTO.class);
    }


	@Override
	public StudentDTO createNewStudent(StudentDTO_1 studentDTO_1) {
		Student newStudent = modelMapper.map(studentDTO_1, Student.class);
		Student saved = studentRepository.save(newStudent);
		return modelMapper.map(saved, StudentDTO.class);
	}


	@Override
	public void deleteStudentByID(Long id) {
		
		if(!studentRepository.existsById(id))
			throw new IllegalArgumentException("Student does not exits"+id);
		studentRepository.deleteById(id);
		
		
	}


	@Override
	public StudentDTO updateStudentByID(Long id, StudentDTO_1 studentDTO_1) {
		Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + id));
		modelMapper.map(studentDTO_1, student); //saraka sara chize studentDTO_1 seh Student(orStudent.class) peh daldo
		student=studentRepository.save(student); //update ko save karna
		return modelMapper.map(student,StudentDTO.class); //updated student ko daldena 
		
	} 



}

