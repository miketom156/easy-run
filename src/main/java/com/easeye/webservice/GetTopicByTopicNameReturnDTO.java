/**
 * GetTopicByTopicNameReturnDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class GetTopicByTopicNameReturnDTO  implements java.io.Serializable {
    private int errorCode;

    private String errorInfo;

    private com.easeye.webservice.Mail_Topic mailTopic;

    public GetTopicByTopicNameReturnDTO() {
    }

    public GetTopicByTopicNameReturnDTO(
           int errorCode,
           String errorInfo,
          com.easeye.webservice.Mail_Topic mailTopic) {
           this.errorCode = errorCode;
           this.errorInfo = errorInfo;
           this.mailTopic = mailTopic;
    }


    /**
     * Gets the errorCode value for this GetTopicByTopicNameReturnDTO.
     * 
     * @return errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this GetTopicByTopicNameReturnDTO.
     * 
     * @param errorCode
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorInfo value for this GetTopicByTopicNameReturnDTO.
     * 
     * @return errorInfo
     */
    public String getErrorInfo() {
        return errorInfo;
    }


    /**
     * Sets the errorInfo value for this GetTopicByTopicNameReturnDTO.
     * 
     * @param errorInfo
     */
    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }


    /**
     * Gets the mailTopic value for this GetTopicByTopicNameReturnDTO.
     * 
     * @return mailTopic
     */
    public com.easeye.webservice.Mail_Topic getMailTopic() {
        return mailTopic;
    }


    /**
     * Sets the mailTopic value for this GetTopicByTopicNameReturnDTO.
     * 
     * @param mailTopic
     */
    public void setMailTopic(Mail_Topic mailTopic) {
        this.mailTopic = mailTopic;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetTopicByTopicNameReturnDTO)) return false;
        GetTopicByTopicNameReturnDTO other = (GetTopicByTopicNameReturnDTO) obj;
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
            ((this.mailTopic==null && other.getMailTopic()==null) || 
             (this.mailTopic!=null &&
              this.mailTopic.equals(other.getMailTopic())));
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
        if (getMailTopic() != null) {
            _hashCode += getMailTopic().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTopicByTopicNameReturnDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetTopicByTopicNameReturnDTO"));
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
        elemField.setFieldName("mailTopic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "mailTopic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Mail_Topic"));
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
