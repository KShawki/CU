<div style="float:right"><a href="insert_news.php">add article</a> </div><br>
<table border=2 width="100%">
<tr><th>serial</th><th>title</th><th>des</th><th>view</th><th>update</th><th>delete</th></tr>
<?php
$counter=1;
$con=mysqli_connect("localhost","root","12345678","news_db");

if($con)
{
	$q=mysqli_query($con,"SELECT * FROM `news_data`");
	if($q)
	{
		while($row=mysqli_fetch_array($q))
		{
			echo "<tr>";
			echo "<td>".$counter++."</td>";
			echo "<td>".$row["news_title"]."</td>";
			echo "<td>".$row["news_details"]."</td>";
			echo "<td><a href='view_news.php?new_id=".$row["id"]."'>view</a></td>";
			echo "<td><a href=''>update</a></td>";
			echo "<td><a href='delete_news.php?new_id=".$row["id"]."'>delete</a></td>";
			echo "</tr>";
		}
	}
	else
	{
		echo "error select".mysqli_errno();
	}
}
else
{
	die("not connected".mysqli_errno());
}
mysqli_close($con);

?>
</table>