package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author: Arkadiusz Brych
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> linesBeforeFilter = fileReader();
        System.out.println(linesBeforeFilter);
        List<String> linesAfterFilter = linesBeforeFilter.stream()
                .map(x -> x.replaceAll(",", ""))
                .map(x -> x.replaceAll("\\.", ""))
                .collect(Collectors.toList());
        System.out.println(linesAfterFilter);

        long sWords = linesAfterFilter.stream()
                .filter(x -> x.startsWith("s"))
                .count();
        System.out.println(sWords);

        long fiveLetterWords = linesAfterFilter.stream()
                .filter(x -> x.length() == 5)
                .peek(x -> System.out.println(x + ""))
                .count();
        System.out.println(fiveLetterWords);
    }

    static List<String> fileReader() throws FileNotFoundException {
        String fileName = "C:\\Users\\Arkadiusz\\IdeaProjects\\CollectionTask\\src\\resource\\loremipsum-129.txt";
        File file = new File(fileName);
        Scanner scan = new Scanner(file);

        List<String> lines = new ArrayList<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.addAll(Arrays.asList(line.split(" ")));
        }
        scan.close();
        return lines;
    }
}
