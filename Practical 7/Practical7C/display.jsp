<%@ page import="java.sql.*" %>
<html>
<head>
<title>Products</title>
<style>
body{font-family:Arial;background:#f2f2f2}
h2{text-align:center}
table{width:100%;border-collapse:collapse;background:white}
th,td{padding:10px;border:1px solid #ccc;text-align:center}
th{background:#333;color:white}

</style>
</head>
<body>
<h2>E-Commerce Products</h2>
<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Category</th>
<th>Brand</th>
<th>Price</th>
<th>Quantity</th>
<th>Rating</th>
<th>Discount</th>
<th>Description</th>
</tr>
<%
try {
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/ecommerce",
"root",
"root"
);
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM product");
while(rs.next()) {
%>
<tr>
<td><%=rs.getInt("product_id")%></td>
<td><%=rs.getString("product_name")%></td>
<td><%=rs.getString("category")%></td>
<td><%=rs.getString("brand")%></td>
<td>Rs. <%=rs.getDouble("price")%></td>
<td><%=rs.getInt("quantity")%></td>
<td><%=rs.getDouble("rating")%></td>
<td><%=rs.getDouble("discount")%>%</td>
<td><%=rs.getString("description")%></td>
</tr>
<%
}
con.close();
} catch(Exception e) {
out.println("Error: " + e);

}
%>
</table>
</body>
</html>
