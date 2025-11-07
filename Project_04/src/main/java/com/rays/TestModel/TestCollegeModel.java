package com.rays.TestModel;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.bean.CollegeBean;
import com.rays.model.CollegeModel;

public class TestCollegeModel {
	public static void main(String[] args) {
		// nextpk();
		// TestAdd();
		// Testupdate();
		// Testdelete();
		//Testfindbypk();
		Testlist();
	}

	private static void Testlist() {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = new CollegeBean();
		List<?> list = model.search(bean, 1, 5);
		Iterator<?> it = list.iterator();

		while(it.hasNext() ) {
			bean = (CollegeBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getPhoneNo());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}
		
	}

	private static void Testfindbypk() {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = model.findBypk(5);
		if (bean != null) {
			System.out.println("ID: " + bean.getId());
			System.out.println("Name: " + bean.getName());
			System.out.println("City: " + bean.getCity());
			System.out.println("Address: " + bean.getAddress());
			System.out.println("State: " + bean.getState());
			System.out.println("phone no: " + bean.getPhoneNo());
		} else {
			System.out.println("Record not found");
		}

	}

	private static void Testdelete() {
		CollegeModel model = new CollegeModel();
		model.delete(2);

	}

	private static void Testupdate() {
		CollegeBean bean = new CollegeBean();
		bean.setId(1);
		bean.setName("MANIT COLLEGE");
		bean.setAddress("chuna bhatti bhopal");
		bean.setCity("BHOPAL");
		bean.setState("Madhya pradesh");
		bean.setPhoneNo("89765432198");
		bean.setCreatedBy("Govt.of MP");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();
		model.update(bean);

	}

	private static void TestAdd() {
		CollegeBean bean = new CollegeBean();
		bean.setName("TRINITY COLLEGE");
		bean.setAddress(" BHOPAL");
		bean.setCity("BHOPAL");
		bean.setState("MP");
		bean.setPhoneNo("9876543210");
		bean.setCreatedBy(" PRIVATE ORGANIZATION");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();
		model.add(bean);

	}

	private static void nextpk() {
		CollegeModel model = new CollegeModel();
		int i = model.nextPk();
		System.out.println("NextPk=:" + i);

	}
}
