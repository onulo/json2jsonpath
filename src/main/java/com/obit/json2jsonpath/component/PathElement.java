package com.obit.json2jsonpath.component;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PathElement {

    private final String name;
    private Integer arrayIndex;
}
