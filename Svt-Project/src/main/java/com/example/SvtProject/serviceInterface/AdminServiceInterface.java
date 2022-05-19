package com.example.SvtProject.serviceInterface;

import java.util.List;

import com.example.SvtProject.model.Admin;

public interface AdminServiceInterface {
	
	public List<Admin> findAll();
	public Admin findOne(Long id);
	public Admin findById(Long userId);
	public Admin findByUNameAndPassword(String uName, String pass);
	public Admin save(Admin admin);
	public void remove(Long id);

}
