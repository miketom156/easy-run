/**
 * MailingStatsSummaryResultType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;


/**
 * This datatype represents a single Summary Statistics record.
 */
public class MailingStatsSummaryResultType  implements java.io.Serializable {
    /* The url (weblink) for this mailing. */
    private java.lang.String weblink;

    /* The number of emails sent. */
    private int total_sent;

    /* The number of emails sent minus hard- and soft bounces. */
    private int total_accepted;

    /* The number of hard bounces. */
    private int hardbounces;

    /* The number of soft bounces. */
    private int softbounces;

    /* The number of unsubscribers. */
    private int unsubscribers;

    /* The number of temporary unsubscribers. */
    private int suspends;

    /* The number of spamcomplaints. */
    private int spamcomplaints;

    /* The number of unique recipients who opened the mailing. */
    private int unique_opens;

    /* The total number of email renders. */
    private int total_renders;

    /* The unique number of email renders. */
    private int unique_renders;

    /* The total number of click-throughs. */
    private int total_clickthroughs;

    /* The number of unique recipients who clicked through. */
    private int unique_clickthroughs;

    /* The number of different links clicked by unique recipients. */
    private int unique_link_clickthroughs;

    /* The total number of conversion hits. */
    private int total_conversion;

    /* The number of unique recipients who caused conversion. */
    private int unique_conversion;

    /* Number of Unique Click-Throughs divided by Unique Email Opens. */
    private float click2Open_rate;

    public MailingStatsSummaryResultType() {
    }

    public MailingStatsSummaryResultType(
           java.lang.String weblink,
           int total_sent,
           int total_accepted,
           int hardbounces,
           int softbounces,
           int unsubscribers,
           int suspends,
           int spamcomplaints,
           int unique_opens,
           int total_renders,
           int unique_renders,
           int total_clickthroughs,
           int unique_clickthroughs,
           int unique_link_clickthroughs,
           int total_conversion,
           int unique_conversion,
           float click2Open_rate) {
           this.weblink = weblink;
           this.total_sent = total_sent;
           this.total_accepted = total_accepted;
           this.hardbounces = hardbounces;
           this.softbounces = softbounces;
           this.unsubscribers = unsubscribers;
           this.suspends = suspends;
           this.spamcomplaints = spamcomplaints;
           this.unique_opens = unique_opens;
           this.total_renders = total_renders;
           this.unique_renders = unique_renders;
           this.total_clickthroughs = total_clickthroughs;
           this.unique_clickthroughs = unique_clickthroughs;
           this.unique_link_clickthroughs = unique_link_clickthroughs;
           this.total_conversion = total_conversion;
           this.unique_conversion = unique_conversion;
           this.click2Open_rate = click2Open_rate;
    }


    /**
     * Gets the weblink value for this MailingStatsSummaryResultType.
     * 
     * @return weblink   * The url (weblink) for this mailing.
     */
    public java.lang.String getWeblink() {
        return weblink;
    }


    /**
     * Sets the weblink value for this MailingStatsSummaryResultType.
     * 
     * @param weblink   * The url (weblink) for this mailing.
     */
    public void setWeblink(java.lang.String weblink) {
        this.weblink = weblink;
    }


    /**
     * Gets the total_sent value for this MailingStatsSummaryResultType.
     * 
     * @return total_sent   * The number of emails sent.
     */
    public int getTotal_sent() {
        return total_sent;
    }


    /**
     * Sets the total_sent value for this MailingStatsSummaryResultType.
     * 
     * @param total_sent   * The number of emails sent.
     */
    public void setTotal_sent(int total_sent) {
        this.total_sent = total_sent;
    }


    /**
     * Gets the total_accepted value for this MailingStatsSummaryResultType.
     * 
     * @return total_accepted   * The number of emails sent minus hard- and soft bounces.
     */
    public int getTotal_accepted() {
        return total_accepted;
    }


    /**
     * Sets the total_accepted value for this MailingStatsSummaryResultType.
     * 
     * @param total_accepted   * The number of emails sent minus hard- and soft bounces.
     */
    public void setTotal_accepted(int total_accepted) {
        this.total_accepted = total_accepted;
    }


    /**
     * Gets the hardbounces value for this MailingStatsSummaryResultType.
     * 
     * @return hardbounces   * The number of hard bounces.
     */
    public int getHardbounces() {
        return hardbounces;
    }


    /**
     * Sets the hardbounces value for this MailingStatsSummaryResultType.
     * 
     * @param hardbounces   * The number of hard bounces.
     */
    public void setHardbounces(int hardbounces) {
        this.hardbounces = hardbounces;
    }


    /**
     * Gets the softbounces value for this MailingStatsSummaryResultType.
     * 
     * @return softbounces   * The number of soft bounces.
     */
    public int getSoftbounces() {
        return softbounces;
    }


