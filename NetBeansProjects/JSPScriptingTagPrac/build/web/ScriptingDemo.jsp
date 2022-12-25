<%-- 
    Document   : ScriptingDemo
    Created on : 06-May-2022, 12:48:40 am
    Author     : SR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%!                     //Declarative Tag (i) Declaring the variavle
        int a = 10;
        String name = "Shivam";
          %>
          
          <%!
           int sum(){           //Declarative Tag (ii) Declaring the method
            return 100+10;
        }
      %>
        
        <%  if(a<5){           // Scriplet Tag     
            out.println(a);
            }
            else{
            out.println("No is too short");
            }
        %>
        <br><br>
        
       <%= "Come again Mr. "+name  // Expression Tag 
       %>   
       <br><br>
        <%= sum() //calling methods via Expression tag 
        %> 
        
     </body>
</html>
