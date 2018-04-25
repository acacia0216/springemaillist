<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<style type="text/css">

</style>
<body>
<h1>메일 리스트 가입</h1>
<p>
    메일 리스트에 가입하려면,<br> 아래 항목을 기입하고 submit 버튼을 클릭하세요.
</p>
<form action="/add" method="post">
    <table>
        <tr>
            <td>Last name(성):</td>
            <td><input type="text" name="last_Name" value="" style="border:none"></td>
            <br></tr>
        <tr>
            <td>First name(이름):</td>
            <td><input type="text" name="first_Name" value="" style="border-radius:10px"></td>
        </tr>
        <br>
        <tr>
            <td>Email address:</td>
            <td><input type="text" name="email" value=""></td>
        </tr>
        <br>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="등록"></td>
        </tr>
    </table>
</form>


<br>
<p>
    <a href="/list">리스트 바로가기</a>
</p>
</body>
</html>