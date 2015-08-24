/**
 * EventType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;


/**
 * This (return) datatype is used as a return-value when returning
 * Event data.
 */
public class EventType  implements java.io.Serializable {
    /* The database id of the event. */
    private int id;

    /* The id of the campaign the event is located in. */
    private int campaign_id;

    /* The template id used for this event. */
    private int template_id;

    /* The name of the event. */
    private java.lang.String name;

    /* The title of the event. */
    private java.lang.String title;

    /* The language of the mailing. Two digit ISO code (nl, en, de
     * etc). */
    private java.lang.String lang;

    /* The date this event will or has been closed. */
    private java.util.Calendar close_date;

    /* The number of seats available for this event. */
    private int nr_seats;

    /* The recipient fields to show when displaying the event form. */
    private java.lang.String show_fields;

    /* Extra fields that may exists for an event attendee. */
    private com.dmdelivery.webservice.EventExtraType[] extras;

    /* The flag which determines if an event decline button will be
     * shown or not. */
    private int show_decline;

    /* The maximum number of attendees that can attend this event. */
    private int max_attendees;

    /* The id of the mailing to send when a recipient confirms they
     * will attend the event. */
    private java.lang.Integer accept_mailing_id;

    /* The id of the sms mailing to send when a recipient confirms
     * they will attend the event. */
    private java.lang.Integer accept_sms_mailing_id;

    /* The text to display when a recipient opens the event form. */
    private java.lang.String text_open;

    /* The text to display when a recipient opens the event form and
     * the event is full. */
    private java.lang.String text_full;

    /* The text to display after an event has been closed. */
    private java.lang.String text_after;

    /* The text to display after a recipient has signed up for the
     * event. */
    private java.lang.String text_accept;

    /* The text to display after a recipient has declined the event. */
    private java.lang.String text_decline;

    /* The id of the DMdelivery group that corresponds to recipients
     * who are attending the event. */
    private java.lang.Integer DMDgid_accept;

    /* The id of the DMdelivery group that corresponds to recipients
     * who declined the event. */
    private java.lang.Integer DMDgid_decline;

    public EventType() {
    }

    public EventType(
           int id,
           int campaign_id,
           int template_id,
           java.lang.String name,
           java.lang.String title,
           java.lang.String lang,
           java.util.Calendar close_date,
           int nr_seats,
           java.lang.String show_fields,
           com.dmdelivery.webservice.EventExtraType[] extras,
           int show_decline,
           int max_attendees,
           java.lang.Integer accept_mailing_id,
           java.lang.Integer accept_sms_mailing_id,
           java.lang.String text_open,
           java.lang.String text_full,
           java.lang.String text_after,
           java.lang.String text_accept,
           java.lang.String text_decline,
           java.lang.Integer DMDgid_accept,
           java.lang.Integer DMDgid_decline) {
           this.id = id;
           this.campaign_id = campaign_id;
           this.template_id = template_id;
           this.name = name;
           this.title = title;
           this.lang = lang;
           this.close_date = close_date;
           this.nr_seats = nr_seats;
           this.show_fields = show_fields;
           this.extras = extras;
           this.show_decline = show_decline;
           this.max_attendees = max_attendees;
           this.accept_mailing_id = accept_mailing_id;
           this.accept_sms_mailing_id = accept_sms_mailing_id;
           this.text_open = text_open;
           this.text_full = text_full;
           this.text_after = text_after;
           this.text_accept = text_accept;
           this.text_decline = text_decline;
           this.DMDgid_accept = DMDgid_accept;
           this.DMDgid_decline = DMDgid_decline;
    }


    /**
     * Gets the id value for this EventType.
     * 
     * @return id   * The database id of the event.
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this EventType.
     * 
     * @param id   * The database id of the event.
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the campaign_id value for this EventType.
     * 
     * @return campaign_id   * The id of the campaign the event is located in.
     */
    public int getCampaign_id() {
        return campaign_id;
    }


    /**
     * Sets the campaign_id value for this EventType.
     * 
     * @param campaign_id   * The id of the campaign the event is located in.
     */
    public void setCampaign_id(int campaign_id) {
        this.campaign_id = campaign_id;
    }


    /**
     * Gets the template_id value for this EventType.
     * 
     * @return template_id   * The template id used for this event.
     */
    public int getTemplate_id() {
        return template_id;
    }


    /**
     * Sets the template_id value for this EventType.
     * 
     * @param template_id   * The template id used for this event.
     */
    public void setTemplate_id(int template_id) {
        this.template_id = template_id;
    }


