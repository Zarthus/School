<?php

class SimpleAPI
{
    protected $dbh;

    protected $api_key;
    protected $format;
    protected $command;

    public $status_id;
    public $status_message;
    public $data = array();

    public function __construct($api_key, $dbh, array $params)
    {
        $this->api_key = $api_key;
        $this->dbh = $dbh;

        if (isset($params["command"]))
            $this->setCommand($params["command"]);

        $this->setStatus(200);
    }

    public function getInvalidRequestResponse($status, $message)
    {
        $this->setStatus((int) $status);
        $this->setStatusMessage($message);
        $this->setData(array());

        return $this->getResponse();
    }

    public function getResponse($format = 'auto')
    {
        $response = array
        (
            "status" => $this->getStatus(),
            "status_message" => $this->getStatusMessage(),
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

    protected function getStatus()
    {
        if (!isset($this->status_id))
            return 404;

        return $this->status_id;
    }

    protected function getStatusMessage()
    {
        if (!isset($this->status_message))
            return "No status message set.";

        return $this->status_message;
    }

    protected function getData()
    {
        if (!isset($this->data))
            return array();

        return (array) $this->data;
    }

    protected function getFormat()
    {
        if (!isset($this->format) || !is_string($this->format) || !$this->isValidFormat($this->format))
            return 'json';

        return $this->format;
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

    protected function isValidFormat($format)
    {
        if ($format != 'xml' && $format != 'json')
            return FALSE;

        return TRUE;
    }
}