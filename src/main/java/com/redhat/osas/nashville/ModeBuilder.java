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

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * User: jottinge
 * Date: 3/28/13
 * Time: 9:33 AM
 */
public class ModeBuilder {
    private static final ModeBuilder instance = new ModeBuilder();
    Map<String, List<Integer>> modes;
    List<String> notes;

    private ModeBuilder() {
        InputStream modesStream = this.getClass().getResourceAsStream("/modes.properties");
        try {
            Properties properties = new Properties();
            properties.load(modesStream);
            Map<String, List<Integer>> modes = new HashMap<>();
            for (String prop : properties.stringPropertyNames()) {
                String[] steps = properties.getProperty(prop).split(" ");
                List<Integer> stepsList = new ArrayList<>();
                int base = 0;
                for (String step : steps) {
                    base += Integer.parseInt(step);
                    stepsList.add(base);
                }
                modes.put(prop, Collections.unmodifiableList(stepsList));
            }
            this.modes = Collections.unmodifiableMap(modes);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Exiting");
            System.exit(-1);
        }
        List<String> notes = new ArrayList<>();
        addOctave(notes);
        addOctave(notes);
        this.notes = Collections.unmodifiableList(notes);
    }

    public static ModeBuilder getInstance() {
        return instance;
    }

    private void addOctave(List<String> notes) {
        for (char c = 'A'; c < 'H'; c++) { // woo, c++
            notes.add(Character.toString(c));
            switch (c) {
                case 'A':
                case 'C':
                case 'D':
                case 'F':
                case 'G':
                    notes.add(Character.toString(c) + "#");
                    break;
                default:
                    break;
            }
        }
    }

    private int convertFromRoman(String romanNumeral) {
        return Numerals.valueOf(romanNumeral.trim().toUpperCase()).ordinal();
    }

    public Integer getStep(String mode, String index) {
        if (index.endsWith("b") || index.endsWith("#")) {
            index = index.substring(0, index.length() - 1);
        }
        return modes.get(mode.toLowerCase()).get(convertFromRoman(index));
    }

    public String getNote(String mode, String key, String numeral) {
        int offset=0;
        if (numeral.endsWith("b")) {
            offset = -1;
        } else {
            if (numeral.endsWith("#")) {
                offset = 1;
            }
        }

        int step = getStep(mode, numeral);
        int base = notes.indexOf(key.toUpperCase());
        return notes.get(base + step + offset);
    }

    enum Numerals {I, II, III, IV, V, VI, VII, VIII, IX, X, XI, XII}
}
