/**
 * MailReportDetailExtReturnDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class MailReportDetailExtReturnDTO  implements java.io.Serializable {
    private int errorCode;

    private String errorInfo;

    private int totalCount;

    private com.easeye.webservice.ReportDetailExt[] mailReportDetailExtDTOList;

    public MailReportDetailExtReturnDTO() {
    }

    public MailReportDetailExtReturnDTO(
           int errorCode,
           String errorInfo,
           int totalCount,
          com.easeye.webservice.ReportDetailExt[] mailReportDetailExtDTOList) {
           this.errorCode = errorCode;
           this.errorInfo = errorInfo;
           this.totalCount = totalCount;
           this.mailReportDetailExtDTOList = mailReportDetailExtDTOList;
    }


    /**
     * Gets the errorCode value for this MailReportDetailExtReturnDTO.
     * 
     * @return errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this MailReportDetailExtReturnDTO.
     * 
     * @param errorCode
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorInfo value for this MailReportDetailExtReturnDTO.
     * 
     * @return errorInfo
     */
    public String getErrorInfo() {
        return errorInfo;
    }


    /**
     * Sets the errorInfo value for this MailReportDetailExtReturnDTO.
     * 
     * @param errorInfo
     */
    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }


    /**
     * Gets the totalCount value for this MailReportDetailExtReturnDTO.
     * 
     * @return totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }


    /**
     * Sets the totalCount value for this MailReportDetailExtReturnDTO.
     * 
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


    /**
     * Gets the mailReportDetailExtDTOList value for this MailReportDetailExtReturnDTO.
     * 
     * @return mailReportDetailExtDTOList
     */
    public com.easeye.webservice.ReportDetailExt[] getMailReportDetailExtDTOList() {
        return mailReportDetailExtDTOList;
    }


    /**
     * Sets the mailReportDetailExtDTOList value for this MailReportDetailExtReturnDTO.
     * 
     * @param mailReportDetailExtDTOList
     */
    public void setMailReportDetailExtDTOList(ReportDetailExt[] mailReportDetailExtDTOList) {
        this.mailReportDetailExtDTOList = mailReportDetailExtDTOList;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof MailReportDetailExtReturnDTO)) return false;
        MailReportDetailExtReturnDTO other = (MailReportDetailExtReturnDTO) obj;
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
            ((this.mailReportDetailExtDTOList==null && other.getMailReportDetailExtDTOList()==null) || 
             (this.mailReportDetailExtDTOList!=null &&
              java.util.Arrays.equals(this.mailReportDetailExtDTOList, other.getMailReportDetailExtDTOList())));
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
        if (getMailReportDetailExtDTOList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMailReportDetailExtDTOList());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getMailReportDetailExtDTOList(), i);
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
        new org.apache.axis.description.TypeDesc(MailReportDetailExtReturnDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailReportDetailExtReturnDTO"));
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
        elemField.setFieldName("mailReportDetailExtDTOList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailReportDetailExtDTOList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportDetailExt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportDetailExt"));
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
