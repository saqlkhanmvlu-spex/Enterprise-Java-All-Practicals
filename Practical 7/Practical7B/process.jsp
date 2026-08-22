<html>
<head>
<title>Admission Details</title>
</head>
<body>
<h2>Admission Details</h2>
<%
String name = request.getParameter("name");
String age = request.getParameter("age");
String email = request.getParameter("email");
String mobile = request.getParameter("mobile");
String gender = request.getParameter("gender");
String course = request.getParameter("course");
String address = request.getParameter("address");
String[] hobbies = request.getParameterValues("hobby");
boolean valid = true;
if(name == null || name.trim().equals(""))
{
out.println("Name is required.<br>");
valid = false;

}
if(age == null || age.trim().equals(""))
{
out.println("Age is required.<br>");
valid = false;
}
if(email == null || email.trim().equals(""))
{
out.println("Email is required.<br>");
valid = false;
}
if(mobile == null || mobile.trim().equals(""))
{
out.println("Mobile number is required.<br>");
valid = false;
}
if(gender == null)
{
out.println("Please select gender.<br>");
valid = false;
}
if(course == null || course.equals(""))
{
out.println("Please select a course.<br>");
valid = false;
}
if(hobbies == null)
{
out.println("Please select at least one hobby.<br>");
valid = false;
}
if(address == null || address.trim().equals(""))
{
out.println("Address is required.<br>");
valid = false;
}
if(valid)
{
%>
<h3>Student Admission Successful</h3>
Name: <%= name %><br><br>
Age: <%= age %><br><br>
Email: <%= email %><br><br>
Mobile: <%= mobile %><br><br>

Gender: <%= gender %><br><br>
Course: <%= course %><br><br>
Hobbies:
<%
for(String hobby : hobbies)
{
out.println(hobby + " ");
}
%>
<br><br>
Address: <%= address %><br><br>
<%
}
%>
</body>
</html>
