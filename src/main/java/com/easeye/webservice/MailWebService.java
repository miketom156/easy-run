/**
 * MailWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public interface MailWebService extends javax.xml.rpc.Service {
    public String getMailWebServiceSoapAddress();

    public com.easeye.webservice.MailWebServiceSoap getMailWebServiceSoap() throws javax.xml.rpc.ServiceException;

    public com.easeye.webservice.MailWebServiceSoap getMailWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
