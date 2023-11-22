package com.example.RTH.controller;

import com.example.RTH.dto.SellDTO;
import com.example.RTH.entity.Sell;
import com.example.RTH.entity.adminSellMessage;
import com.example.RTH.repository.AdminSellRepository;
import com.example.RTH.repository.SellRepository;
import com.example.RTH.service.SellService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class SellController {
    @Autowired
    private SellRepository sellRepository;

    @Autowired
    private AdminSellRepository adminSellRepository;

    @GetMapping("/sell")
    public String sellPage(Model model) {
        //1. 모든 데이터 가져오기
        ArrayList<Sell> sellEntityList = sellRepository.findAll();
        ArrayList<adminSellMessage> adminSellEntityList = adminSellRepository.findAll();
        //2. 모델에 데이터 등록하기
        model.addAttribute("sellList", sellEntityList);
        model.addAttribute("adminSellList", adminSellEntityList);
        //3. 뷰 페이지 설정하기
        return "/sell/sell";
    }

    @GetMapping("/sell/new")
    public String newSellText() {
        return "/sell/new";
    }

    @PostMapping("/sell/create")
    public String createSell(SellDTO sellDTO) {
        //1. DTO를 엔티티로 변환
        Sell sell = sellDTO.toEntity();
        log.info(sellDTO.toString());
        //2. 리파지터리로 엔티티를 DB에 저장
        Sell saved = sellRepository.save(sell);
        log.info(saved.toString());
        //3. 리다이렉트
        return "redirect:/sell/" + saved.getId();
    }

    @GetMapping("/sell/{id}")
    public String sellShow(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        //1. id를 조회해 데이터 가져오기
        Sell sellEntity = sellRepository.findById(id).orElse(null);
        //2. 모델에 데이터 등록하기
        model.addAttribute("sell", sellEntity);
        //3. 뷰 페이지 반환하기
        return "/sell/show";
    }
}
