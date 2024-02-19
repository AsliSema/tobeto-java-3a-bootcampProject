package com.tobeto.bootcampProject.webApi.controllers;

import com.tobeto.bootcampProject.business.abstracts.EmployeeService;
import com.tobeto.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.delete.employee.DeleteEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByIdResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByPositionResponse;
import com.tobeto.bootcampProject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampProject.business.responses.update.employee.UpdateEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public GetEmployeeByIdResponse getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public CreateEmployeeResponse createEmployee(@RequestBody CreateEmployeeRequest request){
        return employeeService.createEmployee(request);
    }

    @GetMapping
    public List<GetAllEmployeeResponse> getAllEmployee(){
        return employeeService.getAllEmployee();
    }


    @PutMapping("/{id}")
    public UpdateEmployeeResponse updateEmployee(@RequestBody UpdateEmployeeRequest request,@PathVariable int id){
        return employeeService.updateEmployee(request, id);
    }

    @DeleteMapping("/{id}")
    public DeleteEmployeeResponse deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/position/{position}")
    public List <GetEmployeeByPositionResponse> getEmployeesByPosition(@PathVariable String position){
        return  employeeService.getEmployeeByPosition(position);
    }
}
