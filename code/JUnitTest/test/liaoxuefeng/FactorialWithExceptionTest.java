package liaoxuefeng;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class FactorialWithExceptionTest {
    /**
     * 输入参数不能是负数.
     */
    @Test
    void testNegative() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                FactorialWithException.fact(-1);
            }
        });
    }
    
    /**
     * 测试输入参数过大抛出的异常（long 类型的范围限制带来的限制）.
     */
    @Test
    void testInputScale() {
        assertThrows(ArithmeticException.class, () -> FactorialWithException.fact(21));
    }
}
