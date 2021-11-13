package com.example.mockypractica.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
@Entity
@Table(name = "mocks")
public class Mock {

    // id, name, route, status code, charset, content-type, access method,
    // http headers, respone body, creation date, expire date
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Route is mandatory")
    @Column(name = "route")
    private String route;

    @NotBlank(message = "Status Code is mandatory")
    @Column(name = "statusCode")
    private String statusCode;

    @NotBlank(message = "Charset is mandatory")
    @Column(name = "charset")
    private String charset;

    @NotBlank(message = "Content type is mandatory")
    @Column(name = "contentType")
    private String contentType;

    @NotBlank(message = "accessMethod is mandatory")
    @Column(name = "accessMethod")
    private String accessMethod;

    @Column(name = "httpHeaders")
    private String httpHeaders;

    @Column(name = "responseBody")
    private String responseBody;

    @NotBlank(message = "Date is mandatory")
    @Column(name = "date")
    private Date dateCreate = new Date();

    /*@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;*/

    public Mock() {
    }
    //name, route, status code, charset, content-type, access method,

    public Mock(String name, String route, String statusCode, String charset, String contentType, String accessMethod) {
        this.name = name;
        this.route = route;
        this.statusCode = statusCode;
        this.charset = charset;
        this.contentType = contentType;
        this.accessMethod = accessMethod;
    }

    /*public long getIdMock() {
        return idMock;
    }

    public void setIdMock(long idMock) {
        this.idMock = idMock;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getAccessMethod() {
        return accessMethod;
    }

    public void setAccessMethod(String accessMethod) {
        this.accessMethod = accessMethod;
    }

    public String getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(String httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    /*public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }*/

}
