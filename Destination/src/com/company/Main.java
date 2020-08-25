package com.company;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

import static java.nio.file.Paths.*;


public final class Main {

    public static void main(String... args) throws IOException {
        Main parser = new Main("/Users/manasipalkar/Desktop/CustomerList.txt");
        parser.parseLineByLine();
        log("Done.");
    }

    /**
     Constructor
     */
    public Main(String fileName){
        filePath = get(fileName);
    }

    public final void parseLineByLine() throws IOException {
        try (Scanner scanner =  new Scanner(filePath, ENCODING.name())){
            while (scanner.hasNextLine()){
                parseEachLine(scanner.nextLine());
            }
        }
    }


    protected void parseEachLine(String line){
        //second Scanner to parse the content of each line
        try(Scanner scanner = new Scanner(line)){
            scanner.useDelimiter(",");
            if (scanner.hasNext()){
                //assumes the line has a certain structure
                String latitude = scanner.next();
                String user_id = scanner.next();
                String name = scanner.next();
              String longitude = scanner.next();
                System.out.println(user_id.trim());
                System.out.println(name.trim());
            }
            else {
                log("Empty or invalid line. Unable to process.");
            }
        }
    }

    // PRIVATE
    private final Path filePath;
    private final static Charset ENCODING = StandardCharsets.UTF_8;

    private static void log(Object object){
        System.out.println(Objects.toString(object));
    }
}