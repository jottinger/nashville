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
 * Time: 11:03 AM
 */
public class ModeBuilderTest {
    ModeBuilder m=ModeBuilder.getInstance();
    @Test
    public void testMode() {
        System.out.println(m.modes.get("major"));
        System.out.println(m.notes);
        System.out.println(m.getNote("major", "a", "iii"));
    }
}
