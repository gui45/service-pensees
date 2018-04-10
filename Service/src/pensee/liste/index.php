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
	<nombre><?=count($listePensees)?></nombre>
<?php
//utf8_encode()
foreach($listePensees as $pensee)
{
	//print_r($pensee);
	?>
	<pensee>
		<auteur><?=($pensee->auteur)?></auteur>
		<message><?=($pensee->message)?></message>
		<annee><?=$pensee->annee?></annee>
		<id><?=$pensee->idPensee?></id>
	</pensee>
	<?php
}
?>
</pensees>