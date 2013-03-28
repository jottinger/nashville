/*
    Copyright 2012- by Joseph B. Ottinger.

    This file is part of Nashville, a nashville-notation converter.

    Alcyone is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Alcyone is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Nashville.  If not, see <http://www.gnu.org/licenses/>.
*/
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