    /**
     * Sets the softbounces value for this MailingStatsSummaryResultType.
     * 
     * @param softbounces   * The number of soft bounces.
     */
    public void setSoftbounces(int softbounces) {
        this.softbounces = softbounces;
    }


    /**
     * Gets the unsubscribers value for this MailingStatsSummaryResultType.
     * 
     * @return unsubscribers   * The number of unsubscribers.
     */
    public int getUnsubscribers() {
        return unsubscribers;
    }


    /**
     * Sets the unsubscribers value for this MailingStatsSummaryResultType.
     * 
     * @param unsubscribers   * The number of unsubscribers.
     */
    public void setUnsubscribers(int unsubscribers) {
        this.unsubscribers = unsubscribers;
    }


    /**
     * Gets the suspends value for this MailingStatsSummaryResultType.
     * 
     * @return suspends   * The number of temporary unsubscribers.
     */
    public int getSuspends() {
        return suspends;
    }


    /**
     * Sets the suspends value for this MailingStatsSummaryResultType.
     * 
     * @param suspends   * The number of temporary unsubscribers.
     */
    public void setSuspends(int suspends) {
        this.suspends = suspends;
    }


    /**
     * Gets the spamcomplaints value for this MailingStatsSummaryResultType.
     * 
     * @return spamcomplaints   * The number of spamcomplaints.
     */
    public int getSpamcomplaints() {
        return spamcomplaints;
    }


    /**
     * Sets the spamcomplaints value for this MailingStatsSummaryResultType.
     * 
     * @param spamcomplaints   * The number of spamcomplaints.
     */
    public void setSpamcomplaints(int spamcomplaints) {
        this.spamcomplaints = spamcomplaints;
    }


    /**
     * Gets the unique_opens value for this MailingStatsSummaryResultType.
     * 
     * @return unique_opens   * The number of unique recipients who opened the mailing.
     */
    public int getUnique_opens() {
        return unique_opens;
    }


    /**
     * Sets the unique_opens value for this MailingStatsSummaryResultType.
     * 
     * @param unique_opens   * The number of unique recipients who opened the mailing.
     */
    public void setUnique_opens(int unique_opens) {
        this.unique_opens = unique_opens;
    }


    /**
     * Gets the total_renders value for this MailingStatsSummaryResultType.
     * 
     * @return total_renders   * The total number of email renders.
     */
    public int getTotal_renders() {
        return total_renders;
    }


    /**
     * Sets the total_renders value for this MailingStatsSummaryResultType.
     * 
     * @param total_renders   * The total number of email renders.
     */
    public void setTotal_renders(int total_renders) {
        this.total_renders = total_renders;
    }


    /**
     * Gets the unique_renders value for this MailingStatsSummaryResultType.
     * 
     * @return unique_renders   * The unique number of email renders.
     */
    public int getUnique_renders() {
        return unique_renders;
    }


    /**
     * Sets the unique_renders value for this MailingStatsSummaryResultType.
     * 
     * @param unique_renders   * The unique number of email renders.
     */
    public void setUnique_renders(int unique_renders) {
        this.unique_renders = unique_renders;
    }


    /**
     * Gets the total_clickthroughs value for this MailingStatsSummaryResultType.
     * 
     * @return total_clickthroughs   * The total number of click-throughs.
     */
    public int getTotal_clickthroughs() {
        return total_clickthroughs;
    }


    /**
     * Sets the total_clickthroughs value for this MailingStatsSummaryResultType.
     * 
     * @param total_clickthroughs   * The total number of click-throughs.
     */
    public void setTotal_clickthroughs(int total_clickthroughs) {
        this.total_clickthroughs = total_clickthroughs;
    }


    /**
     * Gets the unique_clickthroughs value for this MailingStatsSummaryResultType.
     * 
     * @return unique_clickthroughs   * The number of unique recipients who clicked through.
     */
    public int getUnique_clickthroughs() {
        return unique_clickthroughs;
    }


    /**
     * Sets the unique_clickthroughs value for this MailingStatsSummaryResultType.
     * 
     * @param unique_clickthroughs   * The number of unique recipients who clicked through.
     */
    public void setUnique_clickthroughs(int unique_clickthroughs) {
        this.unique_clickthroughs = unique_clickthroughs;
    }


    /**
     * Gets the unique_link_clickthroughs value for this MailingStatsSummaryResultType.
     * 
     * @return unique_link_clickthroughs   * The number of different links clicked by unique recipients.
     */
    public int getUnique_link_clickthroughs() {
        return unique_link_clickthroughs;
    }


    /**
     * Sets the unique_link_clickthroughs value for this MailingStatsSummaryResultType.
     * 
     * @param unique_link_clickthroughs   * The number of different links clicked by unique recipients.
     */
    public void setUnique_link_clickthroughs(int unique_link_clickthroughs) {
        this.unique_link_clickthroughs = unique_link_clickthroughs;
    }


