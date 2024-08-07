package com.schedulemaster.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schedulemaster.pojos.Module;

public interface ModuleDao extends JpaRepository<Module, Long>{
	Module findByName(String name);
}
