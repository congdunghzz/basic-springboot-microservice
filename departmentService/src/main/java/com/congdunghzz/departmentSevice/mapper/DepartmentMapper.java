package com.congdunghzz.departmentSevice.mapper;

import com.congdunghzz.departmentSevice.dto.DepartmentResponse;
import com.congdunghzz.departmentSevice.model.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentMapper {
    public DepartmentResponse convertToDepartmentResponse(Department department){
        return new DepartmentResponse(department.getId(), department.getName(), department.getAddress());
    }
}
