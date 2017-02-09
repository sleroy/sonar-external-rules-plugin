package io.github.sleroy.sonar.jpa;

/**
 * Created by Administrator on 09.02.2017.
 */
public class RuleInfo {
    public String name;
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }
}
