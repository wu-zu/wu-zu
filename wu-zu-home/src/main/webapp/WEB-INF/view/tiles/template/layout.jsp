<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!doctype html>
<html class="no-js" lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title><tiles:getAsString name="title" /></title>
<meta name="description" content="이곳은 우주입니다." />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

<script src="${pageContext.request.contextPath}/js/vendor/modernizr-2.8.3.min.js"></script>
<script src="//code.jquery.com/jquery-2.2.0.min.js"></script>
<script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/js/vendor/jquery-2.2.0.min.js"><\/script>')</script>
</head>
<body>
<!--[if lt IE 9]>
<p class="browserupgrade">브라우져가 <strong>오래되었습니다.</strong> Internet Explorer의 예전 버전을 사용하는 것 같습니다. 웹상에서 최상의 경험을 보려면 브라우저를 <a href="http://browsehappy.com/">업데이트</a>하십시오.</p>
<![endif]-->

<div id="page">
  <header>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="menu" />
  </header>
  
  <section>
  	<tiles:insertAttribute name="body" />
  </section>
  
  <footer>
    <tiles:insertAttribute name="footer" />
  </footer>
</div>

<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>

<script>
  (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
  function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
  e=o.createElement(i);r=o.getElementsByTagName(i)[0];
  e.src='https://www.google-analytics.com/analytics.js';
  r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
  ga('create','UA-68041465-1','auto');ga('send','pageview');
</script>
</body>
</html>