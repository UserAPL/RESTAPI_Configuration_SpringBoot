package in.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.app.entity.Student;

//queries likhne mein help karta hai

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Student findByName(String name);
	

}
