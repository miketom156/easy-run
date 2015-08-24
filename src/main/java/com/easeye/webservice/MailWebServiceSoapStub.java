/**
 * MailWebServiceSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class MailWebServiceSoapStub extends org.apache.axis.client.Stub implements com.easeye.webservice.MailWebServiceSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[75];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
        _initOperationDesc6();
        _initOperationDesc7();
        _initOperationDesc8();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("HelloWorld");
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "HelloWorldResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SendMailListRequest");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeMessageTemplateDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageTemplateDTO"),com.easeye.webservice.EaseyeMessageTemplateDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeMessageReceiveDTOArray"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfEaseyeMessageReceiveDTO"),com.easeye.webservice.EaseyeMessageReceiveDTO[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageReceiveDTO"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeSendOptionDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeSendOptionDTO"),com.easeye.webservice.EaseyeSendOptionDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SendMailListRequestResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SendMailListRequestByGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeMessageTemplateDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageTemplateDTO"),com.easeye.webservice.EaseyeMessageTemplateDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeGroupDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeGroupDTO"),com.easeye.webservice.EaseyeGroupDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeSendOptionDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeSendOptionDTO"),com.easeye.webservice.EaseyeSendOptionDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SendMailListRequestByGroupResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelMaillist");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "mailListName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeDetailedResultReturnDTO"));
        oper.setReturnClass(EaseyeDetailedResultReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CancelMaillistResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ImportContactByGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeGroupDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeGroupDTO"),com.easeye.webservice.EaseyeGroupDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeMessageReceiveDTOArray"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfEaseyeMessageReceiveDTO"),com.easeye.webservice.EaseyeMessageReceiveDTO[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageReceiveDTO"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ImportContactByGroupResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ImportContactByGroupExt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeGroupDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeGroupDTO"),com.easeye.webservice.EaseyeGroupDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeMessageReceiveDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageCustomReceiverDTO"),com.easeye.webservice.EaseyeMessageCustomReceiverDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "importName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeDetailedResultReturnDTO"));
        oper.setReturnClass(EaseyeDetailedResultReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ImportContactByGroupExtResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ImportContactByGroupDetailed");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeGroupDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeGroupDTO"),com.easeye.webservice.EaseyeGroupDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeMessageReceiveDTOArray"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfEaseyeMessageReceiveDTO"),com.easeye.webservice.EaseyeMessageReceiveDTO[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageReceiveDTO"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "importName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeDetailedResultReturnDTO"));
        oper.setReturnClass(EaseyeDetailedResultReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ImportContactByGroupDetailedResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("MoveContactToNewGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "newGroupName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeMessageReceiveDTOArray"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfEaseyeMessageReceiveDTO"),com.easeye.webservice.EaseyeMessageReceiveDTO[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageReceiveDTO"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MoveContactToNewGroupResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SendMailReportResponse");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "queryId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "reportOption"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailStatusReportDTO"));
        oper.setReturnClass(MailStatusReportDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SendMailReportResponseResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCountByGroupName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "groupName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetCountByGroupNameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("QueryContactByGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "groupName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "QueryContactByGroupResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetGroupList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfEaseyeGroupDTO"));
        oper.setReturnClass(EaseyeGroupDTO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetGroupListResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeGroupDTO"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModifyGroupName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "oldGroupName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "newGroupName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteGroupByGroupName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "groupName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteGroupByGroupNameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CreateTask");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SendTemplate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sendTemplateRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SendTemplateRequest"),com.easeye.webservice.SendTemplateRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SendTemplateResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AccessCheck");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "userName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "password"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AccessCheckResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "mailUser"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CustomMailUser"),com.easeye.webservice.CustomMailUser.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AddUserResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "mailUser"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CustomMailUser"),com.easeye.webservice.CustomMailUser.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateUserResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ManageUserPoint");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "point"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ManageUserPointResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSumReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "projectName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "maillistName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentDatetimeFrom"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentDatetimeTo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfMailStatusReportDTO"));
        oper.setReturnClass(MailStatusReportDTO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetSumReportResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailStatusReportDTO"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetReportDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentMailListId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "currentPageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfReportDetail"));
        oper.setReturnClass(ReportDetail[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetReportDetailResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportDetail"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetReportMoreDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentMailListId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "currentPageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfReportMoreDetail"));
        oper.setReturnClass(ReportMoreDetail[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetReportMoreDetailResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportMoreDetail"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetWebServiceSumReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "templateName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentDatetimeFrom"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentDatetimeTo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "WebServiceReportReturnDTO"));
        oper.setReturnClass(WebServiceReportReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetWebServiceSumReportResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetWebServiceReportDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "templateName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentDatetimeFrom"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentDatetimeTo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "currentPageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "WebServiceReportDetailReturnDTO"));
        oper.setReturnClass(WebServiceReportDetailReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetWebServiceReportDetailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetMailReportDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentMailListId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "currentPageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailReportDetailReturnDTO"));
        oper.setReturnClass(MailReportDetailReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetMailReportDetailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetMailSumReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "projectName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "maillistName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentDatetimeFrom"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentDatetimeTo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailSumReportReturnDTO"));
        oper.setReturnClass(MailSumReportReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetMailSumReportResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EY_ImportContactByGroupDetailed");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeGroupDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeGroupDTO"),com.easeye.webservice.EaseyeGroupDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ey_MessageReceiveDTOArray"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfEY_MessageReceiveDTO"),com.easeye.webservice.EY_MessageReceiveDTO[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_MessageReceiveDTO"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeDetailedResultReturnDTO"));
        oper.setReturnClass(EaseyeDetailedResultReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_ImportContactByGroupDetailedResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EY_SendMailListRequest");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeMessageTemplateDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageTemplateDTO"),com.easeye.webservice.EaseyeMessageTemplateDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ey_MessageReceiveDTOArray"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfEY_MessageReceiveDTO"),com.easeye.webservice.EY_MessageReceiveDTO[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_MessageReceiveDTO"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeSendOptionDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeSendOptionDTO"),com.easeye.webservice.EaseyeSendOptionDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_SendMailListRequestResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EY_GetSumReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "projectName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "maillistName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentDatetimeFrom"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentDatetimeTo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfEY_MailStatusReportDTO"));
        oper.setReturnClass(EY_MailStatusReportDTO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_GetSumReportResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_MailStatusReportDTO"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetImportFailedRecords");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "importName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "currentPageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeDetailedResultReturnDTO"));
        oper.setReturnClass(EaseyeDetailedResultReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetImportFailedRecordsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ValidateEmail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "returnUrl"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ValidateEmailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetGroupInfoByGroupName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GroupName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetGroupInfoReturnDTO"));
        oper.setReturnClass(GetGroupInfoReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetGroupInfoByGroupNameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetMailContactInAction");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "dateFrom"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "dateTo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "currentPageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailContactInActionReturnDTO"));
        oper.setReturnClass(MailContactInActionReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetMailContactInActionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetMailSenderStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sendEmail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMailSenderStatusReturnDTO"));
        oper.setReturnClass(EaseyeMailSenderStatusReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetMailSenderStatusResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateRecipientsStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "recipients"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfString"), String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "string"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "status"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeDetailedResultReturnDTO"));
        oper.setReturnClass(EaseyeDetailedResultReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateRecipientsStatusResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RemoveTemplate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "templateName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "RemoveTemplateResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateTemplate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeMessageTemplateDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageTemplateDTO"),com.easeye.webservice.EaseyeMessageTemplateDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateTemplateResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SendMail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeMessageReceiveDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageReceiveDTO"),com.easeye.webservice.EaseyeMessageReceiveDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "templateName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeSendOptionDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeSendOptionDTO"),com.easeye.webservice.EaseyeSendOptionDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SendMailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSmtpSendResultByEmail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "dtBeginTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "dtEndTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SmtpSendResultReturnDTO"));
        oper.setReturnClass(SmtpSendResultReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetSmtpSendResultByEmailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSmtpSendResult");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "dtBeginTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "dtEndTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SmtpSendResultPaginationReturnDTO"));
        oper.setReturnClass(SmtpSendResultPaginationReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetSmtpSendResultResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UploadAttachment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "attachmentContent"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "attachmentName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "uploadMode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AttachmentReturnDTO"));
        oper.setReturnClass(AttachmentReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UploadAttachmentResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AttachmentQuery");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "fileName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AttachmentReturnDTO"));
        oper.setReturnClass(AttachmentReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AttachmentQueryResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetMailTopics");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetTopicReturnDTO"));
        oper.setReturnClass(GetTopicReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetMailTopicsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[43] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetMailTopic");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "topicName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetTopicByTopicNameReturnDTO"));
        oper.setReturnClass(GetTopicByTopicNameReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetMailTopicResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[44] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddMailTopic");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "topic"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Mail_Topic"),com.easeye.webservice.Mail_Topic.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AddMailTopicResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[45] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModifyMailTopic");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "topic"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Mail_Topic"),com.easeye.webservice.Mail_Topic.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ModifyMailTopicResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[46] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteMailTopic");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "topicName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteMailTopicResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[47] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateRecipientsStatusExt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "recipients"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfString"), String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "string"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "status"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "topicNames"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeDetailedResultReturnDTO"));
        oper.setReturnClass(EaseyeDetailedResultReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateRecipientsStatusExtResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[48] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteContactByGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "emails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfString"), String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "string"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "groupName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeDetailedResultReturnDTO"));
        oper.setReturnClass(EaseyeDetailedResultReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteContactByGroupResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[49] = oper;

    }

    private static void _initOperationDesc6(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAccountUserList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "userFilters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UserFilters"),com.easeye.webservice.UserFilters.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AccountUserListReturnDTO"));
        oper.setReturnClass(AccountUserListReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetAccountUserListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[50] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AccountUserGet");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "userId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AccountUserGetReturnDTO"));
        oper.setReturnClass(AccountUserGetReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AccountUserGetResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[51] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTemplateList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "templateFilters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TemplateFilters"),com.easeye.webservice.TemplateFilters.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetTemplateListReturnDTO"));
        oper.setReturnClass(GetTemplateListReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetTemplateListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[52] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("TemplateGet");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "templateId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TemplateGetReturnDTO"));
        oper.setReturnClass(TemplateGetReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TemplateGetResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[53] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTransMailHardBounceList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "senderEmail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "startTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "endTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "currentPageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TransMailBounceGetReturnDTO"));
        oper.setReturnClass(TransMailBounceGetReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetTransMailHardBounceListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[54] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTransMailSpamReportsList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "senderEmail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "startTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "endTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "currentPageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TransMailBounceGetReturnDTO"));
        oper.setReturnClass(TransMailBounceGetReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetTransMailSpamReportsListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[55] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddContactGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "contactGroup"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CustomContactGroup"),com.easeye.webservice.CustomContactGroup.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AddContactGroupResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[56] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteContactGroupByGroupId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "groupId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteContactGroupByGroupIdResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[57] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateContactGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "contactGroup"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateContactGroupDTO"),com.easeye.webservice.UpdateContactGroupDTO.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateContactGroupResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[58] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetContactGroupList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "contactGroupFilters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ContactGroupFilters"),com.easeye.webservice.ContactGroupFilters.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetContactGroupListReturnDTO"));
        oper.setReturnClass(GetContactGroupListReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetContactGroupListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[59] = oper;

    }

    private static void _initOperationDesc7(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddProject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "customProject"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CustomProject"),com.easeye.webservice.CustomProject.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AddProjectResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[60] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteProject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "mailProjectId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteProjectResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[61] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteProjectAndList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "mailProjectId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteProjectAndListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[62] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateProject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "mailProject"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateProjectDTO"),com.easeye.webservice.UpdateProjectDTO.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateProjectResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[63] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProjectList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "projectFilters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ProjectFilters"),com.easeye.webservice.ProjectFilters.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetProjectListReturnDTO"));
        oper.setReturnClass(GetProjectListReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetProjectListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[64] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteSender");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "senderEmail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteSenderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[65] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSMTPPlainReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "category"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "beginTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "endTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "currentPageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPPlainReportDTO"));
        oper.setReturnClass(SMTPPlainReportDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetSMTPPlainReportResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[66] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSMTPReportDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "reportType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "reportCategory"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "category"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "campaign"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "uniqueMsgID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "beginTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "endTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "currentPageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPReportDetailDTO"));
        oper.setReturnClass(SMTPReportDetailDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetSMTPReportDetailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[67] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSMTPBulkReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "category"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "campaign"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "beginTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "endTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "currentPageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPBulkReportDTO"));
        oper.setReturnClass(SMTPBulkReportDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetSMTPBulkReportResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[68] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetContactList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "contactFilter"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ContactFilter"),com.easeye.webservice.ContactFilter.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetContactListReturnDTO"));
        oper.setReturnClass(GetContactListReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetContactListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[69] = oper;

    }

    private static void _initOperationDesc8(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "userEmail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteUserResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[70] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetMailReportDetailExt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "mailListName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "datetimeFrom"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "datetimeTo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "currentPageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailReportDetailExtReturnDTO"));
        oper.setReturnClass(MailReportDetailExtReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetMailReportDetailExtResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[71] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetWebServiceReportDetailExt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "templateName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "datetimeFrom"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "datetimeTo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "sentFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "currentPageIndex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "WebServiceReportDetailExtReturnDTO"));
        oper.setReturnClass(WebServiceReportDetailExtReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetWebServiceReportDetailExtResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[72] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ImportListSentTag");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "mailListName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "tagName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfString"), String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "string"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "listSentTagArray"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfListSentTagDTO"),com.easeye.webservice.ListSentTagDTO[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ListSentTagDTO"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO"));
        oper.setReturnClass(EaseyeReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ImportListSentTagResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[73] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSmtpQueueInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "easeyeUserAccountDTO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO"),com.easeye.webservice.EaseyeUserAccountDTO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SmtpQueueInfoReturnDTO"));
        oper.setReturnClass(SmtpQueueInfoReturnDTO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetSmtpQueueInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[74] = oper;

    }

    public MailWebServiceSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public MailWebServiceSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public MailWebServiceSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
    }

    private void addBindings0() {
            Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AccountUserGetReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.AccountUserGetReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AccountUserListReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.AccountUserListReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfContactInfoDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ContactInfoDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ContactInfoDTO");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ContactInfoDTO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfEaseyeAttachmentReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeAttachmentReturnDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeAttachmentReturnDTO");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeAttachmentReturnDTO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfEaseyeGroupDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeGroupDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeGroupDTO");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeGroupDTO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfEaseyeMessageReceiveDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeMessageReceiveDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageReceiveDTO");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageReceiveDTO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfEaseyeMessageSingleReceiverDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeMessageSingleReceiverDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageSingleReceiverDTO");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageSingleReceiverDTO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfErrorItem");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ErrorItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ErrorItem");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ErrorItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfEY_MailStatusReportDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EY_MailStatusReportDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_MailStatusReportDTO");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_MailStatusReportDTO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfEY_MessageReceiveDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EY_MessageReceiveDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_MessageReceiveDTO");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_MessageReceiveDTO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfHist_TransMailBounce");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.Hist_TransMailBounce[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Hist_TransMailBounce");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Hist_TransMailBounce");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfListSentTagDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ListSentTagDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ListSentTagDTO");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ListSentTagDTO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfMail_Group");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.Mail_Group[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Mail_Group");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Mail_Group");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfMail_Topic");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.Mail_Topic[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Mail_Topic");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Mail_Topic");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfMailContactInActionDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.MailContactInActionDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailContactInActionDTO");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailContactInActionDTO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfMailSenderStatus");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.MailSenderStatus[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailSenderStatus");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailSenderStatus");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfMailStatusReportDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.MailStatusReportDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailStatusReportDTO");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailStatusReportDTO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfReportDetail");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ReportDetail[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportDetail");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportDetail");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfReportDetailExt");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ReportDetailExt[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportDetailExt");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportDetailExt");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfReportMoreDetail");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ReportMoreDetail[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportMoreDetail");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportMoreDetail");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfSimpleContactGroup");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SimpleContactGroup[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SimpleContactGroup");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SimpleContactGroup");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfSimpleProject");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SimpleProject[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SimpleProject");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SimpleProject");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfSimpleTemplateInfo");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SimpleTemplateInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SimpleTemplateInfo");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SimpleTemplateInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfSimpleUserInfo");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SimpleUserInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SimpleUserInfo");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SimpleUserInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfSMTPBulkReport");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SMTPBulkReport[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPBulkReport");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPBulkReport");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfSmtpErrorList");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SmtpErrorList[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SmtpErrorList");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SmtpErrorList");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfSMTPPlainReport");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SMTPPlainReport[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPPlainReport");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPPlainReport");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfSMTPReportDetail");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SMTPReportDetail[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPReportDetail");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPReportDetail");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfString");
            cachedSerQNames.add(qName);
            cls = String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "string");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ArrayOfWebServiceReportDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.WebServiceReportDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "WebServiceReportDTO");
            qName2 = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "WebServiceReportDTO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AttachmentReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.AttachmentReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ContactFilter");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ContactFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ContactGroupFilters");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ContactGroupFilters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ContactInfoDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ContactInfoDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CustomContactGroup");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.CustomContactGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CustomMailUser");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.CustomMailUser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CustomProject");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.CustomProject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CustomTemplate");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.CustomTemplate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CustomUser");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.CustomUser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeAttachmentReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeAttachmentReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeDetailedResultReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeDetailedResultReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeGroupDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeGroupDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMailSenderStatusReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeMailSenderStatusReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageCustomReceiverDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeMessageCustomReceiverDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageReceiveDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeMessageReceiveDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageSingleReceiverDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeMessageSingleReceiverDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageTemplateDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeMessageTemplateDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeSendOptionDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeSendOptionDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeUserAccountDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EaseyeUserAccountDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ErrorItem");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ErrorItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_MailStatusReportDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EY_MailStatusReportDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_MessageReceiveDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.EY_MessageReceiveDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetContactGroupListReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.GetContactGroupListReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetContactListReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.GetContactListReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetGroupInfoReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.GetGroupInfoReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetProjectListReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.GetProjectListReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetTemplateListReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.GetTemplateListReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetTopicByTopicNameReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.GetTopicByTopicNameReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetTopicReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.GetTopicReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Hist_TransMailBounce");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.Hist_TransMailBounce.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ListSentTagDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ListSentTagDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Mail_Group");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.Mail_Group.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Mail_Topic");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.Mail_Topic.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailContactInActionDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.MailContactInActionDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailContactInActionReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.MailContactInActionReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailReportDetailExtReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.MailReportDetailExtReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailReportDetailReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.MailReportDetailReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailSenderStatus");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.MailSenderStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailStatusReportDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.MailStatusReportDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailSumReportReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.MailSumReportReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailUser");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.MailUser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ProjectFilters");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ProjectFilters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportDetail");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ReportDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportDetailExt");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ReportDetailExt.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportMoreDetail");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.ReportMoreDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SendTemplateRequest");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SendTemplateRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SimpleContactGroup");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SimpleContactGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SimpleProject");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SimpleProject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SimpleTemplateInfo");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SimpleTemplateInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SimpleUserInfo");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SimpleUserInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SingleRecipient");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SingleRecipient.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPBulkReport");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SMTPBulkReport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPBulkReportDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SMTPBulkReportDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SmtpErrorList");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SmtpErrorList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPPlainReport");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SMTPPlainReport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPPlainReportDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SMTPPlainReportDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SmtpQueueInfoReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SmtpQueueInfoReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPReportDetail");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SMTPReportDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPReportDetailDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SMTPReportDetailDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SmtpSendResultPaginationReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SmtpSendResultPaginationReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SmtpSendResultReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.SmtpSendResultReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TemplateFilters");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.TemplateFilters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TemplateGetReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.TemplateGetReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TransMailBounceGetReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.TransMailBounceGetReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateContactGroupDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.UpdateContactGroupDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateProjectDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.UpdateProjectDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UserFilters");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.UserFilters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "WebServiceReportDetailExtReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.WebServiceReportDetailExtReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "WebServiceReportDetailReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.WebServiceReportDetailReturnDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings1() {
            Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "WebServiceReportDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.WebServiceReportDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "WebServiceReportReturnDTO");
            cachedSerQNames.add(qName);
            cls =com.easeye.webservice.WebServiceReportReturnDTO.class;
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
                String key = (String) keys.nextElement();
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
                        Class cls = (Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            Class sf = (Class)
                                 cachedSerFactories.get(i);
                            Class df = (Class)
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
        catch (Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public String helloWorld() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/HelloWorld");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "HelloWorld"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (String) _resp;
            } catch (Exception _exception) {
                return (String) org.apache.axis.utils.JavaUtils.convert(_resp, String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO sendMailListRequest(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageTemplateDTO easeyeMessageTemplateDTO,com.easeye.webservice.EaseyeMessageReceiveDTO[] easeyeMessageReceiveDTOArray,com.easeye.webservice.EaseyeSendOptionDTO easeyeSendOptionDTO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/SendMailListRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SendMailListRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, easeyeMessageTemplateDTO, easeyeMessageReceiveDTOArray, easeyeSendOptionDTO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO sendMailListRequestByGroup(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageTemplateDTO easeyeMessageTemplateDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EaseyeSendOptionDTO easeyeSendOptionDTO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/SendMailListRequestByGroup");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SendMailListRequestByGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, easeyeMessageTemplateDTO, easeyeGroupDTO, easeyeSendOptionDTO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeDetailedResultReturnDTO cancelMaillist(EaseyeUserAccountDTO easeyeUserAccountDTO, String mailListName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/CancelMaillist");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CancelMaillist"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, mailListName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeDetailedResultReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeDetailedResultReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeDetailedResultReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO importContactByGroup(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EaseyeMessageReceiveDTO[] easeyeMessageReceiveDTOArray) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/ImportContactByGroup");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ImportContactByGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, easeyeGroupDTO, easeyeMessageReceiveDTOArray});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeDetailedResultReturnDTO importContactByGroupExt(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EaseyeMessageCustomReceiverDTO easeyeMessageReceiveDTO, String importName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/ImportContactByGroupExt");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ImportContactByGroupExt"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, easeyeGroupDTO, easeyeMessageReceiveDTO, importName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeDetailedResultReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeDetailedResultReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeDetailedResultReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeDetailedResultReturnDTO importContactByGroupDetailed(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EaseyeMessageReceiveDTO[] easeyeMessageReceiveDTOArray, String importName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/ImportContactByGroupDetailed");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ImportContactByGroupDetailed"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, easeyeGroupDTO, easeyeMessageReceiveDTOArray, importName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeDetailedResultReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeDetailedResultReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeDetailedResultReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO moveContactToNewGroup(EaseyeUserAccountDTO easeyeUserAccountDTO, String newGroupName,com.easeye.webservice.EaseyeMessageReceiveDTO[] easeyeMessageReceiveDTOArray) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/MoveContactToNewGroup");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MoveContactToNewGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, newGroupName, easeyeMessageReceiveDTOArray});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.MailStatusReportDTO sendMailReportResponse(EaseyeUserAccountDTO easeyeUserAccountDTO, String queryId, int reportOption) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/SendMailReportResponse");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SendMailReportResponse"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, queryId, new Integer(reportOption)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (MailStatusReportDTO) _resp;
            } catch (Exception _exception) {
                return (MailStatusReportDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.MailStatusReportDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int getCountByGroupName(EaseyeUserAccountDTO easeyeUserAccountDTO, String groupName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetCountByGroupName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetCountByGroupName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, groupName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((Integer) _resp).intValue();
            } catch (Exception _exception) {
                return ((Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean queryContactByGroup(EaseyeUserAccountDTO easeyeUserAccountDTO, String groupName, String email) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/QueryContactByGroup");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "QueryContactByGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, groupName, email});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((Boolean) _resp).booleanValue();
            } catch (Exception _exception) {
                return ((Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeGroupDTO[] getGroupList(EaseyeUserAccountDTO easeyeUserAccountDTO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetGroupList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetGroupList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeGroupDTO[]) _resp;
            } catch (Exception _exception) {
                return (EaseyeGroupDTO[]) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeGroupDTO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void modifyGroupName(EaseyeUserAccountDTO easeyeUserAccountDTO, String oldGroupName, String newGroupName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/ModifyGroupName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ModifyGroupName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, oldGroupName, newGroupName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO deleteGroupByGroupName(EaseyeUserAccountDTO easeyeUserAccountDTO, String groupName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/DeleteGroupByGroupName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteGroupByGroupName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, groupName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void createTask(EaseyeUserAccountDTO easeyeUserAccountDTO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/CreateTask");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CreateTask"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO sendTemplate(SendTemplateRequest sendTemplateRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/SendTemplate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SendTemplate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sendTemplateRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean accessCheck(String userName, String password) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/AccessCheck");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AccessCheck"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userName, password});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((Boolean) _resp).booleanValue();
            } catch (Exception _exception) {
                return ((Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO addUser(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.CustomMailUser mailUser) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/AddUser");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AddUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, mailUser});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO updateUser(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.CustomMailUser mailUser) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/UpdateUser");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, mailUser});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO manageUserPoint(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, int point) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/ManageUserPoint");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ManageUserPoint"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, email, new Integer(point)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.MailStatusReportDTO[] getSumReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String projectName, String maillistName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetSumReport");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetSumReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, projectName, maillistName, sentDatetimeFrom, sentDatetimeTo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (MailStatusReportDTO[]) _resp;
            } catch (Exception _exception) {
                return (MailStatusReportDTO[]) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.MailStatusReportDTO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.ReportDetail[] getReportDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, int sentMailListId, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetReportDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetReportDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, new Integer(sentMailListId), new Integer(sentFlag), new Integer(pageSize), new Integer(currentPageIndex)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ReportDetail[]) _resp;
            } catch (Exception _exception) {
                return (ReportDetail[]) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.ReportDetail[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.ReportMoreDetail[] getReportMoreDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, int sentMailListId, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetReportMoreDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetReportMoreDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, new Integer(sentMailListId), new Integer(sentFlag), new Integer(pageSize), new Integer(currentPageIndex)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ReportMoreDetail[]) _resp;
            } catch (Exception _exception) {
                return (ReportMoreDetail[]) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.ReportMoreDetail[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.WebServiceReportReturnDTO getWebServiceSumReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String templateName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetWebServiceSumReport");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetWebServiceSumReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, templateName, sentDatetimeFrom, sentDatetimeTo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (WebServiceReportReturnDTO) _resp;
            } catch (Exception _exception) {
                return (WebServiceReportReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.WebServiceReportReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.WebServiceReportDetailReturnDTO getWebServiceReportDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, String templateName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetWebServiceReportDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetWebServiceReportDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, templateName, sentDatetimeFrom, sentDatetimeTo, new Integer(sentFlag), new Integer(pageSize), new Integer(currentPageIndex)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (WebServiceReportDetailReturnDTO) _resp;
            } catch (Exception _exception) {
                return (WebServiceReportDetailReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.WebServiceReportDetailReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.MailReportDetailReturnDTO getMailReportDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, int sentMailListId, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetMailReportDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetMailReportDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, new Integer(sentMailListId), new Integer(sentFlag), new Integer(pageSize), new Integer(currentPageIndex)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (MailReportDetailReturnDTO) _resp;
            } catch (Exception _exception) {
                return (MailReportDetailReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.MailReportDetailReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.MailSumReportReturnDTO getMailSumReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String projectName, String maillistName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetMailSumReport");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetMailSumReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, projectName, maillistName, sentDatetimeFrom, sentDatetimeTo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (MailSumReportReturnDTO) _resp;
            } catch (Exception _exception) {
                return (MailSumReportReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.MailSumReportReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeDetailedResultReturnDTO EY_ImportContactByGroupDetailed(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeGroupDTO easeyeGroupDTO,com.easeye.webservice.EY_MessageReceiveDTO[] ey_MessageReceiveDTOArray) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/EY_ImportContactByGroupDetailed");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_ImportContactByGroupDetailed"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, easeyeGroupDTO, ey_MessageReceiveDTOArray});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeDetailedResultReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeDetailedResultReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeDetailedResultReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO EY_SendMailListRequest(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageTemplateDTO easeyeMessageTemplateDTO,com.easeye.webservice.EY_MessageReceiveDTO[] ey_MessageReceiveDTOArray,com.easeye.webservice.EaseyeSendOptionDTO easeyeSendOptionDTO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/EY_SendMailListRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_SendMailListRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, easeyeMessageTemplateDTO, ey_MessageReceiveDTOArray, easeyeSendOptionDTO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EY_MailStatusReportDTO[] EY_GetSumReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String projectName, String maillistName, java.util.Calendar sentDatetimeFrom, java.util.Calendar sentDatetimeTo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/EY_GetSumReport");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EY_GetSumReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, projectName, maillistName, sentDatetimeFrom, sentDatetimeTo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EY_MailStatusReportDTO[]) _resp;
            } catch (Exception _exception) {
                return (EY_MailStatusReportDTO[]) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EY_MailStatusReportDTO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeDetailedResultReturnDTO getImportFailedRecords(EaseyeUserAccountDTO easeyeUserAccountDTO, String importName, int pageSize, int currentPageIndex) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetImportFailedRecords");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetImportFailedRecords"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, importName, new Integer(pageSize), new Integer(currentPageIndex)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeDetailedResultReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeDetailedResultReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeDetailedResultReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO validateEmail(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, String returnUrl) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/ValidateEmail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ValidateEmail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, email, returnUrl});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.GetGroupInfoReturnDTO getGroupInfoByGroupName(EaseyeUserAccountDTO easeyeUserAccountDTO, String groupName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetGroupInfoByGroupName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetGroupInfoByGroupName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, groupName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (GetGroupInfoReturnDTO) _resp;
            } catch (Exception _exception) {
                return (GetGroupInfoReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.GetGroupInfoReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.MailContactInActionReturnDTO getMailContactInAction(EaseyeUserAccountDTO easeyeUserAccountDTO, int sentFlag, java.util.Calendar dateFrom, java.util.Calendar dateTo, int pageSize, int currentPageIndex) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetMailContactInAction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetMailContactInAction"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, new Integer(sentFlag), dateFrom, dateTo, new Integer(pageSize), new Integer(currentPageIndex)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (MailContactInActionReturnDTO) _resp;
            } catch (Exception _exception) {
                return (MailContactInActionReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.MailContactInActionReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeMailSenderStatusReturnDTO getMailSenderStatus(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, String sendEmail) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetMailSenderStatus");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetMailSenderStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, email, sendEmail});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeMailSenderStatusReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeMailSenderStatusReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeMailSenderStatusReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeDetailedResultReturnDTO updateRecipientsStatus(EaseyeUserAccountDTO easeyeUserAccountDTO, String[] recipients, int status) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/UpdateRecipientsStatus");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateRecipientsStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, recipients, new Integer(status)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeDetailedResultReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeDetailedResultReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeDetailedResultReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO removeTemplate(EaseyeUserAccountDTO easeyeUserAccountDTO, String templateName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/RemoveTemplate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "RemoveTemplate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, templateName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO updateTemplate(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageTemplateDTO easeyeMessageTemplateDTO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/UpdateTemplate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateTemplate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, easeyeMessageTemplateDTO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO sendMail(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.EaseyeMessageReceiveDTO easeyeMessageReceiveDTO, String templateName,com.easeye.webservice.EaseyeSendOptionDTO easeyeSendOptionDTO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/SendMail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SendMail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, easeyeMessageReceiveDTO, templateName, easeyeSendOptionDTO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.SmtpSendResultReturnDTO getSmtpSendResultByEmail(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, java.util.Calendar dtBeginTime, java.util.Calendar dtEndTime) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetSmtpSendResultByEmail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetSmtpSendResultByEmail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, email, dtBeginTime, dtEndTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (SmtpSendResultReturnDTO) _resp;
            } catch (Exception _exception) {
                return (SmtpSendResultReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.SmtpSendResultReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.SmtpSendResultPaginationReturnDTO getSmtpSendResult(EaseyeUserAccountDTO easeyeUserAccountDTO, String email, java.util.Calendar dtBeginTime, java.util.Calendar dtEndTime, int pageIndex, int pageSize) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetSmtpSendResult");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetSmtpSendResult"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, email, dtBeginTime, dtEndTime, new Integer(pageIndex), new Integer(pageSize)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (SmtpSendResultPaginationReturnDTO) _resp;
            } catch (Exception _exception) {
                return (SmtpSendResultPaginationReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.SmtpSendResultPaginationReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.AttachmentReturnDTO uploadAttachment(EaseyeUserAccountDTO easeyeUserAccountDTO, String attachmentContent, String attachmentName, String uploadMode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/UploadAttachment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UploadAttachment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, attachmentContent, attachmentName, uploadMode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (AttachmentReturnDTO) _resp;
            } catch (Exception _exception) {
                return (AttachmentReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.AttachmentReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.AttachmentReturnDTO attachmentQuery(EaseyeUserAccountDTO easeyeUserAccountDTO, String fileName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/AttachmentQuery");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AttachmentQuery"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, fileName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (AttachmentReturnDTO) _resp;
            } catch (Exception _exception) {
                return (AttachmentReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.AttachmentReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.GetTopicReturnDTO getMailTopics(EaseyeUserAccountDTO easeyeUserAccountDTO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetMailTopics");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetMailTopics"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (GetTopicReturnDTO) _resp;
            } catch (Exception _exception) {
                return (GetTopicReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.GetTopicReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.GetTopicByTopicNameReturnDTO getMailTopic(EaseyeUserAccountDTO easeyeUserAccountDTO, String topicName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[44]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetMailTopic");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetMailTopic"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, topicName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (GetTopicByTopicNameReturnDTO) _resp;
            } catch (Exception _exception) {
                return (GetTopicByTopicNameReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.GetTopicByTopicNameReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO addMailTopic(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.Mail_Topic topic) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[45]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/AddMailTopic");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AddMailTopic"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, topic});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO modifyMailTopic(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.Mail_Topic topic) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[46]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/ModifyMailTopic");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ModifyMailTopic"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, topic});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO deleteMailTopic(EaseyeUserAccountDTO easeyeUserAccountDTO, String topicName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[47]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/DeleteMailTopic");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteMailTopic"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, topicName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeDetailedResultReturnDTO updateRecipientsStatusExt(EaseyeUserAccountDTO easeyeUserAccountDTO, String[] recipients, int status, String topicNames) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[48]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/UpdateRecipientsStatusExt");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateRecipientsStatusExt"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, recipients, new Integer(status), topicNames});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeDetailedResultReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeDetailedResultReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeDetailedResultReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeDetailedResultReturnDTO deleteContactByGroup(EaseyeUserAccountDTO easeyeUserAccountDTO, String[] emails, String groupName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[49]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/DeleteContactByGroup");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteContactByGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, emails, groupName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeDetailedResultReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeDetailedResultReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeDetailedResultReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.AccountUserListReturnDTO getAccountUserList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.UserFilters userFilters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[50]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetAccountUserList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetAccountUserList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, userFilters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (AccountUserListReturnDTO) _resp;
            } catch (Exception _exception) {
                return (AccountUserListReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.AccountUserListReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.AccountUserGetReturnDTO accountUserGet(EaseyeUserAccountDTO easeyeUserAccountDTO, int userId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[51]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/AccountUserGet");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AccountUserGet"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, new Integer(userId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (AccountUserGetReturnDTO) _resp;
            } catch (Exception _exception) {
                return (AccountUserGetReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.AccountUserGetReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.GetTemplateListReturnDTO getTemplateList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.TemplateFilters templateFilters, int pageIndex, int pageSize) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[52]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetTemplateList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetTemplateList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, templateFilters, new Integer(pageIndex), new Integer(pageSize)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (GetTemplateListReturnDTO) _resp;
            } catch (Exception _exception) {
                return (GetTemplateListReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.GetTemplateListReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.TemplateGetReturnDTO templateGet(EaseyeUserAccountDTO easeyeUserAccountDTO, int templateId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[53]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/TemplateGet");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TemplateGet"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, new Integer(templateId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (TemplateGetReturnDTO) _resp;
            } catch (Exception _exception) {
                return (TemplateGetReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.TemplateGetReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.TransMailBounceGetReturnDTO getTransMailHardBounceList(EaseyeUserAccountDTO easeyeUserAccountDTO, String senderEmail, java.util.Calendar startTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[54]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetTransMailHardBounceList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetTransMailHardBounceList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, senderEmail, startTime, endTime, new Integer(pageSize), new Integer(currentPageIndex)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (TransMailBounceGetReturnDTO) _resp;
            } catch (Exception _exception) {
                return (TransMailBounceGetReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.TransMailBounceGetReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.TransMailBounceGetReturnDTO getTransMailSpamReportsList(EaseyeUserAccountDTO easeyeUserAccountDTO, String senderEmail, java.util.Calendar startTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[55]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetTransMailSpamReportsList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetTransMailSpamReportsList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, senderEmail, startTime, endTime, new Integer(pageSize), new Integer(currentPageIndex)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (TransMailBounceGetReturnDTO) _resp;
            } catch (Exception _exception) {
                return (TransMailBounceGetReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.TransMailBounceGetReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO addContactGroup(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.CustomContactGroup contactGroup) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[56]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/AddContactGroup");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AddContactGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, contactGroup});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO deleteContactGroupByGroupId(EaseyeUserAccountDTO easeyeUserAccountDTO, int groupId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[57]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/DeleteContactGroupByGroupId");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteContactGroupByGroupId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, new Integer(groupId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO updateContactGroup(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.UpdateContactGroupDTO contactGroup) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[58]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/UpdateContactGroup");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateContactGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, contactGroup});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.GetContactGroupListReturnDTO getContactGroupList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.ContactGroupFilters contactGroupFilters, int pageIndex, int pageSize) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[59]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetContactGroupList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetContactGroupList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, contactGroupFilters, new Integer(pageIndex), new Integer(pageSize)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (GetContactGroupListReturnDTO) _resp;
            } catch (Exception _exception) {
                return (GetContactGroupListReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.GetContactGroupListReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO addProject(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.CustomProject customProject) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[60]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/AddProject");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AddProject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, customProject});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO deleteProject(EaseyeUserAccountDTO easeyeUserAccountDTO, int mailProjectId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[61]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/DeleteProject");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteProject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, new Integer(mailProjectId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO deleteProjectAndList(EaseyeUserAccountDTO easeyeUserAccountDTO, int mailProjectId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[62]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/DeleteProjectAndList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteProjectAndList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, new Integer(mailProjectId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO updateProject(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.UpdateProjectDTO mailProject) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[63]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/UpdateProject");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateProject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, mailProject});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.GetProjectListReturnDTO getProjectList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.ProjectFilters projectFilters, int pageIndex, int pageSize) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[64]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetProjectList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetProjectList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, projectFilters, new Integer(pageIndex), new Integer(pageSize)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (GetProjectListReturnDTO) _resp;
            } catch (Exception _exception) {
                return (GetProjectListReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.GetProjectListReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO deleteSender(EaseyeUserAccountDTO easeyeUserAccountDTO, String senderEmail) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[65]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/DeleteSender");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteSender"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, senderEmail});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.SMTPPlainReportDTO getSMTPPlainReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String category, java.util.Calendar beginTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[66]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetSMTPPlainReport");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetSMTPPlainReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, category, beginTime, endTime, new Integer(pageSize), new Integer(currentPageIndex)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (SMTPPlainReportDTO) _resp;
            } catch (Exception _exception) {
                return (SMTPPlainReportDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.SMTPPlainReportDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.SMTPReportDetailDTO getSMTPReportDetail(EaseyeUserAccountDTO easeyeUserAccountDTO, int reportType, int reportCategory, String email, String category, String campaign, String uniqueMsgID, java.util.Calendar beginTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[67]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetSMTPReportDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetSMTPReportDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, new Integer(reportType), new Integer(reportCategory), email, category, campaign, uniqueMsgID, beginTime, endTime, new Integer(pageSize), new Integer(currentPageIndex)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (SMTPReportDetailDTO) _resp;
            } catch (Exception _exception) {
                return (SMTPReportDetailDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.SMTPReportDetailDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.SMTPBulkReportDTO getSMTPBulkReport(EaseyeUserAccountDTO easeyeUserAccountDTO, String category, String campaign, java.util.Calendar beginTime, java.util.Calendar endTime, int pageSize, int currentPageIndex) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[68]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetSMTPBulkReport");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetSMTPBulkReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, category, campaign, beginTime, endTime, new Integer(pageSize), new Integer(currentPageIndex)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (SMTPBulkReportDTO) _resp;
            } catch (Exception _exception) {
                return (SMTPBulkReportDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.SMTPBulkReportDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.GetContactListReturnDTO getContactList(EaseyeUserAccountDTO easeyeUserAccountDTO,com.easeye.webservice.ContactFilter contactFilter, int pageIndex, int pageSize) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[69]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetContactList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetContactList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, contactFilter, new Integer(pageIndex), new Integer(pageSize)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (GetContactListReturnDTO) _resp;
            } catch (Exception _exception) {
                return (GetContactListReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.GetContactListReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO deleteUser(EaseyeUserAccountDTO easeyeUserAccountDTO, String userEmail) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[70]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/DeleteUser");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "DeleteUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, userEmail});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.MailReportDetailExtReturnDTO getMailReportDetailExt(EaseyeUserAccountDTO easeyeUserAccountDTO, String mailListName, int sentFlag, java.util.Calendar datetimeFrom, java.util.Calendar datetimeTo, int pageSize, int currentPageIndex) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[71]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetMailReportDetailExt");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetMailReportDetailExt"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, mailListName, new Integer(sentFlag), datetimeFrom, datetimeTo, new Integer(pageSize), new Integer(currentPageIndex)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (MailReportDetailExtReturnDTO) _resp;
            } catch (Exception _exception) {
                return (MailReportDetailExtReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.MailReportDetailExtReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.WebServiceReportDetailExtReturnDTO getWebServiceReportDetailExt(EaseyeUserAccountDTO easeyeUserAccountDTO, String templateName, java.util.Calendar datetimeFrom, java.util.Calendar datetimeTo, int sentFlag, int pageSize, int currentPageIndex) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[72]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetWebServiceReportDetailExt");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetWebServiceReportDetailExt"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, templateName, datetimeFrom, datetimeTo, new Integer(sentFlag), new Integer(pageSize), new Integer(currentPageIndex)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (WebServiceReportDetailExtReturnDTO) _resp;
            } catch (Exception _exception) {
                return (WebServiceReportDetailExtReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.WebServiceReportDetailExtReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.EaseyeReturnDTO importListSentTag(EaseyeUserAccountDTO easeyeUserAccountDTO, String mailListName, String[] tagName,com.easeye.webservice.ListSentTagDTO[] listSentTagArray) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[73]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/ImportListSentTag");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ImportListSentTag"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO, mailListName, tagName, listSentTagArray});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EaseyeReturnDTO) _resp;
            } catch (Exception _exception) {
                return (EaseyeReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.EaseyeReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.easeye.webservice.SmtpQueueInfoReturnDTO getSmtpQueueInfo(EaseyeUserAccountDTO easeyeUserAccountDTO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[74]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.0.43/MailWebService/MailWebService.asmx/GetSmtpQueueInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GetSmtpQueueInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {easeyeUserAccountDTO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (SmtpQueueInfoReturnDTO) _resp;
            } catch (Exception _exception) {
                return (SmtpQueueInfoReturnDTO) org.apache.axis.utils.JavaUtils.convert(_resp,com.easeye.webservice.SmtpQueueInfoReturnDTO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
