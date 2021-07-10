package com.examinationsystemmicroservices.examinationservice.examinationservice.model;

import java.util.List;

public class CourseModel {
	
	public static class CourseAddStudentModel
	{
		public long courseId;
		public List<Long> studentIds;
		
	}
	public static class CourseUpdateModel
	{
		public long courseId;
		public String name ;
	}
	public static class CourseCreateModel
	{
		public String teacherusername;
		public String coursename ;
		
	}
}
