package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class HotelDetails {
    @TableId("details_id")
    private Integer detailsId;
    private Integer hotelId;
    private String detailsName;
    private String detailsContent;
}
