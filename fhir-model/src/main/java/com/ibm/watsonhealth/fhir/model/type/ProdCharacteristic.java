/**
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.model.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;

import com.ibm.watsonhealth.fhir.model.util.ValidationSupport;
import com.ibm.watsonhealth.fhir.model.visitor.Visitor;

/**
 * <p>
 * The marketing status describes the date when a medicinal product is actually put on the market or the date as of which 
 * it is no longer available.
 * </p>
 */
@Generated("com.ibm.watsonhealth.fhir.tools.CodeGenerator")
public class ProdCharacteristic extends BackboneElement {
    private final Quantity height;
    private final Quantity width;
    private final Quantity depth;
    private final Quantity weight;
    private final Quantity nominalVolume;
    private final Quantity externalDiameter;
    private final String shape;
    private final List<String> color;
    private final List<String> imprint;
    private final List<Attachment> image;
    private final CodeableConcept scoring;

    private volatile int hashCode;

    private ProdCharacteristic(Builder builder) {
        super(builder);
        height = builder.height;
        width = builder.width;
        depth = builder.depth;
        weight = builder.weight;
        nominalVolume = builder.nominalVolume;
        externalDiameter = builder.externalDiameter;
        shape = builder.shape;
        color = Collections.unmodifiableList(builder.color);
        imprint = Collections.unmodifiableList(builder.imprint);
        image = Collections.unmodifiableList(builder.image);
        scoring = builder.scoring;
        ValidationSupport.requireValueOrChildren(this);
    }

    /**
     * <p>
     * Where applicable, the height can be specified using a numerical value and its unit of measurement The unit of 
     * measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
     * identifier shall be used.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Quantity}.
     */
    public Quantity getHeight() {
        return height;
    }

    /**
     * <p>
     * Where applicable, the width can be specified using a numerical value and its unit of measurement The unit of 
     * measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
     * identifier shall be used.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Quantity}.
     */
    public Quantity getWidth() {
        return width;
    }

    /**
     * <p>
     * Where applicable, the depth can be specified using a numerical value and its unit of measurement The unit of 
     * measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
     * identifier shall be used.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Quantity}.
     */
    public Quantity getDepth() {
        return depth;
    }

    /**
     * <p>
     * Where applicable, the weight can be specified using a numerical value and its unit of measurement The unit of 
     * measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
     * identifier shall be used.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Quantity}.
     */
    public Quantity getWeight() {
        return weight;
    }

    /**
     * <p>
     * Where applicable, the nominal volume can be specified using a numerical value and its unit of measurement The unit of 
     * measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
     * identifier shall be used.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Quantity}.
     */
    public Quantity getNominalVolume() {
        return nominalVolume;
    }

    /**
     * <p>
     * Where applicable, the external diameter can be specified using a numerical value and its unit of measurement The unit 
     * of measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
     * identifier shall be used.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Quantity}.
     */
    public Quantity getExternalDiameter() {
        return externalDiameter;
    }

    /**
     * <p>
     * Where applicable, the shape can be specified An appropriate controlled vocabulary shall be used The term and the term 
     * identifier shall be used.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link String}.
     */
    public String getShape() {
        return shape;
    }

    /**
     * <p>
     * Where applicable, the color can be specified An appropriate controlled vocabulary shall be used The term and the term 
     * identifier shall be used.
     * </p>
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link String}.
     */
    public List<String> getColor() {
        return color;
    }

    /**
     * <p>
     * Where applicable, the imprint can be specified as text.
     * </p>
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link String}.
     */
    public List<String> getImprint() {
        return imprint;
    }

    /**
     * <p>
     * Where applicable, the image can be provided The format of the image attachment shall be specified by regional 
     * implementations.
     * </p>
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Attachment}.
     */
    public List<Attachment> getImage() {
        return image;
    }

    /**
     * <p>
     * Where applicable, the scoring can be specified An appropriate controlled vocabulary shall be used The term and the 
     * term identifier shall be used.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link CodeableConcept}.
     */
    public CodeableConcept getScoring() {
        return scoring;
    }

    @Override
    public boolean hasChildren() {
        return super.hasChildren() || 
            (height != null) || 
            (width != null) || 
            (depth != null) || 
            (weight != null) || 
            (nominalVolume != null) || 
            (externalDiameter != null) || 
            (shape != null) || 
            !color.isEmpty() || 
            !imprint.isEmpty() || 
            !image.isEmpty() || 
            (scoring != null);
    }

