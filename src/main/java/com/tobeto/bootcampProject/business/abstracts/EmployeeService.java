package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.delete.employee.DeleteEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByIdResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByPositionResponse;
import com.tobeto.bootcampProject.business.responses.update.employee.UpdateEmployeeResponse;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;

import java.util.List;

public interface EmployeeService {

    DataResult<CreateEmployeeResponse> createEmployee(CreateEmployeeRequest request);
    DataResult<List<GetAllEmployeeResponse>> getAllEmployee();

    DataResult<GetEmployeeByIdResponse> getEmployeeById(int id);

    DataResult<UpdateEmployeeResponse> updateEmployee(UpdateEmployeeRequest request, int id);

    DataResult<List<GetEmployeeByPositionResponse>> getEmployeeByPosition(String position);

    DataResult<DeleteEmployeeResponse> deleteEmployeeById(int id);


}
