<?php
$news_title=$_POST["news_title_1"];
$news_des=$_POST["news_des_1"];

if (isset($news_title) && isset($news_des))
{
		$con=mysqli_connect("localhost","root","12345678","news_db");
		if ($con)
		{
			$q=mysqli_query($con,"INSERT INTO `news_data`(`news_title`, `news_details`) VALUES ('$news_title','$news_des')");
			if ($q)
			{
				mysqli_close($con);
				header("Location: select_all.php");
			}
			else
			{
				echo "not inserted";
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
	echo "enter data first";
}


?>