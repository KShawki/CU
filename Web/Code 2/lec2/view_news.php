<?php
$news_id=$_GET["new_id"];


if (isset($news_id) && is_numeric($news_id))
{
		$con=mysqli_connect("localhost","root","12345678","news_db");
		if ($con)
		{
			$q=mysqli_query($con,"SELECT `id`, `news_title`, `news_details` FROM `news_data` WHERE `id` =$news_id");
			if ($q)
			{
				$row=mysqli_fetch_array($q);
				
				echo $row["news_title"]."<br><br>".$row["news_details"];
				mysqli_close($con);
				echo "<br><br><br><a href='select_all.php'>back</a>";
				
				
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