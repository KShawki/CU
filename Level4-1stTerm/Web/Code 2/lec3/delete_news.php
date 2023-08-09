<?php
$news_id=$_GET["new_id"];


if (isset($news_id) && is_numeric($news_id))
{
		$con=mysqli_connect("localhost","root","12345678","news_db");
		if ($con)
		{
			$q=mysqli_query($con,"delete from news_data WHERE `id` =$news_id");
			if ($q)
			{
				
				mysqli_close($con);
				header("Location: select_all.php");
				
			}
			else
			{
				echo "not selected";
			}
			mysqli_close($con);
		}
		else
		{
			die("not connected".mysqli_errno());
		}
}
else
{
	echo "hacking";
}


?>