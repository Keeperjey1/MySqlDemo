<?php
$db_name = "buero";
$mysql_username = "root";
$mysql_password = "";
$server_name = "localhost";

$conn = mysqli_connect($server_name, $mysql_username, $mysql_password, $db_name);

 if ($conn) {
	 echo "connection successfulb  ";
 } else {
	 echo "connection faild";
 }

?>