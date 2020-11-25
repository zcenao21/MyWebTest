<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
  <title>repeat test</title>
</head>
<body>
  <form action="/process-repeat">
      用户名：<input type="text" name="username">
      <input type="hidden" name="token" value="${token}">
  </form>
</body>
</html>
