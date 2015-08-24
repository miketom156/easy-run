/**
 * MailingType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;


/**
 * This (return) datatype is used as a return-value when exporting
 * a single mailing.
 */
public class MailingType  implements java.io.Serializable {
    /* The database id of the mailing. */
    private int id;

    /* The name of the mailing. */
    private java.lang.String name;

    /* The subject of the mailing. */
    private java.lang.String subject;

    /* The kind of mailing. Either 'multipart' or 'plaintext'. */
    private com.dmdelivery.webservice.MailingTypeKind kind;

    /* The language of the mailing. Two digit ISO code (nl, en, de
     * etc). */
    private java.lang.String lang;

    /* The mailing's priority (1-5, 3 = normal). */
    private int priority;

    /* The mailing's from name. */
    private java.lang.String from_name;

    /* The database id of the sender address used. */
    private int sender_id;

    /* The plaintext message. */
    private java.lang.String plaintext_msg;

    /* The id of the template used. Unavailable if mailing is not
     * based on a template. */
    private java.lang.Integer template_id;

    /* The HTML message. */
    private java.lang.String html_msg;

    /* The name of the attachment. */
    private java.lang.String attachment;

    /* Whether or not this mailing can be used as a confirmation mail
     * after a new subscriber has signed up. Also determines whether or not
     * this mailing may be shown in the mailing_archive and last_mailing
     * plugins. */
    private boolean optin_confirm_candidate;

    /* The history of the mailing. */
    private java.lang.String history;

    /* The date this mailing was last modified. */
    private java.util.Calendar last_mod_date;

    /* The user who last modified the mailing. */
    private java.lang.String last_mod_user;

    /* The date the mailing was last sent definitively. Unavailable
     * if not sent definitively yet. */
    private java.util.Calendar last_def_sent_date;

    /* The url for this mailing. */
    private java.lang.String weblink;

    public MailingType() {
    }

    public MailingType(
           int id,
           java.lang.String name,
           java.lang.String subject,
           com.dmdelivery.webservice.MailingTypeKind kind,
           java.lang.String lang,
           int priority,
           java.lang.String from_name,
           int sender_id,
           java.lang.String plaintext_msg,
           java.lang.Integer template_id,
           java.lang.String html_msg,
           java.lang.String attachment,
           boolean optin_confirm_candidate,
           java.lang.String history,
           java.util.Calendar last_mod_date,
           java.lang.String last_mod_user,
           java.util.Calendar last_def_sent_date,
           java.lang.String weblink) {
           this.id = id;
           this.name = name;
           this.subject = subject;
           this.kind = kind;
           this.lang = lang;
           this.priority = priority;
           this.from_name = from_name;
           this.sender_id = sender_id;
           this.plaintext_msg = plaintext_msg;
           this.template_id = template_id;
           this.html_msg = html_msg;
           this.attachment = attachment;
           this.optin_confirm_candidate = optin_confirm_candidate;
           this.history = history;
           this.last_mod_date = last_mod_date;
           this.last_mod_user = last_mod_user;
           this.last_def_sent_date = last_def_sent_date;
           this.weblink = weblink;
    }


    /**
     * Gets the id value for this MailingType.
     * 
     * @return id   * The database id of the mailing.
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this MailingType.
     * 
     * @param id   * The database id of the mailing.
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the name value for this MailingType.
     * 
     * @return name   * The name of the mailing.
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this MailingType.
     * 
     * @param name   * The name of the mailing.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the subject value for this MailingType.
     * 
     * @return subject   * The subject of the mailing.
     */
    public java.lang.String getSubject() {
        return subject;
    }


    /**
     * Sets the subject value for this MailingType.
     * 
     * @param subject   * The subject of the mailing.
     */
    public void setSubject(java.lang.String subject) {
        this.subject = subject;
    }


    /**
     * Gets the kind value for this MailingType.
     * 
     * @return kind   * The kind of mailing. Either 'multipart' or 'plaintext'.
     */
    public com.dmdelivery.webservice.MailingTypeKind getKind() {
        return kind;
    }


    /**
     * Sets the kind value for this MailingType.
     * 
     * @param kind   * The kind of mailing. Either 'multipart' or 'plaintext'.
     */
    public void setKind(com.dmdelivery.webservice.MailingTypeKind kind) {
        this.kind = kind;
    }


    /**
     * Gets the lang value for this MailingType.
     * 
     * @return lang   * The language of the mailing. Two digit ISO code (nl, en, de
     * etc).
     */
    public java.lang.String getLang() {
        return lang;
    }


    /**
     * Sets the lang value for this MailingType.
     * 
     * @param lang   * The language of the mailing. Two digit ISO code (nl, en, de
     * etc).
     */
    public void setLang(java.lang.String lang) {
        this.lang = lang;
    }


    /**
     * Gets the priority value for this MailingType.
     * 
     * @return priority   * The mailing's priority (1-5, 3 = normal).
     */
    public int getPriority() {
        return priority;
    }


