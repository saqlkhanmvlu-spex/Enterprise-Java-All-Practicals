<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="EJPracts.MarksEntryBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    private static MarksEntryBean marksEntry;
    public void jspInit() {
        try {
            InitialContext ic = new InitialContext();
  		marksEntry =
(MarksEntryBean) ic.lookup(
                    "java:global/EJBMarksEntry/MarksEntryBean"
                );
        }
        catch (Exception ex) {
            System.out.println(
                "Database Error" + ex.getMessage()
            );
        }
    }
%>
<%
    if (request.getParameter("insertMarks") != null) {
        String name;
        String marks1;
        String marks2;
        String marks3;
        name =
            request.getParameter("stuName");
        marks1 =
            request.getParameter("sub1");
        marks2 =
            request.getParameter("sub2");
        marks3 =
            request.getParameter("sub3");
        marksEntry.addMarks(
            name,
            marks1,
            marks2,
            marks3
        );
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>Marks Entry</title>
</head>
<body>
<h2 style="text-align: center;">
    Enter Details
</h2>
<form name="result" method="post">
<table>
<tr>
    <td>Enter Students Name</td>
    <td>
        <input type="text"
               name="stuName"
               value="" />
    </td>
</tr>
<tr>
    <td>Enter Subject 1 Marks</td>
    <td>
        <input type="text"
               name="sub1"
               value="" />
    </td>
</tr>
<tr>
    <td>Enter Subject 2 Marks</td>
    <td>
        <input type="text"
               name="sub2"
               value="" />
    </td>
</tr>
<tr>
    <td>Enter Subject 3 Marks</td>
    <td>
        <input type="text"
               name="sub3"
               value="" />
    </td>
</tr>
<tr>
    <td colspan="2">
        <input type="submit"
               value="insertMarks"
               name="insertMarks" />
    </td>
</tr>
</table>
</form>
</body>
</html>
