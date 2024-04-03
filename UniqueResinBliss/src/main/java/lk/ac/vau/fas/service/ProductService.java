package lk.ac.vau.fas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ac.vau.fas.models.Product;
import lk.ac.vau.fas.repository.ProductRepository;

@Service//this class is belong to service
public class ProductService {
	
	@Autowired
	private ProductRepository pRepo;
	
	public void save(Product p) {
		pRepo.save(p);
	}

	public List<Product> getAllProducts(){
		return pRepo.findAll();
	}
	
	public Product getItemById(int id) {
		return pRepo.findById(id).get();
	} 
	
	public void deleteById(int id) {
		pRepo.deleteById(id);
	}
}

