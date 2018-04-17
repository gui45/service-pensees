<?php 

	include "../../accesseur/PenseeDAO.php";
	$penseeDAO = new PenseeDAO();
	//print_r($penseeDAO);
	
	//filter_var_array - $_POST - FILTER_SANITIZE_STRING
	
	$pensee = new stdClass();
	$pensee->auteur = $_POST['auteur'];
	$pensee->message = $_POST['message'];
	$pensee->annee = $_POST['annee'];
	
	$penseeDAO->ajouterPensee($pensee);
?><?php 

header("Content-type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<action>
	<type>ajouter</type>
	<moment><?=time()?></moment>
	<succes>1</succes>
	<message>POST : <?php print_r($_POST);  ?></message>
</action>