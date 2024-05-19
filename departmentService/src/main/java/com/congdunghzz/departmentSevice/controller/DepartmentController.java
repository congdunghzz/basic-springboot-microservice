package com.congdunghzz.departmentSevice.controller;

import com.congdunghzz.departmentSevice.dto.DepartmentRequest;
import com.congdunghzz.departmentSevice.dto.DepartmentResponse;
import com.congdunghzz.departmentSevice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/department")
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    ResponseEntity<List<DepartmentResponse>> getAll(){
        List<DepartmentResponse> departmentResponseList = departmentService.getAll();
        return ResponseEntity.ok(departmentResponseList);
    }

    @GetMapping(value = "{id}")
    ResponseEntity<DepartmentResponse> getById(@PathVariable(value = "id") Integer id){
        System.out.println("DEpartment serive: " + id);
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getById(id));
    }

    @PostMapping
    ResponseEntity<DepartmentResponse> addNew(@RequestBody DepartmentRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(request));

    }
}
