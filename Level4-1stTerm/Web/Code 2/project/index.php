<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<!-- *****************************
** green lush css based layout  **
** ---------------------------- **
** author: Yamazaki             **
** this layout is free for      **
** download, however you can't  **
** redistribute it and put the  **
** zip / rar file in your web   **
** without any permissions from **
** the author. thank you        **
** ---------------------------- **
** have fun with the layout     **
****************************** -->

<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>Green Lush</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="green lush is a greeny layout with a valid XHTML 1.1 strict and CSS 2 specification" />
<meta name="keywords" content="layout, css layout, xhtml layout, css, xhtml, webstandards, free, free layout, free div layout" />
<meta name="author" content="Yamazaki" />
<link rel="stylesheet" type="text/css" href="css.css" media="screen" />
</head>

<body>
<!-- YOU SHOULD TRY TO MAKE EVERY ELEMENTS INSIDE THE CONTAINER! NOT OUTSIDE THE CONTAINER -->
<div id="container">

	<!-- HEADER -->
	<div id="header"><div class="headtitle">GREEN LUSH</div></div>
	<!-- END HEADER -->

	<!-- MENU -->
	<div id="menu">
		<ul>
			<li><a href="#" title="">HOME</a></li>
			<li><a href="#" title="">ABOUT ME</a></li>
			<li><a href="#" title="">MY WORKS</a></li>
			<li><a href="#" title="">SERVICES</a></li>
			<li><a href="#" title="">DOWNLOAD</a></li>
			<li><a href="#" title="">CONTACT ME</a></li>
			<li><a href="#" title="">QUICK MESSAGE</a></li>
			<li><a href="#" title="">LINKS</a></li>
		</ul>
	</div>
	<!-- END MENU -->
	
	<!-- ROUNDED SHAPE BELOW HEADER -->
	<div id="roundedheader">&nbsp;</div>
	
	<!-- START CONTENT -->
	<div id="content">
	
		<!-- LEFT DIV -->
		<div id="insidecontent">
			
			
			<h3>NEWs</h3>
			
			<?php

require_once("classes/news_data_class.php");

$ns = new news_data_class();

$arr=$ns->selectAll();

?>

<table border=2 width="100%">
<tr><th>title</th><th>des</th><th>view</th></tr>

<?php

for ($i=0;$i<sizeof($arr);$i++)
{
	
	echo "<tr>";
			
			echo "<td>".$arr[$i][1]."</td>";
			echo "<td>".$arr[$i][2]."</td>";
			echo "<td><a href='view_news.php?new_id=".$arr[$i][0]."'>view</a></td>";
			
			echo "</tr>";
			
			
	
}


?>

</table>
			
		</div>
		<!-- END LEFT DIV -->
		
		<!-- SIDEBAR -->
		<div id="sidebar">
			
			<h1>download</h1>
			<h2>download</h2>
			
			<h3>Download Green Lush</h3>
			<p><a href="#example" title="download green lush">example link</a>
			<br />
			Broken link? Corrupted zip file? Send an email to <a href="#">angga_fuyuki@hotmail.com</a>
			</p>
		
		</div>
		<!-- END SIDEBAR -->
		
		<!-- 
		CLEAR BOTH FLOAT. THIS IS IMPORTANT! IF YOU
		REMOVE THIS LINE, YOU'LL END UP SCREWING THE 
		CONTENT AND THE SIDEBAR COLUMN
		-->
		<div style="clear: both;"></div>
		<!-- END FLOAT CLEANER -->
		
	</div>
	<!-- END CONTENT -->
	
	<!-- ROUNDED SHAPE ABOVE FOOTER -->
	<div id="roundedfooter">&nbsp;</div>
	
	<!-- FOOTER -->
	<div id="footer">
		<span>XHTML 1.1 STRICT | CSS 2 | LAYOUT &copy; YAMAZAKI</span>
	</div>
	<!--END FOOTER -->
	
</div>
</body>
</html>