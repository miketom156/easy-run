/**
 * CampaignType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;


/**
 * This datatype represents a campaign.
 */
public class CampaignType  implements java.io.Serializable {
    /* The database ID of the campaign. */
    private int id;

    /* The database ID of the brand this campaign belongs to. */
    private java.lang.Integer brand_id;

    /* The name of the campaign. */
    private java.lang.String name;

    /* The languages used in the campaign. Two character ISO codes,
     * comma separated. Ex: nl,en. */
    private java.lang.String lang;

    /* Whether or not the campaign is an overall campaign. */
    private boolean is_overall;

    /* Whether or not the campaign is an active campaign. */
    private boolean is_active;

    /* Whether or not the campaign has a SOAP webservice. */
    private boolean has_soap_api;

    /* The create-date of the campaign. */
    private java.util.Date create_date;

    /* The remarks for the campaign. */
    private java.lang.String remarks;

    public CampaignType() {
    }

    public CampaignType(
           int id,
           java.lang.Integer brand_id,
           java.lang.String name,
           java.lang.String lang,
           boolean is_overall,
           boolean is_active,
           boolean has_soap_api,
           java.util.Date create_date,
           java.lang.String remarks) {
           this.id = id;
           this.brand_id = brand_id;
           this.name = name;
           this.lang = lang;
           this.is_overall = is_overall;
           this.is_active = is_active;
           this.has_soap_api = has_soap_api;
           this.create_date = create_date;
           this.remarks = remarks;
    }


    /**
     * Gets the id value for this CampaignType.
     * 
     * @return id   * The database ID of the campaign.
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this CampaignType.
     * 
     * @param id   * The database ID of the campaign.
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the brand_id value for this CampaignType.
     * 
     * @return brand_id   * The database ID of the brand this campaign belongs to.
     */
    public java.lang.Integer getBrand_id() {
        return brand_id;
    }


    /**
     * Sets the brand_id value for this CampaignType.
     * 
     * @param brand_id   * The database ID of the brand this campaign belongs to.
     */
    public void setBrand_id(java.lang.Integer brand_id) {
        this.brand_id = brand_id;
    }


    /**
     * Gets the name value for this CampaignType.
     * 
     * @return name   * The name of the campaign.
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this CampaignType.
     * 
     * @param name   * The name of the campaign.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the lang value for this CampaignType.
     * 
     * @return lang   * The languages used in the campaign. Two character ISO codes,
     * comma separated. Ex: nl,en.
     */
    public java.lang.String getLang() {
        return lang;
    }


    /**
     * Sets the lang value for this CampaignType.
     * 
     * @param lang   * The languages used in the campaign. Two character ISO codes,
     * comma separated. Ex: nl,en.
     */
    public void setLang(java.lang.String lang) {
        this.lang = lang;
    }


    /**
     * Gets the is_overall value for this CampaignType.
     * 
     * @return is_overall   * Whether or not the campaign is an overall campaign.
     */
    public boolean isIs_overall() {
        return is_overall;
    }


    /**
     * Sets the is_overall value for this CampaignType.
     * 
     * @param is_overall   * Whether or not the campaign is an overall campaign.
     */
    public void setIs_overall(boolean is_overall) {
        this.is_overall = is_overall;
    }


    /**
     * Gets the is_active value for this CampaignType.
     * 
     * @return is_active   * Whether or not the campaign is an active campaign.
     */
    public boolean isIs_active() {
        return is_active;
    }


    /**
     * Sets the is_active value for this CampaignType.
     * 
     * @param is_active   * Whether or not the campaign is an active campaign.
     */
    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }


    /**
     * Gets the has_soap_api value for this CampaignType.
     * 
     * @return has_soap_api   * Whether or not the campaign has a SOAP webservice.
     */
    public boolean isHas_soap_api() {
        return has_soap_api;
    }


    /**
     * Sets the has_soap_api value for this CampaignType.
     * 
     * @param has_soap_api   * Whether or not the campaign has a SOAP webservice.
     */
    public void setHas_soap_api(boolean has_soap_api) {
        this.has_soap_api = has_soap_api;
    }


    /**
     * Gets the create_date value for this CampaignType.
     * 
     * @return create_date   * The create-date of the campaign.
     */
    public java.util.Date getCreate_date() {
        return create_date;
    }


    /**
     * Sets the create_date value for this CampaignType.
     * 
     * @param create_date   * The create-date of the campaign.
     */
    public void setCreate_date(java.util.Date create_date) {
        this.create_date = create_date;
    }


    /**
     * Gets the remarks value for this CampaignType.
     * 
     * @return remarks   * The remarks for the campaign.
     */
    public java.lang.String getRemarks() {
        return remarks;
    }


    /**
     * Sets the remarks value for this CampaignType.
     * 
     * @param remarks   * The remarks for the campaign.
     */
    public void setRemarks(java.lang.String remarks) {
        this.remarks = remarks;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CampaignType)) return false;
        CampaignType other = (CampaignType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.brand_id==null && other.getBrand_id()==null) || 
             (this.brand_id!=null &&
              this.brand_id.equals(other.getBrand_id()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.lang==null && other.getLang()==null) || 
             (this.lang!=null &&
              this.lang.equals(other.getLang()))) &&
            this.is_overall == other.isIs_overall() &&
            this.is_active == other.isIs_active() &&
            this.has_soap_api == other.isHas_soap_api() &&
            ((this.create_date==null && other.getCreate_date()==null) || 
             (this.create_date!=null &&
              this.create_date.equals(other.getCreate_date()))) &&
            ((this.remarks==null && other.getRemarks()==null) || 
             (this.remarks!=null &&
              this.remarks.equals(other.getRemarks())));
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
        _hashCode += getId();
        if (getBrand_id() != null) {
            _hashCode += getBrand_id().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getLang() != null) {
            _hashCode += getLang().hashCode();
        }
        _hashCode += (isIs_overall() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIs_active() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isHas_soap_api() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCreate_date() != null) {
            _hashCode += getCreate_date().hashCode();
        }
        if (getRemarks() != null) {
            _hashCode += getRemarks().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CampaignType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "CampaignType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("brand_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "brand_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lang");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lang"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_overall");
        elemField.setXmlName(new javax.xml.namespace.QName("", "is_overall"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_active");
        elemField.setXmlName(new javax.xml.namespace.QName("", "is_active"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("has_soap_api");
        elemField.setXmlName(new javax.xml.namespace.QName("", "has_soap_api"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("create_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "create_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remarks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remarks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
