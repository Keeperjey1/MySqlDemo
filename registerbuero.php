<?php
require "connbuero.php";
$name = "Hans"; //$_POST["name"];
$surname = "Meiser"; // $_POST["surname"];
$age = "33"; // $_POST["age"];
$user_name = "hansi"; // $_POST["username"]; 
$user_pass = "test"; //$_POST["password"];

//$user_name = "tomy";
//$user_pass = "123";

$qreg = "insert into mitarbeiter (name, surname, age, username, password)values (
'$name', '$surname', '$age', '$user_name', '$user_pass');";

if($conn->query($qreg) === TRUE) {
	echo "insert successful";
}else {
	echo "Error: " . $qreg . "<br>" . $conn->error;
}
$conn->close();

?>