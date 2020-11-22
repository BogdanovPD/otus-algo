package algo;

import org.junit.jupiter.api.Test;
import ru.otus.algo.Fibo;

import java.util.List;

import static org.otus.algo.TestMain.*;

class FiboTest {

    @Test
    void iterTest() throws Exception {
        runTestsAndCheckResult(getTestResource(this.getClass(), "fibo-tests"), input -> {
            List<String> args = parseArgs(input);
            return String.valueOf(new Fibo().iter(Integer.parseInt(args.get(0))));
        }, 11, 0); // tests > 10 are executed toooooooo long for this impl
    }

    @Test
    void recursiveTest() throws Exception {
        runTestsAndCheckResult(getTestResource(this.getClass(), "fibo-tests"), input -> {
            List<String> args = parseArgs(input);
            return String.valueOf(new Fibo().recursive(Integer.parseInt(args.get(0))));
        }, 7, 0); // tests > 6 are executed toooooooo long for this impl
    }

    @Test
    void goldenTest() throws Exception {
        runTestsAndCheckResult(getTestResource(this.getClass(), "fibo-tests"), input -> {
            List<String> args = parseArgs(input);
            return String.valueOf(new Fibo().golden(Integer.parseInt(args.get(0))));
        }, 8, 0); // tests > 7 are executed toooooooo long for this impl
    }

}
