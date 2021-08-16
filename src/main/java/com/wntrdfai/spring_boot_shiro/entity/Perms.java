package com.wntrdfai.spring_boot_shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wntrdfai
 * @Packagecom.wntrdfai.spring_boot_shiro.entity
 * @date 2021/8/13 13:21
 * 作用:
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Perms implements Serializable {
    private String id;
    private String name;
    private String url;
}
