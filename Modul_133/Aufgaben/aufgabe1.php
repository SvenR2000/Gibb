<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Aufgabe 1</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	
	<?php 
	
	$wochentage = array("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag");
	
	for ($i = 0; $i < 7; $i++) {
		echo $wochentage[$i];
		echo ("<br />");
	}
	
// 	$wochentage_asso = array(Mo=>"Montag", Di=>"Dienstag", Mi=>"Mittwoch", Don=>"Donnerstag", Fr=>"Freitag", Sa=>"Samstag", So=>"Sonntag");
	
// 	for ($j = 0; $j < 7; $j++) {
// 		echo $wochentage_asso[$j];
// 		echo ("<br />");
// 	}
	
	?>
	
</body>

</html>