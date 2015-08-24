/**
 * MailWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class MailWebServiceLocator extends org.apache.axis.client.Service implements com.easeye.webservice.MailWebService {

    public MailWebServiceLocator() {
    }


    public MailWebServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MailWebServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MailWebServiceSoap
    private String MailWebServiceSoap_address = "http://app.easeye.com.cn/MailWebService/MailWebService.asmx";

    public String getMailWebServiceSoapAddress() {
        return MailWebServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private String MailWebServiceSoapWSDDServiceName = "MailWebServiceSoap";

    public String getMailWebServiceSoapWSDDServiceName() {
        return MailWebServiceSoapWSDDServiceName;
    }

    public void setMailWebServiceSoapWSDDServiceName(String name) {
        MailWebServiceSoapWSDDServiceName = name;
    }

    public com.easeye.webservice.MailWebServiceSoap getMailWebServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MailWebServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMailWebServiceSoap(endpoint);
    }

    public com.easeye.webservice.MailWebServiceSoap getMailWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
           com.easeye.webservice.MailWebServiceSoapStub _stub = new com.easeye.webservice.MailWebServiceSoapStub(portAddress, this);
            _stub.setPortName(getMailWebServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMailWebServiceSoapEndpointAddress(String address) {
        MailWebServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.  new com
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (MailWebServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
               com.easeye.webservice.MailWebServiceSoapStub _stub = new com.easeye.webservice.MailWebServiceSoapStub(new java.net.URL(MailWebServiceSoap_address), this);
                _stub.setPortName(getMailWebServiceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
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
        String inputPortName = portName.getLocalPart();
        if ("MailWebServiceSoap".equals(inputPortName)) {
            return getMailWebServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailWebServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("MailWebServiceSoap".equals(portName)) {
            setMailWebServiceSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
