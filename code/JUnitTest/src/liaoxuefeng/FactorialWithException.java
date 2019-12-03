package liaoxuefeng;

/**
 * 阶乘实现及异常处理.
 * 
 * @author Xiong Wangqi
 * @version V1.0
 * @since JDK1.8
 */
public class FactorialWithException {
    public static long fact(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        if (n > 20) {
            throw new ArithmeticException();
        }
        
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
    
}