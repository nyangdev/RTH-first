package com.example.RTH.dto;

import com.example.RTH.entity.Sell;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
//폼데이터를 받아올 그릇 DTO
public class SellDTO {
    private Long id;
    private String title;
    private String content;
    private String price;

    public Sell toEntity() {
        return new Sell(id, title, content, price);
    }
}
