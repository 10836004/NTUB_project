<?php  
session_start();
include "conn.php";
 
$name=trim($_POST['name']);//POST收前端送來的帳密
$passwd=trim($_POST['passwd']);

$name=mysqli_real_escape_string($conn,$name);//去除空白等字元
$passwd=mysqli_real_escape_string($conn,$passwd);

$ret=mysqli_query($conn,"select * from `registered` where `id`='$name' and `pwd`='$passwd';");

if  (mysqli_num_rows($ret) > 0){ //上面($ret)那行的sql執行後返回的值,1代表查到了(因為帳密是同時正確才能登入,所以sql語法用and),0代表沒查到
	echo "登入成功";
	$row=mysqli_fetch_assoc($ret);
	$_SESSION['name']=$row['name'];//建立一個名叫name的session,裡面放和登入時輸入帳密一樣的那位使用者的名子(對應的是資料庫中欄位的名稱)
	$_SESSION['login']=1;//用session紀錄login的值為1
	header("location:main.php");//會直接轉去 main.php 所以不會有上面那行的echo
}else{
	echo "帳密錯誤";
    unset($_SESSION['login']);//清掉名叫login的session,登出的時候可以用
}




?>