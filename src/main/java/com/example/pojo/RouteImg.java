package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class RouteImg {
    @TableId("route_img_id")
    private Integer routeImgId;//商品图片id
    private Integer routeId;//旅游商品id
    private String routeBigPic;//详情商品大图
    private String routeSmallPic;//详情商品小图
}
