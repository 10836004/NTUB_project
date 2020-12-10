<?php
header("Content-Type:text/html; charset=utf-8");
$db_name = "test20200901"; //mysql 資料庫名稱
$mysql_username = "root"; //mysql 資料庫使用者名稱
$mysql_password = "loading109203"; //mysql 資料庫使用者密碼
$server_name = "localhost"; //mysql 登入方式
$conn = mysqli_connect($server_name ,$mysql_username,$mysql_password,$db_name );
?>