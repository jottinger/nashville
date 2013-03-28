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
