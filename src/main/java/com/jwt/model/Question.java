package com.jwt.model;

import javax.persistence.*;

@Entity
@Table(name="question")
public class Question {
	@Id
private int qid;
private String question_text;
private String option1;
private String option2;
private String option3;
private String option4;
private String right_answer;
public String getRight_answer() {
	return right_answer;
}
public void setRight_answer(String right_answer) {
	this.right_answer = right_answer;
}
public int getQid() {
	return qid;
}
public void setQid(int qid) {
	this.qid = qid;
}
public String getQuestion_text() {
	return question_text;
}
public void setQuestion_text(String question_text) {
	this.question_text = question_text;
}
public String getOption1() {
	return option1;
}
public void setOption1(String option1) {
	this.option1 = option1;
}
public String getOption2() {
	return option2;
}
public void setOption2(String option2) {
	this.option2 = option2;
}
public String getOption3() {
	return option3;
}
public void setOption3(String option3) {
	this.option3 = option3;
}
public String getOption4() {
	return option4;
}
public void setOption4(String option4) {
	this.option4 = option4;
}

}

