package com.example.demo.reposotories;

import com.example.demo.entities.JewelleryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JewelleryItemRepository extends JpaRepository<JewelleryItem, Integer> {

}