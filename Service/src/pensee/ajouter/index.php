<?php 
	print_r($_POST);
	
	include "../../accesseur/PenseeDAO.php";
	$penseeDAO = new PenseeDAO();
	//print_r($penseeDAO);
	
	//filter_var_array - $_POST - FILTER_SANITIZE_STRING
	
	$penseeTableau = $_POST;
	$pensee = new stdClass();
	$pensee->auteur = $penseeTableau['auteur'];
	$pensee->message = $penseeTableau['message'];
	$pensee->annee = $penseeTableau['annee'];
	
	$succes = $penseeDAO->ajouterPensee($pensee);
?><?php 

//header("Content-type: text/xml");
//echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<action>
	<type>ajouter</type>
	<moment><?=time()?></moment>
	<succes><?=$succes?></succes>
	<message></message>
</action>