    /**
     * Gets the name value for this EventType.
     * 
     * @return name   * The name of the event.
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this EventType.
     * 
     * @param name   * The name of the event.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the title value for this EventType.
     * 
     * @return title   * The title of the event.
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this EventType.
     * 
     * @param title   * The title of the event.
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the lang value for this EventType.
     * 
     * @return lang   * The language of the mailing. Two digit ISO code (nl, en, de
     * etc).
     */
    public java.lang.String getLang() {
        return lang;
    }


    /**
     * Sets the lang value for this EventType.
     * 
     * @param lang   * The language of the mailing. Two digit ISO code (nl, en, de
     * etc).
     */
    public void setLang(java.lang.String lang) {
        this.lang = lang;
    }


    /**
     * Gets the close_date value for this EventType.
     * 
     * @return close_date   * The date this event will or has been closed.
     */
    public java.util.Calendar getClose_date() {
        return close_date;
    }


    /**
     * Sets the close_date value for this EventType.
     * 
     * @param close_date   * The date this event will or has been closed.
     */
    public void setClose_date(java.util.Calendar close_date) {
        this.close_date = close_date;
    }


    /**
     * Gets the nr_seats value for this EventType.
     * 
     * @return nr_seats   * The number of seats available for this event.
     */
    public int getNr_seats() {
        return nr_seats;
    }


    /**
     * Sets the nr_seats value for this EventType.
     * 
     * @param nr_seats   * The number of seats available for this event.
     */
    public void setNr_seats(int nr_seats) {
        this.nr_seats = nr_seats;
    }


    /**
     * Gets the show_fields value for this EventType.
     * 
     * @return show_fields   * The recipient fields to show when displaying the event form.
     */
    public java.lang.String getShow_fields() {
        return show_fields;
    }


    /**
     * Sets the show_fields value for this EventType.
     * 
     * @param show_fields   * The recipient fields to show when displaying the event form.
     */
    public void setShow_fields(java.lang.String show_fields) {
        this.show_fields = show_fields;
    }


    /**
     * Gets the extras value for this EventType.
     * 
     * @return extras   * Extra fields that may exists for an event attendee.
     */
    public com.dmdelivery.webservice.EventExtraType[] getExtras() {
        return extras;
    }


    /**
     * Sets the extras value for this EventType.
     * 
     * @param extras   * Extra fields that may exists for an event attendee.
     */
    public void setExtras(com.dmdelivery.webservice.EventExtraType[] extras) {
        this.extras = extras;
    }

    public com.dmdelivery.webservice.EventExtraType getExtras(int i) {
        return this.extras[i];
    }

    public void setExtras(int i, com.dmdelivery.webservice.EventExtraType _value) {
        this.extras[i] = _value;
    }


    /**
     * Gets the show_decline value for this EventType.
     * 
     * @return show_decline   * The flag which determines if an event decline button will be
     * shown or not.
     */
    public int getShow_decline() {
        return show_decline;
    }


    /**
     * Sets the show_decline value for this EventType.
     * 
     * @param show_decline   * The flag which determines if an event decline button will be
     * shown or not.
     */
    public void setShow_decline(int show_decline) {
        this.show_decline = show_decline;
    }


    /**
     * Gets the max_attendees value for this EventType.
     * 
     * @return max_attendees   * The maximum number of attendees that can attend this event.
     */
    public int getMax_attendees() {
        return max_attendees;
    }


    /**
     * Sets the max_attendees value for this EventType.
     * 
     * @param max_attendees   * The maximum number of attendees that can attend this event.
     */
    public void setMax_attendees(int max_attendees) {
        this.max_attendees = max_attendees;
    }


    /**
     * Gets the accept_mailing_id value for this EventType.
     * 
     * @return accept_mailing_id   * The id of the mailing to send when a recipient confirms they
     * will attend the event.
     */
    public java.lang.Integer getAccept_mailing_id() {
        return accept_mailing_id;
    }


    /**
     * Sets the accept_mailing_id value for this EventType.
     * 
     * @param accept_mailing_id   * The id of the mailing to send when a recipient confirms they
     * will attend the event.
     */
    public void setAccept_mailing_id(java.lang.Integer accept_mailing_id) {
        this.accept_mailing_id = accept_mailing_id;
    }


    /**
     * Gets the accept_sms_mailing_id value for this EventType.
     * 
     * @return accept_sms_mailing_id   * The id of the sms mailing to send when a recipient confirms
     * they will attend the event.
     */
    public java.lang.Integer getAccept_sms_mailing_id() {
        return accept_sms_mailing_id;
    }


