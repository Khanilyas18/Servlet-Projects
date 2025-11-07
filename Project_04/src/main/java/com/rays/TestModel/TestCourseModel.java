package com.rays.TestModel;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.bean.CourseBean;
import com.rays.model.CourseModel;

public class TestCourseModel {
	public static void main(String[] args) {
		// testnextpk();
		// testadd();
		// Testupdate();
		//Testdelete();
		//Testfindbypk();
		//Testfindbyname();
		Testsearch();
		
	}

	private static void Testsearch() {
		CourseBean bean = new CourseBean();

		CourseModel model = new CourseModel();

		List list = model.search(bean, 1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (CourseBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
			
		}
		
	}

	private static void Testfindbyname() {
		CourseModel model= new CourseModel();
		CourseBean bean = model.findByName("BA LLB");
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("name not found");
		}
		
	}

	private static void Testfindbypk() {
		CourseModel model = new CourseModel();
		CourseBean bean =  model.findBypk(9);
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("id not found");
		}
		
	}

	private static void Testdelete() {
		CourseModel model = new CourseModel();
		CourseBean bean = new CourseBean();
		model.delete(11);

	}

	private static void Testupdate() {
		CourseBean bean = new CourseBean();
		// id specify karo jiska data update karna hai
		bean.setId(11);
		bean.setName("Java Full Stack");
		bean.setDuration("6 Months");
		bean.setDescription("Full course with frontend + backend");
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("System");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CourseModel model = new CourseModel();
		model.update(bean);
	}

	private static void testadd() {
		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();

		bean.setName("B Pharmacy");
		bean.setDuration("4 years");
		bean.setDescription("pharmacist");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.add(bean);

	}

	private static void testnextpk() {
		CourseModel model = new CourseModel();
		int i = model.nextPk();
		System.out.println("NextPk" + i);

	}
}
