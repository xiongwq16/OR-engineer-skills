package liaoxuefeng;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class ConfigTest {
    Config config;
    
    @BeforeEach
    void setUp() throws Exception {
        config = new Config();
    }
    
    @AfterEach
    void tearDown() throws Exception {
        config = null;
    }
    
    /**
     * 条件：EnabledOnOs，只在 windows 上运行.
     */
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testWindows() {
        assertEquals("C:\\test.ini", config.getConfigFile("test.ini"));
    }
    
    /**
     * 在运行测试的时候，有些时候，我们需要排出某些@Test方法，不要让它运行，这时，我们就可以给它标记一个 @Disabled.
     */
    @Disabled
    @Test
    void testBug101() {
        // 这个测试不会运行
    }
    
    /**
     * 条件：EnabledOnOs，只在 LINUX 或 MAC 上运行.
     */
    @Test
    @EnabledOnOs({ OS.LINUX, OS.MAC })
    void testLinuxAndMac() {
        assertEquals("/usr/local/test.cfg", config.getConfigFile("test.cfg"));
    }
    
    /**
     * 条件：不能再 windows 上运行.
     */
    @Test
    @DisabledOnOs(OS.WINDOWS)
    void testOnNonWindowsOs() {
        // TODO: this test is disabled on windows
    }

    /**
     * 只能在Java 9或更高版本执行的测试.
     */
    @Test
    @DisabledOnJre(JRE.JAVA_8)
    void testOnJava9OrAbove() {
        // TODO: this test is disabled on java 8
    }
    
    /**
     * 只能在64位操作系统上执行的测试.
     */
    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void testOnlyOn64bitSystem() {
        // TODO: this test is only run on 64 bit system
    }
    
    /**
     * 需要传入环境变量DEBUG=true才能执行的测试，可以用@EnabledIfEnvironmentVariable.
     */
    @Test
    @EnabledIfEnvironmentVariable(named = "DEBUG", matches = "true")
    void testOnlyOnDebugMode() {
        // TODO: this test is only run on DEBUG=true
    }
    
    /**
     * 万能的 EnableIf 可以执行任意Java语句并根据返回的boolean决定是否执行测试.
     */
    @Test
    @EnabledIf("java.time.LocalDate.now().getDayOfWeek()==java.time.DayOfWeek.SUNDAY")
    void testOnlyOnSunday() {
        // TODO: this test is only run on Sunday
    }
}
