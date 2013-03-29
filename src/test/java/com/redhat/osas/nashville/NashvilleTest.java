package com.redhat.osas.nashville;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * User: jottinge
 * Date: 3/29/13
 * Time: 12:29 PM
 */
public class NashvilleTest {
    @Test
    public void testTranslationTest() {
        LineProcessor lp=LineProcessor.getInstance();
        String input="[I]Twinkle, [Iv]twinkle, [V]little [IV]star...";
        assertEquals(lp.process("C", "major", input, 0), "[C]Twinkle, [F]twinkle, [G]little [F]star...");

        // same song, same key, just at capo 5: C should be played as if it were a G
        assertEquals(lp.process("C", "major", input, 5), "[G]Twinkle, [C]twinkle, [D]little [C]star...");

        // same song, same key, just at capo 3...
        assertEquals(lp.process("C", "major", input, 3), "[A]Twinkle, [D]twinkle, [E]little [D]star...");

        // same song, same key, just at capo 2, because we are evil!!!!!!
        // playing this would be a pain, in general. Doable, but meh.
        assertEquals(lp.process("C", "major", input, 2), "[A#]Twinkle, [D#]twinkle, [F]little [D#]star...");

    }
}
