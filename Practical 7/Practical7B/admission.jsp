<html>
<head>
<title>Student Admission Form</title>
</head>
<body>
<h2>Student Admission Form</h2>
<form action="process.jsp" method="post">
Name:
<input type="text" name="name">
<br><br>
Age:
<input type="text" name="age">
<br><br>
Email:
<input type="text" name="email">
<br><br>
Mobile:
<input type="text" name="mobile">
<br><br>
Gender:
<input type="radio" name="gender" value="Male"> Male

<input type="radio" name="gender" value="Female"> Female
<br><br>
Course:
<select name="course">
<option value="">Select Course</option>
<option value="BSc IT">BSc IT</option>
<option value="BCA">BCA</option>
<option value="MSc IT">MSc IT</option>
<option value="MCA">MCA</option>
</select>
<br><br>
Hobbies:
<input type="checkbox" name="hobby" value="Reading"> Reading
<input type="checkbox" name="hobby" value="Sports"> Sports
<input type="checkbox" name="hobby" value="Music"> Music
<br><br>
Address:
<textarea name="address"></textarea>
<br><br>
<input type="submit" value="Submit">
</form>
</body>
</html>
