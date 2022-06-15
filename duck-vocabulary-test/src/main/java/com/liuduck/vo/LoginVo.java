package com.liuduck.vo;

import com.liuduck.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Prince
 * @since 2022/6/16 1:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户登录返回")
public class LoginVo {

    @ApiModelProperty("token字符串，在下次发送请求的时候，这个token要放在请求头的authorization里")
    private String token;

    @ApiModelProperty("登录成功后的User信息")
    private User user;

}