    /**
     * Sets the accept_sms_mailing_id value for this EventType.
     * 
     * @param accept_sms_mailing_id   * The id of the sms mailing to send when a recipient confirms
     * they will attend the event.
     */
    public void setAccept_sms_mailing_id(java.lang.Integer accept_sms_mailing_id) {
        this.accept_sms_mailing_id = accept_sms_mailing_id;
    }


    /**
     * Gets the text_open value for this EventType.
     * 
     * @return text_open   * The text to display when a recipient opens the event form.
     */
    public java.lang.String getText_open() {
        return text_open;
    }


    /**
     * Sets the text_open value for this EventType.
     * 
     * @param text_open   * The text to display when a recipient opens the event form.
     */
    public void setText_open(java.lang.String text_open) {
        this.text_open = text_open;
    }


    /**
     * Gets the text_full value for this EventType.
     * 
     * @return text_full   * The text to display when a recipient opens the event form and
     * the event is full.
     */
    public java.lang.String getText_full() {
        return text_full;
    }


    /**
     * Sets the text_full value for this EventType.
     * 
     * @param text_full   * The text to display when a recipient opens the event form and
     * the event is full.
     */
    public void setText_full(java.lang.String text_full) {
        this.text_full = text_full;
    }


    /**
     * Gets the text_after value for this EventType.
     * 
     * @return text_after   * The text to display after an event has been closed.
     */
    public java.lang.String getText_after() {
        return text_after;
    }


    /**
     * Sets the text_after value for this EventType.
     * 
     * @param text_after   * The text to display after an event has been closed.
     */
    public void setText_after(java.lang.String text_after) {
        this.text_after = text_after;
    }


    /**
     * Gets the text_accept value for this EventType.
     * 
     * @return text_accept   * The text to display after a recipient has signed up for the
     * event.
     */
    public java.lang.String getText_accept() {
        return text_accept;
    }


    /**
     * Sets the text_accept value for this EventType.
     * 
     * @param text_accept   * The text to display after a recipient has signed up for the
     * event.
     */
    public void setText_accept(java.lang.String text_accept) {
        this.text_accept = text_accept;
    }


    /**
     * Gets the text_decline value for this EventType.
     * 
     * @return text_decline   * The text to display after a recipient has declined the event.
     */
    public java.lang.String getText_decline() {
        return text_decline;
    }


    /**
     * Sets the text_decline value for this EventType.
     * 
     * @param text_decline   * The text to display after a recipient has declined the event.
     */
    public void setText_decline(java.lang.String text_decline) {
        this.text_decline = text_decline;
    }


    /**
     * Gets the DMDgid_accept value for this EventType.
     * 
     * @return DMDgid_accept   * The id of the DMdelivery group that corresponds to recipients
     * who are attending the event.
     */
    public java.lang.Integer getDMDgid_accept() {
        return DMDgid_accept;
    }


    /**
     * Sets the DMDgid_accept value for this EventType.
     * 
     * @param DMDgid_accept   * The id of the DMdelivery group that corresponds to recipients
     * who are attending the event.
     */
    public void setDMDgid_accept(java.lang.Integer DMDgid_accept) {
        this.DMDgid_accept = DMDgid_accept;
    }


    /**
     * Gets the DMDgid_decline value for this EventType.
     * 
     * @return DMDgid_decline   * The id of the DMdelivery group that corresponds to recipients
     * who declined the event.
     */
    public java.lang.Integer getDMDgid_decline() {
        return DMDgid_decline;
    }


