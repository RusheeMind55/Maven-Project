package com.example.ProjectDemo.Service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectDemo.dao.MainDao;
import com.example.ProjectDemo.entity.Country;
import com.example.ProjectDemo.entity.Employee2;

@Service
public class MainService {
	
	@Autowired
	MainDao dao;
	



	public String addCountry(Country c) {
		String msg=dao.addCountry(c);
		if(Objects.isNull(msg)) {
			msg="Data is not Added...";
		}
		return msg;

}
	public String updateData(Country c) {
		String msg=dao.updateData(c);
		if(Objects.isNull(msg)) {
			msg="Data is not updated...";
		}
		return msg;

}
	public String deleteCountry(Country c) {
		String msg= dao.deleteCountry(c);
		if(Objects.isNull(msg)) {
			msg="Data not deleted...";
		}
		return msg;

}
	public String addEmployee(Employee2 e) {
		String msg=dao.addEmployee(e);
		if(Objects.isNull(msg)) {
			msg="Data is not Added...";
		}
		return msg;
}
	
	public String updateEmployee(Employee2 e) {
		String msg=dao.updateEmployee(e);
		if(Objects.isNull(msg)) {
			msg="Data is not updated...";
		}
		return msg;

}
	
	public Country getParticularRecord(int id) {
		Country c= dao.getParticularRecord(id);
		return c;
	}
	
	public List<Country> getAllRecord(){
		 List<Country> list= dao.getAllRecord();
		 return list;
	}
	
	public String getPerticularRecord(Country c) {
		String msg=dao.getPerticularRecord(c);
		if(Objects.isNull(msg)) {
			msg="not getting perticular record...";
		}
		return msg;
	
}
}
