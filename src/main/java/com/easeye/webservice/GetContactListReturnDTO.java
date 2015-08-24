/**
 * GetContactListReturnDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class GetContactListReturnDTO  implements java.io.Serializable {
    private int errorCode;

    private String errorInfo;

    private int totalCount;

    private com.easeye.webservice.ContactInfoDTO[] contactInfoDTO;

    public GetContactListReturnDTO() {
    }

    public GetContactListReturnDTO(
           int errorCode,
           String errorInfo,
           int totalCount,
          com.easeye.webservice.ContactInfoDTO[] contactInfoDTO) {
           this.errorCode = errorCode;
           this.errorInfo = errorInfo;
           this.totalCount = totalCount;
           this.contactInfoDTO = contactInfoDTO;
    }


    /**
     * Gets the errorCode value for this GetContactListReturnDTO.
     * 
     * @return errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this GetContactListReturnDTO.
     * 
     * @param errorCode
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorInfo value for this GetContactListReturnDTO.
     * 
     * @return errorInfo
     */
    public String getErrorInfo() {
        return errorInfo;
    }


    /**
     * Sets the errorInfo value for this GetContactListReturnDTO.
     * 
     * @param errorInfo
     */
    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }


    /**
     * Gets the totalCount value for this GetContactListReturnDTO.
     * 
     * @return totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }


    /**
     * Sets the totalCount value for this GetContactListReturnDTO.
     * 
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


    /**
     * Gets the contactInfoDTO value for this GetContactListReturnDTO.
     * 
     * @return contactInfoDTO
     */
    public com.easeye.webservice.ContactInfoDTO[] getContactInfoDTO() {
        return contactInfoDTO;
    }


    /**
     * Sets the contactInfoDTO value for this GetContactListReturnDTO.
     * 
     * @param contactInfoDTO
     */
    public void setContactInfoDTO(ContactInfoDTO[] contactInfoDTO) {
        this.contactInfoDTO = contactInfoDTO;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetContactListReturnDTO)) return false;
        GetContactListReturnDTO other = (GetContactListReturnDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.errorCode == other.getErrorCode() &&
            ((this.errorInfo==null && other.getErrorInfo()==null) || 
             (this.errorInfo!=null &&
              this.errorInfo.equals(other.getErrorInfo()))) &&
            this.totalCount == other.getTotalCount() &&
            ((this.contactInfoDTO==null && other.getContactInfoDTO()==null) || 
             (this.contactInfoDTO!=null &&
              java.util.Arrays.equals(this.contactInfoDTO, other.getContactInfoDTO())));
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
        _hashCode += getErrorCode();
        if (getErrorInfo() != null) {
            _hashCode += getErrorInfo().hashCode();
        }
        _hashCode += getTotalCount();
        if (getContactInfoDTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContactInfoDTO());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getContactInfoDTO(), i);
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
        new org.apache.axis.description.TypeDesc(GetContactListReturnDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetContactListReturnDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ErrorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ErrorInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TotalCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactInfoDTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "contactInfoDTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ContactInfoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ContactInfoDTO"));
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
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
