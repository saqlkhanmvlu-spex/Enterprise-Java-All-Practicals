<%@page import="javax.jms.JMSException"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.jms.Queue"%>
<%@page import="javax.jms.MessageProducer"%>
<%@page import="javax.jms.ConnectionFactory"%>
<%@page import="javax.jms.Session"%>
<%@page import="javax.jms.Connection"%>
<%@page import="javax.jms.TextMessage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    private static ConnectionFactory connFact;
    private static Queue queue;
    Connection conn = null;
    Session mysess = null;
    MessageProducer msgProducer = null;
    TextMessage msg = null;
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>Message Driven Bean</title>
</head>
<body style="color:gray;">
<h1>Welcome To Message Driven Bean</h1>
<%
try {
    InitialContext ctx = new InitialContext();
    queue = (Queue) ctx.lookup("jms/Queue");
    connFact =
        (ConnectionFactory) ctx.lookup("jms/QueueFactory");
    conn = connFact.createConnection();
    mysess = conn.createSession(
        false,
        Session.AUTO_ACKNOWLEDGE
    );
    msgProducer = mysess.createProducer(queue);
    msg = mysess.createTextMessage();
    msg.setText(request.getRemoteAddr());
    msgProducer.send(msg);
}
catch (JMSException e) {
    System.out.println(
        "Exception occurred: " + e.toString()
    );
}
%>
</body>
</html>
