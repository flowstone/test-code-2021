package me.xueyao;

import me.xueyao.entity.Rectangle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * T PowerMockito.mock(Class clazz);
 * 用途：
 * 可以用于模拟指定类的对象实例。
 * 当模拟非final类（接口、普通类、虚基类）的非final方法时，不必使用@RunWith和@PrepareForTest注解。当模拟final类或final方法时，必须使用@RunWith和@PrepareForTest注解。注解形如：
 * @RunWith(PowerMockRunner.class)
 * @PrepareForTest({TargetClass.class})
 *
 * @author Simon.Xue
 * @date 2021/4/8 4:58 下午
 **/
@RunWith(PowerMockRunner.class)
@PrepareForTest({})
public class RectangleTest {

    @Test
    public void testGetArea() {
        double expectArea = 100.0D;
        Rectangle rectangle = PowerMockito.mock(Rectangle.class);
        PowerMockito.when(rectangle.getArea()).thenReturn(expectArea);
        double actualArea = rectangle.getArea();
        Assert.assertEquals("返回值不相等", expectArea, actualArea, 1E-6D);
    }
}


