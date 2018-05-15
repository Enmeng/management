<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%--导入jstl标签--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%-- 设置页面全局变量 --%>
<c:set var="domain" value="http://127.0.0.1:8080" />
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="basePath" value="${domain}${ctx}" />

<c:set var="cdnDomain" value="http://127.0.0.1:8080" />
<c:set var="cdnPath" value="${domain}${ctx}" />


<%-- 设置JS全局变量--%>
<script type="text/javascript">
  var Global = {};
//   动态请求
  Global.domain = "${domain}";
  Global.ctx = "${pageContext.request.contextPath}";
  Global.basePath = "${basePath}";
//静态请求
  Global.cdnDomain = "${cdnDomain}";
  Global.cdnPath = "${cdnPath}";
</script>