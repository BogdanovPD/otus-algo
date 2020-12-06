package bits;

import org.junit.jupiter.api.Test;
import ru.otus.algo.bits.Bits;

import java.math.BigInteger;
import java.util.List;

import static org.otus.algo.TestMain.*;

class BitsTest {

    private static final String TMPL = "%s\r\n%s";

    @Test
    void kingTest() throws Exception {
        runTestsAndCheckResult(getTestResource(this.getClass(), "king-tests"), input -> {
            List<String> args = parseArgs(input);
            BigInteger[] result = new Bits().king(Integer.parseInt(args.get(0)));
            return String.format(TMPL, result[0], result[1]);
        }, 0, 0);
    }

    @Test
    void horseTest() throws Exception {
        runTestsAndCheckResult(getTestResource(this.getClass(), "horse-tests"), input -> {
            List<String> args = parseArgs(input);
            BigInteger[] result = new Bits().horse(Integer.parseInt(args.get(0)));
            return String.format(TMPL, result[0], result[1]);
        }, 0, 0);
    }

    @Test
    void bishopTest() throws Exception {
        runTestsAndCheckResult(getTestResource(this.getClass(), "bishop-tests"), input -> {
            List<String> args = parseArgs(input);
            BigInteger[] result = new Bits().bishop(Integer.parseInt(args.get(0)));
            return String.format(TMPL, result[0], result[1]);
        }, 0, 0);
    }

    @Test
    void rookTests() throws Exception {
        runTestsAndCheckResult(getTestResource(this.getClass(), "rook-tests"), input -> {
            List<String> args = parseArgs(input);
            BigInteger[] result = new Bits().rook(Integer.parseInt(args.get(0)));
            return String.format(TMPL, result[0], result[1]);
        }, 0, 0);
    }

    @Test
    void queenTests() throws Exception {
        runTestsAndCheckResult(getTestResource(this.getClass(), "queen-tests"), input -> {
            List<String> args = parseArgs(input);
            BigInteger[] result = new Bits().queen(Integer.parseInt(args.get(0)));
            return String.format(TMPL, result[0], result[1]);
        }, 0, 0);
    }

}
