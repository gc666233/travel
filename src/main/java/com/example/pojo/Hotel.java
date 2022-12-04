package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Hotel {
    @TableId("hotel_id")
    private Integer hotelId;
    private Integer categoryId;
    private String hotelLocation;
    private String hotelName;
    private String hotelRank;
    private Integer hotelPrice;
    private Double hotelScore;
    private String hotelPosition;
    private String hotelImage;
    private Date hotelEstablishDate;
    private Integer hotelCount;

    @TableField(exist = false)
    private List<HotelDetails> detailsList;

    @TableField(exist = false)
    private List<HotelImg> hotelImgList;

    @TableField(exist = false)
    private List<HotelComment> hotelCommentList;

    @TableField(exist = false)
    private List<HotelRoom> hotelRoomList;
}
