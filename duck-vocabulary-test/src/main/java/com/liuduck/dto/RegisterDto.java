package com.liuduck.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.annotations.Param;

/**
 * @author Prince
 * @since 2022/6/16 1:35
 */
@Data
@Api("注册表单对象")
public class RegisterDto {

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("性别，1男2女")
    private int gender;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("验证码")
    private String code;

}
