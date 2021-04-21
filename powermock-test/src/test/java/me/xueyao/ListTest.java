package me.xueyao;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Simon.Xue
 * @date 2021/4/8 4:57 下午
 **/
@SpringBootTest
public class ListTest {
    @Test
    public void testSize() {
        Integer expected = 100;
        List mock = PowerMockito.mock(List.class);
        // 当调用size方法，然后返回expected
        PowerMockito.when(mock.size()).thenReturn(expected);

        Integer actual = mock.size();
        Assert.assertEquals("返回值不相等", expected, actual);
    }
}
