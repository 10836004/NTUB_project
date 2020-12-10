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

table {

    background-color: #FFF6CC;
}
</style>
<body>

<div style="text-align:right;background-color:#FFF6CC">
   <h2> <?php echo "歡迎："; echo $_SESSION['name'] ;?>&nbsp; | <a href='logout.php'>登出</a></h2>
</div>

<body background="https://i.imgur.com/bHkxx.jpg" >
<?php 
if (!isset($_SESSION['login'])){
	die("請您登入系統~");
}

if ($_SESSION['login']!=1){
	die("請您依正常管道登入;)");
}
    ?>
	
	
<table style="border:8px #9955FF groove;" cellpadding="10" border='8'  >
<tr>
<td width="500" align="center"><a href="add.php"><h2>新增使用者</h2></a></td>
<!--<td width="500" align="center"><a href="excel/index.php">批次新增使用者</a> </td>-->
<td width="500" align="center"><a href="show.php"><h2>使用者資料</h2></a></td>
<td width="500" align="center"><a href="mood.php"><h2>使用者心情</h2></a></td>
<td width="500" align="center"><a href="diary.php"><h2>使用者日記</h2></a></td>
</tr>
</table>


</body>
</html>