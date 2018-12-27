package com.jwt.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Employee;
import com.jwt.model.Question;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	SessionFactory sessionfactory;
	public void saveEmployee(Employee emp)
	{
		sessionfactory.getCurrentSession().save(emp);
		
		
	}
	
	public List<Question> getRightAnswerByQuestionId(int questionId) {
		return (List<Question>)sessionfactory
				.getCurrentSession()
				.createQuery(
						"from Question where qid=:id")
				.setParameter("id", questionId).list();
	}
	
	public void updateAllEmployee(Employee emp)
	{
		sessionfactory.getCurrentSession().update(emp);
		
	}
	public List<Question> getAllEmployees()
	{
		return sessionfactory.getCurrentSession().createQuery("from Question").list();
	}
	public Employee getEmplyeeById(int empid)
	{
		return(Employee) sessionfactory.getCurrentSession().get(Employee.class,empid);
	}
	public void deleteEmployee(int employeeId)
	{
		Employee employee = (Employee) sessionfactory.getCurrentSession().load(
				Employee.class, employeeId);
		if (null != employee) {
			this.sessionfactory.getCurrentSession().delete(employee);
		}
	}
	/*public void getAnswerMarked(int employeeId)
	{
		Employee employee = (Employee) sessionfactory.getCurrentSession().load(
				Employee.class, employeeId);
		if (null != employee) {
			this.sessionfactory.getCurrentSession().update(employee);
		}
	}*/

	
}
