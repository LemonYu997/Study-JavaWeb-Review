<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//从请求头中获取Locale信息（语言）
		Locale locale = null;

		String country = request.getParameter("country");
		if ("cn".equals(country)) {
			locale = Locale.CHINA;
		} else if ("us".equals(country)) {
			locale = Locale.US;
		} else {
			//默认
			locale = request.getLocale();
		}
		System.out.println(locale);

		//获取资源包，根据指定的baseName和Locale读取语言信息
		ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
	%>
	<a href="/i18n.jsp?country=cn">中文</a>|
	<a href="/i18n.jsp?country=us">english</a>
	<center>
		<h1><%=new String(bundle.getString("regist").getBytes("ISO-8859-1"), "UTF8")%></h1>
		<table>
		<form>
			<tr>
				<td><%=new String(bundle.getString("username").getBytes("ISO-8859-1"), "UTF8")%></td>
				<td><input name="username" type="text" /></td>
			</tr>
			<tr>
				<td><%=new String(bundle.getString("password").getBytes("ISO-8859-1"), "UTF8")%></td>
				<td><input type="password" /></td>
			</tr>
			<tr>
				<td><%=new String(bundle.getString("sex").getBytes("ISO-8859-1"), "UTF8")%></td>
				<td><input type="radio" />
					<%=new String(bundle.getString("male").getBytes("ISO-8859-1"), "UTF8")%>
					<input type="radio" />
					<%=new String(bundle.getString("female").getBytes("ISO-8859-1"), "UTF8")%>
				</td>
			</tr>
			<tr>
				<td><%=new String(bundle.getString("email").getBytes("ISO-8859-1"), "UTF8")%></td>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="reset" value="<%=new String(bundle.getString("reset").getBytes("ISO-8859-1"), "UTF8")%>" />&nbsp;&nbsp;
				<input type="submit" value="<%=new String(bundle.getString("submit").getBytes("ISO-8859-1"), "UTF8")%>" /></td>
			</tr>
			</form>
		</table>
		<br /> <br /> <br /> <br />
	</center>
	国际化测试：
	<br /> 1、访问页面，通过浏览器设置，请求头信息确定国际化语言。
	<br /> 2、通过左上角，手动切换语言
</body>
</html>