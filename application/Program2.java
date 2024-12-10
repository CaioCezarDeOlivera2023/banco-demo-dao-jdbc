package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== Test 1 : findById ====");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n==== Test 2 : findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		System.out.println("\n==== Test 3 : Insert ====");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("inserted! New Id: " + newDepartment.getId());
		
		System.out.println("\n==== Test 4 : Update ====");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("update Complete");
		
		System.out.println("\n==== Test 5 : Delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Complete");
		
		sc.close();

		}
	}

