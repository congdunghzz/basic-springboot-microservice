package com.congdunghzz.departmentSevice.service;

import com.congdunghzz.departmentSevice.dto.DepartmentRequest;
import com.congdunghzz.departmentSevice.dto.DepartmentResponse;
import com.congdunghzz.departmentSevice.exceptionHandler.NotFoundException;
import com.congdunghzz.departmentSevice.mapper.DepartmentMapper;
import com.congdunghzz.departmentSevice.model.Department;
import com.congdunghzz.departmentSevice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    public List<DepartmentResponse> getAll(){
        return departmentRepository.findAll()
                            .stream()
                                .map(departmentMapper::convertToDepartmentResponse)
                                .toList();
    }

    public DepartmentResponse getById(int id){
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isEmpty()) throw new NotFoundException("Department with id: " + id +" not be found");
        System.out.println("DEpartment serive: name:" + department.get().getName());
        return departmentMapper.convertToDepartmentResponse(department.get());
    }

    public DepartmentResponse addDepartment(DepartmentRequest request){
        if (request.name().isBlank() || request.address().isBlank()){
            throw new NotFoundException("Please fill all the fields");
        }
        Department department = Department
                .builder()
                .address(request.address())
                .name(request.name())
                .build();
        return departmentMapper.convertToDepartmentResponse(departmentRepository.save(department));
    }

}
