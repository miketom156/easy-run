/**
 * MailReportDetailReturnDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class MailReportDetailReturnDTO  implements java.io.Serializable {
    private int errorCode;

    private String errorInfo;

    private com.easeye.webservice.ReportDetail[] mailReportDetailDTOList;

    public MailReportDetailReturnDTO() {
    }

    public MailReportDetailReturnDTO(
           int errorCode,
           String errorInfo,
          com.easeye.webservice.ReportDetail[] mailReportDetailDTOList) {
           this.errorCode = errorCode;
           this.errorInfo = errorInfo;
           this.mailReportDetailDTOList = mailReportDetailDTOList;
    }


    /**
     * Gets the errorCode value for this MailReportDetailReturnDTO.
     * 
     * @return errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this MailReportDetailReturnDTO.
     * 
     * @param errorCode
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorInfo value for this MailReportDetailReturnDTO.
     * 
     * @return errorInfo
     */
    public String getErrorInfo() {
        return errorInfo;
    }


    /**
     * Sets the errorInfo value for this MailReportDetailReturnDTO.
     * 
     * @param errorInfo
     */
    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }


    /**
     * Gets the mailReportDetailDTOList value for this MailReportDetailReturnDTO.
     * 
     * @return mailReportDetailDTOList
     */
    public com.easeye.webservice.ReportDetail[] getMailReportDetailDTOList() {
        return mailReportDetailDTOList;
    }


    /**
     * Sets the mailReportDetailDTOList value for this MailReportDetailReturnDTO.
     * 
     * @param mailReportDetailDTOList
     */
    public void setMailReportDetailDTOList(ReportDetail[] mailReportDetailDTOList) {
        this.mailReportDetailDTOList = mailReportDetailDTOList;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof MailReportDetailReturnDTO)) return false;
        MailReportDetailReturnDTO other = (MailReportDetailReturnDTO) obj;
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
            ((this.mailReportDetailDTOList==null && other.getMailReportDetailDTOList()==null) || 
             (this.mailReportDetailDTOList!=null &&
              java.util.Arrays.equals(this.mailReportDetailDTOList, other.getMailReportDetailDTOList())));
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
        if (getMailReportDetailDTOList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMailReportDetailDTOList());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getMailReportDetailDTOList(), i);
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
        new org.apache.axis.description.TypeDesc(MailReportDetailReturnDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailReportDetailReturnDTO"));
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
        elemField.setFieldName("mailReportDetailDTOList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailReportDetailDTOList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportDetail"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportDetail"));
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
