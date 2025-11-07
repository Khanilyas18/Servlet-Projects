package com.rays.TestModel;

import java.sql.Timestamp;
import java.util.Date;

import com.rays.bean.Rolebean;
import com.rays.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) {

		// TestNextPk();
		// TestAdd();
		// Testupdate();
		// TestDelete();
		//Testfindbypk();
		Testfindbyname();
	}

	private static void Testfindbyname() {
		RoleModel model = new RoleModel();
		
		Rolebean bean = model.findbyName("yusuf");
		
		if (bean !=null) {
			
			System.out.print("\t"+ bean.getId());
			System.out.print("\t"+  bean.getName());
			System.out.print("\t"+  bean.getDescription());
			System.out.print("\t"+  bean.getCreatedby());
			System.out.print("\t"+  bean.getModifiedBy());
			System.out.print("\t"+  bean.getCreatedDatetime());
			System.out.print("\t"+  bean.getModifiedDatetime());
			
		}
		
	}

	private static void Testfindbypk() {
		RoleModel model = new RoleModel();
		Rolebean bean = model.findBypk(2);
		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("Id not found");
		}

	}

	private static void TestDelete() {
		RoleModel model = new RoleModel();
		model.delete(1);

	}

	private static void Testupdate() {
		Rolebean bean = new Rolebean();
		bean.setId(1);
		bean.setName("Amit");
		bean.setDescription("admin");
		bean.setCreatedBy("Ameesh");
		bean.setModifiedBy("aman");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		RoleModel model = new RoleModel();
		model.update(bean);

	}

	private static void TestAdd() {

		Rolebean bean = new Rolebean();
		bean.setName("yusuf");
		bean.setDescription("Admin");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		RoleModel model = new RoleModel();
		model.add(bean);

	}

	private static void TestNextPk() {
		RoleModel model = new RoleModel();

		int i = model.nextPk();

		System.out.println("nextPk " + i);

	}
}
