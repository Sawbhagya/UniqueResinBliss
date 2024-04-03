package lk.ac.vau.fas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ac.vau.fas.models.MyItemList;

@Repository
public interface MyItemsRepository extends JpaRepository<MyItemList, Integer>{

}

