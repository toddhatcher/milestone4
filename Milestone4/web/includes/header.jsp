<%-- 
    Document   : header.jsp
    Created on : Oct 10, 2021, 11:15:35 PM
    Author     : Todd Hatcher
    Assignment : 9.2
    Class      : CIS402-A349
    Date       : 10/12/2021

--%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>All Aboard Toys</title>
    <link rel="shortcut icon" href="<c:url value='/images/favicon.ico'/>">
    <link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
</head>

<body>
    <div id="center">
        <header>
            <img src="<c:url value='/images/logo.png'/>" 
                 alt="All Aboard Toys Logo" width="250">
            <h2>Quality, Name Brand, Wooden Toy Trains</h2>
        </header>
    </div>
    <nav id="nav_bar">
            <form id="searchBox" action = "Search.jsp" method="POST">
                <input type="text" id="search" name="search" placeholder="Search">
            </form>
        
        <a href="<c:url value='/' />">
                  Home</a>
        &nbsp;
        <a href="<c:url value='/admin/index.jsp'/>">
                  Admin</a>          
        <!--
            <ul>
                <li><a href="<c:url value='/admin'/>">
                        Admin</a></li>
                <li><a href="<c:url value='/' />">
                      Home</a></li>

                <li><a href="<c:url value='/user/deleteCookies'/>">
                        Delete Cookies</a></li>
                <li><a href="<c:url value='/order/showCart'/>">
                        Show Cart</a></li>

            </ul>
         -->
    </nav>