<?php

class connection {
	
	var $server="localhost";
	var $username="root";
	var $password="12345678";
	var $db="news_db";
	
	var $connect;
	
	
	function connect()
	{
		$this->connect=mysqli_connect($this->server,$this->username,$this->password,$this->db) or die(mysqli_errno());
	}
	
	function disconnect()
	{
		if (isset($this->connect))
		{
			mysqli_close($this->connect) or die(mysqli_errno());
		}

	}
	
	function return_connect()
	{
		return $this->connect;
	}
	
	
}



?>