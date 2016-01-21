/**
 * This file is part of Almura, All Rights Reserved.
 *
 * Copyright (c) AlmuraDev <http://github.com/AlmuraDev/>
 */
package org.aaron1011.bugtest;

import java.util.function.Supplier;

/**
 * This class demonstrates an odd bug with Srg2Source
 *
 * If you run a 'gradle build' with this class exactly as it is, you'll get an NPE from SymbolRangeEmitter.emitTypeRange:113
 *
 * If you change almost anything in this class, it goes away
 */
public final class BugTest {

    // Changing any of these things makes the build succeed. Yes, any of these things.

    // Even this
    private Supplier<Boolean> test = () -> true;

    // The static block doesn't matter, it can be in a constructor
    static {
        // The condition or contents of the blocks don't matter, but the try/catch within the if does
        if (true) {
            try {

            } catch (Exception e) {

            }
        }

        // This is a duplicate - try removing it

        if (true) {
            try {

            } catch (Throwable e) {

            }
        }
    }
}
