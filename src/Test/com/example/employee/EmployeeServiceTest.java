package com.example.employee;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Test
    void shouldAddEmployee() {

        EmployeeRepository repository = mock(EmployeeRepository.class);

        EmployeeService service = new EmployeeService(repository);

        Employee employee =
                new Employee("John", "john@gmail.com", "IT");

        service.addEmployee(employee);

        verify(repository, times(1)).save(employee);
    }
}
