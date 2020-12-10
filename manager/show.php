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
<body background="https://www.foracare.com.tw/wp-content/uploads/2017/02/%E5%8B%95%E7%89%A9%E8%83%8C%E6%99%AF1920x1080.jpg" >
<div style="text-align:right;background-color:#FFF6CC">
   <h2> <?php echo "歡迎："; echo $_SESSION['name'] ;?>&nbsp; | <a href='logout.php'>登出</a></h2>
</div>
<h1>管理使用者</h1>

<a class="navbar-brand hidden-xs" href="main.php">回選單頁</a>
<?php 
if (!isset($_SESSION['login'])){
	die("</p>請登入系統!");
}

if ($_SESSION['login']!=1){ //名叫login 的 session 裡面的值如果不等於1       (ps.如果要用等於必需要用 == ,如果用一個等於會把值蓋過去,而不是比較) 
	die("登入異常!請重新登入");
}
include "conn.php";
$ret=mysqli_query($conn,"SELECT * FROM `registered`;"); //這邊因為要叫出所有的使用者所以用這sql語法
if (mysqli_num_rows($ret)==0) {

	die("系統內目前沒有任何使用者~");
}else{
	echo"<table border='1' class='sample'>
     <th>帳號</th>
     <th>密碼</th>
     <th>姓名</th>
	 <th>性別</th>
     <th>出生日期</th>
     <th>爸爸學歷</th>
	 <th>爸爸年齡</th>
     <th>媽媽學歷</th>
     <th>媽媽年齡</th>
     <th>其他操作</th>
     </tr>";	 
while($roa=mysqli_fetch_row($ret)){
	//上面用的 fetch_row 是用數字紀錄的,並且是從0開始算,要用欄位名稱可以去看 auth.php 的寫法
	$id=urlencode($roa[0]);//這邊使用 urlencode 來把帳號轉成 URL 的格式,後面用 GET 的時候可以收,然後把轉好的值放到 id 這個變數裡面
	echo "<tr>";
	echo "<td>".$roa[0]."</td>"; //帳號
	echo "<td>".$roa[1]."</td>"; //密碼
    echo "<td>".$roa[2]."</td>"; //姓名
	echo "<td>".$roa[3]."</td>"; //性別
	echo "<td>".$roa[4]."</td>"; //出生日期
    echo "<td>".$roa[5]."</td>"; //爸爸學歷
	echo "<td>".$roa[6]."</td>"; //爸爸年齡
	echo "<td>".$roa[7]."</td>"; //媽媽學歷
    echo "<td>".$roa[8]."</td>"; //媽媽年齡
	echo "<td><a href='modify.php?id=$id'>修改</a> | <a href='del.php?id=$id''>刪除</a></td>";
	//這個是修改的文字超聯結,修改密碼的部分會轉到 modify.php?id=$id ,這邊$id的地方就是上面用urlencode轉的部分,後面的刪除也是一樣ㄉ道理
	echo "</tr>";
	}
    echo"</table>";
	}
?>
</body>
</html>