package com.example.RTH.dto;

import com.example.RTH.entity.Buy;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString

//폼 데이터를 받아올 그릇 DTO
public class BuyDTO {
    private Long id;
    private String title;
    private String content;
    private String price;

    public Buy toEntity() {
        return new Buy(id, title, content, price);
    }
}
