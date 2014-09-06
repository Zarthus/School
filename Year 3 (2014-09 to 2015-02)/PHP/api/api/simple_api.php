<?php

abstract class Simple_API
{
    protected $dbh;

    protected $api_key;
    protected $format;
    protected $command;

    public $status_id;
    public $status_message;
    public $data = array();

    public function __construct($dbh, array $params)
    {
        $this->setStatus(200);
        $this->dbh = $dbh;

        if (isset($params['api_key']))
            $this->setApiKey($params['api_key']);

        if (isset($params["format"]))
            $this->setFormat($params["format"]);

        if (isset($params["command"]))
            $this->setCommand($params["command"]);

    }

    public function setApiKey($api_key)
    {
        $this->api_key = $api_key;
    }

    public function validateRequest()
    {
        if ($this->api_key === null)
            return $this->getInvalidRequestResponse(401, "No API key was supplied.");

        return TRUE;
    }

    public function getInvalidRequestResponse($status, $message)
    {
        $this->setStatus((int) $status);
        $this->setStatusMessage($message);
        $this->setData(array());

        return $this->getResponse();
    }

    /* Warning, this kills off the script as result if $die = true. */
    public function sendInvalidRequestResponse($status, $message, $die = false)
    {
        echo $this->getInvalidRequestResponse($status, $message);
        if ($die)
            die($status);
    }

    /* make an api call which figures out which command to use automatically */
    public abstract function call($format = 'auto');

    /* Warning, this kills off the script as result if $die = true. */
    public function sendCall($format = 'auto', $die = false)
    {
        echo $this->call($format);

        if ($die)
            die($this->status_id);
    }

    public function getStatus()
    {
        if (!isset($this->status_id))
            return 404;

        return (int) $this->status_id;
    }

    public function getStatusMessage()
    {
        if (!isset($this->status_message))
            return "No status message set.";

        return $this->status_message;
    }

    public function getData()
    {
        if (!isset($this->data))
            return array();

        return (array) $this->data;
    }

    public function getCommand()
    {
        return $this->command;
    }

    public function getFormat()
    {
        if (!isset($this->format) || !is_string($this->format) || !$this->isValidFormat($this->format))
            return 'json';

        return $this->format;
    }

    protected function getResponse($format = 'auto')
    {
        $response = array
        (
            "status" => $this->getStatus(),
            "status_message" => $this->getStatusMessage(),
            "command" => $this->getCommand(),
            "data" => $this->getData()
        );

        if ($format == 'auto')
            $format = $this->format;

        if ($format == 'xml')
        {
            $xml = new SimpleXMLElement('<root/>');
            array_walk_recursive($response, array($xml, 'addChild'));
            return $xml->asXML();
        }
        else
        {
            return json_encode($response);
        }
    }

    protected function setStatus($status)
    {
        if (!is_numeric($status))
            return FALSE;

        $this->status_id = (int) $status;
        return TRUE;
    }

    protected function setStatusMessage($message)
    {
        if (!is_string($message))
            return FALSE;

        $this->status_message = $message;
        return TRUE;
    }

    protected function setData(array $data)
    {
        $this->data = $data;
        return TRUE;
    }

    protected function setFormat($format)
    {
        if (!is_string($format) || !$this->isValidFormat($format))
            return FALSE;

        $this->format = $format;
        return TRUE;
    }

    protected function setCommand($command)
    {
        $command = strtolower($command);

        if (!$this->isValidCommand($command))
            return FALSE;

        $this->command = $command;
        return TRUE;
    }

    abstract protected function isValidCommand($command);

    protected function isValidFormat($format)
    {
        if ($format != 'xml' && $format != 'json')
            return FALSE;

        return TRUE;
    }
}