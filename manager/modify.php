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
<h3>修改</h3>
<form method="post" action="modify2.php?id=<?php echo $_GET['id']; ?>"> <!--這邊是HTML的部分,一樣會用到要送GET的部分!-->
<?php 
include "conn.php";
if (!isset($_SESSION['login'])){
	die("</p>請登入系統!");
}

if ($_SESSION['login']!=1){
	die("登入異常!請重新登入");
}
$id=$_GET['id'];

$id=mysqli_real_escape_string($conn,$id);

$ret=mysqli_query($conn,"SELECT * from `registered` where `id`='$id';"); //這邊的id是上面GET收到的id,也就是我門前一頁點要修改密碼的那個帳號,做這個sql語法的查詢只是要確定是不是有這個帳號

if (mysqli_num_rows($ret)== 0) { //如果沒有查到
	die("系統裡找不到這個資料!"); //die 會讓程式做到這邊為止,以下都不會執行,不過前提是這個if的條件要成立
}

$roa=mysqli_fetch_row($ret);
?>
帳號：<input type='text' name="account" value="<?php echo htmlspecialchars($roa["0"]) ;?>" readonly /></br>
密碼：<input type='text' name="passwd" value="<?php echo $roa["1"];?>" /></br>
姓名：<input type='text' name="name" value="<?php echo htmlspecialchars($roa["2"]) ;?>"/></br>
性別：<input type='text' name="sex" value="<?php echo htmlspecialchars($roa["3"]) ;?>"/></br>
出生日期：<input type='text' name="birth" value="<?php echo htmlspecialchars($roa["4"]) ;?>"/></br>
爸爸學歷：<input type='text' name="dadeducation" value="<?php echo htmlspecialchars($roa["5"]) ;?>"/></br>
爸爸年齡：<input type='text' name="dadparentsage" value="<?php echo htmlspecialchars($roa["6"]) ;?>"/></br>
媽媽學歷：<input type='text' name="momeducation" value="<?php echo htmlspecialchars($roa["7"]) ;?>"/></br>
媽媽年齡：<input type='text' name="momparentsage" value="<?php echo htmlspecialchars($roa["8"]) ;?>"/></br>
<!--驗證密碼：<input type='text' name="vpasswd" value="<?php echo $roa["1"];?>" /></br></br>-->
<input type='button' /onclick='history.go(-1)' value='回上一頁'>
<input type="submit" value='更改'> <br/>

</form>
</body>
</html>