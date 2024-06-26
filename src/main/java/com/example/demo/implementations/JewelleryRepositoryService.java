package com.example.demo.implementations;

import com.example.demo.entities.JewelleryItem;

import java.util.List;

public interface JewelleryRepositoryService {
    List<JewelleryItem> getItems();
    JewelleryItem saveItem(JewelleryItem item);
}
