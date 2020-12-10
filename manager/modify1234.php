<?php  
session_start();
include "conn.php";
$id=$_GET['id'];
$idid=$_GET['idid'];
$id=mysqli_real_escape_string($conn,$id);
$idid=mysqli_real_escape_string($conn,$idid);
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
<form method="post" action="modify1234-2.php?id=<?php echo $id ?>&idid=<?php echo $idid ?>"> <!--這邊是HTML的部分,一樣會用到要送GET的部分!-->
<?php 
if (!isset($_SESSION['login'])){
	die("</p>請登入系統!");
}

if ($_SESSION['login']!=1){
	die("登入異常!請重新登入");
}
$ret=mysqli_query($conn,"SELECT * from `calender` where `id`='$id'  and  `idid`='$idid';"); //這邊的id是上面GET收到的id,也就是我門前一頁點要修改密碼的那個帳號,做這個sql語法的查詢只是要確定是不是有這個帳號

if (mysqli_num_rows($ret)== 0) { //如果沒有查到
	die("系統裡找不到這個資料!"); //die 會讓程式做到這邊為止,以下都不會執行,不過前提是這個if的條件要成立
}

$roa=mysqli_fetch_row($ret);
?>
<!--姓名：<input type='text' name="name" value="<?php //echo htmlspecialchars($roa["2"]) ;?>"/></br>!-->

流水號：<input type='text' name="idid" value="<?php echo htmlspecialchars($roa["0"]) ;?>" readonly /></br></br>
帳號(學號)：<input type='text' name="account" value="<?php echo htmlspecialchars($roa["1"]) ;?>" readonly /></br></br>
寫日記時間：<input type='text' name="writetime" value="<?php echo $roa["3"];?>"readonly /></br></br>
天氣：<input type='text' name="weather" value="<?php echo $roa["2"];?>" /></br></br>
心情：<input type='text' name="mood" value="<?php echo $roa["5"];?>" /></br></br>
和誰：<input type='text' name="who" value="<?php echo $roa["6"];?>" /></br></br>
發生時間：<input type='text' name="when" value="<?php echo $roa["7"];?>" /></br></br>
日記內容：<input type='textarea' cols="20" rows="3" name="what" value="<?php echo $roa["8"];?>" /></br></br>
<!--日記內容：<textarea cols="20" rows="3" name="what" value="<?php //echo $roa["7"];?>"></textarea></br></br>-->
<input type='button' /onclick='history.go(-1)' value='回上一頁'>
<input type="submit" value='更改'> <br/>

</form>
</body>
</html>