    /**
     * Sets the priority value for this MailingType.
     * 
     * @param priority   * The mailing's priority (1-5, 3 = normal).
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }


    /**
     * Gets the from_name value for this MailingType.
     * 
     * @return from_name   * The mailing's from name.
     */
    public java.lang.String getFrom_name() {
        return from_name;
    }


    /**
     * Sets the from_name value for this MailingType.
     * 
     * @param from_name   * The mailing's from name.
     */
    public void setFrom_name(java.lang.String from_name) {
        this.from_name = from_name;
    }


    /**
     * Gets the sender_id value for this MailingType.
     * 
     * @return sender_id   * The database id of the sender address used.
     */
    public int getSender_id() {
        return sender_id;
    }


    /**
     * Sets the sender_id value for this MailingType.
     * 
     * @param sender_id   * The database id of the sender address used.
     */
    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }


    /**
     * Gets the plaintext_msg value for this MailingType.
     * 
     * @return plaintext_msg   * The plaintext message.
     */
    public java.lang.String getPlaintext_msg() {
        return plaintext_msg;
    }


    /**
     * Sets the plaintext_msg value for this MailingType.
     * 
     * @param plaintext_msg   * The plaintext message.
     */
    public void setPlaintext_msg(java.lang.String plaintext_msg) {
        this.plaintext_msg = plaintext_msg;
    }


    /**
     * Gets the template_id value for this MailingType.
     * 
     * @return template_id   * The id of the template used. Unavailable if mailing is not
     * based on a template.
     */
    public java.lang.Integer getTemplate_id() {
        return template_id;
    }


    /**
     * Sets the template_id value for this MailingType.
     * 
     * @param template_id   * The id of the template used. Unavailable if mailing is not
     * based on a template.
     */
    public void setTemplate_id(java.lang.Integer template_id) {
        this.template_id = template_id;
    }


    /**
     * Gets the html_msg value for this MailingType.
     * 
     * @return html_msg   * The HTML message.
     */
    public java.lang.String getHtml_msg() {
        return html_msg;
    }


    /**
     * Sets the html_msg value for this MailingType.
     * 
     * @param html_msg   * The HTML message.
     */
    public void setHtml_msg(java.lang.String html_msg) {
        this.html_msg = html_msg;
    }


    /**
     * Gets the attachment value for this MailingType.
     * 
     * @return attachment   * The name of the attachment.
     */
    public java.lang.String getAttachment() {
        return attachment;
    }


    /**
     * Sets the attachment value for this MailingType.
     * 
     * @param attachment   * The name of the attachment.
     */
    public void setAttachment(java.lang.String attachment) {
        this.attachment = attachment;
    }


    /**
     * Gets the optin_confirm_candidate value for this MailingType.
     * 
     * @return optin_confirm_candidate   * Whether or not this mailing can be used as a confirmation mail
     * after a new subscriber has signed up. Also determines whether or not
     * this mailing may be shown in the mailing_archive and last_mailing
     * plugins.
     */
    public boolean isOptin_confirm_candidate() {
        return optin_confirm_candidate;
    }


    /**
     * Sets the optin_confirm_candidate value for this MailingType.
     * 
     * @param optin_confirm_candidate   * Whether or not this mailing can be used as a confirmation mail
     * after a new subscriber has signed up. Also determines whether or not
     * this mailing may be shown in the mailing_archive and last_mailing
     * plugins.
     */
    public void setOptin_confirm_candidate(boolean optin_confirm_candidate) {
        this.optin_confirm_candidate = optin_confirm_candidate;
    }


    /**
     * Gets the history value for this MailingType.
     * 
     * @return history   * The history of the mailing.
     */
    public java.lang.String getHistory() {
        return history;
    }


    /**
     * Sets the history value for this MailingType.
     * 
     * @param history   * The history of the mailing.
     */
    public void setHistory(java.lang.String history) {
        this.history = history;
    }


    /**
     * Gets the last_mod_date value for this MailingType.
     * 
     * @return last_mod_date   * The date this mailing was last modified.
     */
    public java.util.Calendar getLast_mod_date() {
        return last_mod_date;
    }


    /**
     * Sets the last_mod_date value for this MailingType.
     * 
     * @param last_mod_date   * The date this mailing was last modified.
     */
    public void setLast_mod_date(java.util.Calendar last_mod_date) {
        this.last_mod_date = last_mod_date;
    }


    /**
     * Gets the last_mod_user value for this MailingType.
     * 
     * @return last_mod_user   * The user who last modified the mailing.
     */
    public java.lang.String getLast_mod_user() {
        return last_mod_user;
    }


    /**
     * Sets the last_mod_user value for this MailingType.
     * 
     * @param last_mod_user   * The user who last modified the mailing.
     */
    public void setLast_mod_user(java.lang.String last_mod_user) {
        this.last_mod_user = last_mod_user;
    }


    /**
     * Gets the last_def_sent_date value for this MailingType.
     * 
     * @return last_def_sent_date   * The date the mailing was last sent definitively. Unavailable
     * if not sent definitively yet.
     */
    public java.util.Calendar getLast_def_sent_date() {
        return last_def_sent_date;
    }


    /**
     * Sets the last_def_sent_date value for this MailingType.
     * 
     * @param last_def_sent_date   * The date the mailing was last sent definitively. Unavailable
     * if not sent definitively yet.
     */
    public void setLast_def_sent_date(java.util.Calendar last_def_sent_date) {
        this.last_def_sent_date = last_def_sent_date;
    }


    /**
     * Gets the weblink value for this MailingType.
     * 
     * @return weblink   * The url for this mailing.
     */
    public java.lang.String getWeblink() {
        return weblink;
    }


    /**
     * Sets the weblink value for this MailingType.
     * 
     * @param weblink   * The url for this mailing.
     */
    public void setWeblink(java.lang.String weblink) {
        this.weblink = weblink;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MailingType)) return false;
        MailingType other = (MailingType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.subject==null && other.getSubject()==null) || 
             (this.subject!=null &&
              this.subject.equals(other.getSubject()))) &&
            ((this.kind==null && other.getKind()==null) || 
             (this.kind!=null &&
              this.kind.equals(other.getKind()))) &&
            ((this.lang==null && other.getLang()==null) || 
             (this.lang!=null &&
              this.lang.equals(other.getLang()))) &&
            this.priority == other.getPriority() &&
            ((this.from_name==null && other.getFrom_name()==null) || 
             (this.from_name!=null &&
              this.from_name.equals(other.getFrom_name()))) &&
            this.sender_id == other.getSender_id() &&
            ((this.plaintext_msg==null && other.getPlaintext_msg()==null) || 
             (this.plaintext_msg!=null &&
              this.plaintext_msg.equals(other.getPlaintext_msg()))) &&
            ((this.template_id==null && other.getTemplate_id()==null) || 
             (this.template_id!=null &&
              this.template_id.equals(other.getTemplate_id()))) &&
            ((this.html_msg==null && other.getHtml_msg()==null) || 
             (this.html_msg!=null &&
              this.html_msg.equals(other.getHtml_msg()))) &&
            ((this.attachment==null && other.getAttachment()==null) || 
             (this.attachment!=null &&
              this.attachment.equals(other.getAttachment()))) &&
            this.optin_confirm_candidate == other.isOptin_confirm_candidate() &&
            ((this.history==null && other.getHistory()==null) || 
             (this.history!=null &&
              this.history.equals(other.getHistory()))) &&
            ((this.last_mod_date==null && other.getLast_mod_date()==null) || 
             (this.last_mod_date!=null &&
              this.last_mod_date.equals(other.getLast_mod_date()))) &&
            ((this.last_mod_user==null && other.getLast_mod_user()==null) || 
             (this.last_mod_user!=null &&
              this.last_mod_user.equals(other.getLast_mod_user()))) &&
            ((this.last_def_sent_date==null && other.getLast_def_sent_date()==null) || 
             (this.last_def_sent_date!=null &&
              this.last_def_sent_date.equals(other.getLast_def_sent_date()))) &&
            ((this.weblink==null && other.getWeblink()==null) || 
             (this.weblink!=null &&
              this.weblink.equals(other.getWeblink())));
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getSubject() != null) {
            _hashCode += getSubject().hashCode();
        }
        if (getKind() != null) {
            _hashCode += getKind().hashCode();
        }
        if (getLang() != null) {
            _hashCode += getLang().hashCode();
        }
        _hashCode += getPriority();
        if (getFrom_name() != null) {
            _hashCode += getFrom_name().hashCode();
        }
        _hashCode += getSender_id();
        if (getPlaintext_msg() != null) {
            _hashCode += getPlaintext_msg().hashCode();
        }
        if (getTemplate_id() != null) {
            _hashCode += getTemplate_id().hashCode();
        }
        if (getHtml_msg() != null) {
            _hashCode += getHtml_msg().hashCode();
        }
        if (getAttachment() != null) {
            _hashCode += getAttachment().hashCode();
        }
        _hashCode += (isOptin_confirm_candidate() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getHistory() != null) {
            _hashCode += getHistory().hashCode();
        }
        if (getLast_mod_date() != null) {
            _hashCode += getLast_mod_date().hashCode();
        }
        if (getLast_mod_user() != null) {
            _hashCode += getLast_mod_user().hashCode();
        }
        if (getLast_def_sent_date() != null) {
            _hashCode += getLast_def_sent_date().hashCode();
        }
        if (getWeblink() != null) {
            _hashCode += getWeblink().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MailingType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "MailingType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kind");
        elemField.setXmlName(new javax.xml.namespace.QName("", "kind"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingType>kind"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lang");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lang"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priority");
        elemField.setXmlName(new javax.xml.namespace.QName("", "priority"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("from_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "from_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sender_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sender_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plaintext_msg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "plaintext_msg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("template_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "template_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("html_msg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "html_msg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "attachment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("optin_confirm_candidate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "optin_confirm_candidate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("history");
        elemField.setXmlName(new javax.xml.namespace.QName("", "history"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("last_mod_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "last_mod_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("last_mod_user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "last_mod_user"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("last_def_sent_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "last_def_sent_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weblink");
        elemField.setXmlName(new javax.xml.namespace.QName("", "weblink"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
