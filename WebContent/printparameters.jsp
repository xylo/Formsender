<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Enumeration"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
Enumeration paramNames = request.getParameterNames();
while(paramNames.hasMoreElements()) {
    String name = (String) paramNames.nextElement();
    out.println("Name: " + name);
    String[] values = request.getParameterValues(name);
    if(values.length == 1) {
        String value = values[0];
        if(value.length() == 0) {
            out.print("No Value");
        }else {
            out.print("Value: " + value);
        }
    }else {
        for(String value : values) {
            out.print("Value: " + value);
        }
    }
}

%>
</body>
</html>