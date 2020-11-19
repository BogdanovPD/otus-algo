package algo;

import org.junit.jupiter.api.Test;
import ru.otus.algo.Fibo;
import ru.otus.algo.Primes;

import java.util.List;

import static org.otus.algo.TestMain.parseArgs;
import static org.otus.algo.TestMain.runTestsAndCheckResult;

class PrimeTest {

    @Test
    void bruteForceTest() throws Exception {
        runTestsAndCheckResult("./prime-tests", input -> {
            List<String> args = parseArgs(input);
            return String.valueOf(new Primes().bruteForce(Integer.parseInt(args.get(0))));
        }, 10, 0); // tests > 9 are executed toooooooo long for this impl
    }

}
