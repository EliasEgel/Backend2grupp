package com.example.demo.Service;

import com.example.demo.Models.Item;
import com.example.demo.Repositories.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public Item getItem(Long id){
        return itemRepository.findById(id).get();
    }

    public String addItemtoRepo(Item i){
        itemRepository.save(i);
        return "Varan " + i.getName() + " har lagts till";
    }

}
