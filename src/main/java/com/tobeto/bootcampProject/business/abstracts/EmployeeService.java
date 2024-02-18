package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByIdResponse;

public interface EmployeeService {
    GetEmployeeByIdResponse getEmployeeById(int id);
}
