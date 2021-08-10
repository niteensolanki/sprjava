package com.demo.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.Vo.CommenResponse;
import com.demo.Vo.EmployeeVo;
import com.demo.dao.EmployeeDao;
import com.demo.dao.MSTAddressDao;
import com.demo.model.Employee;
import com.demo.model.MSTAddress;
import com.demo.model.MstDistict;
import com.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private MSTAddressDao addressDao;

	@Override
	public CommenResponse insertUpdateEmploye(EmployeeVo employeeVo) {
		CommenResponse response = new CommenResponse();
		Employee employee = new Employee();
		MSTAddress address = new MSTAddress();
		try {
			String filePaths = null;

			for (MultipartFile file : employeeVo.getAddressProfs()) {
				String fileP = uploadFiles(file);
				if (fileP != null) {
					if (filePaths == null) {
						filePaths = fileP;
					} else {
						filePaths = filePaths + "," + fileP;
					}
				}
			}

			if (employeeVo.getId() == null || employeeVo.getId() == 0l) {
				BeanUtils.copyProperties(employeeVo, employee);
				Long eId = employeeDao.save(employee);
				BeanUtils.copyProperties(employeeVo, address);
				address.setAddressProofs(filePaths);
				address.setEmpId(eId);
				addressDao.save(address);
				response.setStatus(200);
				response.setMessage("Employee save successfully.");
			} else {
				// update
				employee = employeeDao.findById(employeeVo.getId());
				employee.setEmailId(employeeVo.getEmailId());
				employee.setEmpCode(employeeVo.getEmpCode());
				employee.setEmpMobNo(employeeVo.getEmpMobNo());
				employee.setEmpName(employeeVo.getEmpName());
				employeeDao.update(employee);

				address = addressDao.findByEmpId(employee.getId());
				address.setAddressProofs(filePaths);
				address.setAdr_area(employeeVo.getAdr_area());
				address.setAdr_flrno(employeeVo.getAdr_flrno());
				address.setAdr_houseno(employeeVo.getAdr_houseno());
				address.setAdr_pinno(employeeVo.getAdr_pinno());
				address.setAdr_street(employeeVo.getAdr_street());
				address.setCity_id(employeeVo.getCity_id());
				address.setCountry_id(employeeVo.getCountry_id());
				address.setDist_id(employeeVo.getDist_id());
				address.setState_id(employeeVo.getState_id());

				addressDao.update(address);

				response.setStatus(200);
				response.setMessage("Employee details update successfully.");

			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			response.setMessage("Something went wrong.");
		}
		return response;
	}

	private String uploadFiles(MultipartFile file) {

		String rootPath = System.getProperty("catalina.home");
		String sourcePath = rootPath + File.separator + "addressProof" + File.separator;
		File isDir = new File(sourcePath);
		if (!isDir.exists()) {
			new File(sourcePath).mkdirs();
		}
		String fileName = isDir + File.separator + file.getOriginalFilename();
		String returnFilePath = file.getOriginalFilename();
		System.out.println("File Path :: " + returnFilePath);
//		folderName + 
		try {
			InputStream inputStream = file.getInputStream();
			if (inputStream != null) {
				File newFile = new File(fileName);
				if (!newFile.exists()) {
					newFile.createNewFile();
				}
				OutputStream outputStream = new FileOutputStream(newFile);
				int read = 0;
				byte[] bytes = new byte[10240];

				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				inputStream.close();
				outputStream.close();
			}

			return fileName;
		} catch (IOException e) {
			System.out.println("File is not save" + e.getMessage());
			e.printStackTrace();
		}
		return returnFilePath;
	}

	@Override
	public List<EmployeeVo> findAll() {
		List<EmployeeVo> list = new ArrayList<>();
		List<Long> empIds = new ArrayList<>();
		try {
			List<Employee> empList = employeeDao.findAll();
			if (empList != null && empList.size() != 0 && !empList.isEmpty()) {
				empList.forEach(emp -> {
					empIds.add(emp.getId());
				});

				List<MSTAddress> empAddressList = addressDao.findByEmpIds(empIds);
				Map<Long, MSTAddress> mapEMpAdd = new HashMap<>();
				empAddressList.forEach(addres -> {
					mapEMpAdd.put(addres.getEmpId(), addres);
				});

				empList.forEach(empDe -> {
					MSTAddress mstAddress = mapEMpAdd.get(empDe.getId());
					EmployeeVo employee = new EmployeeVo();
					BeanUtils.copyProperties(empDe, employee);
					BeanUtils.copyProperties(mstAddress, employee);
					List<String> addressList = new ArrayList<>();
					for (String str : mstAddress.getAddressProofs().split(",")) {
						addressList.add(str);
					}
					employee.setDocumentList(addressList);
					list.add(employee);
				});

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}