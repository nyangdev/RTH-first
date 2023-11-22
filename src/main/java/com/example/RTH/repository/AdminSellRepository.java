package com.example.RTH.repository;

import com.example.RTH.entity.adminSellMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface AdminSellRepository extends JpaRepository<adminSellMessage, Long> {
    @Override
    ArrayList<adminSellMessage> findAll();
}
