package com.nh.authorization;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Getouo(梁圣贤) on 2023/5/8
 * @version 1.0
 */
@Data
@TableName("`user`")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}