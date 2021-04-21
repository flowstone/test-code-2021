package me.xueyao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Simon.Xue
 * @date 2021/4/8 5:13 下午
 **/
@Getter
@Setter
@ToString
public final class Circle {
    private double radius;

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
