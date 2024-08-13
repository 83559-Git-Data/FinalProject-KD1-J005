package com.schedulemaster.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.schedulemaster.customexception.ResourceNotFoundException;
import com.schedulemaster.dao.CourseDao;
import com.schedulemaster.dao.FacultyDao;
import com.schedulemaster.dao.ModuleDao;
import com.schedulemaster.dao.ScheduleDao;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.ScheduleRequestDTO;
import com.schedulemaster.pojos.Course;
import com.schedulemaster.pojos.Faculty;
import com.schedulemaster.pojos.Module;
import com.schedulemaster.pojos.Schedule;

@Service
@Transactional
public class ScheduleServicesImpl implements ScheduleService {
	

	@Autowired
	private ModelMapper map;
	
	@Autowired
	private ScheduleDao scheduleDao;
	
	@Autowired
	private FacultyDao facultyDao;
	
	@Autowired
	private ModuleDao moduleDao;
	
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public ApiResponse createNewSchedule(ScheduleRequestDTO dto) {
		LocalTime startTime=LocalTime.parse(dto.getStartTime());
		LocalTime endTime=LocalTime.parse(dto.getEndTime());
		System.out.println(startTime);
		Faculty faculty=facultyDao.findById(dto.getFacultyId())
				.orElseThrow(()->new ResourceNotFoundException("faculty Not Found!!"));
		Course course=courseDao.findById(dto.getCourseId())
				.orElseThrow(()->new ResourceNotFoundException("faculty Not Found!!"));
		Module module=moduleDao.findById(dto.getModuleId())
				.orElseThrow(()->new ResourceNotFoundException("faculty Not Found!!"));
		if(faculty!=null && course!=null&&module!=null) {
			Schedule schedule=map.map(dto, Schedule.class);
			schedule.setStartTime(startTime);
			schedule.setEndTime(endTime);
			schedule.setCourse(course);
			schedule.setFaculty(faculty);
			schedule.setModule(module);
			Schedule persistentSchedule=scheduleDao.save(schedule);
			return new ApiResponse("Schedule is Uploded!!");
		}
		return new ApiResponse("Somthing went Wrong!!");
	}

	
	@Override
	public List getAllSchedule() {
		List<Schedule> scheduleList=scheduleDao.findAll();
		return scheduleList;
	}


	@Override
	public List<Schedule> getScheduleOfFaculty(Long id) {
		
		return null;
	}
	@Override
	 public List<Schedule> getAvailableSchedules(LocalDate startDate, LocalDate endDate, Long facultyId, Long courseId, Long moduleId) {
	        return scheduleDao.findOverlappingSchedules(startDate, endDate, facultyId, courseId, moduleId);
	    }
}
