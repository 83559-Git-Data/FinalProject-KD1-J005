package com.schedulemaster.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schedulemaster.customexception.ResourceNotFoundException;
import com.schedulemaster.dao.FacultyDao;
import com.schedulemaster.dao.ModuleDao;
import com.schedulemaster.dao.UserDao;
import com.schedulemaster.dto.AddFacultyDTO;
import com.schedulemaster.dto.AddModule;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.exception.AuthenticationException;
import com.schedulemaster.pojos.Course;
import com.schedulemaster.pojos.Faculty;
import com.schedulemaster.pojos.Module;
import com.schedulemaster.pojos.Role;
import com.schedulemaster.pojos.User;

//for the use of modularity we have implemented interface

@Service
//The @Service annotation in Spring is used to indicate that a class is a "Service" 
@Transactional
//The @Transactional annotation in Spring is used to manage transaction boundaries in a 
//declarative way. 
public class FacultyServicesImpl implements FacultyServices {
	// dependencies
	@Autowired
	
	private FacultyDao facultyDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper map;

	@Autowired
	private ModuleDao moduleDao;
	
	@Override
	public ApiResponse addFaculty(AddFacultyDTO dto, Long id) {
		System.out.println(dto.toString());
		System.out.println(id);
		User user = userDao.findById(id).orElseThrow(() -> new AuthenticationException("User Doesnt exitst"));
		if (user.getRole().equals(Role.ROLE_FACULTY)) {
			System.out.println(user.toString());
			Faculty faculty = map.map(dto, Faculty.class);
			System.out.println(faculty.toString());
			faculty.setUserId(user);
			System.out.println(faculty.toString());
			
			Faculty f = facultyDao.save(faculty);
			return new ApiResponse("Profile Added Successfully!");
		} else {
			return new ApiResponse("Something failed!!");
		}
	}

	@Override
	public ApiResponse addModule(AddModule dto, Long id) {
		Faculty faculty = facultyDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Faculty is not found of that id"));
		Module module = moduleDao.findByName(dto.getName());
		if (faculty != null && module != null) {
			faculty.addModule(module);
			return new ApiResponse("Module is added to the Course Successfully");
		}
		return new ApiResponse("somthing went wrong");
	}

	@Override
	public List<Module> getModulesByFacultyId(Long id) {
		Faculty faculty = facultyDao.findById(id).orElseThrow();
		List<Module> modules = faculty.getModules().stream().collect(Collectors.toList());
		return modules;
	}

	@Override
	public Faculty getFacultyById(Long id) {
		Faculty faculty = facultyDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Faculty is not found!"));

		return faculty;
	}

	@Override
	public ApiResponse updateFacultyDetails(Long id, AddFacultyDTO facultyDTO) {
		Faculty f = facultyDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found!"));

		f.setDob(facultyDTO.getDob());
		f.setCurrentAge(facultyDTO.getCurrentAge());
		f.setAddress(facultyDTO.getAddress());
		f.setMobNo(facultyDTO.getMobNo());
		f.setPanId(facultyDTO.getPanId());

		User u = userDao.findById(f.getUserId().getId()).orElseThrow();
		u.setFirstName(facultyDTO.getFirstName());
		u.setLastName(facultyDTO.getLastName());
		
		f.setUserId(u);

		Faculty facultyUpdated = facultyDao.save(f);
		
		return facultyUpdated != null ? new ApiResponse("Faculty Updated Successfully")
				: new ApiResponse("Faculty Updatation Failed!!");
	}

	@Override
	public List<Faculty> getAllFaculties() {
		return facultyDao.findAll();
	}
}
