<?php  
session_start();
?>
<html>
<header>
<meta charset="UTF-8">
</header>
<body>
<h3>登出頁面</h3>
<?php 
unset($_SESSION['login']);
echo '登出成功';
header("location:index.php");
?>
</body>
</html>