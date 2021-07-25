package me.xueyao.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Simon.Xue
 * @date 2021/7/22 11:13 下午
 **/
@Data
public class Employee implements Serializable {
    private String jobNumber;
    private String username;
    private String email;
    private String phone;
}
