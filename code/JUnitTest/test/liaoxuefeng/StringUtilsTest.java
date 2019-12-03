package liaoxuefeng;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Description. <br>
 * @author Xiong Wangqi
 * @version V1.0
 * @since JDK1.8
 */
class StringUtilsTest {

    /**
     * 要用参数化测试的方法来测试，我们不但要给出输入，还要给出预期输出。因此，测试方法至少需要接收两个参数。
     * @param input 输入字符串
     * @param result 输出字符串
     */
    @ParameterizedTest
    @MethodSource
    void testCapitalize(String input, String result) {
        assertEquals(result, StringUtils.capitalize(input));
    }
    
    /**
     * 参数传入方法一：<br>
     * 在测试方法中使用 @MethodSource 注释，然后编写一个同名的静态方法来提供测试参数；
     * 如果静态方法和测试方法的名称不同，@MethodSource也允许指定方法名。但使用默认同名方法最方便.
     * @return testCapitalize 所需的输入输出
     */
    static List<Arguments> testCapitalize() {
        return Arrays.asList(new Arguments[]{
                Arguments.arguments("abc", "Abc"), 
                Arguments.arguments("APPLE", "Apple"), 
                Arguments.arguments("gooD", "Good")
        });
    }

    /**
     * 参数传入方法二：<br>
     * 使用@CsvSource，它的每一个字符串表示一行，一行包含的若干参数用，分隔.
     * @param input 输入字符串
     * @param result 输出字符串
     */
    @ParameterizedTest
    @CsvSource({ "abc, Abc", "APPLE, Apple", "gooD, Good" })
    void testCapitalizeUseCsvSource(String input, String result) {
        assertEquals(result, StringUtils.capitalize(input));
    }
    
    /**
     * 参数传入方法三：<br>
     * 把测试数据提到一个独立的CSV文件中，然后标注上 @CsvFileSource，便于大规模数据测试.
     * @param input 输入字符串
     * @param result 输出字符串
     */
    @ParameterizedTest
    @CsvFileSource(resources = { "/test-capitalize.csv" })
    void testCapitalizeUsingCsvFile(String input, String result) {
        assertEquals(result, StringUtils.capitalize(input));
    }
}
