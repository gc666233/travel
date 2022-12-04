package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;


@Data
public class HotelComment {
    @TableId("comment_ic")
    private Integer commentId;
    private Integer hotelId;
    private String commentContent;
    private Date commentTime;
}
