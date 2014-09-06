<?php

error_reporting(-1); ini_set('display_errors', 1);
include_once('autoloader.php');
include_once('dbconn.php');

$api = new Student_API($dbh, $_GET);

// Validate the request, asking the API if it is missing any required values, true if all is good.
// An API response according to settings if something is wrong (status_message will contain the error, and
// the status code will not be 200).
$api_valid = $api->validateRequest();
if ($api_valid !== TRUE)
{
    echo $api_valid;
    die($api->getStatus());
}

$api->sendCall('auto', true);