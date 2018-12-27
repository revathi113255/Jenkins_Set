package com.jwt.Dao;

import java.util.List;

import com.jwt.model.Employee;
import com.jwt.model.Question;

public interface EmployeeDao {
public void saveEmployee(Employee emp);
public void updateAllEmployee(Employee emp);
public List<Question> getAllEmployees();
public Employee getEmplyeeById(int empid);
public List<Question> getRightAnswerByQuestionId(int questionId);
public void deleteEmployee(int employeeId);
//public void getAnswerMarked(int qid);
}
