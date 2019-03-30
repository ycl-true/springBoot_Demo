package com.example.demo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/*
参数包装对象
 */
@Data
@ApiModel(value = "接受对象model")
public class Condition {
    @ApiModelProperty(value = "id",required = true)
    private String id;
    @ApiModelProperty(value = "name",required = true)
    public String name;
}
