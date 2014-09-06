<?php

class Student_API extends Simple_API
{
    protected $class_id;
    protected $student_id;
    protected $teacher_id;

    public function __construct($dbh, array $params)
    {
        parent::__construct($dbh, $params);

        if (isset($params["student_id"]))
            $this->setStudentID($params["student_id"]);
   }

    public function setStudentID($id)
    {
        if (!is_int($id) && (is_string($id) && !is_numeric($id)))
            return FALSE;

        $this->student_id = (int) $id;

        if ($this->api_key)
        {
            $stmt = $this->dbh->prepare("SELECT class_id FROM students WHERE api_key = ? AND student_id = ?");
            $stmt->execute(array($this->api_key, $this->student_id));
            $result = $stmt->fetch();

            if ($result && isset($result['class_id']))
            {
                $this->setClassID($result['class_id']);
            }
        }

        return TRUE;
    }

    public function setClassID($id)
    {
        if (!is_int($id) && (is_string($id) && !is_numeric($id)))
            return FALSE;

        $this->class_id = (int) $id;

        $stmt = $this->dbh->prepare("SELECT teacher_id FROM class WHERE class_id = ?");
        $stmt->execute(array($this->class_id));
        $result = $stmt->fetch(PDO::FETCH_ASSOC);

        if ($result && isset($result['teacher_id']))
        {
            $this->setTeacherID($result['teacher_id']);
        }

        return TRUE;
    }

    public function setTeacherID($id)
    {
        if (!is_int($id) && (is_string($id) && !is_numeric($id)))
            return FALSE;

        $this->teacher_id = (int) $id;
        return TRUE;
    }

    public function getStudentID()
    {
        if (!isset($this->student_id))
            return FALSE;

        return $this->student_id;
    }

    public function getTeacher()
    {
        if (!isset($this->student_id))
            return $this->getInvalidRequestResponse(400, "Student ID not set.");

        if (!isset($this->teacher_id))
            return $this->getInvalidRequestResponse(400, "Teacher ID not set.");

        $this->setStatus(200);
        $this->setStatusMessage("request-get-teacher");

        $stmt = $this->dbh->prepare("SELECT * FROM teachers WHERE teacher_id = ?");
        $stmt->execute(array($this->teacher_id));
        $result = $stmt->fetch(PDO::FETCH_ASSOC);

        $this->setData((array) $result);

        return $this->getResponse();
    }

    public function getAccount()
    {
        if (!isset($this->student_id))
            return $this->getInvalidRequestResponse(400, "Student ID not set.");

        $this->setStatus(200);
        $this->setStatusMessage("request-get-account");

        $stmt = $this->dbh->prepare("SELECT * FROM students WHERE student_id = ?");
        $stmt->execute(array($this->student_id));
        $result = $stmt->fetch(PDO::FETCH_ASSOC);

        $this->setData((array) $result);

        return $this->getResponse();
    }

    public function getClass()
    {
        if (!isset($this->class_id))
            return $this->getInvalidRequestResponse(400, "Class ID not set.");

        $this->setStatus(200);
        $this->setStatusMessage("request-get-class");

        $stmt = $this->dbh->prepare("SELECT * FROM class WHERE class_id = ?");
        $stmt->execute(array($this->class_id));
        $result = $stmt->fetch(PDO::FETCH_ASSOC);

        $this->setData((array) $result);

        return $this->getResponse();
    }

    public function call($format = 'auto')
    {
        $response = null;
        $oldformat = null;

        if ($format != 'auto' && $format != $this->format) {
            $oldformat = $this->format;
            $this->setFormat($format);
        }

        switch($this->command)
        {
            case 'account':
            case 'getaccount':
                $response = $this->getAccount();
                break;

            case 'class':
            case 'getclass':
                $response = $this->getClass();
                break;

            case 'mentor':
            case 'getmentor':
            case 'teacher':
            case 'getteacher':
                $response = $this->getTeacher();
                break;

            default:
                $response = $this->getResponse();
        }

        if ($oldformat !== null)
            $this->setFormat($oldformat);

        return $response;
    }

    protected function isValidCommand($command)
    {
        $commands = array
        (
            'account', 'getaccount',
            'class', 'getclass',
            'mentor', 'getmentor', 'teacher', 'getteacher',
            'student', 'getstudent'
        );

        if (!in_array($command, $commands))
            return FALSE;

        return TRUE;
    }
}