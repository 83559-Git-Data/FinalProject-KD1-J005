package com.schedulemaster.services;
import com.schedulemaster.customexception.ResourceNotFoundException;
//
//import java.lang.invoke.CallSite;
//import java.util.List;
//import java.util.Set;
//
//import javax.validation.Valid;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.schedulemaster.dao.CourseDao;
//import com.schedulemaster.dao.ModuleDao;
//import com.schedulemaster.dto.ApiResponse;
//import com.schedulemaster.dto.CourseRegistrationDTO;
//import com.schedulemaster.pojos.Course;
//import com.schedulemaster.pojos.Module;
//
////for the use of modularity we have implemented interface
//
//@Service
////The @Service annotation in Spring is used to indicate that a class is a "Service" and it is a 
////specialization of the @Component annotation. Service classes typically contain the business 
////logic of your application and are used to handle the processing required by the application, 
////separate from the controller and repository layers.
//
//@Transactional
////The @Transactional annotation in Spring is used to manage transaction boundaries in a 
////declarative way. This annotation can be applied to classes or methods to define the 
////scope of a database transaction. When applied, it ensures that a series of operations
////within the annotated scope are executed within a transaction context.
//public class CourseServicesImpl implements CourseService {
//
//	@Autowired
//	private CourseDao coursedao;
//	
//	@Autowired
//	private ModuleDao moduleDao;
//
//	@Autowired
//	private ModelMapper map;
//	// ModelMapper is a Java library used for object mapping. It helps in mapping
//	// data between different object models, which is especially useful in scenarios
//	// like mapping between database entities and Data Transfer Objects (DTOs), or
//	// between various representations of data in your application. This is commonly
//	// used in scenarios involving data transformation and reducing boilerplate
//	// code.
//
//	// course registration
//	@Override
//	public ApiResponse register(CourseRegistrationDTO dto) {
//		Course course = map.map(dto, Course.class);
////		course.getModules().
//		// The map function in ModelMapper is used to copy values from one object to
//		// another based on the mappings defined.
////		System.out.println(course.toString());
////		Course c = coursedao.save(course);
//		List<String> string=dto.getModules();
//		Set<Module> modules =course.getModules();
//		for (String str : string) {
//			System.out.println(str);
//            Module m=moduleDao.findByName(str);
//            System.out.println(m);
////            c.addModule(m);
////            m.addCourse(c);
//            modules.add(m);
//        }
//		course.setModules(modules);
//		Course c = coursedao.save(course);
//		
//		return c!=null ? new ApiResponse("Course Registrated Successfully") : new ApiResponse("Course Registration Failed!!");
//	}
//
//}
import com.schedulemaster.dao.CourseDao;
import com.schedulemaster.dao.ModuleDao;
import com.schedulemaster.dto.AddModule;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.CourseDTO;
import com.schedulemaster.dto.CourseRegistrationDTO;
import com.schedulemaster.pojos.Course;
import com.schedulemaster.pojos.Module;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseServicesImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private ModuleDao moduleDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ApiResponse register(CourseRegistrationDTO dto) {
    	
        Course course = modelMapper.map(dto, Course.class);
       if(dto.getStartDate().isBefore(dto.getEndDate())) {
        Course savedCourse = courseDao.save(course);
          return savedCourse != null ? new ApiResponse("Course Registered Successfully") : new ApiResponse("Course Registration Failed!!");
    }
       return new ApiResponse("starting date must be before the ned date!");
    }

	@Override
	public ApiResponse addModule(AddModule dto, Long courseId) {
		Course course=courseDao.findById(courseId).orElseThrow(()->new ResourceNotFoundException("course not found!"));
		Module module=moduleDao.findByName(dto.getName());
		if(course!=null && module!=null) {
			course.addModule(module);
		}
		return new ApiResponse("Module is added to the Course Successfully");
	}

	@Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseDao.findAll();
        return courses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
	 private CourseDTO convertToDTO(Course course) {
	        CourseDTO courseDTO = new CourseDTO();
	        courseDTO.setId(course.getId());
	        courseDTO.setCourseName(course.getCourseName());
	        courseDTO.setFees(course.getFees());
	        courseDTO.setDescription(course.getDescription());
	        courseDTO.setStartDate(course.getStartDate());
	        courseDTO.setEndDate(course.getEndDate());
	        courseDTO.setCapacity(course.getCapacity());
//	        courseDTO.setModuleNames(course.getModules().stream().map(Module::getName).collect(Collectors.toSet()));
	        return courseDTO;
	    }
	 @Override
	 public CourseDTO getCourseById(Long id) {
		 Course course=courseDao.findById(id).orElseThrow(()->new ResourceNotFoundException("course is not found!"));
		 return convertToDTO(course);
	 }

	 public List<Module> getModulesByCourseId(Long courseId) {
	       Course course =courseDao.findById(courseId).orElseThrow();
	       List<Module> modules=course.getModules().stream().collect(Collectors.toList());
	       return modules;
	    }
    
}
