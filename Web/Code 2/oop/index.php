<?php

require_once("classes/news_data_class.php");

$ns = new news_data_class();

$arr=$ns->selectAll();

?>

<table border=2 width="100%">
<tr><th>title</th><th>des</th><th>view</th><th>update</th><th>delete</th></tr>

<?php

for ($i=0;$i<sizeof($arr);$i++)
{
	
	echo "<tr>";
			
			echo "<td>".$arr[$i][1]."</td>";
			echo "<td>".$arr[$i][2]."</td>";
			echo "<td><a href='view_news.php?new_id=".$arr[$i][0]."'>view</a></td>";
			echo "<td><a href=''>update</a></td>";
			echo "<td><a href='delete_news.php?new_id=".$arr[$i][0]."'>delete</a></td>";
			echo "</tr>";
			
			
	
}


?>

</table>