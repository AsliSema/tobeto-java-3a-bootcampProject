package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByIdResponse;

public interface EmployeeService {
    GetEmployeeByIdResponse getEmployeeById(int id);
    CreateEmployeeResponse createEmployee(CreateEmployeeRequest request);
}
