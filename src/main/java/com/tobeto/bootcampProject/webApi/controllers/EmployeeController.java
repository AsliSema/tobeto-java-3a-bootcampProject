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
import com.tobeto.bootcampProject.core.entities.BaseEntity;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController extends BaseController{
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id){
        return handleDataResult(employeeService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody CreateEmployeeRequest request){
        return handleDataResult(employeeService.createEmployee(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployee(){
        return handleDataResult(employeeService.getAllEmployee());
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody UpdateEmployeeRequest request,@PathVariable int id){
        return handleDataResult(employeeService.updateEmployee(request, id));
    }

    @DeleteMapping("/{id}")
    public DeleteEmployeeResponse deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<?> getEmployeesByPosition(@PathVariable String position){
        return handleDataResult(employeeService.getEmployeeByPosition(position));
    }
}
