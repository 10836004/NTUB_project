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
<h1>心情溫度計</h1>

<a class="navbar-brand hidden-xs" href="main.php">回選單頁</a>



<?php 
if (!isset($_SESSION['login'])){
	die("</p>請登入系統!");
}

if ($_SESSION['login']!=1){ //名叫login 的 session 裡面的值如果不等於1       (ps.如果要用等於必需要用 == ,如果用一個等於會把值蓋過去,而不是比較) 
	die("登入異常!請重新登入");
}
include "conn.php";
$ret=mysqli_query($conn,"SELECT * FROM `imood`;"); //這邊因為要叫出所有的使用者所以用這sql語法
if (mysqli_num_rows($ret)==0) {

	die("系統內目前沒有任何使用者~");
}else{
	echo"<table border='1' class='sample'>
	 <th>編號</th>
     <th>帳號</th>
     <th>測試時間</th>
     <th>心情(選字)</th>
	 <th>心情(選圖)</th>
     <th>建議事項</th>
     <th>二次測試</th>
     
     </tr>";	 
while($roa=mysqli_fetch_row($ret)){
	//上面用的 fetch_row 是用數字紀錄的,並且是從0開始算,要用欄位名稱可以去看 auth.php 的寫法
	$id=urlencode($roa[0]);//這邊使用 urlencode 來把帳號轉成 URL 的格式,後面用 GET 的時候可以收,然後把轉好的值放到 id 這個變數裡面
	echo "<tr>";
	echo "<td>".$roa[0]."</td>"; //流水號
	echo "<td>".$roa[1]."</td>"; //帳號
	echo "<td>".$roa[2]."</td>"; //測試時間
    echo "<td>".$roa[4]."</td>"; //心情(選字)
	echo "<td>".$roa[5]."</td>"; //心情(選圖)
	echo "<td>".$roa[6]."</td>"; //建議事項
    echo "<td>".$roa[7]."</td>"; //二次測試
	//echo "<td><a href='modify.php?id=$id'>修改</a> | <a href='del.php?id=$id''>刪除</a></td>";
	//這個是修改的文字超聯結,修改密碼的部分會轉到 modify.php?id=$id ,這邊$id的地方就是上面用urlencode轉的部分,後面的刪除也是一樣ㄉ道理
	echo "</tr>";
	}
    echo"</table>";
	}
?>
</body>
</html>