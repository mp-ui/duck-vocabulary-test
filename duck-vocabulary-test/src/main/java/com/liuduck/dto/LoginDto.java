package com.liuduck.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Prince
 * @since 2022/6/16 1:32
 */
@Data
@Api("登录表单对象")
public class LoginDto {
    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("密码")
    private String password;
}
