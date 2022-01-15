# Self-Practicing-Android-Project
<p style="text-align: center;">&nbsp;</p>
<p style="text-align: center;">&nbsp;</p>
<p align="center"><strong><img src="https://media.dhakatribune.com/uploads/2016/11/nsulogo.jpg" alt="" width="307" height="172" /></strong></p>
<p align="center"><strong>North South University</strong></p>
<p align="center">Department of Electrical &amp; Computer Engineering</p>
<p align="center"><strong>Project Report</strong></p>
<p align="center"><strong>Group No</strong>: 01</p>
<p align="center"><strong>Fall 2020</strong></p>
<p align="center"><strong>Project Name</strong>: An Android app for faculty members to manage students data - Marksheet App.</p>
<p align="center"><strong>Course No</strong>: CSE 299 <strong>Sec</strong><strong>:</strong> 03</p>
<p align="center"><strong>Faculty</strong>: Shaikh Shawon Arefin Shimon (Sas3)</p>
<p align="center"><strong>Name</strong><strong>:</strong> Kazi Ruhol Kabir Moahhed </p>
<p align="center"><strong>ID</strong><strong>:&nbsp; </strong>1721103642</p>
<p align="center"><strong>Email</strong><strong>:</strong> <a href="mailto:kazi.moahhed@northsouth.edu">kazi.moahhed@northsouth.edu</a></p>


<p align="center"><strong>Git Repository</strong><strong>: </strong><a href="https://github.com/NSU-FA20-CSE299-3/Group01">https://github.com/NSU-FA20-CSE299-3/Group01/</a></p>
<p align="center"><strong>Date Prepared</strong><strong>: </strong>18/01/2021</p>
<p><strong>&nbsp;</strong></p>
<p><strong>&nbsp;</strong></p>


<h2> Project Name: Marksheet App </h2><br>
<h3 id="table-of-contents">Table of contents</h3>

<ol>
  <a href="#introduction"><li>Introduction</li><br></a>
  <a href="#features"><li>Software Specification</li><br></a>
  <a href="#technology"><li>Technology</li><br></a>
  <a href="#monetization"><li>Monetization</li></a><br>
  <a href="#conclusion"><li>Conclusion</li></a><br><hr>

</ol>
<br>
<h2 id="#introduction">1. Introduction</h2>
<p>I have built an app specially for faculty members. Where a faculty can manage his students data. A faculty is a very busy person so I think this app will help them to manage their students. They can keep track of their student’s data. They will be able to update data on regular basis. There is a database where I created a lot of data table (Faculty table, student table, etc.). A data table to keep Faculty’s username and password to login. And a data table to keep students data like F.name, L.name, Id, PhoneNo, etc. And a data table to keep data on regular basis like exam’s marks. At the start of a semester a faculty member will be given a section on his particular subject. In a section there will be 40 students. And throughout the semester the faculty have to upload regular data like Quiz-I marks, Quiz-II marks, MID marks, Final Marks. At the end of the table there will be a column for total marks and Final Grade. Grade will be on a university’s grading policy (ex- North South University).
</p>

<h2 id="features">2. Software Specification</h2>

This Project has the following features -
<p><strong>&nbsp;</strong></p>
<p><strong>User Registration:</strong></p>
<p>To Access main activity of this android application user must need to register. Users must have to provide their information. They must include First name, Last name, Phone No, Address, Username and password. The Username will be used as a primary key to identify unique users.</p>
 <br>
   <br>
 <p align="center">
   <img width="200" height="380" src="Mockup/Register.PNG"><br>
   Figure 1.0
 </p>
 <p><strong>Login to a specific platform:</strong></p>
 <p>After registering successfully then user have to go through login phase. The main	feature will be accessed after successfully logged in.</p>
 <br>
   <br>
 <p align="center">
   <img width="200" height="380" src="Mockup/LoginActivity.PNG"><br>
   Figure 2.0
 </p>
 <p><strong>Home Activity:</strong></p>
 <p>After login this application will show the user of it’s Home activity. Where user or a faculty member can use this application’s main features. User can add student by sections properly with Add Student button. User can view added student by section with Show Student button. User can view Student Mark sheet by pressing Mark sheet button. User can maintain exam marks with exam marks button and also can view student progress by student progress button.</p>
 <br>
   <br>
 <p align="center">
   <img width="200" height="380" src="Mockup/HomeActivity.PNG"><br>
   Figure 3.0
 </p>
  <p><strong>Add Student Activity:</strong></p>
 <p>Here user can add student by sections. Just need some student information. Which are Student Id, Student first name, Student last name, Student phone no, student section.</p>
 <br>
   <br>
 <p align="center">
   <img width="200" height="380" src="Mockup/AddStudentActivity.PNG"><br>
   Figure 4.0
 </p>
  <p><strong>Show Student Activity:</strong></p>
 <p>This Activity will present the student details which are added to the database. Like I already added two student data with add student activity and this activity is showing their corresponding data.</p>
 <br>
   <br>
 <p align="center">
   <img width="200" height="380" src="Mockup/ShowStudentActivity.PNG"><br>
   Figure 5.0
 </p>
  <p><strong>Marksheet Activity:</strong></p>
 <p>This activity is incomplete. Just represented the outlook of this activity.</p>
 <br>
   <br>
 <p align="center">
   <img width="200" height="380" src="Mockup/MarksheetActivity.PNG"><br>
   Figure 6.0
 </p>
  <p><strong>Show Student Progress Activity:</strong></p>
 <p>This activity is also incomplete. Just represented the outlook of this activity</p>
 <br>
   <br>
 <p align="center">
   <img width="200" height="380" src="Mockup/StudentProgress.PNG"><br>
   Figure 7.0
 </p>
 


 <h2 id="#technology">3. Technology</h2>

<p>&nbsp;</p>
<p><strong>Proposed Technology Stack:</strong></p>
<p>I proposed to Build mark sheet app by using Android studio 4.0.1 . Which is the latest version of android studio. Android studio is one of the most popular and a complete software to build android applications. For my Front end I decided to use xml to design my front end. For backend I decided to use java programming language. And for database I decided to use SQLiteOpenHelper to build database.</p>
<p>&nbsp;</p>
<p><strong>Implemented Technology Stack:</strong></p>
<p>For user interface I used the built in feature of android studio. I used Android Studio 4.0.1 . I used Java Programming language as my backend. Where all logical condition was running. For database I used built-in database method. I used SQLiteOpenHelper to write queries of SQL. I used xml to design my activities. I used Intents to connect my activity to activity. And Used 100% of Java programming language at the backend.</em></p>
<p>&nbsp;</p>
<h2 id="monetization">4. Monetization</h2>
<p>This is actually a customized project not a generic project. This type of project held for particular organization. </p>
<p>My application basically is on educational purpose. So, I have to charge an amount of money to an educational organization like North South University who will use this app.</p>
<p>&nbsp;</p>
<p><strong>Social Impact</strong></p>
<p>This application will help the faculty or teachers. They are very busy to manage their student’s data properly. They don’t have enough time to do a lot of works properly at a time. They will be able to sort out the marks of students and don’t need to waste their time to calculate the final grade.</p>
<p>&nbsp; </p>
<h2>5. Conclusion</h2>
<p id="#conclusion">
Marksheet App is basically made for the faculty members. Where the faculty members will be able to use by username password verification. Their data will be protected with most security. They will be the most user of this app. The features of this app will help them to maintain the marks distribution of their students properly. And most important thing is this application will help them to maintain their time because it will cost them less time than other process of marks distribution.</p>

