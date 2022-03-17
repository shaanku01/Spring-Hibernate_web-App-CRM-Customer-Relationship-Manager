<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>List Customers</title>

<!-- Style Sheet Ref-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>



    <div id="container">
        <div id="content">

            <!--Put button : add customer -->
            <input type="button" value="Add Customer"
            onclick="window.location.href='showFormForAdd'; return false;"
            class="add-button"
            /><br/><br/><br/>

            <form:form action="search" method="GET">
            Search Customer : <input type="text" name="theSearchName"/>
            <input type="submit" value="search" class="add-button"/>

            </form:form>



            <!-- add out html table here -->
                <table>
                    <tr>
                        <th>  </th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                         <th>Action</th>
                    </tr>
                    <!-- Loop over and print all the customers-->
                 <form:form action="deleteCustomers"  method="POST">
                    <c:forEach var="tempCustomer" items="${Customers}">

                        <c:url var="updateLink" value="/customer/showFormForUpdate">
                            <c:param name="customerId" value="${tempCustomer.id}"/>
                        </c:url>

                        <c:url var="deleteLink" value="/customer/delete">
                            <c:param name="customerId" value="${tempCustomer.id}"/>
                        </c:url>

                        <tr>
                            <td><input type="checkbox"  name="checkbox" value="${tempCustomer.id}"></td>
                            <td>
                            ${tempCustomer.firstName}
                            </td>
                            <td>${tempCustomer.lastName}</td>
                            <td>${tempCustomer.email}</td>
                            <td>
                            <a href="${updateLink}">Update</a>
                            |
                             <a href="${deleteLink}"
                             onclick ="if(!(confirm('Are you Sure you want to delete this customer?'))) return false">Delete</a>
                            </td>

                        </tr>
                    </c:forEach>
                        <input type="submit" value="Delete Customers" class="add-button"/><br/><br/>
                   </form:form>

                </table>
        </div>
    </div>



</body>
</html>