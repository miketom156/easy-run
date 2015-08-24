/**
 * DMdeliverySoapAPIBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;

public class DMdeliverySoapAPIBindingStub extends org.apache.axis.client.Stub implements com.dmdelivery.webservice.DMdeliverySoapAPIPort {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[52];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
        _initOperationDesc6();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("checkHealth");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "checkHealth_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addOverallRecipient");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientData"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewRecipientType"), com.dmdelivery.webservice.RecipientNameValuePairType[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "fields"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "overwrite"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addOverallRecipient_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("editOverallRecipient");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientData"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewRecipientType"), com.dmdelivery.webservice.RecipientNameValuePairType[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "fields"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "editOverallRecipient_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("editRecipient");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientData"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewRecipientType"), com.dmdelivery.webservice.RecipientNameValuePairType[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "fields"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "editRecipient_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addOverallRecipientToGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addOverallRecipientToGroups_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("removeOverallRecipientFromGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "removeOverallRecipientFromGroups_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getBrands");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "BrandArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.BrandType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getBrands_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "brand"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCampaigns");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "CampaignArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.CampaignType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getCampaigns_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "campaign"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSenderAddresses");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "SenderAddressArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.SenderAddressType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getSenderAddresses_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "senderAddress"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getOverallRecipientCampaigns");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientCampaignArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecipientCampaignType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getOverallRecipientCampaigns_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "recipientCampaign"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRecipientsByMatch");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientData"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewRecipientType"), com.dmdelivery.webservice.RecipientNameValuePairType[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "fields"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecipientType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRecipientsByMatch_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "recipients"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRecipientFields");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lang"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientFieldArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecipientFieldType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRecipientFields_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "recipientField"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sendSingleMailing");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "sendSingleMailing_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sendSingleSMS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "sendSingleMailing_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sendMailing");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "isTest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "resultsEmail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "filterID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "langs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfStringType"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "string"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ADprefixDomains"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "callbackUrl"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "sendMailing_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sendSystemMail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "attachments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "sendSystemMail_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sendMailingScheduled");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sendDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "isTest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "resultsEmail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "filterID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "langs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfStringType"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "string"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ADprefixDomains"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "callbackUrl"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "approvalGroupID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "approvalPeriod"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"), float.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "approvalAck"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "approvalNack"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "sendMailing_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sendSMS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "isTest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "resultsEmail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "filterID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "langs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfStringType"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "string"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ADprefixDomains"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "callbackUrl"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "sendMailing_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createMailing");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lang"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "subject"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fromName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "senderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "html"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createMailing_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("slurpMailing");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lang"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "subject"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fromName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "senderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "url"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "checkTimestamp"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "slurpMailing_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("removeRecipientFromGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "removeRecipientFromGroups_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addRecipientToGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addRecipientToGroups_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("moveRecipientsToGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fromGroupID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "toGroupID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "moveRecipientsToGroup_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMailings");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "limit"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "definitiveOnly"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "MailingArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.MailingType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getMailings_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "mailing"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSMSMailings");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "limit"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "definitiveOnly"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "SMSMailingArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.SMSMailingType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getSMSMailings_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "mailing"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRecipientsFromGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fields"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfStringType"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "string"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "inGroupID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fromDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"), java.util.Date.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "filterID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecipientType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRecipientsFromGroup_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "recipients"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRecipients");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fields"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfStringType"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "string"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "inGroupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "notInGroupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "filterID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecipientType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRecipients_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "recipients"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRecipientGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRecipientGroups_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMailingStatsSummary");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailing"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "MailingStatsSummaryResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.MailingStatsSummaryResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getMailingStatsSummary_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "GroupArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.GroupType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getGroups_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "group"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMailingResponse");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "types"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "field"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "MailingResponseArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.MailingResponseType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getMailingResponse_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "response"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteMailing");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteMailing_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "group"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewGroupType"), com.dmdelivery.webservice.NewGroupType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addGroup_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("flushGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "flushGroup_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteGroup_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addRecipient");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientData"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewRecipientType"), com.dmdelivery.webservice.RecipientNameValuePairType[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "fields"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "addDuplisToGroups"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "overwrite"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addRecipient_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addRecipientAttachment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fileName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fileMD5"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fileData"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addRecipientAttachment_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addMailingAttachment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fileName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fileMD5"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fileData"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addMailingAttachment_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteMailingAttachments");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "attachmentIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteMailingAttachments_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMailingAttachmentIDs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getMailingAttachmentIDs_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addRecipients");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientDatas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewRecipientArrayType"), com.dmdelivery.webservice.RecipientNameValuePairType[][].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "recipients"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "addDuplisToGroups"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "overwrite"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addRecipientsResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.AddRecipientsResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addRecipients_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addRecipientsSendMailing");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientDatas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewRecipientArrayType"), com.dmdelivery.webservice.RecipientNameValuePairType[][].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "recipients"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "addDuplisToGroups"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "overwrite"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addRecipientsResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.AddRecipientsResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addRecipientsSendMailing_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addRecipientsSendSMS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "SMSmailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType"), int[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientDatas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewRecipientArrayType"), com.dmdelivery.webservice.RecipientNameValuePairType[][].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "recipients"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "addDuplisToGroups"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "overwrite"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addRecipientsResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.AddRecipientsResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addRecipientsSendSMS_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("importRemoteCSV");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "csvURL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "csvCharset"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "csvFieldSep"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "csvEnclosure"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "addDuplisToGroups"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "overwrite"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "callbackUrl"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "importRemoteCSV_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[43] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("importRemoteCSVSendMailing");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "csvURL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "csvCharset"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "csvFieldSep"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "csvEnclosure"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "addDuplisToGroups"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "overwrite"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mailingID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "resultsEmail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "filterID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "langs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfStringType"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "string"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ADprefixDomains"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "callbackUrl"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "importRemoteCSVSendMailing_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[44] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEvents");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "eventID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "EventArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.EventType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getEvents_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "eventExtras"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[45] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addEventAttendee");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "eventID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "recipientData"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewRecipientType"), com.dmdelivery.webservice.RecipientNameValuePairType[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "fields"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "status"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewRecipientType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecipientNameValuePairType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addEventAttendee_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "fields"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[46] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEventAttendees");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "eventID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewRecipientArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecipientNameValuePairType[][].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getEventAttendees_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "recipients"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[47] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFilters");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "campaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "FilterArrayType"));
        oper.setReturnClass(com.dmdelivery.webservice.FilterType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getFilters_result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "filters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[48] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createSenderAddress");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fromEmail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createSenderAddress_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[49] = oper;

    }

    private static void _initOperationDesc6(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createCampaign");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "brandID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "defaultSenderName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "defaultSenderAddress"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "defaultReplyAddress"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "langs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "isOverall"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "conversionPoints"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "localDomain"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "excludeLists"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createCampaign_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[50] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("copyFieldDefinition");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType"), com.dmdelivery.webservice.DMdeliveryLoginType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "srcCampaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dstCampaignID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        oper.setReturnClass(com.dmdelivery.webservice.RecordResultType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "copyFieldDefinition_result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[51] = oper;

    }

    public DMdeliverySoapAPIBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public DMdeliverySoapAPIBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public DMdeliverySoapAPIBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">addRecipientsResultType>status");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.AddRecipientsResultTypeStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">BrandType>name");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">CampaignType>lang");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">CampaignType>name");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">CampaignType>remarks");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">DMdeliveryLoginType>password");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">DMdeliveryLoginType>username");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">EventExtraType>explanation");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">EventExtraType>inputtype");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">EventExtraType>name");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">EventExtraType>options");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">EventType>lang");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">EventType>name");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">EventType>show_fields");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">EventType>text_accept");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">EventType>text_after");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">EventType>text_decline");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">EventType>text_full");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">EventType>text_open");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">EventType>title");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">GroupType>name");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">GroupType>remarks");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingResponseType>type");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.MailingResponseTypeType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingStatsSummaryResultType>weblink");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingType>attachment");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingType>from_name");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingType>history");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingType>html_msg");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingType>kind");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.MailingTypeKind.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingType>lang");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingType>last_mod_user");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingType>name");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingType>plaintext_msg");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingType>priority");
            cachedSerQNames.add(qName);
            cls = int.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingType>subject");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingType>weblink");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">NewGroupType>name");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">NewGroupType>remarks");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">RecipientFieldType>default");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">RecipientFieldType>desc");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">RecipientFieldType>explanation");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">RecipientFieldType>name");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">RecipientFieldType>type");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">RecipientNameValuePairType>name");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">RecipientNameValuePairType>value");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">RecipientResultType>DMDmessage");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">RecordResultType>status");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.RecordResultTypeStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">SenderAddressType>alias_address");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">SenderAddressType>dmdelivery_address");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">SenderAddressType>forward_address");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">SMSMailingType>history");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">SMSMailingType>lang");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">SMSMailingType>last_mod_user");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">SMSMailingType>name");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">SMSMailingType>pers_msg");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">SMSMailingType>unpers_msg");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addRecipientsResultType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.AddRecipientsResultType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfIntType");
            cachedSerQNames.add(qName);
            cls = int[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int");
            qName2 = new javax.xml.namespace.QName("", "int");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "ArrayOfStringType");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "string");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "BrandArrayType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.BrandType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "BrandType");
            qName2 = new javax.xml.namespace.QName("", "brand");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "BrandType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.BrandType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "CampaignArrayType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.CampaignType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "CampaignType");
            qName2 = new javax.xml.namespace.QName("", "campaign");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "CampaignType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.CampaignType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "DMdeliveryLoginType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.DMdeliveryLoginType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "EventArrayType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.EventType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "EventType");
            qName2 = new javax.xml.namespace.QName("", "eventExtras");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "EventExtraType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.EventExtraType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "EventType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.EventType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "FilterArrayType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.FilterType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "FilterType");
            qName2 = new javax.xml.namespace.QName("", "filters");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "FilterType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.FilterType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "GroupArrayType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.GroupType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "GroupType");
            qName2 = new javax.xml.namespace.QName("", "group");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "GroupType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.GroupType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "MailingArrayType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.MailingType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "MailingType");
            qName2 = new javax.xml.namespace.QName("", "mailing");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "MailingResponseArrayType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.MailingResponseType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "MailingResponseType");
            qName2 = new javax.xml.namespace.QName("", "response");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "MailingResponseType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.MailingResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "MailingStatsSummaryResultType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.MailingStatsSummaryResultType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "MailingType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.MailingType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewGroupType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.NewGroupType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewRecipientArrayType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.RecipientNameValuePairType[][].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewRecipientType");
            qName2 = new javax.xml.namespace.QName("", "recipients");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewRecipientType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.RecipientNameValuePairType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientNameValuePairType");
            qName2 = new javax.xml.namespace.QName("", "fields");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientArrayType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.RecipientType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientType");
            qName2 = new javax.xml.namespace.QName("", "recipients");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientCampaignArrayType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.RecipientCampaignType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientCampaignType");
            qName2 = new javax.xml.namespace.QName("", "recipientCampaign");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientCampaignType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.RecipientCampaignType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientFieldArrayType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.RecipientFieldType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientFieldType");
            qName2 = new javax.xml.namespace.QName("", "recipientField");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientFieldType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.RecipientFieldType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientNameValuePairType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.RecipientNameValuePairType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientResultArrayType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.RecipientResultType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientResultType");
            qName2 = new javax.xml.namespace.QName("", "recipient");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientResultType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.RecipientResultType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.RecipientType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.RecordResultType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "SenderAddressArrayType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.SenderAddressType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "SenderAddressType");
            qName2 = new javax.xml.namespace.QName("", "senderAddress");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "SenderAddressType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.SenderAddressType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "SMSMailingArrayType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.SMSMailingType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "SMSMailingType");
            qName2 = new javax.xml.namespace.QName("", "mailing");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "SMSMailingType");
            cachedSerQNames.add(qName);
            cls = com.dmdelivery.webservice.SMSMailingType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public boolean checkHealth(com.dmdelivery.webservice.DMdeliveryLoginType login) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "checkHealth"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType addOverallRecipient(com.dmdelivery.webservice.DMdeliveryLoginType login, int[] campaignIDs, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData, boolean overwrite) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addOverallRecipient"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, campaignIDs, groupIDs, recipientData, new java.lang.Boolean(overwrite)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType editOverallRecipient(com.dmdelivery.webservice.DMdeliveryLoginType login, int[] campaignIDs, int recipientID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "editOverallRecipient"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, campaignIDs, new java.lang.Integer(recipientID), groupIDs, recipientData});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType editRecipient(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int recipientID, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "editRecipient"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(recipientID), recipientData});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean addOverallRecipientToGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int[] campaignIDs, int recipientID, int[] groupIDs) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addOverallRecipientToGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, campaignIDs, new java.lang.Integer(recipientID), groupIDs});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean removeOverallRecipientFromGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int[] campaignIDs, int recipientID, int[] groupIDs) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "removeOverallRecipientFromGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, campaignIDs, new java.lang.Integer(recipientID), groupIDs});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.BrandType[] getBrands(com.dmdelivery.webservice.DMdeliveryLoginType login) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getBrands"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.BrandType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.BrandType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.BrandType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.CampaignType[] getCampaigns(com.dmdelivery.webservice.DMdeliveryLoginType login) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getCampaigns"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.CampaignType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.CampaignType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.CampaignType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.SenderAddressType[] getSenderAddresses(com.dmdelivery.webservice.DMdeliveryLoginType login) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getSenderAddresses"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.SenderAddressType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.SenderAddressType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.SenderAddressType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecipientCampaignType[] getOverallRecipientCampaigns(com.dmdelivery.webservice.DMdeliveryLoginType login, int recipientID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getOverallRecipientCampaigns"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(recipientID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecipientCampaignType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecipientCampaignType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecipientCampaignType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecipientType[] getRecipientsByMatch(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getRecipientsByMatch"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), recipientData});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecipientType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecipientType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecipientType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecipientFieldType[] getRecipientFields(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String lang) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getRecipientFields"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), lang});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecipientFieldType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecipientFieldType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecipientFieldType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean sendSingleMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int recipientID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "sendSingleMailing"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(mailingID), new java.lang.Integer(recipientID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean sendSingleSMS(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int recipientID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "sendSingleSMS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(mailingID), new java.lang.Integer(recipientID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType sendMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, boolean isTest, java.lang.String resultsEmail, int[] groupIDs, int filterID, java.lang.String[] langs, java.lang.String ADprefixDomains, java.lang.String callbackUrl) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "sendMailing"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(mailingID), new java.lang.Boolean(isTest), resultsEmail, groupIDs, new java.lang.Integer(filterID), langs, ADprefixDomains, callbackUrl});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean sendSystemMail(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int recipientID, java.lang.String attachments) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "sendSystemMail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(mailingID), new java.lang.Integer(recipientID), attachments});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType sendMailingScheduled(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, java.lang.String sendDate, boolean isTest, java.lang.String resultsEmail, int[] groupIDs, int filterID, java.lang.String[] langs, java.lang.String ADprefixDomains, java.lang.String callbackUrl, int approvalGroupID, float approvalPeriod, int approvalAck, int approvalNack) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "sendMailingScheduled"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(mailingID), sendDate, new java.lang.Boolean(isTest), resultsEmail, groupIDs, new java.lang.Integer(filterID), langs, ADprefixDomains, callbackUrl, new java.lang.Integer(approvalGroupID), new java.lang.Float(approvalPeriod), new java.lang.Integer(approvalAck), new java.lang.Integer(approvalNack)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType sendSMS(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, boolean isTest, java.lang.String resultsEmail, int[] groupIDs, int filterID, java.lang.String[] langs, java.lang.String ADprefixDomains, java.lang.String callbackUrl) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "sendSMS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(mailingID), new java.lang.Boolean(isTest), resultsEmail, groupIDs, new java.lang.Integer(filterID), langs, ADprefixDomains, callbackUrl});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType createMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String mailingName, java.lang.String lang, java.lang.String subject, java.lang.String fromName, int senderID, java.lang.String html) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "createMailing"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), mailingName, lang, subject, fromName, new java.lang.Integer(senderID), html});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType slurpMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String mailingName, java.lang.String lang, java.lang.String subject, java.lang.String fromName, int senderID, java.lang.String url, boolean checkTimestamp) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "slurpMailing"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), mailingName, lang, subject, fromName, new java.lang.Integer(senderID), url, new java.lang.Boolean(checkTimestamp)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] removeRecipientFromGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int recipientID, int[] groupIDs) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "removeRecipientFromGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(recipientID), groupIDs});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] addRecipientToGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int recipientID, int[] groupIDs) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addRecipientToGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(recipientID), groupIDs});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int moveRecipientsToGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int fromGroupID, int toGroupID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "moveRecipientsToGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(fromGroupID), new java.lang.Integer(toGroupID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.MailingType[] getMailings(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int limit, boolean definitiveOnly) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getMailings"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(limit), new java.lang.Boolean(definitiveOnly)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.MailingType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.MailingType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.MailingType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.SMSMailingType[] getSMSMailings(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int limit, boolean definitiveOnly) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getSMSMailings"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(limit), new java.lang.Boolean(definitiveOnly)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.SMSMailingType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.SMSMailingType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.SMSMailingType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecipientType[] getRecipientsFromGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String[] fields, int inGroupID, java.util.Date fromDate, int[] mailingIDs, int filterID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getRecipientsFromGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), fields, new java.lang.Integer(inGroupID), fromDate, mailingIDs, new java.lang.Integer(filterID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecipientType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecipientType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecipientType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecipientType[] getRecipients(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, java.lang.String[] fields, int[] inGroupIDs, int[] notInGroupIDs, int[] mailingIDs, int filterID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getRecipients"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), fields, inGroupIDs, notInGroupIDs, mailingIDs, new java.lang.Integer(filterID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecipientType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecipientType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecipientType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] getRecipientGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int recipientID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getRecipientGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(recipientID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.MailingStatsSummaryResultType getMailingStatsSummary(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailing) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getMailingStatsSummary"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(mailing)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.MailingStatsSummaryResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.MailingStatsSummaryResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.MailingStatsSummaryResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.GroupType[] getGroups(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.GroupType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.GroupType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.GroupType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.MailingResponseType[] getMailingResponse(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, java.lang.String types, java.lang.String field) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getMailingResponse"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(mailingID), types, field});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.MailingResponseType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.MailingResponseType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.MailingResponseType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType deleteMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "deleteMailing"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(mailingID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType addGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, com.dmdelivery.webservice.NewGroupType group) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), group});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int flushGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int groupID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "flushGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(groupID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int deleteGroup(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int groupID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "deleteGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(groupID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType addRecipient(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData, boolean addDuplisToGroups, boolean overwrite) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addRecipient"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), groupIDs, recipientData, new java.lang.Boolean(addDuplisToGroups), new java.lang.Boolean(overwrite)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String addRecipientAttachment(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int recipientID, java.lang.String fileName, java.lang.String fileMD5, java.lang.String fileData) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addRecipientAttachment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(mailingID), new java.lang.Integer(recipientID), fileName, fileMD5, fileData});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String addMailingAttachment(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, java.lang.String fileName, java.lang.String fileMD5, java.lang.String fileData) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addMailingAttachment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(mailingID), fileName, fileMD5, fileData});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType deleteMailingAttachments(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, java.lang.String attachmentIDs) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "deleteMailingAttachments"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(mailingID), attachmentIDs});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String getMailingAttachmentIDs(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getMailingAttachmentIDs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(mailingID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.AddRecipientsResultType addRecipients(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[][] recipientDatas, boolean addDuplisToGroups, boolean overwrite) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addRecipients"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), groupIDs, recipientDatas, new java.lang.Boolean(addDuplisToGroups), new java.lang.Boolean(overwrite)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.AddRecipientsResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.AddRecipientsResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.AddRecipientsResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.AddRecipientsResultType addRecipientsSendMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int mailingID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[][] recipientDatas, boolean addDuplisToGroups, boolean overwrite) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addRecipientsSendMailing"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(mailingID), groupIDs, recipientDatas, new java.lang.Boolean(addDuplisToGroups), new java.lang.Boolean(overwrite)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.AddRecipientsResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.AddRecipientsResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.AddRecipientsResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.AddRecipientsResultType addRecipientsSendSMS(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int SMSmailingID, int[] groupIDs, com.dmdelivery.webservice.RecipientNameValuePairType[][] recipientDatas, boolean addDuplisToGroups, boolean overwrite) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addRecipientsSendSMS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(SMSmailingID), groupIDs, recipientDatas, new java.lang.Boolean(addDuplisToGroups), new java.lang.Boolean(overwrite)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.AddRecipientsResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.AddRecipientsResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.AddRecipientsResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType importRemoteCSV(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int groupID, java.lang.String csvURL, java.lang.String csvCharset, java.lang.String csvFieldSep, java.lang.String csvEnclosure, boolean addDuplisToGroups, boolean overwrite, java.lang.String callbackUrl) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "importRemoteCSV"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(groupID), csvURL, csvCharset, csvFieldSep, csvEnclosure, new java.lang.Boolean(addDuplisToGroups), new java.lang.Boolean(overwrite), callbackUrl});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType importRemoteCSVSendMailing(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int groupID, java.lang.String csvURL, java.lang.String csvCharset, java.lang.String csvFieldSep, java.lang.String csvEnclosure, boolean addDuplisToGroups, boolean overwrite, int mailingID, java.lang.String resultsEmail, int filterID, java.lang.String[] langs, java.lang.String ADprefixDomains, java.lang.String callbackUrl) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[44]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "importRemoteCSVSendMailing"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(groupID), csvURL, csvCharset, csvFieldSep, csvEnclosure, new java.lang.Boolean(addDuplisToGroups), new java.lang.Boolean(overwrite), new java.lang.Integer(mailingID), resultsEmail, new java.lang.Integer(filterID), langs, ADprefixDomains, callbackUrl});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.EventType[] getEvents(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int eventID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[45]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getEvents"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(eventID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.EventType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.EventType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.EventType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecipientNameValuePairType[] addEventAttendee(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int eventID, com.dmdelivery.webservice.RecipientNameValuePairType[] recipientData, boolean status) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[46]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addEventAttendee"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(eventID), recipientData, new java.lang.Boolean(status)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecipientNameValuePairType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecipientNameValuePairType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecipientNameValuePairType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecipientNameValuePairType[][] getEventAttendees(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID, int eventID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[47]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getEventAttendees"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID), new java.lang.Integer(eventID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecipientNameValuePairType[][]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecipientNameValuePairType[][]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecipientNameValuePairType[][].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.FilterType[] getFilters(com.dmdelivery.webservice.DMdeliveryLoginType login, int campaignID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[48]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "getFilters"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(campaignID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.FilterType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.FilterType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.FilterType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType createSenderAddress(com.dmdelivery.webservice.DMdeliveryLoginType login, java.lang.String fromEmail) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[49]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "createSenderAddress"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, fromEmail});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType createCampaign(com.dmdelivery.webservice.DMdeliveryLoginType login, int brandID, java.lang.String name, java.lang.String defaultSenderName, int defaultSenderAddress, int defaultReplyAddress, java.lang.String langs, boolean isOverall, java.lang.String conversionPoints, java.lang.String localDomain, java.lang.String excludeLists) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[50]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "createCampaign"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(brandID), name, defaultSenderName, new java.lang.Integer(defaultSenderAddress), new java.lang.Integer(defaultReplyAddress), langs, new java.lang.Boolean(isOverall), conversionPoints, localDomain, excludeLists});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dmdelivery.webservice.RecordResultType copyFieldDefinition(com.dmdelivery.webservice.DMdeliveryLoginType login, int srcCampaignID, int dstCampaignID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[51]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:DMdeliveryAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "copyFieldDefinition"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login, new java.lang.Integer(srcCampaignID), new java.lang.Integer(dstCampaignID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dmdelivery.webservice.RecordResultType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dmdelivery.webservice.RecordResultType) org.apache.axis.utils.JavaUtils.convert(_resp, com.dmdelivery.webservice.RecordResultType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
