package org.csgi.digital;

import org.csgi.digital.input.FileInputSource;
import org.csgi.digital.service.WordCountService;
import org.csgi.digital.util.WordsUtil;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) {
        handleInput();
    }

    private static void handleInput() {
        System.out.println("Please input the fileName");
        Scanner fileNameScanner = new Scanner(System.in);
        String inputFileName = fileNameScanner.nextLine();
        handleWordCount(inputFileName);
    }

    private static void handleCorrectInput(String oldFileName) {
        System.out.println("Please input the correct fileName " + oldFileName + " is not valid");
        Scanner fileNameScanner = new Scanner(System.in);
        String inputFileName = fileNameScanner.nextLine();
        handleWordCount(inputFileName);
    }

    private static void handleWordCount(String fileName) {
        var wordCountService = new WordCountService();
        FileInputSource fileInputSource = new FileInputSource(fileName);

        try {
            int length = 5;
            String prefixToBeMatched = "M";

            List<String> input = WordsUtil.getWordsFromString(fileInputSource.input());
            long wordsCount = wordCountService.countWordsWithMatchingPrefix(input, prefixToBeMatched);
            System.out.println("Number of words with length greater than "+length+" is : "+wordsCount);

            List<String> words = wordCountService.findWordsGreaterThanCertainLength(input, length);
            System.out.println("Words starting with prefix "+ prefixToBeMatched +" are: ");
            words.forEach(System.out::println);

            List<String> wordsWithGreaterThan5LengthAndStartsWithM = wordCountService
                    .findWordsGreaterThanCertainLengthAndMatchingPrefix(input, length, prefixToBeMatched);
            System.out.println("Words greater than length "+length+" and starting with prefix "+ prefixToBeMatched +" are: ");
            wordsWithGreaterThan5LengthAndStartsWithM.forEach(System.out::println);

        } catch (NoSuchFileException noSuchFileException) {
            handleCorrectInput(fileName);
        } catch (IOException e) {
            handleCorrectInput(fileName);
        }
    }
}
