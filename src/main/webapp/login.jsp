<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
        <link href='css/process.css' rel="stylesheet" type="text/css">
        <title>Login</title>
    </head>
    <body id='body' >
        <form id="stock_form" class="pure-form" method="POST" action="./mvc/login/check">
            <table>
                <fieldset id='label'>   
                    <font size='6' color='white'>Login</font><br/><br/><br/>
                    <b>User:</b><input type="text" placeholder="帳號" name="name" value="" /><p/><br/><br/>
                    <b>Pass:</b><input type="password" placeholder="密碼" name="pass" value="" /><p/><br/><br/><br/><br/>
                    <input type="submit"  class="pure-button pure-button-primary" value="Login" id='button'/>
                </fieldset>
            </table>
        </form>
        <table>
        <form:form modelAttribute="User" class="pure-form" action="./mvc/login/check">
            <fieldset  id='label'>
                <legend><h2 class="content-subhead">Login</h2></legend>

                <form:input path="name" placeholder="帳號"  /><p />
                <form:input path="pass" placeholder="密碼" /><p />


                <button id='button' type="submit" class="pure-button pure-button-primary"/>
            </fieldset>
        </form:form>
        </table>
    </body>
</html>
