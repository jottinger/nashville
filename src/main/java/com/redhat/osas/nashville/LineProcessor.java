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

/**
 * User: jottinge
 * Date: 3/28/13
 * Time: 11:26 AM
 */
public class LineProcessor {
    private static final LineProcessor instance = new LineProcessor();
    ModeBuilder modeBuilder = ModeBuilder.getInstance();

    static public LineProcessor getInstance() {
        return instance;
    }

    public String process(String key, String mode, String input, int offset) {
        int index = 0;
        StringBuilder output = new StringBuilder();
        char[] line = input.toCharArray();
        while (index < line.length) {
            if (line[index] == '[') {
                output.append('['); // we still want the header.
                // now we look for anything that matches 'I' 'V' 'X' 'b' or '#'
                StringBuilder note = new StringBuilder();
                int v = 1;
                while ("ivb#".indexOf(Character.toLowerCase(line[index + v])) != -1) {
                    note.append(line[index + v]);
                    v++;
                }
                // okay, we have the note in "note" and v should now be pointing to the augmentation
                // /let's increment index
                output.append(modeBuilder.getNote(mode, key, note.toString(), offset));
                index += v - 1; // since v goes one past the note we find
            } else {
                output.append(line[index]);
            }
            index++;
        }
        return output.toString();
    }
}
