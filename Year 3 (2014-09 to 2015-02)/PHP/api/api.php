<?php
include_once('autoloader.php');
include_once('dbconn.php');

$api_key = isset($_GET['api_key']) ? $_GET['api_key'] : null;
$api = new Student_API($dbh, $_GET, $api_key);

if (empty($_GET) || $_SERVER['REQUEST_METHOD'] != 'GET') {
    $api->sendInvalidRequestResponse(400, "No GET request.", true);
}

$api_valid = $api->validateRequest(); // Validate the request
if ($api_valid !== TRUE)
{
    echo $api_valid;
    die($api->getStatus());
}

$api->sendResponse('auto', true);