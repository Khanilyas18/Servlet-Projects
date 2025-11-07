package com.rays.TestModel;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.rays.bean.StudentBean;
import com.rays.model.StudentModel;

public class TestStudentModel {
	public static void main(String[] args) throws ParseException {

		// Testnextpk();
		// Testadd();
		// Testupdate();
		// Testdelete();
		// Testfindbypk();
		// Testfindbyemail();
		Testsearch();

	}

	private static void Testsearch() {
		StudentModel model = new StudentModel();

		StudentBean bean = new StudentBean();
		List list = model.search(bean,0,6 );
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (StudentBean)it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}
	}

	private static void Testfindbyemail() {
		StudentModel model = new StudentModel();
		StudentBean bean = model.findByEmail("farhan@gmail.com");
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Id not found");
		}

	}

	private static void Testfindbypk() {
		StudentModel model = new StudentModel();
		StudentBean bean = model.findByPk(2);
		if (bean != null) {
			System.out.println(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("ID not found");
		}

	}

	private static void Testdelete() {
		StudentModel model = new StudentModel();
		model.delete(9);
	}

	private static void Testupdate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StudentBean bean = new StudentBean();
		bean.setId(1);
		bean.setFirstName("Ajay");
		bean.setLastName("parmar");
		bean.setDob(sdf.parse("2025-09-12"));
		bean.setGender("male");
		bean.setMobileNo("7648880088");
		bean.setEmail("ajay@gmail.com");
		bean.setCollegeId(3);
		bean.setCollegeName("Khushi Lal College");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		StudentModel model = new StudentModel();
		model.update(bean);
	}

	private static void Testadd() throws ParseException {
		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		bean.setFirstName("aditya");
		bean.setLastName("sharma");
		bean.setDob(sdf.parse("12-09-2025"));
		bean.setGender("male");
		bean.setMobileNo("7648880088");
		bean.setEmail("aditya@gmail.com");
		bean.setCollegeId(101);
		bean.setCollegeName("Khushi Lal college");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		StudentModel model = new StudentModel();
		model.add(bean);

	}

	private static void Testnextpk() {
		StudentModel model = new StudentModel();

		int i = model.nextPk();
		System.out.println("NextPk:= " + i);

	}
}
