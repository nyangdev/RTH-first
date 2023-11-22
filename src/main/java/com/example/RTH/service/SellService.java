package com.example.RTH.service;

import com.example.RTH.entity.Sell;
import com.example.RTH.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellService {
    @Autowired
    private SellRepository sellRepository;
}
