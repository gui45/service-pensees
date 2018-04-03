<?php 

	include "../../accesseur/PenseeDAO.php";
	$penseeDAO = new PenseeDAO();
	//print_r($penseeDAO);
	$listePensees = $penseeDAO->listerPensees();
	//print_r($listePensees);
?><?php 

header("Content-type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<pensees>
<?php
foreach($listePensees as $pensee)
{
	//print_r($pensee);
	?>
	<pensee>
		<auteur><?=utf8_encode($pensee->auteur)?></auteur>
		<message><?=utf8_encode($pensee->message)?></message>
		<annee><?=$pensee->annee?></annee>
		<id><?=$pensee->idPensee?></id>
	</pensee>
	<?php	
}
?>
</pensees>