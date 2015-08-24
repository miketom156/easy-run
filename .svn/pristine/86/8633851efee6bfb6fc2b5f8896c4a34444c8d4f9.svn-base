/**
 * RecipientCampaignType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;


/**
 * This datatype is used as a return value when retrieving the overall
 * campaigns a recipient is member of.
 */
public class RecipientCampaignType  implements java.io.Serializable {
    /* The database ID of the campaign. */
    private int campaign_id;

    /* Array of group IDs the recipient is in, within the campaign. */
    private int[] group_ids;

    public RecipientCampaignType() {
    }

    public RecipientCampaignType(
           int campaign_id,
           int[] group_ids) {
           this.campaign_id = campaign_id;
           this.group_ids = group_ids;
    }


    /**
     * Gets the campaign_id value for this RecipientCampaignType.
     * 
     * @return campaign_id   * The database ID of the campaign.
     */
    public int getCampaign_id() {
        return campaign_id;
    }


    /**
     * Sets the campaign_id value for this RecipientCampaignType.
     * 
     * @param campaign_id   * The database ID of the campaign.
     */
    public void setCampaign_id(int campaign_id) {
        this.campaign_id = campaign_id;
    }


    /**
     * Gets the group_ids value for this RecipientCampaignType.
     * 
     * @return group_ids   * Array of group IDs the recipient is in, within the campaign.
     */
    public int[] getGroup_ids() {
        return group_ids;
    }


    /**
     * Sets the group_ids value for this RecipientCampaignType.
     * 
     * @param group_ids   * Array of group IDs the recipient is in, within the campaign.
     */
    public void setGroup_ids(int[] group_ids) {
        this.group_ids = group_ids;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RecipientCampaignType)) return false;
        RecipientCampaignType other = (RecipientCampaignType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.campaign_id == other.getCampaign_id() &&
            ((this.group_ids==null && other.getGroup_ids()==null) || 
             (this.group_ids!=null &&
              java.util.Arrays.equals(this.group_ids, other.getGroup_ids())));
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
        _hashCode += getCampaign_id();
        if (getGroup_ids() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGroup_ids());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGroup_ids(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RecipientCampaignType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientCampaignType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaign_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "campaign_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("group_ids");
        elemField.setXmlName(new javax.xml.namespace.QName("", "group_ids"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "int"));
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
