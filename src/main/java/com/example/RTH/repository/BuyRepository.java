package com.example.RTH.repository;

import com.example.RTH.entity.Buy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface BuyRepository extends JpaRepository<Buy, Long> {
    @Override
    ArrayList<Buy> findAll();
}
