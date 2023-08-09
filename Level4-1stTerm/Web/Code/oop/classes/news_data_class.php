<?php
require_once("connection.php");

class news_data_class extends connection {
	
	function selectAll()
	{
		parent::connect();
		$sql ="select * from news_data";
		$query=mysqli_query(parent::return_connect(),$sql);
		$num_of_rows=mysqli_affected_rows(parent::return_connect());
		
		for ($i=0;$i<$num_of_rows;$i++)
		{
			$row=mysqli_fetch_assoc($query);
			$arr[$i][0]=$row["id"];
			$arr[$i][1]=$row["news_title"];
			$arr[$i][2]=$row["news_details"];
		}
		
		parent::disconnect();
		return $arr;
		
	}
	
	
	
	function selectDataById($news_id)
	{
		parent::connect();
		$sql ="select * from news_data where id=$news_id";
		$query=mysqli_query(parent::return_connect(),$sql);
		
		
			$row=mysqli_fetch_assoc($query);
			$arr[0]=$row["id"];
			$arr[1]=$row["news_title"];
			$arr[2]=$row["news_details"];
		
		
		parent::disconnect();
		return $arr;
		
	}

    function deleteDataById($news_id)
	{
		parent::connect();
		$sql ="delete from news_data where id=$news_id";
		$query=mysqli_query(parent::return_connect(),$sql);	
		parent::disconnect();
		if ($query)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
?>
