package lk.ac.vau.fas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ac.vau.fas.models.Product;


//JpaRepository provide basic functionalities like create save update delete 
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}


