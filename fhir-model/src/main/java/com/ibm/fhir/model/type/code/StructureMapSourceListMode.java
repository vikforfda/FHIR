/*
 * (C) Copyright IBM Corp. 2019, 2020
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.model.type.code;

import com.ibm.fhir.model.annotation.System;
import com.ibm.fhir.model.type.Code;
import com.ibm.fhir.model.type.Extension;
import com.ibm.fhir.model.type.String;

import java.util.Collection;
import java.util.Objects;

import javax.annotation.Generated;

@System("http://hl7.org/fhir/map-source-list-mode")
@Generated("com.ibm.fhir.tools.CodeGenerator")
public class StructureMapSourceListMode extends Code {
    /**
     * First
     * 
     * <p>Only process this rule for the first in the list.
     */
    public static final StructureMapSourceListMode FIRST = StructureMapSourceListMode.builder().value(ValueSet.FIRST).build();

    /**
     * All but the first
     * 
     * <p>Process this rule for all but the first.
     */
    public static final StructureMapSourceListMode NOT_FIRST = StructureMapSourceListMode.builder().value(ValueSet.NOT_FIRST).build();

    /**
     * Last
     * 
     * <p>Only process this rule for the last in the list.
     */
    public static final StructureMapSourceListMode LAST = StructureMapSourceListMode.builder().value(ValueSet.LAST).build();

    /**
     * All but the last
     * 
     * <p>Process this rule for all but the last.
     */
    public static final StructureMapSourceListMode NOT_LAST = StructureMapSourceListMode.builder().value(ValueSet.NOT_LAST).build();

    /**
     * Enforce only one
     * 
     * <p>Only process this rule is there is only item.
     */
    public static final StructureMapSourceListMode ONLY_ONE = StructureMapSourceListMode.builder().value(ValueSet.ONLY_ONE).build();

    private volatile int hashCode;

    private StructureMapSourceListMode(Builder builder) {
        super(builder);
    }

    public ValueSet getValueAsEnumConstant() {
        return (value != null) ? ValueSet.from(value) : null;
    }

    public static StructureMapSourceListMode of(ValueSet value) {
        switch (value) {
        case FIRST:
            return FIRST;
        case NOT_FIRST:
            return NOT_FIRST;
        case LAST:
            return LAST;
        case NOT_LAST:
            return NOT_LAST;
        case ONLY_ONE:
            return ONLY_ONE;
        default:
            throw new IllegalStateException(value.name());
        }
    }

    public static StructureMapSourceListMode of(java.lang.String value) {
        return of(ValueSet.from(value));
    }

    public static String string(java.lang.String value) {
        return of(ValueSet.from(value));
    }

    public static Code code(java.lang.String value) {
        return of(ValueSet.from(value));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        StructureMapSourceListMode other = (StructureMapSourceListMode) obj;
        return Objects.equals(id, other.id) && Objects.equals(extension, other.extension) && Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Objects.hash(id, extension, value);
            hashCode = result;
        }
        return result;
    }

    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.id(id);
        builder.extension(extension);
        builder.value(value);
        return builder;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Code.Builder {
        private Builder() {
            super();
        }

        @Override
        public Builder id(java.lang.String id) {
            return (Builder) super.id(id);
        }

        @Override
        public Builder extension(Extension... extension) {
            return (Builder) super.extension(extension);
        }

        @Override
        public Builder extension(Collection<Extension> extension) {
            return (Builder) super.extension(extension);
        }

        @Override
        public Builder value(java.lang.String value) {
            return (value != null) ? (Builder) super.value(ValueSet.from(value).value()) : this;
        }

        public Builder value(ValueSet value) {
            return (value != null) ? (Builder) super.value(value.value()) : this;
        }

        @Override
        public StructureMapSourceListMode build() {
            return new StructureMapSourceListMode(this);
        }
    }

    public enum ValueSet {
        /**
         * First
         * 
         * <p>Only process this rule for the first in the list.
         */
        FIRST("first"),

        /**
         * All but the first
         * 
         * <p>Process this rule for all but the first.
         */
        NOT_FIRST("not_first"),

        /**
         * Last
         * 
         * <p>Only process this rule for the last in the list.
         */
        LAST("last"),

        /**
         * All but the last
         * 
         * <p>Process this rule for all but the last.
         */
        NOT_LAST("not_last"),

        /**
         * Enforce only one
         * 
         * <p>Only process this rule is there is only item.
         */
        ONLY_ONE("only_one");

        private final java.lang.String value;

        ValueSet(java.lang.String value) {
            this.value = value;
        }

        public java.lang.String value() {
            return value;
        }

        public static ValueSet from(java.lang.String value) {
            for (ValueSet c : ValueSet.values()) {
                if (c.value.equals(value)) {
                    return c;
                }
            }
            throw new IllegalArgumentException(value);
        }
    }
}