    /**
     * Gets the total_conversion value for this MailingStatsSummaryResultType.
     * 
     * @return total_conversion   * The total number of conversion hits.
     */
    public int getTotal_conversion() {
        return total_conversion;
    }


    /**
     * Sets the total_conversion value for this MailingStatsSummaryResultType.
     * 
     * @param total_conversion   * The total number of conversion hits.
     */
    public void setTotal_conversion(int total_conversion) {
        this.total_conversion = total_conversion;
    }


    /**
     * Gets the unique_conversion value for this MailingStatsSummaryResultType.
     * 
     * @return unique_conversion   * The number of unique recipients who caused conversion.
     */
    public int getUnique_conversion() {
        return unique_conversion;
    }


    /**
     * Sets the unique_conversion value for this MailingStatsSummaryResultType.
     * 
     * @param unique_conversion   * The number of unique recipients who caused conversion.
     */
    public void setUnique_conversion(int unique_conversion) {
        this.unique_conversion = unique_conversion;
    }


    /**
     * Gets the click2Open_rate value for this MailingStatsSummaryResultType.
     * 
     * @return click2Open_rate   * Number of Unique Click-Throughs divided by Unique Email Opens.
     */
    public float getClick2Open_rate() {
        return click2Open_rate;
    }


    /**
     * Sets the click2Open_rate value for this MailingStatsSummaryResultType.
     * 
     * @param click2Open_rate   * Number of Unique Click-Throughs divided by Unique Email Opens.
     */
    public void setClick2Open_rate(float click2Open_rate) {
        this.click2Open_rate = click2Open_rate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MailingStatsSummaryResultType)) return false;
        MailingStatsSummaryResultType other = (MailingStatsSummaryResultType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.weblink==null && other.getWeblink()==null) || 
             (this.weblink!=null &&
              this.weblink.equals(other.getWeblink()))) &&
            this.total_sent == other.getTotal_sent() &&
            this.total_accepted == other.getTotal_accepted() &&
            this.hardbounces == other.getHardbounces() &&
            this.softbounces == other.getSoftbounces() &&
            this.unsubscribers == other.getUnsubscribers() &&
            this.suspends == other.getSuspends() &&
            this.spamcomplaints == other.getSpamcomplaints() &&
            this.unique_opens == other.getUnique_opens() &&
            this.total_renders == other.getTotal_renders() &&
            this.unique_renders == other.getUnique_renders() &&
            this.total_clickthroughs == other.getTotal_clickthroughs() &&
            this.unique_clickthroughs == other.getUnique_clickthroughs() &&
            this.unique_link_clickthroughs == other.getUnique_link_clickthroughs() &&
            this.total_conversion == other.getTotal_conversion() &&
            this.unique_conversion == other.getUnique_conversion() &&
            this.click2Open_rate == other.getClick2Open_rate();
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
        if (getWeblink() != null) {
            _hashCode += getWeblink().hashCode();
        }
        _hashCode += getTotal_sent();
        _hashCode += getTotal_accepted();
        _hashCode += getHardbounces();
        _hashCode += getSoftbounces();
        _hashCode += getUnsubscribers();
        _hashCode += getSuspends();
        _hashCode += getSpamcomplaints();
        _hashCode += getUnique_opens();
        _hashCode += getTotal_renders();
        _hashCode += getUnique_renders();
        _hashCode += getTotal_clickthroughs();
        _hashCode += getUnique_clickthroughs();
        _hashCode += getUnique_link_clickthroughs();
        _hashCode += getTotal_conversion();
        _hashCode += getUnique_conversion();
        _hashCode += new Float(getClick2Open_rate()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MailingStatsSummaryResultType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "MailingStatsSummaryResultType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weblink");
        elemField.setXmlName(new javax.xml.namespace.QName("", "weblink"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total_sent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "total_sent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total_accepted");
        elemField.setXmlName(new javax.xml.namespace.QName("", "total_accepted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hardbounces");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hardbounces"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softbounces");
        elemField.setXmlName(new javax.xml.namespace.QName("", "softbounces"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unsubscribers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unsubscribers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suspends");
        elemField.setXmlName(new javax.xml.namespace.QName("", "suspends"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("spamcomplaints");
        elemField.setXmlName(new javax.xml.namespace.QName("", "spamcomplaints"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unique_opens");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unique_opens"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total_renders");
        elemField.setXmlName(new javax.xml.namespace.QName("", "total_renders"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unique_renders");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unique_renders"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total_clickthroughs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "total_clickthroughs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unique_clickthroughs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unique_clickthroughs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unique_link_clickthroughs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unique_link_clickthroughs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total_conversion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "total_conversion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unique_conversion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unique_conversion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("click2Open_rate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "click2open_rate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
