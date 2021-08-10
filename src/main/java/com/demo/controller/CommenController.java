package com.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.Vo.CommenResponse;
import com.demo.Vo.EmployeeVo;
import com.demo.model.MstCity;
import com.demo.model.MstCountry;
import com.demo.model.MstDistict;
import com.demo.model.MstState;
import com.demo.service.CityService;
import com.demo.service.CountryService;
import com.demo.service.DistService;
import com.demo.service.EmployeeService;
import com.demo.service.StateService;

@Controller
public class CommenController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@Autowired
	private DistService distService;

	@Autowired
	private CityService cityService;

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("addCountry")
	public String addCountry(Model model) {
		return "addcountry";
	}

	@PostMapping("saveCountry")
	public String saveCountry(MstCountry country, RedirectAttributes ru) {
		try {
			countryService.save(country);
			ru.addFlashAttribute("message", "<span style='color:green;'>Country save successfully.</span>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/addCountry";
	}

	@GetMapping("addState")
	public String addState(Model model) {

		List<MstCountry> countryList = countryService.findAll();

		model.addAttribute("countryList", countryList);

		return "addState";
	}

	@PostMapping("saveState")
	public String saveState(MstState country, RedirectAttributes ru) {
		try {
			stateService.save(country);
			ru.addFlashAttribute("message", "<span style='color:green;'>State save successfully.</span>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/addState";
	}

	@GetMapping("addDist")
	public String addDist(Model model) {

		List<MstState> stateList = stateService.findAll();
		model.addAttribute("stateList", stateList);
		model.addAttribute("countryList", countryService.findAll());

		return "addDist";
	}

	@PostMapping("saveDistrict")
	public String saveDist(MstDistict country, RedirectAttributes ru) {
		try {
			distService.save(country);
			ru.addFlashAttribute("message", "<span style='color:green;'>District save successfully.</span>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/addDist";
	}

	@GetMapping("addCity")
	public String addCity(Model model) {
		List<MstDistict> districtList = distService.findAll();
		model.addAttribute("districtList", districtList);
		model.addAttribute("countryList", countryService.findAll());
		model.addAttribute("stateList", stateService.findAll());
		return "addCity";
	}

	@PostMapping("saveCity")
	public String saveCity(MstCity country, RedirectAttributes ru) {
		try {
			cityService.save(country);
			ru.addFlashAttribute("message", "<span style='color:green;'>City save successfully.</span>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/addCity";
	}

	@GetMapping("addEmployee")
	public String addEmployee(Model model) {

		model.addAttribute("countryList", countryService.findAll());
		model.addAttribute("stateList", stateService.findByCountryId(1l));
		model.addAttribute("districtList", distService.findAll());
		model.addAttribute("employeeVo", new EmployeeVo());
		return "addEmployee";
	}

	@PostMapping("saveEmployee")
	public String Employee(@ModelAttribute("employeeVo") EmployeeVo employeeVo, RedirectAttributes ru) {
		CommenResponse response = employeeService.insertUpdateEmploye(employeeVo);
		if (response.getStatus() == 200) {
			ru.addFlashAttribute("message", "<span style='color:green'>" + response.getMessage() + "</span>");
		} else {
			ru.addFlashAttribute("message", "<span style='color:red'>" + response.getMessage() + "</span>");
		}
		return "redirect:/addEmployee";
	}
	

	@PostMapping("getDist")
	public @ResponseBody List<MstDistict> getDist(Long id) {
		return distService.findByStateId(id);
	}

	@PostMapping("getCity")
	public @ResponseBody List<MstCity> getCity(@RequestParam("id") Long id) {
		System.out.println("id " + id);
		return cityService.findByDisId(id);
	}

	@GetMapping("showImage")
	public void showProfile(@RequestParam("imagePath") String imagePath, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			File file = new File(imagePath);
			InputStream in = new FileInputStream(file);
			response.setContentType(MediaType.IMAGE_JPEG_VALUE);
			response.setContentType(MediaType.IMAGE_PNG_VALUE);
			IOUtils.copy(in, response.getOutputStream());
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(response.getOutputStream());
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("getEmployeeReport")
	public String getEmployeeReport(Model model) {
		List<EmployeeVo> employeeList = employeeService.findAll();
		model.addAttribute("employeeList", employeeList);
		return "getEmployeeReport";
	}
}
