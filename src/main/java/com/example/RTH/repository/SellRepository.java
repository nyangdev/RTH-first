package com.example.RTH.repository;

import com.example.RTH.entity.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface SellRepository extends JpaRepository<Sell, Long> {
    @Override
    ArrayList<Sell> findAll();
}
