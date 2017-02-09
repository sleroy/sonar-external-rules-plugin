package io.github.sleroy.sonar.jpa.checks;

import java.util.HashSet;
import java.util.Set;

/**
 * This class is basicallzy a set of string initialized with a list of keys separated by a comma.
 * Created by Administrator on 09.02.2017.
 */
public class StringMatcher {

    private Set<String> keys = new HashSet<>();

    public StringMatcher(String restAnnotations) {
        if (restAnnotations == null) restAnnotations = "";
        String[] split = restAnnotations.split(",");
        for (String str : split) {
            keys.add(str.trim());
        }
    }

    /**
     * Tests for the presence of the name inside the key list
     *
     * @param name the name
     * @return true if the nmame is included in the key list.
     */
    public boolean matches(String name) {
        return keys.contains(name);
    }
}
