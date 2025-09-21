package net.guides.springboot2.springboot2jpacrudexample.service;


import org.springframework.stereotype.Service;

import net.guides.springboot2.springboot2jpacrudexample.model.Department;
import net.guides.springboot2.springboot2jpacrudexample.repository.DepartMentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartMentRepo departmentRepository;

    public DepartmentService(DepartMentRepo departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // Create
    public Department createDepartment(Department department) {
    	
    	Department dept=departmentRepository.findByNameAndLocation(department.getName(), department.getLocation());
    	if(dept==null)    	
        return departmentRepository.save(department);
    	
    	dept.setDescription(department.getDescription());
    	return departmentRepository.save(dept);
    	
    }

    // Read all
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Read by id
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    // Update
    public Department updateDepartment(Long id, Department departmentDetails) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id " + id));

        department.setName(departmentDetails.getName());
        department.setLocation(departmentDetails.getLocation());
        department.setDescription(departmentDetails.getDescription());

        return departmentRepository.save(department);
    }

    // Delete
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
