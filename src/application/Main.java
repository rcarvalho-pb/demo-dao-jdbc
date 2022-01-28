package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: Seller findById ===");		
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: Seller findByDepartment ===");		
		Department department = new Department(2, null);
		List<Seller> seller1 = sellerDao.findByDepartment(department);		
		for(Seller obj : seller1) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 3: Seller findAll ===");
		seller1 = sellerDao.findAll();		
		for(Seller obj : seller1) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 4: Seller Insert ===");		
		Seller newSeller = new Seller(null, "Greg Black", "greg@gmail.com", new Date(), 3000.00, department);	
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New seller Id: " + newSeller.getId());
		
	}
}
