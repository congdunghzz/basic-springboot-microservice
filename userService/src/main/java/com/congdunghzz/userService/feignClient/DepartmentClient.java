package com.congdunghzz.userService.feignClient;

import com.congdunghzz.userService.dto.DepartmentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "DEPARTMENT-SERVICE", path = "/api/v1/department")
public interface DepartmentClient {
    @GetMapping("/{id}")
    DepartmentResponse getDepartmentById(@PathVariable("id") int id);
}
