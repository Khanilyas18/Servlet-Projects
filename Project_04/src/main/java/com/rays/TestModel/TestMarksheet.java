package com.rays.TestModel;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.bean.MarksheetBean;
import com.rays.model.MarksheetModel;

public class TestMarksheet {
	public static void main(String[] args) {

		// Testnextpk();
		// Testadd();
		// Testupdate();
		// Testdelete();
		// TestfindByPk();
		// TestfindByRoll();
		Testsearch();
	}

	private static void Testsearch() {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		List list = model.search(bean, 1, 10);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (MarksheetBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}

	}

	private static void TestfindByRoll() {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findByRoll("BE107");
		if (bean != null) {
			System.out.println(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("RollNo not found");
		}

	}

	private static void TestfindByPk() {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findByPk(1);
		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Id not found");
		}

	}

	private static void Testdelete() {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		model.delete(4);

	}

	private static void Testupdate() {
		MarksheetBean bean = new MarksheetBean();

		bean.setId(10);
		bean.setRollNo("BE111");
		bean.setStudentId(9);
		bean.setName("aliya");
		bean.setPhysics(76);
		bean.setChemistry(79);
		bean.setMaths(89);
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		MarksheetModel model = new MarksheetModel();
		model.update(bean);

	}

	private static void Testadd() {
		MarksheetBean bean = new MarksheetBean();
		bean.setRollNo("BE109");
		bean.setStudentId(8);
		bean.setName("aliya");
		bean.setPhysics(80);
		bean.setChemistry(85);
		bean.setMaths(90);
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		MarksheetModel model = new MarksheetModel();
		model.add(bean);

	}

	private static void Testnextpk() {
		MarksheetModel model = new MarksheetModel();
		int i = model.nextPk();
		System.out.println("Nextpk=" + i);

	}
}
