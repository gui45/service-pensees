<?php 

	include "../../accesseur/PenseeDAO.php";
	$penseeDAO = new PenseeDAO();
	print_r($penseeDAO);
	$listePensees = $penseeDAO->listerPensees();
	print_r($listePensees);
?>