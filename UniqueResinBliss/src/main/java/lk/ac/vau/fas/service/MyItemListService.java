package lk.ac.vau.fas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ac.vau.fas.models.MyItemList;
import lk.ac.vau.fas.repository.MyItemsRepository;

@Service //to indicate this is a service class
public class MyItemListService {
	
	@Autowired
	private MyItemsRepository myitem;
	
	public void saveMyItems(MyItemList item) {
		myitem.save(item);
	}
	
	public List<MyItemList> getAllMyItems(){
		return myitem.findAll();
	}
	
	public void deleteById(int id) {
		myitem.deleteById(id);
	}

}

