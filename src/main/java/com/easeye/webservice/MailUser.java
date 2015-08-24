/**
 * MailUser.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class MailUser  implements java.io.Serializable {
    private String email;

    private String password;

    private int accountId;

    private boolean isAdmin;

    private String firstName;

    private String lastName;

    private String mobile;

    private String gender;

    private String remark;

    private String newPassword;

    public MailUser() {
    }

    public MailUser(
           String email,
           String password,
           int accountId,
           boolean isAdmin,
           String firstName,
           String lastName,
           String mobile,
           String gender,
           String remark,
           String newPassword) {
           this.email = email;
           this.password = password;
           this.accountId = accountId;
           this.isAdmin = isAdmin;
           this.firstName = firstName;
           this.lastName = lastName;
           this.mobile = mobile;
           this.gender = gender;
           this.remark = remark;
           this.newPassword = newPassword;
    }


    /**
     * Gets the email value for this MailUser.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this MailUser.
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the password value for this MailUser.
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this MailUser.
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Gets the accountId value for this MailUser.
     * 
     * @return accountId
     */
    public int getAccountId() {
        return accountId;
    }


    /**
     * Sets the accountId value for this MailUser.
     * 
     * @param accountId
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }


    /**
     * Gets the isAdmin value for this MailUser.
     * 
     * @return isAdmin
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }


    /**
     * Sets the isAdmin value for this MailUser.
     * 
     * @param isAdmin
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


    /**
     * Gets the firstName value for this MailUser.
     * 
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Sets the firstName value for this MailUser.
     * 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * Gets the lastName value for this MailUser.
     * 
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Sets the lastName value for this MailUser.
     * 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Gets the mobile value for this MailUser.
     * 
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this MailUser.
     * 
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the gender value for this MailUser.
     * 
     * @return gender
     */
    public String getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this MailUser.
     * 
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }


    /**
     * Gets the remark value for this MailUser.
     * 
     * @return remark
     */
    public String getRemark() {
        return remark;
    }


    /**
     * Sets the remark value for this MailUser.
     * 
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }


    /**
     * Gets the newPassword value for this MailUser.
     * 
     * @return newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }


    /**
     * Sets the newPassword value for this MailUser.
     * 
     * @param newPassword
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof MailUser)) return false;
        MailUser other = (MailUser) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            this.accountId == other.getAccountId() &&
            this.isAdmin == other.isIsAdmin() &&
            ((this.firstName==null && other.getFirstName()==null) || 
             (this.firstName!=null &&
              this.firstName.equals(other.getFirstName()))) &&
            ((this.lastName==null && other.getLastName()==null) || 
             (this.lastName!=null &&
              this.lastName.equals(other.getLastName()))) &&
            ((this.mobile==null && other.getMobile()==null) || 
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.gender==null && other.getGender()==null) || 
             (this.gender!=null &&
              this.gender.equals(other.getGender()))) &&
            ((this.remark==null && other.getRemark()==null) || 
             (this.remark!=null &&
              this.remark.equals(other.getRemark()))) &&
            ((this.newPassword==null && other.getNewPassword()==null) || 
             (this.newPassword!=null &&
              this.newPassword.equals(other.getNewPassword())));
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
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        _hashCode += getAccountId();
        _hashCode += (isIsAdmin() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getFirstName() != null) {
            _hashCode += getFirstName().hashCode();
        }
        if (getLastName() != null) {
            _hashCode += getLastName().hashCode();
        }
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getGender() != null) {
            _hashCode += getGender().hashCode();
        }
        if (getRemark() != null) {
            _hashCode += getRemark().hashCode();
        }
        if (getNewPassword() != null) {
            _hashCode += getNewPassword().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MailUser.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailUser"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AccountId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAdmin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "IsAdmin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "FirstName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "LastName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Mobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gender");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Gender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remark");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Remark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newPassword");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "NewPassword"));
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
