<?php

$host = 'localhost';
$dbname = '';

$user = '';
$pass = '';

// Make the database connection
if ($host == '' || $dbname == '' || $user == '')
{
	die("dbconn.php was not configured properly, please ensure the database details are filled in.");
}

try {
	$dbh = new PDO("mysql:host=$host;dbname=$dbname", $user, $pass);
} catch (PDOException $e) {
	die("Could not connect to the database.");
}

// unset the variables we will never use again.
unset($host, $dbname, $user, $pass);