package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.delete.employee.DeleteEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByIdResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByPositionResponse;
import com.tobeto.bootcampProject.business.responses.update.employee.UpdateEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<GetAllEmployeeResponse> getAllEmployee();

    GetEmployeeByIdResponse getEmployeeById(int id);
    CreateEmployeeResponse createEmployee(CreateEmployeeRequest request);

    UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest request, int id);

    DeleteEmployeeResponse deleteEmployeeById(int id);

    List <GetEmployeeByPositionResponse> getEmployeeByPosition(String position);

}
