package com.jwt.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.Dao.EmployeeDao;
import com.jwt.model.Employee;
import com.jwt.model.Question;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDao dao;
	public void addEmployee(Employee emp)
	{
		dao.saveEmployee(emp);
		
	}
	/*public void getAnswerMarked(int qid)
	{
		dao.getAnswerMarked(qid);
	}*/
	public List<Question> getRightAnswerByQuestionId(int questionId)
	{
		return dao.getRightAnswerByQuestionId(questionId);
	}
	public void updateEmployee(Employee emp)
	{
		dao.updateAllEmployee(emp);
		
	}
	public List<Question> getAllEmployees()
	{
		return dao.getAllEmployees();
		
	}
	public Employee getEmployee(int empid)
	{
		return dao.getEmplyeeById(empid);
	}
	public void deleteEmployee(int empid)
	{
		dao.deleteEmployee(empid);
	}
}
