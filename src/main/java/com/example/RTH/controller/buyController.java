package com.example.RTH.controller;

import com.example.RTH.dto.BuyDTO;
import com.example.RTH.entity.Buy;
import com.example.RTH.entity.adminBuyMessage;
import com.example.RTH.repository.AdminBuyRepository;
import com.example.RTH.repository.BuyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Slf4j
@Controller
public class buyController {
    @Autowired
    private BuyRepository buyRepository;
    @Autowired
    private AdminBuyRepository adminBuyRepository;

    @GetMapping("/buy")
    public String buyPage(Model model) {
        //1. 모든 데이터 가져오기
        ArrayList<Buy> buyEntityList = buyRepository.findAll();
        ArrayList<adminBuyMessage> adminBuyEntityList = adminBuyRepository.findAll();
        //2. 모델에 데이터 등록하기
        model.addAttribute("buyList", buyEntityList);
        model.addAttribute("adminBuyList", adminBuyEntityList);
        //3. 뷰 페이지 설정하기
        return "buy/buy";
    }

    @GetMapping("/buy/new")
    public String newBuyText() {
        return "/buy/new";
    }

    @PostMapping("/buy/create")
    public String createBuy(BuyDTO buyDTO) {
        //1. DTO를 엔티티로 변환
        Buy buy = buyDTO.toEntity();
        //2. 리파지터리로 엔티티를 DB에 저장
        Buy saved = buyRepository.save(buy);
        log.info(saved.toString());
        //3. 리다이렉트
        return "redirect:/buy/" + saved.getId();
    }
    @GetMapping("/buy/{id}")
    public String sellShow(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        //1. id를 조회해 데이터 가져오기
        Buy buyEntity = buyRepository.findById(id).orElse(null);
        //2. 모델에 데이터 등록하기
        model.addAttribute("buy", buyEntity);
        //3. 뷰 페이지 반환하기
        return "/buy/show";
    }
}
