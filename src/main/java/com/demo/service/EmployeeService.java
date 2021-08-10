package com.demo.service;

import java.util.List;

import com.demo.Vo.CommenResponse;
import com.demo.Vo.EmployeeVo;

public interface EmployeeService {

	CommenResponse insertUpdateEmploye(EmployeeVo employeeVo);

	List<EmployeeVo> findAll();

}
