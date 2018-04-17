<?php
	include_once "basededonnees.php";
	class PenseeDAO
	{
		function listerPensees()
		{			
			$SQL_LISTER_PENSEES = "SELECT * FROM pensee";
			global $basededonnees;
			$requeteListerPensees = $basededonnees->prepare($SQL_LISTER_PENSEES);
			$requeteListerPensees->execute();
			return $requeteListerPensees->fetchAll(PDO::FETCH_OBJ);
		}
		
		function ajouterPensee($pensee)
		{
			echo "ajouterPensee()";
			print_r($pensee);
			
			$SQL_AJOUTER_PENSEE = "INSERT into pensee(auteur, message, annee) VALUES('$pensee->auteur','$pensee->message','$pensee->annee')";
			
			echo $SQL_AJOUTER_PENSEE;
			global $basededonnees;
			print_r($basededonnees);
			
			$requeteAjouterPensee = $basededonnees->prepare($SQL_AJOUTER_PENSEE);
			$reussite = $requeteAjouterPensee->execute();
			
			echo "Code erreur : " . $basededonnees->errorCode();
			echo "Erreurs : ";
			print_r($basededonnees->errorInfo());
			return $reussite;
		}
	}
?>