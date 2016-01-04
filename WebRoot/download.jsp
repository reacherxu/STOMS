<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@page import="java.io.*"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  

</head>  
<body>  
<%  
    OutputStream o = response.getOutputStream();  
    byte b[]=new byte[500];  
    String fileName = request.getParameter("fileName");
   	fileName =java.net.URLDecoder.decode(fileName,"UTF-8");
    File fileLoad = new File("D:/STOMS_FileData_temp/",fileName);  
	response.setHeader("Content-disposition","attachment;filename="+fileName);  
    response.setContentType("application/x-tar");  
    long fileLength=fileLoad.length();  
    String length = String.valueOf(fileLength);  
    response.setHeader("Content_Length",length);  
    FileInputStream in=new FileInputStream(fileLoad);  
    int n=0;  
    while((n=in.read(b))!=-1){  
        o.write(b,0,n);  
    }     
	o.flush();  
	o.close();  
	o=null;  
	response.flushBuffer();  
	out.clear();  
	out = pageContext.pushBody();
      
%>  
</body>  
</html> 