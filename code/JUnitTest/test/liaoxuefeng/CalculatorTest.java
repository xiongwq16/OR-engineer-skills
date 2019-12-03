package liaoxuefeng;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator calculator;

    /**
     * BeforeEach 会在每个测试方法运行前调用.
     * @throws Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        calculator = new Calculator();
    }

    /**
     * @AfterEach 会在每个测试方法运行完成后调用，JUnit还提供了 BeforeAll 和 AfterAll，它们在运行所有测试方法前后运行.
     * @throws Exception
     */
    @AfterEach
    void tearDown() throws Exception {
        calculator = null;
    }

    @Test
    void testAdd() {
        assertEquals(100, this.calculator.add(100));
        assertEquals(150, this.calculator.add(50));
        assertEquals(130, this.calculator.add(-20));
    }

    @Test
    void testSub() {
        assertEquals(-100, this.calculator.sub(100));
        assertEquals(-150, this.calculator.sub(50));
        assertEquals(-130, this.calculator.sub(-20));
    }
    
}
