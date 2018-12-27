package com.jwt.Service;

import java.util.List;

import com.jwt.model.Employee;
import com.jwt.model.Question;

public interface EmployeeService {
public void addEmployee(Employee emp);
public void updateEmployee(Employee emp);
public List<Question> getAllEmployees();
public Employee getEmployee(int empid);
public void deleteEmployee(int empid);
public List<Question> getRightAnswerByQuestionId(int questionId);
//public void getAnswerMarked(int qid);
}
