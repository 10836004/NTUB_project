<?php  
session_start();
?>
<html>
<header>
<meta charset="UTF-8">
</header>
<style>
body {

    background-color: #FFF6CC;
}
</style>
<body>
<h3>新增使用者</h3>

<?php
if (!isset($_SESSION['login'])){
	die("</p>請登入系統!");
}

if ($_SESSION['login']!=1){
	die("登入異常!請重新登入");
}

include "conn.php";

$account=trim($_POST['account']);//帳號
$name=trim($_POST['name']);//姓名
$passwd=trim($_POST['passwd']);//密碼

    if ($account==""){
        exit("帳號不能為空~</p><input type='button' onclick='history.go(-1)' value='返回'>");
    }
    if ($name==""){
    exit("姓名不能為空~</p><input type='button' onclick='history.go(-1)' value='返回'>");
    }
    if ($passwd==""){
    exit("密碼不能為空~</p><input type='button' onclick='history.go(-1)' value='返回'>");
    }

$account=mysqli_real_escape_string($conn,$account);
$name=mysqli_real_escape_string($conn,$name);
$passwd=mysqli_real_escape_string($conn,$passwd);
$ret=mysqli_query($conn,"select * from `registered` where `id`='$account';");

if(mysqli_num_rows($ret)>0) {
	die("</p>資料庫已有相同的帳號!!</p><input type='button' onclick='history.go(-1)' value='我想想好了!，趕緊回去新增'>");
}else{
	mysqli_query($conn,"INSERT INTO `registered` (`id`, `pwd`, `name`,`sex`) VALUES ('$account','$passwd','$name','')");
	echo "</p>會員資料新增成功!</p>";  
}
//header("location:main.php");
?>
</p>
<a class="navbar-brand hidden-xs" href="main.php">回選單頁</a>
</body>
</html>
