package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
/**programa Principal
 * 
 */
public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		SellerDao sellerDao = DaoFactory.creatSellerDao();
		
		System.out.println("=== Test 1: seller finbyId ====");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller finbyDepartment ====");
		Department department = new Department (2, null);
		List<Seller> list = sellerDao.finByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n=== Test 3: seller findAll ====");
		list = sellerDao.findAll();
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 4: seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gamil.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		
		System.out.println("\n=== Test 5: seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		System.out.println("\n=== Test 6: seller Delete ====");
		System.out.println("Enter  id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Complete");
		
		sc.close();
	}
	

}
