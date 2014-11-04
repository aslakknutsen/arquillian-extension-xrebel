package org.arquillian.extension.xrebel.model;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

public class Invocation {

    String ref;
    String method;
    String url;
    
    long start;
    int length;
    
    Except[] exceptions;
    
    IOUpdate ioUpdates;
    
    public String getRef() {
        return ref;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public long getStart() {
        return start;
    }

    public int getLength() {
        return length;
    }

    public Except[] getExceptions() {
        return exceptions == null ? new Except[0]:exceptions;
    }

    public IOUpdate getIoUpdates() {
        return ioUpdates;
    }

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
        
        public Query[] getQueries() {
            return queries == null ? new Query[0]:queries;
        }

        public Stats[] getStats() {
            return stats == null ? new Stats[0]:stats;
        }

        @Override
        public String toString() {
            return "IOUpdate [queries=" + Arrays.toString(queries) + ", stats="
                    + Arrays.toString(stats) + "]";
        }
    }

    public static class Query { 
        int id;
        String type;
        long timestamp;
        int duration;
        String rawQuery;
        String queryHash;
        String processedQuery;
        Stack[] stackTrace;

        public int getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public int getDuration() {
            return duration;
        }

        public String getRawQuery() {
            return rawQuery;
        }

        public String getQueryHash() {
            return queryHash;
        }

        public String getProcessedQuery() {
            return processedQuery;
        }

        public Stack[] getStackTrace() {
            return stackTrace == null ? new Stack[0]:stackTrace;
        }

        @Override
        public String toString() {
            return "Query [id=" + id + ", type=" + type + ", timestamp="
                    + timestamp + ", duration=" + duration + ", rawQuery="
                    + rawQuery + ", queryHash=" + queryHash
                    + ", processedQuery=" + processedQuery + ", stacktrace="
                    + Arrays.toString(stackTrace) + "]";
        }
    }
    public static class Stack {
        @SerializedName("class") String class_;
        String method;
        int line;
        String file;

        public String getClass_() {
            return class_;
        }

        public String getMethod() {
            return method;
        }

        public int getLine() {
            return line;
        }

        public String getFile() {
            return file;
        }

        @Override
        public String toString() {
            return "Stack [class=" + class_ + ", method=" + method + ", line="
                    + line + ", file=" + file + "]";
        }
    }
    public static class Stats {
        
        String type;
        int durationMax;
        double durationAvg;
        int countMax;
        double countAvg;
        
        String[] driver;
        
        String[] framework;

        public String getType() {
            return type;
        }

        public int getDurationMax() {
            return durationMax;
        }

        public double getDurationAvg() {
            return durationAvg;
        }

        public int getCountMax() {
            return countMax;
        }

        public double getCountAvg() {
            return countAvg;
        }

        public String[] getDriver() {
            return driver == null ? new String[0]:driver;
        }

        public String[] getFramework() {
            return framework == null ? new String[0]:framework;
        }

        @Override
        public String toString() {
            return "Stats [type=" + type + ", durationMax=" + durationMax
                    + ", durationAvg=" + durationAvg + ", countMax=" + countMax
                    + ", countAvg=" + countAvg + ", driver="
                    + Arrays.toString(driver) + ", framework="
                    + Arrays.toString(framework) + "]";
        }
    }
    
    public static class Except { }
}
