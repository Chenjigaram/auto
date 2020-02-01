
package com.auto.utilities;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MethodPattern {

    public final String regex;
    public final Method method;
    private final Pattern pattern;

    public MethodPattern(Method method, String regex) {
        this.regex = regex;
        this.method = method;
        try {
            pattern = Pattern.compile(regex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }    

    public List<String> match(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.lookingAt()) {
            List<String> args = new ArrayList(matcher.groupCount());
            for (int i = 1; i <= matcher.groupCount(); i++) {
                int startIndex = matcher.start(i);
                args.add(startIndex == -1 ? null : matcher.group(i));
            }
            return args;
        } else {
            return null;
        }
    } 
    
    @Override
    public String toString() {
        return "\n" + pattern + " " + method.toGenericString();
    }    

}
