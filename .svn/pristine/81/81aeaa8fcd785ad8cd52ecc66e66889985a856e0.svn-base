/**
 * EventExtraType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;


/**
 * This (return) datatype is used as a return-value when returning
 * Event extras data.
 */
public class EventExtraType  implements java.io.Serializable {
    /* The name of the event extra field. */
    private java.lang.String name;

    /* A brief description of this event extra field. */
    private java.lang.String explanation;

    /* The options that may be used for this field. */
    private java.lang.String options;

    /* The form type of the event extra field. */
    private java.lang.String inputtype;

    /* The flag that determines if this field is required or not. */
    private boolean required;

    public EventExtraType() {
    }

    public EventExtraType(
           java.lang.String name,
           java.lang.String explanation,
           java.lang.String options,
           java.lang.String inputtype,
           boolean required) {
           this.name = name;
           this.explanation = explanation;
           this.options = options;
           this.inputtype = inputtype;
           this.required = required;
    }


    /**
     * Gets the name value for this EventExtraType.
     * 
     * @return name   * The name of the event extra field.
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this EventExtraType.
     * 
     * @param name   * The name of the event extra field.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the explanation value for this EventExtraType.
     * 
     * @return explanation   * A brief description of this event extra field.
     */
    public java.lang.String getExplanation() {
        return explanation;
    }


    /**
     * Sets the explanation value for this EventExtraType.
     * 
     * @param explanation   * A brief description of this event extra field.
     */
    public void setExplanation(java.lang.String explanation) {
        this.explanation = explanation;
    }


    /**
     * Gets the options value for this EventExtraType.
     * 
     * @return options   * The options that may be used for this field.
     */
    public java.lang.String getOptions() {
        return options;
    }


    /**
     * Sets the options value for this EventExtraType.
     * 
     * @param options   * The options that may be used for this field.
     */
    public void setOptions(java.lang.String options) {
        this.options = options;
    }


    /**
     * Gets the inputtype value for this EventExtraType.
     * 
     * @return inputtype   * The form type of the event extra field.
     */
    public java.lang.String getInputtype() {
        return inputtype;
    }


    /**
     * Sets the inputtype value for this EventExtraType.
     * 
     * @param inputtype   * The form type of the event extra field.
     */
    public void setInputtype(java.lang.String inputtype) {
        this.inputtype = inputtype;
    }


    /**
     * Gets the required value for this EventExtraType.
     * 
     * @return required   * The flag that determines if this field is required or not.
     */
    public boolean isRequired() {
        return required;
    }


    /**
     * Sets the required value for this EventExtraType.
     * 
     * @param required   * The flag that determines if this field is required or not.
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EventExtraType)) return false;
        EventExtraType other = (EventExtraType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.explanation==null && other.getExplanation()==null) || 
             (this.explanation!=null &&
              this.explanation.equals(other.getExplanation()))) &&
            ((this.options==null && other.getOptions()==null) || 
             (this.options!=null &&
              this.options.equals(other.getOptions()))) &&
            ((this.inputtype==null && other.getInputtype()==null) || 
             (this.inputtype!=null &&
              this.inputtype.equals(other.getInputtype()))) &&
            this.required == other.isRequired();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getExplanation() != null) {
            _hashCode += getExplanation().hashCode();
        }
        if (getOptions() != null) {
            _hashCode += getOptions().hashCode();
        }
        if (getInputtype() != null) {
            _hashCode += getInputtype().hashCode();
        }
        _hashCode += (isRequired() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EventExtraType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "EventExtraType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("explanation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "explanation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("options");
        elemField.setXmlName(new javax.xml.namespace.QName("", "options"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inputtype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inputtype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("required");
        elemField.setXmlName(new javax.xml.namespace.QName("", "required"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
