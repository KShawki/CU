<?php session_start(); 

if (isset($_SESSION["user_id"]))
{

echo "welcome ".$_SESSION["email"]."<br>";

echo "<a href='logout.php'> logout <a>";
?>

<form action="insert_query.php" method="post">
News Title <br>
<input type="text" name="news_title_1" id="news_title_1" style="width:320px" required>
<br>

News Description <br>
<textarea name="news_des_1" id="news_des_1" rows=20 cols=40></textarea>
<br>

<input type="submit" name="btn" id="btn" value="insert">

</form>

<?php

}
else
{
	header("Location: index.php");
}

?>