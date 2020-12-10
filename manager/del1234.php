<?php  
session_start();
?>
<html>
<header>
<meta charset="UTF-8">
</header>
<body>
<h3>刪除</h3>
<?php 
include "conn.php";
if (!isset($_SESSION['login'])){
	die("</p>請登入系統!");
}

if ($_SESSION['login']!=1){
	die("登入異常!請重新登入");
}
$id=trim($_GET['id']);
$id=mysqli_real_escape_string($conn,$id);
$ret=mysqli_query($conn,"DELETE FROM `calender` WHERE `id` = '$id';");
echo "<h3>會員資料刪除成功！</h3>";
header("location:diary.php");
?>
</body>
</html>