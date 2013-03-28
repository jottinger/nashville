package com.redhat.osas.nashville;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Nashville {
    @Parameter(names="-key")
    String key="C";
    @Parameter(names="-mode")
    String mode="major";
    @Parameter(description="files")
    List<String> files=new ArrayList<>();

    public static void main( String[] args )    {
        Nashville nashville=new Nashville();
        new JCommander(nashville, args);
        nashville.run();
    }

    private void run() {
        LineProcessor processor=LineProcessor.getInstance();
        for(String file:files) {
            try {
                FileReader fr=new FileReader(file);
                Scanner scanner=new Scanner(fr);
                String input;
                while(scanner.hasNext()) {
                    input=scanner.nextLine();
                    System.out.println(processor.process(key, mode, input));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
