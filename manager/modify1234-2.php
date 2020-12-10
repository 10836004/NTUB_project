<?php  
session_start();
?>
<html>
<header>
<meta charset="UTF-8">
</header>
<body>
<h3>修改2</h3>
<?php 
include "conn.php";
 if (!isset($_SESSION['login'])){
	die("</p>請登入系統!");
}

if ($_SESSION['login']!=1){
	die("登入異常!請重新登入");
}
$idid=trim($_GET['idid']);//idid
$id=trim($_GET['id']);//ID
$mood=trim($_POST['mood']);//心情
$weather=trim($_POST['weather']);//天氣
$who=trim($_POST['who']);//和誰
$when=trim($_POST['when']);//發生時間
$what=trim($_POST['what']);//日記內容

$idid=mysqli_real_escape_string($conn,$idid);
$id=mysqli_real_escape_string($conn,$id);
$mood=mysqli_real_escape_string($conn,$mood);
$weather=mysqli_real_escape_string($conn,$weather);
$who=mysqli_real_escape_string($conn,$who);
$when=mysqli_real_escape_string($conn,$when);
$what=mysqli_real_escape_string($conn,$what);

if (mysqli_num_rows($id)>0) { //如果沒有查到
	die("系統裡找不到這個資料!"); //die 會讓程式做到這邊為止,以下都不會執行,不過前提是這個if的條件要成立
}
    else{
    $ret=mysqli_query($conn,"UPDATE `calender` SET `mood` = '$mood', `weather` = '$weather', `person` = '$who', `time` = '$when', `diary` = '$what' WHERE `calender`.`id` = '$id' and  `calender`.`idid`='$idid';"); 
        if(mysqli_num_rows($ret)>0) {
            die("</p>修改失敗!<input type='button' onclick='history.go(-1)' value='上一頁'>");
        }
        else{
        echo "修改成功;)";
        header("location:diary.php");
   
        }
    
	}
?>
</body>
</html>