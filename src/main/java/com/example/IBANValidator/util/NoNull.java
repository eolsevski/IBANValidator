package com.example.IBANValidator.util;

/**
 * A simple null-check utility. Yes, <code>Objects.requireNonNull()</code> would do this,
 * but requiring JDK 1.7 for <i>one</i> method is not exactly a good trade-off.
 */
public class NoNull {
    
    private NoNull() {
        // suppress public constructor
    }
    
    /**
     * Check argument for <code>null</code>.
     * 
     * @param obj       argument to null-check.
     * 
     * @throws IllegalArgumentException if given argument is <code>null</code>.
     */
    public static void requireNonNull(Object obj) throws IllegalArgumentException {
        if (obj == null) {
            throw new IllegalArgumentException("Precondidition failed: non-null argument required");
        }
    }

}
