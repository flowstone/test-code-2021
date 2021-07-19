package me.xueyao.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Simon.Xue
 * @date 2021/4/30 9:32 上午
 **/
@Data
public class School implements Serializable {
    private Integer id;
    private String name;
    private String local;
}
