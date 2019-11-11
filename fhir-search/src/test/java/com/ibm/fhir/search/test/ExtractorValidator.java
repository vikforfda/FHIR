/*
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.search.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.ibm.fhir.model.path.FHIRPathBooleanValue;
import com.ibm.fhir.model.path.FHIRPathDateTimeValue;
import com.ibm.fhir.model.path.FHIRPathElementNode;
import com.ibm.fhir.model.path.FHIRPathNode;
import com.ibm.fhir.model.path.FHIRPathPrimitiveValue;
import com.ibm.fhir.model.path.FHIRPathResourceNode;
import com.ibm.fhir.model.path.FHIRPathStringValue;
import com.ibm.fhir.model.resource.SearchParameter;

/**
 * Helper class for validating that a given FHIRPath SearchParameter expression extracts nodes as expected.
 */
public class ExtractorValidator {

    private Map<String, List<String>> expected = new HashMap<>();
    boolean strict = false;

    public void addExpected(String name, List<String> values) {
        expected.put(name, values);
    }

    /**
     * validates the FHIR Path expectations for a specific search parameter. 
     * @param output
     */
    public void validate(Map<SearchParameter, List<FHIRPathNode>> output) {

        printOutput(output);

        for (Entry<SearchParameter, List<FHIRPathNode>> entry : output.entrySet()) {
            String code = entry.getKey().getCode().getValue();

            if (strict) {
                assertTrue(expected.containsKey(code));
            }

            List<String> expectedValues = expected.remove(code);
            if (expectedValues != null) {
                for (FHIRPathNode node : entry.getValue()) {
                    String tmp = processOutput(node);
                    if (BaseSearchTest.DEBUG) {
                        System.out.println("NODE: " + code + " " + tmp);
                    }
                    if (expectedValues.contains(tmp)) {
                        expectedValues = expectedValues.stream().filter(new Predicate<String>() {

                            @Override
                            public boolean test(String t) {
                                return tmp.compareTo(t) != 0;
                            }

                        }).collect(Collectors.toList());

                        if (expectedValues == null) {
                            expectedValues = Collections.emptyList();
                        }
                    }
                }

                if (BaseSearchTest.DEBUG) {
                    System.out.println("Expected Values -> " + expectedValues);
                }
                assertEquals(expectedValues.size(), 0);
            }
        }

        // Dummy Assertion in case of empty expected
        if (expected.size() > 0) {
            System.out.println(expected);
        }
        assertEquals(expected.size(), 0);

    }

    private void printOutput(Map<SearchParameter, List<FHIRPathNode>> output) {
        if (BaseSearchTest.DEBUG) {
            int i = 0;
            for (Entry<SearchParameter, List<FHIRPathNode>> entry : output.entrySet()) {
                String name = entry.getKey().getCode().getValue();

                String outputStr = i++ + "|" + name + "|=[";
                StringJoiner joiner = new StringJoiner(",");

                for (FHIRPathNode node : entry.getValue()) {
                    joiner.add(processOutput(node));
                }
                outputStr += joiner.toString() + "]";
                System.out.println(outputStr);
            }
        }
    }

    /**
     * Process the FHIRPathNode into a String value
     */
    private static String processOutput(FHIRPathNode node) {
        
        String val = "";
        if (node.getClass().getSimpleName().contains("FHIRPathBooleanValue")) {
            FHIRPathBooleanValue booleanValue = (FHIRPathBooleanValue) node;
            if (booleanValue._boolean()) {
                val = "true";
            } else {
                val = "false";
            }

        } else if (node.isPrimitiveValue()) {
            FHIRPathPrimitiveValue nodeConverted = node.asPrimitiveValue();
            if (nodeConverted.isDateTimeValue()) {
                FHIRPathDateTimeValue v = (FHIRPathDateTimeValue) node;
                val = "" + v.toString();
            } else if (nodeConverted.isStringValue()) {
                FHIRPathStringValue v = nodeConverted.asStringValue();
                val = "" + v.string();
            }

        } else if (node.is(FHIRPathElementNode.class)) {
            FHIRPathElementNode tNode = node.asElementNode();

            FHIRPathPrimitiveValue v = tNode.getValue();
            if (v != null) {

                if (v.isStringValue()) {
                    FHIRPathStringValue sv = v.asStringValue();
                    val = "" + sv.string();
                } else if (v.isDateTimeValue()) {
                    FHIRPathDateTimeValue vv = v.asDateTimeValue();
                    TemporalAccessor acc = vv.dateTime();
                    val = "" + acc.toString(); //DATE_TIME_FORMATTER.format(acc);
                }
            } else {
                Collection<FHIRPathNode> children = tNode.children();
                for (FHIRPathNode child : children) {
                    if (child.isElementNode()) {
                        FHIRPathElementNode nx = child.asElementNode();
                        val = "" + nx.getValue();

                    } else if (child.isPrimitiveValue()) {
                        FHIRPathPrimitiveValue v1 = child.asPrimitiveValue();
                        if (v1.isStringValue()) {
                            FHIRPathStringValue sv = v1.asStringValue();
                            val = "" + sv.string() + ",";
                        }
                    }
                }
            }

        } else {
            FHIRPathResourceNode nodeConverted = node.asResourceNode();
            val = "" + nodeConverted.getValue();
        }
        return val;
    }

    public static ExtractorValidator.Builder builder() {
        return new ExtractorValidator.Builder();
    }

    public void setStrict(boolean strict) {
        this.strict = strict;
    }

    /**
     * For building ExtractorValidators
     */
    public static class Builder {

        private final ExtractorValidator validator;

        public Builder() {
            validator = new ExtractorValidator();
        }

        public Builder add(String name, List<String> values) {
            validator.addExpected(name, values);
            return this;
        }

        public Builder add(String name, String... values) {
            validator.addExpected(name, Arrays.asList(values));
            return this;
        }

        public Builder strict(boolean strict) {
            validator.setStrict(strict);
            return this;
        }

        public ExtractorValidator build() {
            return validator;
        }
    }
}
