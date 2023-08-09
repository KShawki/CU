<select name=s1 id=s1>
<?php
for ($i=1700;$i<=2010;$i++)
{
	echo "<option value=$i>$i</option>";
}
?>
</select>

<table border=2 width=100% height=100%>
<?php
for ($i=1;$i<=2;$i++)
{
	echo "<tr>";
	for ($j=1;$j<=2;$j++)
	{
		//echo "<td bgcolor='rgb(".rand(150,255).",".rand(50,255).",".rand(0,255).")'>".$i*$j."</td>";
	}
	echo "</tr>";
	
}
?>
</table>


<table border=2 width=100% height=100%>
<?php
for ($i=1;$i<=10;$i++)
{
	echo "<tr>";
	for ($j=1;$j<=10;$j++)
	{
		$x=$i*$j;
		if ($x%2==0)
			echo "<td bgcolor='red'>even";
		else
			echo "<td bgcolor='blue'>odd";
		echo "</td>";
	}
	echo "</tr>";
	
}
?>
</table>