    @Override
    public void accept(java.lang.String elementName, Visitor visitor) {
        if (visitor.preVisit(this)) {
            visitor.visitStart(elementName, this);
            if (visitor.visit(elementName, this)) {
                // visit children
                accept(id, "id", visitor);
                accept(extension, "extension", visitor, Extension.class);
                accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                accept(height, "height", visitor);
                accept(width, "width", visitor);
                accept(depth, "depth", visitor);
                accept(weight, "weight", visitor);
                accept(nominalVolume, "nominalVolume", visitor);
                accept(externalDiameter, "externalDiameter", visitor);
                accept(shape, "shape", visitor);
                accept(color, "color", visitor, String.class);
                accept(imprint, "imprint", visitor, String.class);
                accept(image, "image", visitor, Attachment.class);
                accept(scoring, "scoring", visitor);
            }
            visitor.visitEnd(elementName, this);
            visitor.postVisit(this);
        }
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
        ProdCharacteristic other = (ProdCharacteristic) obj;
        return Objects.equals(id, other.id) && 
            Objects.equals(extension, other.extension) && 
            Objects.equals(modifierExtension, other.modifierExtension) && 
            Objects.equals(height, other.height) && 
            Objects.equals(width, other.width) && 
            Objects.equals(depth, other.depth) && 
            Objects.equals(weight, other.weight) && 
            Objects.equals(nominalVolume, other.nominalVolume) && 
            Objects.equals(externalDiameter, other.externalDiameter) && 
            Objects.equals(shape, other.shape) && 
            Objects.equals(color, other.color) && 
            Objects.equals(imprint, other.imprint) && 
            Objects.equals(image, other.image) && 
            Objects.equals(scoring, other.scoring);
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Objects.hash(id, 
                extension, 
                modifierExtension, 
                height, 
                width, 
                depth, 
                weight, 
                nominalVolume, 
                externalDiameter, 
                shape, 
                color, 
                imprint, 
                image, 
                scoring);
            hashCode = result;
        }
        return result;
    }

    @Override
    public Builder toBuilder() {
        return new Builder().from(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BackboneElement.Builder {
        // optional
        private Quantity height;
        private Quantity width;
        private Quantity depth;
        private Quantity weight;
        private Quantity nominalVolume;
        private Quantity externalDiameter;
        private String shape;
        private List<String> color = new ArrayList<>();
        private List<String> imprint = new ArrayList<>();
        private List<Attachment> image = new ArrayList<>();
        private CodeableConcept scoring;

        private Builder() {
            super();
        }

        /**
         * <p>
         * Unique id for the element within a resource (for internal references). This may be any string value that does not 
         * contain spaces.
         * </p>
         * 
         * @param id
         *     Unique id for inter-element referencing
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder id(java.lang.String id) {
            return (Builder) super.id(id);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the element. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * </p>
         * <p>
         * Adds new element(s) to existing list
         * </p>
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder extension(Extension... extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the element. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * </p>
         * <p>
         * Replaces existing list with a new one containing elements from the Collection
         * </p>
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder extension(Collection<Extension> extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the element and that 
         * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
         * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
         * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
         * extension. Applications processing a resource are required to check for modifier extensions.
         * </p>
         * <p>
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * </p>
         * <p>
         * Adds new element(s) to existing list
         * </p>
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored even if unrecognized
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder modifierExtension(Extension... modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the element and that 
         * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
         * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
         * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
         * extension. Applications processing a resource are required to check for modifier extensions.
         * </p>
         * <p>
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * </p>
         * <p>
         * Replaces existing list with a new one containing elements from the Collection
         * </p>
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored even if unrecognized
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder modifierExtension(Collection<Extension> modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * <p>
         * Where applicable, the height can be specified using a numerical value and its unit of measurement The unit of 
         * measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
         * identifier shall be used.
         * </p>
         * 
         * @param height
         *     Where applicable, the height can be specified using a numerical value and its unit of measurement The unit of 
         *     measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
         *     identifier shall be used
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder height(Quantity height) {
            this.height = height;
            return this;
        }

        /**
         * <p>
         * Where applicable, the width can be specified using a numerical value and its unit of measurement The unit of 
         * measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
         * identifier shall be used.
         * </p>
         * 
         * @param width
         *     Where applicable, the width can be specified using a numerical value and its unit of measurement The unit of 
         *     measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
         *     identifier shall be used
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder width(Quantity width) {
            this.width = width;
            return this;
        }

        /**
         * <p>
         * Where applicable, the depth can be specified using a numerical value and its unit of measurement The unit of 
         * measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
         * identifier shall be used.
         * </p>
         * 
         * @param depth
         *     Where applicable, the depth can be specified using a numerical value and its unit of measurement The unit of 
         *     measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
         *     identifier shall be used
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder depth(Quantity depth) {
            this.depth = depth;
            return this;
        }

        /**
         * <p>
         * Where applicable, the weight can be specified using a numerical value and its unit of measurement The unit of 
         * measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
         * identifier shall be used.
         * </p>
         * 
         * @param weight
         *     Where applicable, the weight can be specified using a numerical value and its unit of measurement The unit of 
         *     measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
         *     identifier shall be used
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder weight(Quantity weight) {
            this.weight = weight;
            return this;
        }

        /**
         * <p>
         * Where applicable, the nominal volume can be specified using a numerical value and its unit of measurement The unit of 
         * measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
         * identifier shall be used.
         * </p>
         * 
         * @param nominalVolume
         *     Where applicable, the nominal volume can be specified using a numerical value and its unit of measurement The unit of 
         *     measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
         *     identifier shall be used
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder nominalVolume(Quantity nominalVolume) {
            this.nominalVolume = nominalVolume;
            return this;
        }

        /**
         * <p>
         * Where applicable, the external diameter can be specified using a numerical value and its unit of measurement The unit 
         * of measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
         * identifier shall be used.
         * </p>
         * 
         * @param externalDiameter
         *     Where applicable, the external diameter can be specified using a numerical value and its unit of measurement The unit 
         *     of measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol 
         *     identifier shall be used
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder externalDiameter(Quantity externalDiameter) {
            this.externalDiameter = externalDiameter;
            return this;
        }

        /**
         * <p>
         * Where applicable, the shape can be specified An appropriate controlled vocabulary shall be used The term and the term 
         * identifier shall be used.
         * </p>
         * 
         * @param shape
         *     Where applicable, the shape can be specified An appropriate controlled vocabulary shall be used The term and the term 
         *     identifier shall be used
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder shape(String shape) {
            this.shape = shape;
            return this;
        }

        /**
         * <p>
         * Where applicable, the color can be specified An appropriate controlled vocabulary shall be used The term and the term 
         * identifier shall be used.
         * </p>
         * <p>
         * Adds new element(s) to existing list
         * </p>
         * 
         * @param color
         *     Where applicable, the color can be specified An appropriate controlled vocabulary shall be used The term and the term 
         *     identifier shall be used
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder color(String... color) {
            for (String value : color) {
                this.color.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Where applicable, the color can be specified An appropriate controlled vocabulary shall be used The term and the term 
         * identifier shall be used.
         * </p>
         * <p>
         * Replaces existing list with a new one containing elements from the Collection
         * </p>
         * 
         * @param color
         *     Where applicable, the color can be specified An appropriate controlled vocabulary shall be used The term and the term 
         *     identifier shall be used
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder color(Collection<String> color) {
            this.color = new ArrayList<>(color);
            return this;
        }

        /**
         * <p>
         * Where applicable, the imprint can be specified as text.
         * </p>
         * <p>
         * Adds new element(s) to existing list
         * </p>
         * 
         * @param imprint
         *     Where applicable, the imprint can be specified as text
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder imprint(String... imprint) {
            for (String value : imprint) {
                this.imprint.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Where applicable, the imprint can be specified as text.
         * </p>
         * <p>
         * Replaces existing list with a new one containing elements from the Collection
         * </p>
         * 
         * @param imprint
         *     Where applicable, the imprint can be specified as text
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder imprint(Collection<String> imprint) {
            this.imprint = new ArrayList<>(imprint);
            return this;
        }

        /**
         * <p>
         * Where applicable, the image can be provided The format of the image attachment shall be specified by regional 
         * implementations.
         * </p>
         * <p>
         * Adds new element(s) to existing list
         * </p>
         * 
         * @param image
         *     Where applicable, the image can be provided The format of the image attachment shall be specified by regional 
         *     implementations
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder image(Attachment... image) {
            for (Attachment value : image) {
                this.image.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Where applicable, the image can be provided The format of the image attachment shall be specified by regional 
         * implementations.
         * </p>
         * <p>
         * Replaces existing list with a new one containing elements from the Collection
         * </p>
         * 
         * @param image
         *     Where applicable, the image can be provided The format of the image attachment shall be specified by regional 
         *     implementations
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder image(Collection<Attachment> image) {
            this.image = new ArrayList<>(image);
            return this;
        }

        /**
         * <p>
         * Where applicable, the scoring can be specified An appropriate controlled vocabulary shall be used The term and the 
         * term identifier shall be used.
         * </p>
         * 
         * @param scoring
         *     Where applicable, the scoring can be specified An appropriate controlled vocabulary shall be used The term and the 
         *     term identifier shall be used
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder scoring(CodeableConcept scoring) {
            this.scoring = scoring;
            return this;
        }

        @Override
        public ProdCharacteristic build() {
            return new ProdCharacteristic(this);
        }

        private Builder from(ProdCharacteristic prodCharacteristic) {
            id = prodCharacteristic.id;
            extension.addAll(prodCharacteristic.extension);
            modifierExtension.addAll(prodCharacteristic.modifierExtension);
            height = prodCharacteristic.height;
            width = prodCharacteristic.width;
            depth = prodCharacteristic.depth;
            weight = prodCharacteristic.weight;
            nominalVolume = prodCharacteristic.nominalVolume;
            externalDiameter = prodCharacteristic.externalDiameter;
            shape = prodCharacteristic.shape;
            color.addAll(prodCharacteristic.color);
            imprint.addAll(prodCharacteristic.imprint);
            image.addAll(prodCharacteristic.image);
            scoring = prodCharacteristic.scoring;
            return this;
        }
    }
}