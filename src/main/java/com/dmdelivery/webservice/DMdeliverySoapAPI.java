/**
 * DMdeliverySoapAPI.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;

public interface DMdeliverySoapAPI extends javax.xml.rpc.Service {

/**
 * This is the DMdelivery SOAP webservice.
 * 
 * 	In order to be able to use this webservice, you need to have a login
 * for DMdelivery. A login consists of a username and a password. Each
 * SOAP call in the webservice needs this username and password for access!
 * Please inquire with the DMdelivery administrator for a login.
 */
    public java.lang.String getDMdeliverySoapAPIPortAddress();

    public com.dmdelivery.webservice.DMdeliverySoapAPIPort getDMdeliverySoapAPIPort() throws javax.xml.rpc.ServiceException;

    public com.dmdelivery.webservice.DMdeliverySoapAPIPort getDMdeliverySoapAPIPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
