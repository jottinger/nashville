package com.redhat.osas.nashville;

import org.testng.annotations.Test;

/**
 * User: jottinge
 * Date: 3/28/13
 * Time: 11:42 AM
 */
public class LineProcessorTest {
    LineProcessor lineProcessor=LineProcessor.getInstance();
    @Test
    public void testLineProcessor() {
        System.out.println(lineProcessor.process("A", "major", "How you doing"));
        System.out.println(lineProcessor.process("A", "major", "How you [I]doing"));
        System.out.println(lineProcessor.process("A", "major", "How you [II]doing"));
        System.out.println(lineProcessor.process("A", "major", "How you [III]doing"));
        System.out.println(lineProcessor.process("A", "major", "How you [IV]doing"));
        System.out.println(lineProcessor.process("A", "major", "How you [V]doing"));
        System.out.println(lineProcessor.process("A", "major", "How you [VI]doing"));
        System.out.println(lineProcessor.process("A", "major", "How you [VII]doing"));
        System.out.println(lineProcessor.process("A", "major", "How you [VIII]doing"));
        System.out.println(lineProcessor.process("A", "major", "[I]How [IV]you [V]doing"));
        System.out.println(lineProcessor.process("A", "major", "[I4]How [IVm]you [Vaug]doing"));
        System.out.println(lineProcessor.process("A", "major", "[I4]How [IVbm]you [Vaug]doing"));
        System.out.println(lineProcessor.process("A", "major", "[I4]How [IV#m]you [Vaug]doing"));
        System.out.println(lineProcessor.process("A", "major", "[i]I [iv]have [v]a [i7]dream"));
        System.out.println(lineProcessor.process("C#", "major", "[i]I [iv]have [v]a [i7]dream"));
        System.out.println(lineProcessor.process("B", "major", "[i]I [iv]have [v]a [ibm7]dream"));
        System.out.println(lineProcessor.process("G", "minor", "[i]I [iii]have [v]a [im7]dream"));

        System.out.flush();
    }
}
