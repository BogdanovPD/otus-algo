package algo;

import org.junit.jupiter.api.Test;
import ru.otus.algo.Fibo;
import ru.otus.algo.Pow;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

import static org.otus.algo.TestMain.parseArgs;
import static org.otus.algo.TestMain.runTestsAndCheckResult;

class FiboTest {

    @Test
    void iterTest() throws Exception {
        runTestsAndCheckResult("./fibo-tests", input -> {
            List<String> args = parseArgs(input);
            return String.valueOf(new Fibo(Integer.parseInt(args.get(0))).iter());
        }, 11, 0); // tests > 10 are executed toooooooo long for this impl
    }

    @Test
    void recursiveTest() throws Exception {
        runTestsAndCheckResult("./fibo-tests", input -> {
            List<String> args = parseArgs(input);
            return String.valueOf(new Fibo(Integer.parseInt(args.get(0))).recursive());
        }, 8, 0); // tests > 7 are executed toooooooo long for this impl
    }

    @Test
    void goldenTest() throws Exception {
        runTestsAndCheckResult("./fibo-tests", input -> {
            List<String> args = parseArgs(input);
            return String.valueOf(new Fibo(Integer.parseInt(args.get(0))).golden());
        }, 8, 0); // tests > 7 are executed toooooooo long for this impl
    }

}
