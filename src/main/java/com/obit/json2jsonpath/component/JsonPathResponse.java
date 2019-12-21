package com.obit.json2jsonpath.component;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JsonPathResponse {

    private List<String> jsonPaths;
    private List<String> errors;
}
