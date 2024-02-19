package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.EmployeeService;
import com.tobeto.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.delete.employee.DeleteEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByIdResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByPositionResponse;
import com.tobeto.bootcampProject.business.responses.update.employee.UpdateEmployeeResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataAccess.abstracts.EmployeeRepository;
import com.tobeto.bootcampProject.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapperService mapperService;

    @Override
    public List<GetAllEmployeeResponse> getAllEmployee() {
        List <Employee> employees = employeeRepository.findAll();
        List <GetAllEmployeeResponse> response = employees.stream().map(employee -> mapperService.
                forResponse().map(employee, GetAllEmployeeResponse.class)).collect(Collectors.toList());

        return response;
    }
    @Override
    public GetEmployeeByIdResponse getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        GetEmployeeByIdResponse response = mapperService.forResponse().map(employee, GetEmployeeByIdResponse.class);
        return response;
    }

    @Override
    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest request) {
        Employee employee = mapperService.forRequest().map(request, Employee.class);
        employee.setCreatedDate(LocalDateTime.now());
        employeeRepository.save(employee);

        CreateEmployeeResponse response = this.mapperService.forResponse().map(employee, CreateEmployeeResponse.class);
        return response;
    }

    @Override
    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest request, int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();

        Employee updatedEmployee = mapperService.forRequest().map(request, Employee.class);

        employee.setId(id);
        employee.setUpdatedDate(LocalDateTime.now());
        employee.setFirstName(updatedEmployee.getFirstName() != null ? updatedEmployee.getFirstName() : employee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName() != null ? updatedEmployee.getLastName() : employee.getLastName());
        employee.setUserName(updatedEmployee.getUserName() != null ? updatedEmployee.getUserName() : employee.getUserName());
        employee.setNationalIdentity(updatedEmployee.getNationalIdentity() != null ? updatedEmployee.getNationalIdentity() : employee.getNationalIdentity());
        employee.setDateOfBirth((updatedEmployee.getDateOfBirth() != null ? updatedEmployee.getDateOfBirth() : employee.getDateOfBirth()));
        employee.setPosition(updatedEmployee.getPosition() != null ? updatedEmployee.getPosition() : employee.getPosition());

        employeeRepository.save(employee);
        UpdateEmployeeResponse response = mapperService.forResponse().map(employee, UpdateEmployeeResponse.class);

        return response;
    }

    @Override
    public DeleteEmployeeResponse deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
        DeleteEmployeeResponse response = new DeleteEmployeeResponse("Employee Deleted");
        return response;
    }

    @Override
    public List <GetEmployeeByPositionResponse> getEmployeeByPosition(String position) {
        List<Employee> employees = employeeRepository.findAllByPosition(position);

        List<GetEmployeeByPositionResponse> response = employees.stream()
                .map(employee -> mapperService.forResponse().map(employee, GetEmployeeByPositionResponse.class))
                .collect(Collectors.toList());

        return response;
    }


}
