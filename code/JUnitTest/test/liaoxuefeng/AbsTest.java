package liaoxuefeng;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 参数化测试：<br>
 * 如果待测试的输入和输出是一组数据：可以把测试数据组织起来,用不同的测试数据调用相同的测试方法；
 * 参数化测试和普通测试稍微不同的地方在于，一个测试方法需要接收至少一个参数，然后，传入一组参数反复运行.
 * @author Xiong Wangqi
 * @version V1.0
 * @since JDK1.8
 */
class AbsTest {

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 5, 100 })
    void testAbs(int x) {
        assertEquals(x, Math.abs(x));
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, -5, -100 })
    void testAbsNegative(int x) {
        assertEquals(-x, Math.abs(x));
    }
    
}
