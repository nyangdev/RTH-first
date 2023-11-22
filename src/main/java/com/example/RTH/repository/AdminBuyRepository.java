package com.example.RTH.repository;

import com.example.RTH.entity.adminBuyMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface AdminBuyRepository extends JpaRepository<adminBuyMessage, Long> {
    @Override
    ArrayList<adminBuyMessage> findAll();
}
