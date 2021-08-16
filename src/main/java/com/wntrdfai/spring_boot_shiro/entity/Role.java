package com.wntrdfai.spring_boot_shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author wntrdfai
 * @Packagecom.wntrdfai.spring_boot_shiro.entity
 * @date 2021/8/13 13:22
 * 作用:
 */
@Data
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    private String id;
    private String name;

    //定义权限集合
    private List<Perms> perms;
}
