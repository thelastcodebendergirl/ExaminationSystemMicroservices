package com.examinationsystemmicroservices.examinationservice.examinationservice.model;

import java.util.List;

public class ExamModel {
	public static class ExamGetByCourseIdModel
	{
		public long courseId;
		public List<Long> studentIds;
		
	}

	public static class ExamCreateModel
	{
		public long courseId;
		public String examName ;
		public List<QuestionDataModel> questions;
		
	}
	public static class CourseSearchModel
	{
		public long userId;
		
	}


	public static class QuestionDataModel
	{
		public String question;
		public String optionA;
		public String optionB;
		public String optionC;
		public String optionD;
		public char answer ;
		
		
	}


}