    /**
     * Sets the DMDgid_decline value for this EventType.
     * 
     * @param DMDgid_decline   * The id of the DMdelivery group that corresponds to recipients
     * who declined the event.
     */
    public void setDMDgid_decline(java.lang.Integer DMDgid_decline) {
        this.DMDgid_decline = DMDgid_decline;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EventType)) return false;
        EventType other = (EventType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            this.campaign_id == other.getCampaign_id() &&
            this.template_id == other.getTemplate_id() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.lang==null && other.getLang()==null) || 
             (this.lang!=null &&
              this.lang.equals(other.getLang()))) &&
            ((this.close_date==null && other.getClose_date()==null) || 
             (this.close_date!=null &&
              this.close_date.equals(other.getClose_date()))) &&
            this.nr_seats == other.getNr_seats() &&
            ((this.show_fields==null && other.getShow_fields()==null) || 
             (this.show_fields!=null &&
              this.show_fields.equals(other.getShow_fields()))) &&
            ((this.extras==null && other.getExtras()==null) || 
             (this.extras!=null &&
              java.util.Arrays.equals(this.extras, other.getExtras()))) &&
            this.show_decline == other.getShow_decline() &&
            this.max_attendees == other.getMax_attendees() &&
            ((this.accept_mailing_id==null && other.getAccept_mailing_id()==null) || 
             (this.accept_mailing_id!=null &&
              this.accept_mailing_id.equals(other.getAccept_mailing_id()))) &&
            ((this.accept_sms_mailing_id==null && other.getAccept_sms_mailing_id()==null) || 
             (this.accept_sms_mailing_id!=null &&
              this.accept_sms_mailing_id.equals(other.getAccept_sms_mailing_id()))) &&
            ((this.text_open==null && other.getText_open()==null) || 
             (this.text_open!=null &&
              this.text_open.equals(other.getText_open()))) &&
            ((this.text_full==null && other.getText_full()==null) || 
             (this.text_full!=null &&
              this.text_full.equals(other.getText_full()))) &&
            ((this.text_after==null && other.getText_after()==null) || 
             (this.text_after!=null &&
              this.text_after.equals(other.getText_after()))) &&
            ((this.text_accept==null && other.getText_accept()==null) || 
             (this.text_accept!=null &&
              this.text_accept.equals(other.getText_accept()))) &&
            ((this.text_decline==null && other.getText_decline()==null) || 
             (this.text_decline!=null &&
              this.text_decline.equals(other.getText_decline()))) &&
            ((this.DMDgid_accept==null && other.getDMDgid_accept()==null) || 
             (this.DMDgid_accept!=null &&
              this.DMDgid_accept.equals(other.getDMDgid_accept()))) &&
            ((this.DMDgid_decline==null && other.getDMDgid_decline()==null) || 
             (this.DMDgid_decline!=null &&
              this.DMDgid_decline.equals(other.getDMDgid_decline())));
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
        _hashCode += getCampaign_id();
        _hashCode += getTemplate_id();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getLang() != null) {
            _hashCode += getLang().hashCode();
        }
        if (getClose_date() != null) {
            _hashCode += getClose_date().hashCode();
        }
        _hashCode += getNr_seats();
        if (getShow_fields() != null) {
            _hashCode += getShow_fields().hashCode();
        }
        if (getExtras() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExtras());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExtras(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getShow_decline();
        _hashCode += getMax_attendees();
        if (getAccept_mailing_id() != null) {
            _hashCode += getAccept_mailing_id().hashCode();
        }
        if (getAccept_sms_mailing_id() != null) {
            _hashCode += getAccept_sms_mailing_id().hashCode();
        }
        if (getText_open() != null) {
            _hashCode += getText_open().hashCode();
        }
        if (getText_full() != null) {
            _hashCode += getText_full().hashCode();
        }
        if (getText_after() != null) {
            _hashCode += getText_after().hashCode();
        }
        if (getText_accept() != null) {
            _hashCode += getText_accept().hashCode();
        }
        if (getText_decline() != null) {
            _hashCode += getText_decline().hashCode();
        }
        if (getDMDgid_accept() != null) {
            _hashCode += getDMDgid_accept().hashCode();
        }
        if (getDMDgid_decline() != null) {
            _hashCode += getDMDgid_decline().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EventType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "EventType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaign_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "campaign_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("template_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "template_id"));
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
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
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
        elemField.setFieldName("close_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "close_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nr_seats");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nr_seats"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("show_fields");
        elemField.setXmlName(new javax.xml.namespace.QName("", "show_fields"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "extras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "EventExtraType"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("show_decline");
        elemField.setXmlName(new javax.xml.namespace.QName("", "show_decline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("max_attendees");
        elemField.setXmlName(new javax.xml.namespace.QName("", "max_attendees"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accept_mailing_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accept_mailing_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accept_sms_mailing_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accept_sms_mailing_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("text_open");
        elemField.setXmlName(new javax.xml.namespace.QName("", "text_open"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("text_full");
        elemField.setXmlName(new javax.xml.namespace.QName("", "text_full"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("text_after");
        elemField.setXmlName(new javax.xml.namespace.QName("", "text_after"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("text_accept");
        elemField.setXmlName(new javax.xml.namespace.QName("", "text_accept"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("text_decline");
        elemField.setXmlName(new javax.xml.namespace.QName("", "text_decline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DMDgid_accept");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DMDgid_accept"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DMDgid_decline");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DMDgid_decline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
