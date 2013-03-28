package com.redhat.osas.nashville;

/**
 * User: jottinge
 * Date: 3/28/13
 * Time: 11:26 AM
 */
public class LineProcessor {
    private static final LineProcessor instance=new LineProcessor();
    ModeBuilder modeBuilder=ModeBuilder.getInstance();
    static public LineProcessor getInstance() { return instance;}
    String process(String key, String mode, String input) {
        int index=0;
        StringBuilder output=new StringBuilder();
        char[] line=input.toCharArray();
        while(index<line.length) {
            if(line[index]=='[') {
                output.append('['); // we still want the header.
                // now we look for anything that matches 'I' 'V' 'X' 'b' or '#'
                StringBuilder note=new StringBuilder();
                int v=1;
                while("ivb#".indexOf(Character.toLowerCase(line[index+v]))!=-1) {
                    note.append(line[index+v]);
                    v++;
                }
                // okay, we have the note in "note" and v should now be pointing to the augmentation
                // /let's increment index
                output.append(modeBuilder.getNote(mode, key, note.toString()));
                index+=v-1; // since v goes one past the note we find
            } else {
                output.append(line[index]);
            }
            index++;
        }
        return output.toString();
    }
}
