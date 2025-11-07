package com.rays.TestModel;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

public class TestUserModel {
	public static void main(String[] args) throws Exception {

		
		// addTest();
		//testupdate();
		//testdelete();
		//testfindbypk();
		//testnextPk();
		testlogin();
	}

	public static void testlogin() {
		UserModel model = new UserModel();
		UserBean bean = model.findByLogin("rohit@gmail.com");
		if (bean !=null) {
			
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			//System.out.print("\t" + bean.getConfirmPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileno());
			System.out.print("\t" + bean.getRollId());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

			
		}
		
	}

	public static void testnextPk() {
		UserModel model = new UserModel();
		int i = model.nextPk();
		System.out.println("NextPk:"+i);
		
	}

	private static void testfindbypk() {

			UserModel model = new UserModel();

			UserBean bean = model.finByPk(3);

			if (bean != null) {

				System.out.print(bean.getId());
				System.out.print("\t" + bean.getFirstName());
				System.out.print("\t" + bean.getLastName());
				System.out.print("\t" + bean.getLogin());
				System.out.print("\t" + bean.getPassword());
				System.out.print("\t" + bean.getConfirmPassword());
				System.out.print("\t" + bean.getDob());
				System.out.print("\t" + bean.getMobileno());
				System.out.print("\t" + bean.getRollId());
				System.out.print("\t" + bean.getGender());
				System.out.print("\t" + bean.getCreatedby());
				System.out.print("\t" + bean.getModifiedBy());
				System.out.print("\t" + bean.getCreatedDatetime());
				System.out.println("\t" + bean.getModifiedDatetime());

			}
		}
		
	

	private static void testdelete() {
		UserModel model = new UserModel();
		model.delete(2);
		
	}

	private static void testupdate() throws ParseException {
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		bean.setId(3);
		bean.setFirstName("rohit");
		bean.setLastName("sharma");
		bean.setLogin("rohit@gmail.com");
		bean.setPassword("Pass3215");
		bean.setDob(sdf.parse("2025-09-05"));
		bean.setMobileno("9145786542");
		bean.setRollId(1);
		bean.setGender("male");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	model.update(bean);

	}

	private static void addTest() throws ParseException {

		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();

		bean.setFirstName("arishfa");
		bean.setLastName("khan");
		bean.setLogin("arishfa@gmail.com");
		bean.setPassword("pass9876");
		bean.setDob(sdf.parse("2025-09-04"));
		bean.setMobileno("7863126754");
		bean.setRollId(8);
		bean.setGender("female");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}
}
