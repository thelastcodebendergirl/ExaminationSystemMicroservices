package com.examinationsystemmicroservices.examinationservice.examinationservice.model;

import java.util.List;

public class ExamModel {
	public class ExamgGetByCourseIdModel
	{
		public long courseId;
		public List<Long> studentIds;
		
	}

	public class ExamCreateModel
	{
		public long courseId;
		public String examName ;
		public List<QuestionDataModel> questions;
		
	}
	public class CourseSearchModel
	{
		public long userId;
		
	}
	public class QuestionDataModel
	{
		public String question;
		public String optionA;
		public String optionB;
		public String optionC;
		public String optionD;
		public char answer ;
		
		
	}


}
