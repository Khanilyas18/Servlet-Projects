package com.rays.TestModel;


import java.sql.Timestamp;
import java.util.Date;

import com.rays.bean.SubjectBean;
import com.rays.model.SubjectModel;

public class TestSubjectModel {
	public static void main(String[] args) {

		//Testnextpk();
		//Testadd();
		Testupdate();
	}

	private static void Testupdate() {
		SubjectBean bean = new SubjectBean();
		bean.setId(6);
		bean.setName("Arsil");
		bean.setCourseId(02);
		bean.setCourseName("Engineering");
		bean.setDescription("ITI");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		SubjectModel model = new SubjectModel();
		model.update(bean);
		
	}

	private static void Testadd() {
		SubjectBean bean = new SubjectBean();

		bean.setName("Shifa Khan");
		bean.setCourseId(05);
		bean.setCourseName("Engineering");
		bean.setDescription("IT Sector");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		SubjectModel model = new SubjectModel();
		model.add(bean);

		
	}

	private static void Testnextpk() {
		SubjectModel model = new SubjectModel();

		int i = model.nextPk();
		System.out.println("NextPk = " + i);

	}

}
