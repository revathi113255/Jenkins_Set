package com.jwt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jwt.Service.EmployeeService;
import com.jwt.model.Employee;
import com.jwt.model.Question;

import com.jwt.validator.EmployeeValidator;
@Controller
public class EmpController {
	@Autowired
	EmployeeService empser;
@Autowired
EmployeeValidator customerValidator;
	
				@RequestMapping(value = "Login")
			public ModelAndView LoginEmployee( @ModelAttribute("employee")  Employee employee,BindingResult res,Model model) throws IOException {
				return new ModelAndView("EmployeeForm");
			}
				@RequestMapping(value = "Pdf")
				public ModelAndView PdfGeneator(HttpServletRequest request,HttpSession session,Model model) throws IOException {
				List<Question> listEmployee = empser.getAllEmployees();
					
					return new ModelAndView("UserSummary","listEmployee",listEmployee);
				}
				
		@RequestMapping(value = "ResultPage")
		public ModelAndView ResultEmployee(HttpServletRequest request,HttpSession session,Model model) throws IOException {
			
			int thirdpage=(int)session.getAttribute("rightAnswer");
			System.out.println("firstpage Ans"+thirdpage);
			int qid=Integer.parseInt(request.getParameter("quesNum"));
			 List<Question> listEmployee = empser.getAllEmployees();
			 System.out.println("size"+listEmployee.size());
			for(int i=qid;i<=listEmployee.size();i++)
			{
			
		String option1=request.getParameter("option"+i);
		List<Question> list=empser.getRightAnswerByQuestionId(i);
		String rightanswer=list.get(0).getRight_answer();
		if(option1.equals(rightanswer))
		{
			thirdpage++;
		}
		
		
			}
			
		
			session.setAttribute("totalQuestion", listEmployee.size());
			session.setAttribute("rightAnswer", thirdpage);
			session.setAttribute("wrongAnswer", (listEmployee.size()) -thirdpage);
		
			return new ModelAndView("ResultPage");
		}
		
		@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
		public ModelAndView saveEmployee(@Valid @ModelAttribute("employee")  Employee employee,BindingResult result) {
			customerValidator.validate(employee, result);
			 if (result.hasErrors()) {
				 return new ModelAndView("EmployeeForm"); 
			 }
			 List<Question> listEmployee = empser.getAllEmployees();
			 return new ModelAndView("Success","listEmployee",listEmployee);
		}
		
		
		
		@RequestMapping(value = "/FirstPage", method = RequestMethod.POST)
		public ModelAndView saveEmployee1(@ModelAttribute("employee")  Employee employee,HttpServletRequest request,HttpSession session) {
			int rightAnswer=0,wrongAnswer=0;
			//int firstpage=(int)session.getAttribute("rightAnswer");
			int qid=Integer.parseInt(request.getParameter("quesNum"));
			
			
			 List<Question> listEmployee = empser.getAllEmployees();
			for(int i=qid;i<=(listEmployee.size()/3);i++)
			{
			
		String option1=request.getParameter("option"+i);
		List<Question> list=empser.getRightAnswerByQuestionId(i);
		//empser.getAnswerMarked();
		String rightanswer=list.get(0).getRight_answer();
		if(option1.equals(rightanswer))
		{
			rightAnswer++;
		}
		
		//session.setAttribute("wrongAnswer", (3) - rightAnswer);
		
			}
			//System.out.println("RightAnswer"+rightAnswer);
			session.setAttribute("totalQuestion", listEmployee.size());
			session.setAttribute("rightAnswer", rightAnswer);
			 //List<Question> listEmployee = empser.getAllEmployees();
			 return new ModelAndView("FirstPage","listEmployee",listEmployee);
		}
		@RequestMapping(value = "/SecondPage", method = RequestMethod.POST)
		public ModelAndView saveEmployee2(@ModelAttribute("employee")  Employee employee,HttpServletRequest request,HttpSession session) {
			//int rightAnswer=0,wrongAnswer=0;
			int secondpage=(int)session.getAttribute("rightAnswer");
			
			int qid=Integer.parseInt(request.getParameter("quesNum"));
			System.out.println("questionid"+qid);
			 List<Question> listEmployee = empser.getAllEmployees();
			 System.out.println("SecondPage"+listEmployee.size());
			for(int i=qid;i<=(listEmployee.size()-(listEmployee.size()/3));i++)
			{
			
		String option1=request.getParameter("option"+i);
		List<Question> list=empser.getRightAnswerByQuestionId(i);
		String rightanswer=list.get(0).getRight_answer();
		if(option1.equals(rightanswer))
		{
			secondpage++;
		}
		
		//session.setAttribute("wrongAnswer", (listEmployee.size()) - thirdpage);
		
			}
			session.setAttribute("totalQuestion", listEmployee.size());
			session.setAttribute("rightAnswer", secondpage);
			System.out.println("RightAnswer"+secondpage);
			 //List<Question> listEmployee = empser.getAllEmployees();
			 return new ModelAndView("SecondPage","listEmployee",listEmployee);
		}
		
		
		
		
		/*@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
		public ModelAndView deleteEmployee(HttpServletRequest request) {
			int employeeId = Integer.parseInt(request.getParameter("id"));
			empser.deleteEmployee(employeeId);
			 List<Question> listEmployee = empser.getAllEmployees();
			 return new ModelAndView("Success","listEmployee",listEmployee);

		}*/

}
