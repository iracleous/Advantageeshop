<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1><%= "Hello World!" %></h1>
    <br/>
    <h1><%= "Basic menugi" %></h1>
    <br/>
    <a href="http://localhost:8080/eshop-1.0-SNAPSHOT/api/ping">Hello World</a><br />
    <a href="http://localhost:8080/eshop-1.0-SNAPSHOT/api/customer"> Get all customers</a> <br />
    <input type="number" id="customerId" placehoder="customerId"> <button onclick="getCustomer()">Get a customers</button>
    <br />
    <a href="http://localhost:8080/eshop-1.0-SNAPSHOT/CreateCustomer.html"> Create a customer</a> <br />

<script>
    function getCustomer(){
        url = "http://localhost:8080/eshop-1.0-SNAPSHOT/api/customer/" + document.getElementById("customerId").value
        window.open(url,"_self");
    }

</script>

</body>
</html>