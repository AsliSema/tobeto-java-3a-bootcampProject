package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByIdResponse;

import java.util.List;

public interface EmployeeService {
    List<GetAllEmployeeResponse> getAllEmployee();

    GetEmployeeByIdResponse getEmployeeById(int id);
    CreateEmployeeResponse createEmployee(CreateEmployeeRequest request);

}
