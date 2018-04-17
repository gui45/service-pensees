<?php
	include_once "basededonnees.php";
	class PenseeDAO
	{
		function listerPensees()
		{			
			$LISTER_PENSEES = "SELECT * FROM pensee";
			global $basededonnees;
			$requeteListerPensees = $basededonnees->prepare($LISTER_PENSEES);
			$requeteListerPensees->execute();
			return $requeteListerPensees->fetchAll(PDO::FETCH_OBJ);
		}
		
		function ajouterPensee($pensee)
		{
			
		}
	}
?>