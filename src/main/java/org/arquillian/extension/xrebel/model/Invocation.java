package org.arquillian.extension.xrebel.model;

import java.util.Arrays;

public class Invocation {

    String ref;
    String method;
    String url;
    
    long start;
    int length;
    
    Except[] exceptions;
    
    IOUpdate ioUpdates;
    
    @Override
    public String toString() {
        return "Invocation [ref=" + ref + ", method=" + method + ", url=" + url
                + ", start=" + start + ", length=" + length + ", exceptions="
                + Arrays.toString(exceptions) + ", ioUpdates="
                + ioUpdates + "]";
    }

    public static class IOUpdate {
        
        Query[] queries;
        Stats[] stats;
        @Override
        public String toString() {
            return "IOUpdate [queries=" + Arrays.toString(queries) + ", stats="
                    + Arrays.toString(stats) + "]";
        }

    }

    public static class Query { }
    public static class Stats {
        
        String type;
        int durationMax;
        double durationAvg;
        int countMax;
        double countAvg;
        
        Driver[] driver;
        
        Framework[] framework;

        @Override
        public String toString() {
            return "Stats [type=" + type + ", durationMax=" + durationMax
                    + ", durationAvg=" + durationAvg + ", countMax=" + countMax
                    + ", countAvg=" + countAvg + ", driver="
                    + Arrays.toString(driver) + ", framework="
                    + Arrays.toString(framework) + "]";
        }
    }
    
    public static class Driver {}
    
    public static class Framework {}
    
    public static class Except { }
}
