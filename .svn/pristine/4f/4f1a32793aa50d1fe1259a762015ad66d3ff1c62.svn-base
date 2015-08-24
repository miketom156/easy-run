/**
 * DMdeliverySoapAPILocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;

public class DMdeliverySoapAPILocator extends org.apache.axis.client.Service implements com.dmdelivery.webservice.DMdeliverySoapAPI {

/**
 * This is the DMdelivery SOAP webservice.
 * 
 * 	In order to be able to use this webservice, you need to have a login
 * for DMdelivery. A login consists of a username and a password. Each
 * SOAP call in the webservice needs this username and password for access!
 * Please inquire with the DMdelivery administrator for a login.
 */

    public DMdeliverySoapAPILocator() {
    }


    public DMdeliverySoapAPILocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DMdeliverySoapAPILocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DMdeliverySoapAPIPort
    private java.lang.String DMdeliverySoapAPIPort_address = "https://job5156.dmdelivery.com/x/soap-v4/server.php";

    public java.lang.String getDMdeliverySoapAPIPortAddress() {
        return DMdeliverySoapAPIPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DMdeliverySoapAPIPortWSDDServiceName = "DMdeliverySoapAPIPort";

    public java.lang.String getDMdeliverySoapAPIPortWSDDServiceName() {
        return DMdeliverySoapAPIPortWSDDServiceName;
    }

    public void setDMdeliverySoapAPIPortWSDDServiceName(java.lang.String name) {
        DMdeliverySoapAPIPortWSDDServiceName = name;
    }

    public com.dmdelivery.webservice.DMdeliverySoapAPIPort getDMdeliverySoapAPIPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DMdeliverySoapAPIPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDMdeliverySoapAPIPort(endpoint);
    }

    public com.dmdelivery.webservice.DMdeliverySoapAPIPort getDMdeliverySoapAPIPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.dmdelivery.webservice.DMdeliverySoapAPIBindingStub _stub = new com.dmdelivery.webservice.DMdeliverySoapAPIBindingStub(portAddress, this);
            _stub.setPortName(getDMdeliverySoapAPIPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDMdeliverySoapAPIPortEndpointAddress(java.lang.String address) {
        DMdeliverySoapAPIPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.dmdelivery.webservice.DMdeliverySoapAPIPort.class.isAssignableFrom(serviceEndpointInterface)) {
                com.dmdelivery.webservice.DMdeliverySoapAPIBindingStub _stub = new com.dmdelivery.webservice.DMdeliverySoapAPIBindingStub(new java.net.URL(DMdeliverySoapAPIPort_address), this);
                _stub.setPortName(getDMdeliverySoapAPIPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("DMdeliverySoapAPIPort".equals(inputPortName)) {
            return getDMdeliverySoapAPIPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliverySoapAPI");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliverySoapAPIPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DMdeliverySoapAPIPort".equals(portName)) {
            setDMdeliverySoapAPIPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
