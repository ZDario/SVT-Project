package com.example.SvtProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SvtProject.model.Admin;
import com.example.SvtProject.repository.AdminRepository;
import com.example.SvtProject.serviceInterface.AdminServiceInterface;

@Service
public class AdminService implements AdminServiceInterface{

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public Admin findOne(Long id) {
		return adminRepository.getOne(id);
	}

	@Override
	public Admin findById(Long userId) {
		return adminRepository.findByIdUser(userId);
	}

	@Override
	public Admin save(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public void remove(Long id) {
		adminRepository.deleteById(id);
		
	}

	@Override
	public Admin findByUNameAndPassword(String uName, String pass) {
		return adminRepository.findByUserNameAndPassword(uName, pass);
	}

}