//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.09.09 at 05:48:14 PM IST 
//


package com.bms.transaction_management;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bms.transaction_management package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bms.transaction_management
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PerformTransactionRequest }
     * 
     */
    public PerformTransactionRequest createPerformTransactionRequest() {
        return new PerformTransactionRequest();
    }

    /**
     * Create an instance of {@link GetAllTransactionsResponse }
     * 
     */
    public GetAllTransactionsResponse createGetAllTransactionsResponse() {
        return new GetAllTransactionsResponse();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link PerformTransactionResponse }
     * 
     */
    public PerformTransactionResponse createPerformTransactionResponse() {
        return new PerformTransactionResponse();
    }

    /**
     * Create an instance of {@link GetAllTransactionsRequest }
     * 
     */
    public GetAllTransactionsRequest createGetAllTransactionsRequest() {
        return new GetAllTransactionsRequest();
    }

}
