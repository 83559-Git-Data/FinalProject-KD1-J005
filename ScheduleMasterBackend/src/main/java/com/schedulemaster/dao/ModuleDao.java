package com.schedulemaster.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.schedulemaster.pojos.Course;
import com.schedulemaster.pojos.Module;

public interface ModuleDao extends JpaRepository<Module, Long>{
	Module findByName(String name);
	
	//@Query("SELECT m FROM Course c JOIN c.modules m WHERE c.id = :courseId")
//    List<Module> findModules(Long courseId);
//	@Query("select c from Course c left join fetch c.modules where c.id=:courseId")
//	List<Module> findByIdWithModules(@Param("courseId") Long courseId);
//	@Query("SELECT c.modules FROM Course c WHERE c.id = :courseId")
//	Set<Module> findModulesByCourseId(@Param("courseId") Long courseId);

}
