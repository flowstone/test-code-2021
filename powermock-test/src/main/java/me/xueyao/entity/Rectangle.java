package me.xueyao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Simon.Xue
 * @date 2021/4/8 5:00 下午
 **/
@Getter
@Setter
@ToString
public class Rectangle implements Serializable {
    private double width;
    private double height;

    public double getArea() {
        return width * height;
    }
}
