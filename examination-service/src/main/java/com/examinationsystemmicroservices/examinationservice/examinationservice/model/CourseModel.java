package com.examinationsystemmicroservices.examinationservice.examinationservice.model;

import java.util.List;

public class CourseModel {
	
	public class CourseAddStudentModel
	{
		public long courseId;
		public List<Long> studentIds;
		
	}
	public class CourseUpdateModel
	{
		public long courseId;
		public String name ;
	}
	public class CourseCreateModel
	{
		public String teacherusername;
		public String coursename ;
		
	}
	public class CourseSearchModel
	{
		public long userId;
		
	}
	

}
