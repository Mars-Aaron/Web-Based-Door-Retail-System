# Web-Based-Door-Retail-System
Class project titled "Web Based Heavy-Duty Door Management &amp; Retail System" using Java EE and Java SE

# Purpose
The purpose of this project was to develop a distributed application to process requests made by users of a web application (Web Based Heavy-Duty Door Management &amp; Retail System) and pass an appropriate response (Error/Content/Data).

# Technologies Used
* J2EE
  * Servlet
    * Sits on the server side and acts as the requests handler (Controller). There will be several servlets in the web server, and each  servlet will handle different parts of the system. One example in the system is a LoginServlet which handles Login requests through GET and POST methods. The GET method is used when the users requests for a webpage related to that servlet (Login.jsp) and the POST method is executed when the user sends a login request. 
  * Java Server Pages (JSP)
    * These are HTML pages that are preprocessed in the web server before being sent to the browser. JSP will contain Tags and other forms of scripting which enables dynamic webpage configuration. Depending on the output of the Servlet (which may or may not pass some data to the corresponding JSP), the content of the final HTML webpage may be different. In the system, this is used to populate tables. A webpage that is meant to list all orders made by user must first get all the order associated with the currently signed in user. The orders are send to the JSP, which is then parsed and populated into HTML tags using Servlet Tags. Once the table tag is created, the HTML webpage is sent to the user's browser and different users will have a different list of products.
  * Enterprise Java Beans (EJB)
    * EJBs in the system is used to encapsulate related objects or data which can then be used in different views to provide consistent usage. For example, in login.jsp, there will be a LoginBean which will contain properties called username and password. This Bean is used in the login.jsp to assign username and password entered by user into the corresponding Bean properties and then when the user clicks on the Login button, the Login method in the bean will be called, which will then make the request to the appropriate controller (Servlet) and pass the username and password into the body. Using bean for this purpose is mainly for reusability, for example similar validations can be performed on similar properties on different views.
* DBMS
  * Oracle Database
    * Oracle database is used to store the data. The database is generated automatically if it does not exist in the server with the help of Persistence API Entity Framework. CRUD features are also easily managed with Persistance API by providing methods for the basic CRUD with the help of EJB.
* Web Application Development
  * HTML
  * CSS
  * JavaScript (Scripting)

# Learning Outcome
Throughout this project, I developed a basic understanding of how distributed applications work and why they are necessary as well as the different architectural choices that can applied. The use of J2EE also teaches the concepts of Containers which allows developers very easily deploy a complete, multi-tier system on any Java enabled system.  
