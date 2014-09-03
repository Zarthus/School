<?php

class Student_API extends Simple_API
{
    protected $class_id;
    protected $student_id;

    public function __construct($api_key, $dbh, array $params)
    {
        parent::__construct($api_key, $dbh, $params);

        if (isset($params["class_id"]))
            $this->setClassID($params["class_id"]);

        if (isset($params["student_id"]))
            $this->setStudentID($params["student_id"]);
   }

    public function setClassID($id)
    {
        if (!is_int($id) || (!is_string($id) && !is_numeric($id))
            return FALSE;

        $this->class_id = (int) $id;
        return TRUE;
    }

    public function setStudentID($id)
    {
        if (!is_int($id) || (!is_string($id) && !is_numeric($id))
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

        return $this->getResponse();
    }

    public function getAccount()
    {
        if (!isset($this->student_id))
            return $this->getInvalidRequestResponse("Student ID not set.");

        $this->setStatus(200);
        $this->setStatusReason("");
        $this->setData(array());

        return $this->getResponse();
    }

    public function getClass()
    {
        if (!isset($this->class_id))
            return $this->getInvalidRequestResponse("Class ID not set.");

        $this->setStatus(200);
        $this->setStatusReason("");
        $this->setData(array());

        return $this->getResponse();
    }

    function getMentor()
    {
        if (!is_int($this->class_id))
            return $this->getInvalidRequestResponse(200, "ClassID is not numeric.");
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