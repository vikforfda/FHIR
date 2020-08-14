/*
 * (C) Copyright IBM Corp. 2018,2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.persistence.search.test;

import static org.testng.Assert.assertTrue;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.ibm.fhir.config.FHIRRequestContext;
import com.ibm.fhir.model.resource.Basic;
import com.ibm.fhir.model.test.TestUtil;
import com.ibm.fhir.search.exception.FHIRSearchException;

/**
 * @author lmsurpre
 * @see https://hl7.org/fhir/r4/search.html#string
 */
public abstract class AbstractSearchStringTest extends AbstractPLSearchTest {

    @Override
    protected Basic getBasicResource() throws Exception {
        return TestUtil.readExampleResource("json/ibm/basic/BasicString.json");
    }

    @Override
    protected void setTenant() throws Exception {
        FHIRRequestContext.get().setTenantId("string");
    }

    @Test
    public void testSearchString_string() throws Exception {
        assertSearchReturnsSavedResource("string:exact", "testString");

        assertSearchReturnsSavedResource("string", "testString");
        assertSearchReturnsSavedResource("string", "test");

        assertSearchReturnsSavedResource("string:contains", "String");
        assertSearchReturnsSavedResource("string:contains", "string");

        assertSearchDoesntReturnSavedResource("string", "String");
        assertSearchDoesntReturnSavedResource("string:exact", "test");
        assertSearchDoesntReturnSavedResource("string:exact", "teststring");

        // TODO add test for diacritics and other unusual characters
    }

    @Test
    public void testSearchString_string_chained() throws Exception {
        assertSearchReturnsComposition("subject:Basic.string:exact", "testString");

        assertSearchReturnsComposition("subject:Basic.string", "testString");
        assertSearchReturnsComposition("subject:Basic.string", "test");

        assertSearchReturnsComposition("subject:Basic.string:contains", "String");
        assertSearchReturnsComposition("subject:Basic.string:contains", "string");

        assertSearchDoesntReturnComposition("subject:Basic.string", "String");

        assertSearchDoesntReturnComposition("subject:Basic.string:exact", "test");
        assertSearchDoesntReturnComposition("subject:Basic.string:exact", "teststring");

        // TODO add test for diacritics and other unusual characters
    }

    @Test
    public void testSearchString_string_revinclude() throws Exception {
        assertSearchReturnsComposition("subject:Basic.string:exact", "testString");

        Map<String, List<String>> queryParms = new HashMap<String, List<String>>(1);
        queryParms.put("_revinclude", Collections.singletonList("Composition:subject"));
        queryParms.put("string:exact", Collections.singletonList("testString"));
        assertTrue(searchReturnsResource(Basic.class, queryParms, savedResource));
        assertTrue(searchReturnsResource(Basic.class, queryParms, composition));
    }


    @Test
    public void testSearchString_string_missing() throws Exception {
        assertSearchReturnsSavedResource("string:missing", "false");
        assertSearchDoesntReturnSavedResource("string:missing", "true");

        assertSearchReturnsSavedResource("missing-string:missing", "true");
        assertSearchDoesntReturnSavedResource("missing-string:missing", "false");
    }

    @Test
    public void testSearchString_string_or() throws Exception {
        assertSearchReturnsSavedResource("string:exact", "foo,testString,bar");
        assertSearchDoesntReturnSavedResource("string:exact", "foo\\,testString,bar");
        assertSearchDoesntReturnSavedResource("string:exact", "foo,testString\\,bar");
    }

    @Test
    public void testSearchString_string_escaping() throws Exception {
        assertSearchReturnsSavedResource("string:exact", "special testChars & : ; \\$ \\| \\, \\\\");
        assertSearchReturnsSavedResource("string:contains", "& : ; \\$ \\| \\, \\\\");
    }

    @Test(expectedExceptions = { FHIRSearchException.class })
    public void testSearchString_string_invalidEscaping() throws Exception {
        runQueryTest(Basic.class, "string", "\\", Integer.MAX_VALUE);
    }

    @Test
    public void testSearchString_string_chained_missing() throws Exception {
        assertSearchReturnsComposition("subject:Basic.string:missing", "false");
        assertSearchDoesntReturnComposition("subject:Basic.string:missing", "true");

        assertSearchReturnsComposition("subject:Basic.missing-string:missing", "true");
        assertSearchDoesntReturnComposition("subject:Basic.missing-string:missing", "false");
    }

    @Test
    public void testSearchString_HumanName() throws Exception {
        /*
        "use": "usual",
        "prefix": ["Mr."]
        "given": ["Topo"],
        "family": "Gigio",
        "suffix": ["II"],
        "text": "Topo Gigio"
        */
        assertSearchDoesntReturnSavedResource("HumanName", "usual");
        assertSearchReturnsSavedResource("HumanName", "Mr.");
        assertSearchReturnsSavedResource("HumanName", "Topo");
        assertSearchReturnsSavedResource("HumanName", "Gigio");
        assertSearchReturnsSavedResource("HumanName", "II");
        assertSearchReturnsSavedResource("HumanName", "Topo Gigio");
    }

    @Test
    public void testSearchString_Address() throws Exception {
        /*
        "use": "work",
        "type", "both",
        "text": "4025 S. Miami Blvd., Durham, NC 27703",
        "line": "4025 S. Miami Blvd.",
        "city": "Research Triangle Park",
        "district": "Durham",
        "state": "NC",
        "postalCode": "27703",
        "country": "USA"
        */
        assertSearchDoesntReturnSavedResource("Address", "work");
        assertSearchDoesntReturnSavedResource("Address", "both");
        assertSearchReturnsSavedResource("Address", "4025 S. Miami Blvd., Durham, NC 27703");
        assertSearchReturnsSavedResource("Address", "4025 S. Miami Blvd.");
        assertSearchReturnsSavedResource("Address", "Research Triangle Park");
        assertSearchReturnsSavedResource("Address", "Durham");
        assertSearchReturnsSavedResource("Address", "NC");
        assertSearchReturnsSavedResource("Address", "27703");
        assertSearchReturnsSavedResource("Address", "USA");
    }
}
