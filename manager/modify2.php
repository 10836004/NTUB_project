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
$id=trim($_GET['id']);														//ID
$name=trim($_POST['name']);											//姓名
$account=trim($_POST['account']);									//帳號
$passwd=trim($_POST['passwd']);										//密碼
$sex=trim($_POST['sex']);													//性別
$birth=trim($_POST['birth']);												//出生日期
$dadeducation=trim($_POST['dadeducation']);					//爸爸學歷
$dadparentsage=trim($_POST['dadparentsage']);				//爸爸年齡
$momeducation=trim($_POST['momeducation']);					//媽媽學歷
$momparentsage=trim($_POST['momparentsage']);				//媽媽年齡


$id=mysqli_real_escape_string($conn,$id);											 	//ID
$name=mysqli_real_escape_string($conn,$name);                                  	//姓名
$account=mysqli_real_escape_string($conn,$account);                            	//帳號
$passwd=mysqli_real_escape_string($conn,$passwd);                             	//密碼
$sex=mysqli_real_escape_string($conn,$sex);                                        	//性別
$birth=mysqli_real_escape_string($conn,$birth);                                     	//出生日期
$dadeducation=mysqli_real_escape_string($conn,$dadeducation);            	//爸爸學歷
$dadparentsage=mysqli_real_escape_string($conn,$dadparentsage);        	//爸爸年齡 
$momeducation=mysqli_real_escape_string($conn,$momeducation);        	//媽媽學歷
$momparentsage=mysqli_real_escape_string($conn,$momparentsage);    	//媽媽年齡 






    if ($name===""){
        exit("新姓名不能為空~<input type='button' onclick='history.go(-1)' value='返回'>");
    }
    if ($account===""){
        exit("新密碼不能為空~<input type='button' onclick='history.go(-1)' value='返回'>");
    }
    if ($passwd===""){
        exit("驗證密碼不能為空~<input type='button' onclick='history.go(-1)' value='返回'>");
    }
    
    
    
    else{
    $ret=mysqli_query($conn,"UPDATE `registered` SET `name` = '$name', `pwd` = '$passwd' , `sex` = '$sex' , `birth` = '$birth' , `dadeducation` = '$dadeducation' , `dadparentsage` = '$dadparentsage' , `momeducation` = '$momeducation' , `momparentsage` = '$momparentsage'  WHERE `registered`.`id` = '$id';"); 
        if(mysqli_num_rows($ret)>0) {
            die("</p>密碼修改失敗!<input type='button' onclick='history.go(-1)' value='上一頁'>");
        }
        else{
        echo "密碼修改成功;)";
        header("location:show.php");
        }
    }
        
?>
</body>
</html>