<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
<title>우주에 오신 것을 환영합니다.</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/vendor/easyui/themes/default/easyui.css">
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/vendor/easyui/themes/icon.css"> --%>

<script src="${pageContext.request.contextPath}/js/vendor/easyui/jquery.easyui.min.js"></script>
</head>
<body>

<aside>
  <ul id="menu-tree"></ul>
</aside>

<article>

</article>

<script>
$('#menu-tree').tree({
  url : '<c:url value="/energy/menu" />',
  method : 'get',
  loadFilter : function(data) {
      
      for (var i = 0; i < data.length; ++i) {

          var menu = data[i];
          
          menu.text = menu.name;
      }
      
    return data;
  }
});
</script>

</body>
</html>