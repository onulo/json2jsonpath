package com.obit.json2jsonpath.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component()
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Json2JsonPathGenerator {
    private static final String PREFIX = "$.";
    private static final String DELIMITER = ".";
    private static final String EQUALS = "=";
    private List<PathElement> pathElements = new ArrayList<>();
    private List<String> output = new ArrayList<>();

    public List<String> generate(JSONObject jsonObject) {
        iterateOverJson(jsonObject);
        return getOutput();
    }

    private void iterateOverJson(JSONObject jsonObject) {
        Iterator<String> elements = jsonObject.keys();
        while (elements.hasNext()) {
            String elementName = elements.next();
            pathElements.add(new PathElement(elementName));
            Object jsonElement = jsonObject.get(elementName);

            if (jsonElement instanceof JSONObject) {
                iterateOverJson((JSONObject) jsonElement);
            } else if (isComplexJsonArray(jsonElement)) {
                for (Object arrayElement : (JSONArray) jsonElement) {
                    if (arrayElement instanceof JSONObject) {
                        incrementArrayIndexInPathElement();
                        iterateOverJson((JSONObject) arrayElement);
                    } else {
                        printFormatedPath(arrayElement.toString());
                    }
                }
            } else {
                printFormatedPath(jsonElement.toString());
            }
            removeLastElement(pathElements);
        }
    }

    private void incrementArrayIndexInPathElement() {
        Integer arrayIndex = pathElements.get(pathElements.size() - 1).getArrayIndex();
        if (arrayIndex == null) {
            arrayIndex = 0;
        } else {
            arrayIndex++;
        }
        pathElements.get(pathElements.size() - 1).setArrayIndex(arrayIndex);
    }

    private boolean isComplexJsonArray(Object object) {
        return object instanceof JSONArray &&
                !((JSONArray) object).isEmpty() &&
                ((JSONArray) object).get(0) instanceof JSONObject;
    }

    private List<?> removeLastElement(List<?> list) {
        list.remove(list.size() - 1);
        return list;
    }

    private void printFormatedPath(String value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PREFIX);
        for (int i = 0; i < pathElements.size(); i++) {
            stringBuilder.append(pathElements.get(i).getName());
            if (pathElements.get(i).getArrayIndex() != null) {
                stringBuilder.append("[" + pathElements.get(i).getArrayIndex() + "]");
            }

            if (i != pathElements.size() - 1) {
                stringBuilder.append(DELIMITER);

            }
        }
        stringBuilder.append(EQUALS);
        stringBuilder.append(value);
        output.add(stringBuilder.toString());
    }

    public List<String> getOutput() {
        return output;
    }

}
