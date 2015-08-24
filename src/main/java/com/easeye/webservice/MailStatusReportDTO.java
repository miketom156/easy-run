/**
 * MailStatusReportDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class MailStatusReportDTO  implements java.io.Serializable {
    private int allCount;

    private float sentPerCent;

    private int unSendCount;

    private int sent;

    private int bounce;

    private int delay;

    private int error;

    private int optOut;

    private int open;

    private int success;

    private int bounceFalse;

    private float bouncePercent;

    private float delayPercent;

    private float errorPercent;

    private float optOutPercent;

    private float openPercent;

    private float successPercent;

    private float bounceFalsePercent;

    private String userName;

    private String companyName;

    private String mailListName;

    private java.util.Calendar sendTime;

    private java.util.Calendar finishTime;

    private int sentMailListId;

    private int emailErrorCount;

    private int emailSuccessCount;

    private Integer mailClicked;

    private Integer netLinkClicked;

    private Integer sumLinkClicked;

    private Integer transmit;

    private Integer mailProjectId;

    private String mailProjectName;

    public MailStatusReportDTO() {
    }

    public MailStatusReportDTO(
           int allCount,
           float sentPerCent,
           int unSendCount,
           int sent,
           int bounce,
           int delay,
           int error,
           int optOut,
           int open,
           int success,
           int bounceFalse,
           float bouncePercent,
           float delayPercent,
           float errorPercent,
           float optOutPercent,
           float openPercent,
           float successPercent,
           float bounceFalsePercent,
           String userName,
           String companyName,
           String mailListName,
           java.util.Calendar sendTime,
           java.util.Calendar finishTime,
           int sentMailListId,
           int emailErrorCount,
           int emailSuccessCount,
           Integer mailClicked,
           Integer netLinkClicked,
           Integer sumLinkClicked,
           Integer transmit,
           Integer mailProjectId,
           String mailProjectName) {
           this.allCount = allCount;
           this.sentPerCent = sentPerCent;
           this.unSendCount = unSendCount;
           this.sent = sent;
           this.bounce = bounce;
           this.delay = delay;
           this.error = error;
           this.optOut = optOut;
           this.open = open;
           this.success = success;
           this.bounceFalse = bounceFalse;
           this.bouncePercent = bouncePercent;
           this.delayPercent = delayPercent;
           this.errorPercent = errorPercent;
           this.optOutPercent = optOutPercent;
           this.openPercent = openPercent;
           this.successPercent = successPercent;
           this.bounceFalsePercent = bounceFalsePercent;
           this.userName = userName;
           this.companyName = companyName;
           this.mailListName = mailListName;
           this.sendTime = sendTime;
           this.finishTime = finishTime;
           this.sentMailListId = sentMailListId;
           this.emailErrorCount = emailErrorCount;
           this.emailSuccessCount = emailSuccessCount;
           this.mailClicked = mailClicked;
           this.netLinkClicked = netLinkClicked;
           this.sumLinkClicked = sumLinkClicked;
           this.transmit = transmit;
           this.mailProjectId = mailProjectId;
           this.mailProjectName = mailProjectName;
    }


    /**
     * Gets the allCount value for this MailStatusReportDTO.
     * 
     * @return allCount
     */
    public int getAllCount() {
        return allCount;
    }


    /**
     * Sets the allCount value for this MailStatusReportDTO.
     * 
     * @param allCount
     */
    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }


    /**
     * Gets the sentPerCent value for this MailStatusReportDTO.
     * 
     * @return sentPerCent
     */
    public float getSentPerCent() {
        return sentPerCent;
    }


    /**
     * Sets the sentPerCent value for this MailStatusReportDTO.
     * 
     * @param sentPerCent
     */
    public void setSentPerCent(float sentPerCent) {
        this.sentPerCent = sentPerCent;
    }


    /**
     * Gets the unSendCount value for this MailStatusReportDTO.
     * 
     * @return unSendCount
     */
    public int getUnSendCount() {
        return unSendCount;
    }


    /**
     * Sets the unSendCount value for this MailStatusReportDTO.
     * 
     * @param unSendCount
     */
    public void setUnSendCount(int unSendCount) {
        this.unSendCount = unSendCount;
    }


    /**
     * Gets the sent value for this MailStatusReportDTO.
     * 
     * @return sent
     */
    public int getSent() {
        return sent;
    }


    /**
     * Sets the sent value for this MailStatusReportDTO.
     * 
     * @param sent
     */
    public void setSent(int sent) {
        this.sent = sent;
    }


    /**
     * Gets the bounce value for this MailStatusReportDTO.
     * 
     * @return bounce
     */
    public int getBounce() {
        return bounce;
    }


    /**
     * Sets the bounce value for this MailStatusReportDTO.
     * 
     * @param bounce
     */
    public void setBounce(int bounce) {
        this.bounce = bounce;
    }


    /**
     * Gets the delay value for this MailStatusReportDTO.
     * 
     * @return delay
     */
    public int getDelay() {
        return delay;
    }


    /**
     * Sets the delay value for this MailStatusReportDTO.
     * 
     * @param delay
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }


    /**
     * Gets the error value for this MailStatusReportDTO.
     * 
     * @return error
     */
    public int getError() {
        return error;
    }


    /**
     * Sets the error value for this MailStatusReportDTO.
     * 
     * @param error
     */
    public void setError(int error) {
        this.error = error;
    }


    /**
     * Gets the optOut value for this MailStatusReportDTO.
     * 
     * @return optOut
     */
    public int getOptOut() {
        return optOut;
    }


    /**
     * Sets the optOut value for this MailStatusReportDTO.
     * 
     * @param optOut
     */
    public void setOptOut(int optOut) {
        this.optOut = optOut;
    }


    /**
     * Gets the open value for this MailStatusReportDTO.
     * 
     * @return open
     */
    public int getOpen() {
        return open;
    }


    /**
     * Sets the open value for this MailStatusReportDTO.
     * 
     * @param open
     */
    public void setOpen(int open) {
        this.open = open;
    }


    /**
     * Gets the success value for this MailStatusReportDTO.
     * 
     * @return success
     */
    public int getSuccess() {
        return success;
    }


    /**
     * Sets the success value for this MailStatusReportDTO.
     * 
     * @param success
     */
    public void setSuccess(int success) {
        this.success = success;
    }


    /**
     * Gets the bounceFalse value for this MailStatusReportDTO.
     * 
     * @return bounceFalse
     */
    public int getBounceFalse() {
        return bounceFalse;
    }


    /**
     * Sets the bounceFalse value for this MailStatusReportDTO.
     * 
     * @param bounceFalse
     */
    public void setBounceFalse(int bounceFalse) {
        this.bounceFalse = bounceFalse;
    }


    /**
     * Gets the bouncePercent value for this MailStatusReportDTO.
     * 
     * @return bouncePercent
     */
    public float getBouncePercent() {
        return bouncePercent;
    }


    /**
     * Sets the bouncePercent value for this MailStatusReportDTO.
     * 
     * @param bouncePercent
     */
    public void setBouncePercent(float bouncePercent) {
        this.bouncePercent = bouncePercent;
    }


    /**
     * Gets the delayPercent value for this MailStatusReportDTO.
     * 
     * @return delayPercent
     */
    public float getDelayPercent() {
        return delayPercent;
    }


    /**
     * Sets the delayPercent value for this MailStatusReportDTO.
     * 
     * @param delayPercent
     */
    public void setDelayPercent(float delayPercent) {
        this.delayPercent = delayPercent;
    }


    /**
     * Gets the errorPercent value for this MailStatusReportDTO.
     * 
     * @return errorPercent
     */
    public float getErrorPercent() {
        return errorPercent;
    }


    /**
     * Sets the errorPercent value for this MailStatusReportDTO.
     * 
     * @param errorPercent
     */
    public void setErrorPercent(float errorPercent) {
        this.errorPercent = errorPercent;
    }


    /**
     * Gets the optOutPercent value for this MailStatusReportDTO.
     * 
     * @return optOutPercent
     */
    public float getOptOutPercent() {
        return optOutPercent;
    }


    /**
     * Sets the optOutPercent value for this MailStatusReportDTO.
     * 
     * @param optOutPercent
     */
    public void setOptOutPercent(float optOutPercent) {
        this.optOutPercent = optOutPercent;
    }


    /**
     * Gets the openPercent value for this MailStatusReportDTO.
     * 
     * @return openPercent
     */
    public float getOpenPercent() {
        return openPercent;
    }


    /**
     * Sets the openPercent value for this MailStatusReportDTO.
     * 
     * @param openPercent
     */
    public void setOpenPercent(float openPercent) {
        this.openPercent = openPercent;
    }


    /**
     * Gets the successPercent value for this MailStatusReportDTO.
     * 
     * @return successPercent
     */
    public float getSuccessPercent() {
        return successPercent;
    }


    /**
     * Sets the successPercent value for this MailStatusReportDTO.
     * 
     * @param successPercent
     */
    public void setSuccessPercent(float successPercent) {
        this.successPercent = successPercent;
    }


    /**
     * Gets the bounceFalsePercent value for this MailStatusReportDTO.
     * 
     * @return bounceFalsePercent
     */
    public float getBounceFalsePercent() {
        return bounceFalsePercent;
    }


    /**
     * Sets the bounceFalsePercent value for this MailStatusReportDTO.
     * 
     * @param bounceFalsePercent
     */
    public void setBounceFalsePercent(float bounceFalsePercent) {
        this.bounceFalsePercent = bounceFalsePercent;
    }


    /**
     * Gets the userName value for this MailStatusReportDTO.
     * 
     * @return userName
     */
    public String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this MailStatusReportDTO.
     * 
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }


    /**
     * Gets the companyName value for this MailStatusReportDTO.
     * 
     * @return companyName
     */
    public String getCompanyName() {
        return companyName;
    }


    /**
     * Sets the companyName value for this MailStatusReportDTO.
     * 
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    /**
     * Gets the mailListName value for this MailStatusReportDTO.
     * 
     * @return mailListName
     */
    public String getMailListName() {
        return mailListName;
    }


    /**
     * Sets the mailListName value for this MailStatusReportDTO.
     * 
     * @param mailListName
     */
    public void setMailListName(String mailListName) {
        this.mailListName = mailListName;
    }


    /**
     * Gets the sendTime value for this MailStatusReportDTO.
     * 
     * @return sendTime
     */
    public java.util.Calendar getSendTime() {
        return sendTime;
    }


    /**
     * Sets the sendTime value for this MailStatusReportDTO.
     * 
     * @param sendTime
     */
    public void setSendTime(java.util.Calendar sendTime) {
        this.sendTime = sendTime;
    }


    /**
     * Gets the finishTime value for this MailStatusReportDTO.
     * 
     * @return finishTime
     */
    public java.util.Calendar getFinishTime() {
        return finishTime;
    }


    /**
     * Sets the finishTime value for this MailStatusReportDTO.
     * 
     * @param finishTime
     */
    public void setFinishTime(java.util.Calendar finishTime) {
        this.finishTime = finishTime;
    }


    /**
     * Gets the sentMailListId value for this MailStatusReportDTO.
     * 
     * @return sentMailListId
     */
    public int getSentMailListId() {
        return sentMailListId;
    }


    /**
     * Sets the sentMailListId value for this MailStatusReportDTO.
     * 
     * @param sentMailListId
     */
    public void setSentMailListId(int sentMailListId) {
        this.sentMailListId = sentMailListId;
    }


    /**
     * Gets the emailErrorCount value for this MailStatusReportDTO.
     * 
     * @return emailErrorCount
     */
    public int getEmailErrorCount() {
        return emailErrorCount;
    }


    /**
     * Sets the emailErrorCount value for this MailStatusReportDTO.
     * 
     * @param emailErrorCount
     */
    public void setEmailErrorCount(int emailErrorCount) {
        this.emailErrorCount = emailErrorCount;
    }


    /**
     * Gets the emailSuccessCount value for this MailStatusReportDTO.
     * 
     * @return emailSuccessCount
     */
    public int getEmailSuccessCount() {
        return emailSuccessCount;
    }


    /**
     * Sets the emailSuccessCount value for this MailStatusReportDTO.
     * 
     * @param emailSuccessCount
     */
    public void setEmailSuccessCount(int emailSuccessCount) {
        this.emailSuccessCount = emailSuccessCount;
    }


    /**
     * Gets the mailClicked value for this MailStatusReportDTO.
     * 
     * @return mailClicked
     */
    public Integer getMailClicked() {
        return mailClicked;
    }


    /**
     * Sets the mailClicked value for this MailStatusReportDTO.
     * 
     * @param mailClicked
     */
    public void setMailClicked(Integer mailClicked) {
        this.mailClicked = mailClicked;
    }


    /**
     * Gets the netLinkClicked value for this MailStatusReportDTO.
     * 
     * @return netLinkClicked
     */
    public Integer getNetLinkClicked() {
        return netLinkClicked;
    }


    /**
     * Sets the netLinkClicked value for this MailStatusReportDTO.
     * 
     * @param netLinkClicked
     */
    public void setNetLinkClicked(Integer netLinkClicked) {
        this.netLinkClicked = netLinkClicked;
    }


    /**
     * Gets the sumLinkClicked value for this MailStatusReportDTO.
     * 
     * @return sumLinkClicked
     */
    public Integer getSumLinkClicked() {
        return sumLinkClicked;
    }


    /**
     * Sets the sumLinkClicked value for this MailStatusReportDTO.
     * 
     * @param sumLinkClicked
     */
    public void setSumLinkClicked(Integer sumLinkClicked) {
        this.sumLinkClicked = sumLinkClicked;
    }


    /**
     * Gets the transmit value for this MailStatusReportDTO.
     * 
     * @return transmit
     */
    public Integer getTransmit() {
        return transmit;
    }


    /**
     * Sets the transmit value for this MailStatusReportDTO.
     * 
     * @param transmit
     */
    public void setTransmit(Integer transmit) {
        this.transmit = transmit;
    }


    /**
     * Gets the mailProjectId value for this MailStatusReportDTO.
     * 
     * @return mailProjectId
     */
    public Integer getMailProjectId() {
        return mailProjectId;
    }


    /**
     * Sets the mailProjectId value for this MailStatusReportDTO.
     * 
     * @param mailProjectId
     */
    public void setMailProjectId(Integer mailProjectId) {
        this.mailProjectId = mailProjectId;
    }


    /**
     * Gets the mailProjectName value for this MailStatusReportDTO.
     * 
     * @return mailProjectName
     */
    public String getMailProjectName() {
        return mailProjectName;
    }


    /**
     * Sets the mailProjectName value for this MailStatusReportDTO.
     * 
     * @param mailProjectName
     */
    public void setMailProjectName(String mailProjectName) {
        this.mailProjectName = mailProjectName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof MailStatusReportDTO)) return false;
        MailStatusReportDTO other = (MailStatusReportDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.allCount == other.getAllCount() &&
            this.sentPerCent == other.getSentPerCent() &&
            this.unSendCount == other.getUnSendCount() &&
            this.sent == other.getSent() &&
            this.bounce == other.getBounce() &&
            this.delay == other.getDelay() &&
            this.error == other.getError() &&
            this.optOut == other.getOptOut() &&
            this.open == other.getOpen() &&
            this.success == other.getSuccess() &&
            this.bounceFalse == other.getBounceFalse() &&
            this.bouncePercent == other.getBouncePercent() &&
            this.delayPercent == other.getDelayPercent() &&
            this.errorPercent == other.getErrorPercent() &&
            this.optOutPercent == other.getOptOutPercent() &&
            this.openPercent == other.getOpenPercent() &&
            this.successPercent == other.getSuccessPercent() &&
            this.bounceFalsePercent == other.getBounceFalsePercent() &&
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName()))) &&
            ((this.companyName==null && other.getCompanyName()==null) || 
             (this.companyName!=null &&
              this.companyName.equals(other.getCompanyName()))) &&
            ((this.mailListName==null && other.getMailListName()==null) || 
             (this.mailListName!=null &&
              this.mailListName.equals(other.getMailListName()))) &&
            ((this.sendTime==null && other.getSendTime()==null) || 
             (this.sendTime!=null &&
              this.sendTime.equals(other.getSendTime()))) &&
            ((this.finishTime==null && other.getFinishTime()==null) || 
             (this.finishTime!=null &&
              this.finishTime.equals(other.getFinishTime()))) &&
            this.sentMailListId == other.getSentMailListId() &&
            this.emailErrorCount == other.getEmailErrorCount() &&
            this.emailSuccessCount == other.getEmailSuccessCount() &&
            ((this.mailClicked==null && other.getMailClicked()==null) || 
             (this.mailClicked!=null &&
              this.mailClicked.equals(other.getMailClicked()))) &&
            ((this.netLinkClicked==null && other.getNetLinkClicked()==null) || 
             (this.netLinkClicked!=null &&
              this.netLinkClicked.equals(other.getNetLinkClicked()))) &&
            ((this.sumLinkClicked==null && other.getSumLinkClicked()==null) || 
             (this.sumLinkClicked!=null &&
              this.sumLinkClicked.equals(other.getSumLinkClicked()))) &&
            ((this.transmit==null && other.getTransmit()==null) || 
             (this.transmit!=null &&
              this.transmit.equals(other.getTransmit()))) &&
            ((this.mailProjectId==null && other.getMailProjectId()==null) || 
             (this.mailProjectId!=null &&
              this.mailProjectId.equals(other.getMailProjectId()))) &&
            ((this.mailProjectName==null && other.getMailProjectName()==null) || 
             (this.mailProjectName!=null &&
              this.mailProjectName.equals(other.getMailProjectName())));
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
        _hashCode += getAllCount();
        _hashCode += new Float(getSentPerCent()).hashCode();
        _hashCode += getUnSendCount();
        _hashCode += getSent();
        _hashCode += getBounce();
        _hashCode += getDelay();
        _hashCode += getError();
        _hashCode += getOptOut();
        _hashCode += getOpen();
        _hashCode += getSuccess();
        _hashCode += getBounceFalse();
        _hashCode += new Float(getBouncePercent()).hashCode();
        _hashCode += new Float(getDelayPercent()).hashCode();
        _hashCode += new Float(getErrorPercent()).hashCode();
        _hashCode += new Float(getOptOutPercent()).hashCode();
        _hashCode += new Float(getOpenPercent()).hashCode();
        _hashCode += new Float(getSuccessPercent()).hashCode();
        _hashCode += new Float(getBounceFalsePercent()).hashCode();
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        if (getCompanyName() != null) {
            _hashCode += getCompanyName().hashCode();
        }
        if (getMailListName() != null) {
            _hashCode += getMailListName().hashCode();
        }
        if (getSendTime() != null) {
            _hashCode += getSendTime().hashCode();
        }
        if (getFinishTime() != null) {
            _hashCode += getFinishTime().hashCode();
        }
        _hashCode += getSentMailListId();
        _hashCode += getEmailErrorCount();
        _hashCode += getEmailSuccessCount();
        if (getMailClicked() != null) {
            _hashCode += getMailClicked().hashCode();
        }
        if (getNetLinkClicked() != null) {
            _hashCode += getNetLinkClicked().hashCode();
        }
        if (getSumLinkClicked() != null) {
            _hashCode += getSumLinkClicked().hashCode();
        }
        if (getTransmit() != null) {
            _hashCode += getTransmit().hashCode();
        }
        if (getMailProjectId() != null) {
            _hashCode += getMailProjectId().hashCode();
        }
        if (getMailProjectName() != null) {
            _hashCode += getMailProjectName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MailStatusReportDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailStatusReportDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AllCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sentPerCent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SentPerCent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unSendCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UnSendCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Sent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bounce");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Bounce"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("delay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Delay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Error"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("optOut");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "OptOut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("open");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Open"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("success");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Success"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bounceFalse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "BounceFalse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bouncePercent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "BouncePercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("delayPercent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DelayPercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorPercent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ErrorPercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("optOutPercent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "OptOutPercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openPercent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "OpenPercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("successPercent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SuccessPercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bounceFalsePercent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "BounceFalsePercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CompanyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mailListName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailListName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SendTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finishTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "FinishTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sentMailListId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SentMailListId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailErrorCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EmailErrorCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailSuccessCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EmailSuccessCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mailClicked");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailClicked"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("netLinkClicked");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "NetLinkClicked"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sumLinkClicked");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SumLinkClicked"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transmit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Transmit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mailProjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailProjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mailProjectName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailProjectName"));
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
