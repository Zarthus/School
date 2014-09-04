<?php
class Autoloader 
{

    public function __construct()
    {
        spl_autoload_register(array($this, 'api'));
        spl_autoload_register(array($this, 'loadclass'));
    }

    public function api($class)
    {
        set_include_path(get_include_path() . PATH_SEPARATOR . 'api' . PATH_SEPARATOR);
        spl_autoload_extensions('.php');
        spl_autoload($class);
    }

    public function loadclass($class)
    {
        set_include_path(get_include_path());
        spl_autoload_extensions('.php');
        spl_autoload($class);
    }

}

new Autoloader();