import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/FileUploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
private static final String UPLOAD_DIR = "uploads";
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
File uploadDir = new File(uploadPath);
if (!uploadDir.exists()) {
uploadDir.mkdir();
}
Part filePart = request.getPart("file");
String fileName = filePart.getSubmittedFileName();
File file = new File(uploadPath + File.separator + fileName);
try (InputStream inputStream = filePart.getInputStream();
OutputStream outputStream = new FileOutputStream(file)) {
byte[] buffer = new byte[4096];
int bytesRead;
while ((bytesRead = inputStream.read(buffer)) != -1) {
outputStream.write(buffer, 0, bytesRead);

}
}
response.getWriter().println("File uploaded successfully.");
}
}
