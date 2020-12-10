<?php  
session_start();
?>
<html>
<head>
<title>後台登入畫面</title>
<meta charset="utf-8">
</head>
<style>
body {

    background-color: #FFF6CC;
}
</style>
<body background="https://i.imgur.com/7rYdt.jpg" >
<form name="f1" action="auth.php" method="POST">

<h1>登入畫面</h1>
<h1>帳號</h1><input type="text" name="name">
<h1>密碼</h1><input type="password" name="passwd"></p>
<input type="submit" value="送出">
</form>
</body>
</html>