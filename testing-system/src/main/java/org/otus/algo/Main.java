package org.otus.algo;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("Please specify jar path as 1 parameter");
            System.out.println("Please specify testsPath as 2 parameter");
            System.out.println("Please specify count of tests to run (must be an integer, 0 == all)");
        }

        String path = args[0];
        String testsPath = args[1];
        int count = Integer.parseInt(args[2]);

        runTestsAndCheckResult(path, testsPath, count);
    }

    private static void runTestsAndCheckResult(String path, String testsPath, int count) throws Exception {
        String tmpl = "%s/test.%s.%s";

        if (count == 0) {
            try (Stream<Path> paths = Files.walk(Paths.get(testsPath))) {
                count = (int) paths
                        .filter(p -> Files.isRegularFile(p) && FilenameUtils.isExtension(p.toString(), "in"))
                        .count();
            }
        }

        for (int i = 0; i < count; i++) {
            File inFile = Paths.get(String.format(tmpl, testsPath, i, "in")).toFile();
            String inData = FileUtils.readFileToString(inFile, "UTF-8");
            File outFile = Paths.get(String.format(tmpl, testsPath, i, "out")).toFile();
            String expectedResult = FileUtils.readFileToString(outFile, "UTF-8").trim();

            System.out.println("Test " + i + " started");
            long startTime = System.currentTimeMillis();
            Process proc = Runtime.getRuntime().exec("java -jar " + path + " " + inData);
            proc.waitFor();
            InputStream in = proc.getInputStream();
            String executionResult = new String(in.readAllBytes()).trim();
            in.close();
            long endTime = System.currentTimeMillis();
            if (executionResult.equals(expectedResult)) {
                System.out.println("Test " + i + " passed!");
            } else {
                System.out.println("Test " + i + " failed!");
                System.out.println(executionResult + " is not equal to " + expectedResult);
            }
            System.out.println("Execution time: " + (endTime - startTime) + " ms");
        }
    }
}
