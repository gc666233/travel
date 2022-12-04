package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class HotelRoom {
    @TableId("room_id")
    private Integer roomId;
    private String roomImage;
    private Integer hotelId;
    private String roomType;
    private String breakfast;
    private Integer roomPrice;
}
