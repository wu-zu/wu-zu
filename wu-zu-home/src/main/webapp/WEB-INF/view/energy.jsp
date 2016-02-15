<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="wu-zu.home.layout">
  <tiles:putAttribute name="header">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/vendor/easyui/themes/default/easyui.css">
    <%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/vendor/easyui/themes/icon.css"> --%>
    
    <script src="${pageContext.request.contextPath}/js/vendor/easyui/jquery.easyui.min.js"></script>
  </tiles:putAttribute>
  <tiles:putAttribute name="body">
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
  </tiles:putAttribute>
</tiles:insertDefinition>