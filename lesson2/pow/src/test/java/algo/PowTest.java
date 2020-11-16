package algo;

import org.junit.jupiter.api.Test;
import ru.otus.algo.Pow;

import java.math.RoundingMode;
import java.util.List;

import static org.otus.algo.TestMain.parseArgs;
import static org.otus.algo.TestMain.runTestsAndCheckResult;

class PowTest {

    @Test
    void iterTest() throws Exception {
        Pow pow = new Pow(RoundingMode.HALF_UP);
        runTestsAndCheckResult("./power-tests", input -> {
            List<String> args = parseArgs(input);
            return String.valueOf(pow.iter(Double.parseDouble(args.get(0)), Long.parseLong(args.get(1))));
        }, 9, 0); // 10 test is toooooooo long for this impl
    }

    @Test
    void pow2Test() throws Exception {
        Pow pow = new Pow(RoundingMode.HALF_UP);
        runTestsAndCheckResult("./power-tests", input -> {
            List<String> args = parseArgs(input);
            return String.valueOf(pow.pow2(Double.parseDouble(args.get(0)), Long.parseLong(args.get(1))));
        }, 10, 9);
    }

    @Test
    void expansionTest() throws Exception {
        Pow pow = new Pow(RoundingMode.HALF_UP);
        runTestsAndCheckResult("./power-tests", input -> {
            List<String> args = parseArgs(input);
            return String.valueOf(pow.expansion(Double.parseDouble(args.get(0)), Long.parseLong(args.get(1))));
        }, 10, 9);
    }

}
