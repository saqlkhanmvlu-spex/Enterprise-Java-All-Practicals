import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
private static final String UPLOAD_DIR = "uploads";
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String fileName = request.getParameter("filename");
if (fileName == null) {
response.getWriter().println("File name is missing.");
return;
}
String filePath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR +
File.separator + fileName;

File file = new File(filePath);
if (!file.exists()) {
response.getWriter().println("File not found.");
return;
}
response.setContentType("application/octet-stream");
response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName +
"\"");
try (FileInputStream inputStream = new FileInputStream(file);
OutputStream outputStream = response.getOutputStream()) {
byte[] buffer = new byte[4096];
int bytesRead;
while ((bytesRead = inputStream.read(buffer)) != -1) {
outputStream.write(buffer, 0, bytesRead);
}}}}

(web.xml)
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE glassfish-web-app PUBLIC "-//GlassFish.org//DTD GlassFish Application Server
3.1 Servlet 3.0//EN" "http://glassfish.org/dtds/glassfish-web-app_3_0-1.dtd">
<glassfish-web-app error-url="">
<context-root>/FileUploadanDownload</context-root>
<class-loader delegate="true"/>
<jsp-config>
<property name="keepgenerated" value="true">
<description>Keep a copy of the generated servlet class' java code.</description>
</property>
</jsp-config>
</glassfish-web-app> 
