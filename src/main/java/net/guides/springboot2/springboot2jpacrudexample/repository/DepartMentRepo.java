package net.guides.springboot2.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Department;

@Repository
public interface DepartMentRepo extends JpaRepository<Department, Long> {
	
	public Department findByNameAndLocation(String name, String location);

}
