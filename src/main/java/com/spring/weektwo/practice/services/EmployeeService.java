package com.spring.weektwo.practice.services;

import com.spring.weektwo.practice.dtos.EmployeeDTO;
import com.spring.weektwo.practice.entities.Employee;
import com.spring.weektwo.practice.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow();
        return modelMapper.map(employee,EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees
                .stream().
                map(employee -> modelMapper.map(employee,EmployeeDTO.class))
                .toList();
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        Employee employee = modelMapper.map(employeeDTO,Employee.class);
        Employee saved = employeeRepository.save(employee);
        return modelMapper.map(saved,EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long id, EmployeeDTO employeeDTO){
        Employee employee = modelMapper.map(employeeDTO,Employee.class);
        employee.setId(id);
        Employee save = employeeRepository.save(employee);
        return modelMapper.map(save,EmployeeDTO.class);
    }

    public Boolean deleteEmployeeById(Long id){
        if(!employeeRepository.existsById(id)) return false;
        employeeRepository.deleteById(id);
        return true;
    }


}
