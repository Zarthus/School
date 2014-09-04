<?php

class Student_API extends Simple_API
{
    protected $class_id;
    protected $student_id;

    public function __construct($dbh, array $params, $api_key = null)
    {
        parent::__construct($dbh, $params, $api_key);

        if (isset($params["class_id"]))
            $this->setClassID($params["class_id"]);

        if (isset($params["student_id"]))
            $this->setStudentID($params["student_id"]);
   }

    public function setClassID($id)
    {
        if (!is_int($id) || (!is_string($id) && !is_numeric($id)))
            return FALSE;

        $this->class_id = (int) $id;
        return TRUE;
    }

    public function setStudentID($id)
    {
        if (!is_int($id) || (!is_string($id) && !is_numeric($id)))
            return FALSE;

        $this->student_id = (int) $id;
        return TRUE;
    }

    public function getStudentID()
    {
        if (!isset($this->student_id))
            return FALSE;

        return $this->student_id;
    }

    public function getMentor()
    {
        if (!isset($this->student_id))
            return $this->getInvalidRequestResponse("Student ID not set.");

        $this->setStatus(200);
        $this->setStatusReason("request-get-mentor");
        $this->setData(array());

        return $this->getResponse();
    }

    public function getAccount()
    {
        if (!isset($this->student_id))
            return $this->getInvalidRequestResponse("Student ID not set.");

        $this->setStatus(200);
        $this->setStatusReason("request-get-account");
        $this->setData(array());

        return $this->getResponse();
    }

    public function getClass()
    {
        if (!isset($this->class_id))
            return $this->getInvalidRequestResponse("Class ID not set.");

        $this->setStatus(200);
        $this->setStatusReason("request-get-class");
        $this->setData(array());

        return $this->getResponse();
    }

    protected function isValidCommand($command)
    {
        $commands = array
        (
            'account', 'getaccount',
            'class', 'getclass',
            'mentor', 'getmentor',
            'student', 'getstudent'
        );

        if (!in_array($command, $commands))
            return FALSE;

        return TRUE;
    }
}