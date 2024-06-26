package com.example.demo.implementations;

import com.example.demo.entities.JewelleryItem;
import com.example.demo.reposotories.JewelleryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JewelleryRepositoryServiceImplementation implements JewelleryRepositoryService{
    private JewelleryItemRepository repository;

    public JewelleryRepositoryServiceImplementation(JewelleryItemRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public List<JewelleryItem> getItems() {
        return repository.findAll();
    }

    @Override
    public JewelleryItem saveItem(JewelleryItem item) {
        return repository.save(item);
    }
}
