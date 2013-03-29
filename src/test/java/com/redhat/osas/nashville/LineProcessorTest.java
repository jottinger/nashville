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
        System.out.println(lineProcessor.process("A", "major", "How you doing",0));
        System.out.println(lineProcessor.process("A", "major", "How you [I]doing",0));
        System.out.println(lineProcessor.process("A", "major", "How you [II]doing",0));
        System.out.println(lineProcessor.process("A", "major", "How you [III]doing",0));
        System.out.println(lineProcessor.process("A", "major", "How you [IV]doing",0));
        System.out.println(lineProcessor.process("A", "major", "How you [V]doing",0));
        System.out.println(lineProcessor.process("A", "major", "How you [VI]doing",0));
        System.out.println(lineProcessor.process("A", "major", "How you [VII]doing",0));
        System.out.println(lineProcessor.process("A", "major", "How you [VIII]doing",0));
        System.out.println(lineProcessor.process("A", "major", "[I]How [IV]you [V]doing",0));
        System.out.println(lineProcessor.process("A", "major", "[I4]How [IVm]you [Vaug]doing",0));
        System.out.println(lineProcessor.process("A", "major", "[I4]How [IVbm]you [Vaug]doing",0));
        System.out.println(lineProcessor.process("A", "major", "[I4]How [IV#m]you [Vaug]doing",0));
        System.out.println(lineProcessor.process("A", "major", "[i]I [iv]have [v]a [i7]dream",0));
        System.out.println(lineProcessor.process("C#", "major", "[i]I [iv]have [v]a [i7]dream",0));
        System.out.println(lineProcessor.process("B", "major", "[i]I [iv]have [v]a [ibm7]dream",0));
        System.out.println(lineProcessor.process("G", "minor", "[i]I [iii]have [v]a [im7]dream",0));

        System.out.flush();
    }
}
