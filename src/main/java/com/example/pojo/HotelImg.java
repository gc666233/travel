package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class HotelImg {
    @TableId("hotel_img_id")
    private Integer hotelImgId;//酒店图片id
    private Integer hotelId;//酒店商品id
    private String hotelBigPic;//详情酒店大图
    private String hotelSmallPic;//详情酒店小图
}
