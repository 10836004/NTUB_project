<?php  
session_start();
?>
<html>
<head>
	<title>新增使用者</title>
	<meta charset="utf-8">
</head>
<style>
body {

    background-color: #FFF6CC;
}
</style>
<body background="https://www.foracare.com.tw/wp-content/uploads/2017/02/%E5%8B%95%E7%89%A9%E8%83%8C%E6%99%AF1920x1080.jpg" >


    <?php 
    if (!isset($_SESSION['login'])){
	die("</p>請登入系統!");
    }
    if ($_SESSION['login']!=1){
	die("登入異常!請重新登入");
    }
    ?>
<form name="f1" action="add2.php" method="POST">
<h1>新增使用者</h1>
<h2>帳號</h2><input type="text" name="account">
<h2>姓名</h2><input type="text" name="name">
<h2>密碼</h2><input type="text" name="passwd"></p>
<input type="submit" value="送出">
</form>
</body>
</html>