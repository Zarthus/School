<?php
/*
 * Onze API roepen we als volgt aan:
 * 		/localhost/api_course1/?key=<api key>&cmd=<opdracht>[&args=<argumenten>]
 *
 * 		Hierbij is &args optioneel en hoeft niet meegegeven te worden, omdat een aantal opdrachten geen
 * 		argumenten verwachten
 *
 * Onze API kent de volgende opdrachten:
 * 		getmyaccount	Haal informatie van je eigen account
 * 						Geen argumenten
 * 		getmymentor		Haal informatie over je mentor
 * 						Geen argumenten
 * 		getmyclass		Haal informatie over je class
 * 						Geen argumenten
 * 		getclass		Haal informatie over een class
 * 						Argument(en): &class=<classnaam>  	of		&classid=<id van de class>
 * 		getmentor		Haal informatie over een mentor van een class
 * 						Argument(en): &class=<classnaam>		of		&classid=<id van de class>
 *
 * In ons geval sturen we altijd informatie terug in JSON formaat.
 */


if (!file_exists('dbconn.php'))
{
    if (file_exists('dbconn.example.php'))
    {
        die("dbconn.example.php exists, but dbconn.php does not. " .
            "Please ensure your database details are filled in correctly.");
    }

    die("dbconn.example.php exists, but dbconn.php does not. " .
        "Please ensure your database details are filled in correctly.");
}

include_once('autoloader.php');
include_once('dbconn.php');

$api = new Student_API();

if (empty($_GET)) {
    send_response(invalid_request("No GET response."));
    die(1);
}

if($_SERVER['REQUEST_METHOD'] == 'GET') {
	// We accepteren alleen GET requests voorlopig, dit is niet RESTfull echter

    $format = null;
    if (isset($_GET['format']))
    {
        if (strtolower($_GET['format']) == 'xml')
            $format = 'xml';
        else
            $format = 'json';
    }
	// We controleren eerst de api_key en halen de daarbij studenten ID binnen
	$api_key = isset($_GET['key']) ? $_GET['key'] : null;

    if ($api_key === null)
    {
        send_response(invalid_request("No API Key supplied."));
        die(2);
    }

    $student_id = getStudentID($api_key);
	if ($student_id !== null) {
		// Student gevonden van een geldige API key

		// We bepalen nu welke opdracht gevraagd wordt en voeren deze uit
		$api_command = (!empty($_GET['cmd']) ? strtolower($_GET['cmd']) : 'getmyaccount');
		$return_data = array();

		switch($api_command)
        {
			case 'getmyaccount':
				$return_data = getMyAccount($student_id);
				break;

			case 'getmyclass':
				$return_data = getMyClass($student_id);
				break;

			case 'getmymentor':
				$return_data = getMyMentor($student_id);
				break;

			case 'getclass':
				$class = (isset($_GET['class']) ? (int) $_GET['class'] : 1);
				$return_data = getClass($class);
				break;

			case 'getmentor':
				$class = (isset($_GET['class']) ? (int) $_GET['class'] : 1);
				$return_data = getMentor($class);
				break;

			default:
                send_response(invalid_request("Command was invalid."));
                die(3);
				break;
		}

		send_response($return_data, $format);

	} else {
		// Stuur een fout terug
	}
}