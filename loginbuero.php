<?php
require "connbuero.php";
$user_name = $_POST["username"]; 
$user_pass = $_POST["password"];

//$user_name = "tomy";
//$user_pass = "123";

$mysql_qry = "select * from mitarbeiter where username like '$user_name' and password like '$user_pass';";
$result = mysqli_query($conn, $mysql_qry);
if(mysqli_num_rows($result) > 0) {
	echo "   login success";
}else {
	echo "login failed";
}

?>