package com.obit.json2jsonpath.services;

public class PathElement {
    private String name;
    private Integer arrayIndex;

    public PathElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getArrayIndex() {
        return arrayIndex;
    }

    public void setArrayIndex(Integer arrayIndex) {
        this.arrayIndex = arrayIndex;
    }
}
