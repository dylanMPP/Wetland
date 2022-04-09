package ui;

/*
	* DESCRIPTION:
	* The program is an informatic solution that affords the user to save the information for wetlands in Cali, with 
	* its respective information such as species that lives there and the events that have been realized there. 
	*/

import java.util.Scanner;
import model.WetlandController;

public class WetlandManager {

	public static Scanner reader;
	public static WetlandController controller; // I create the global variables

	public static void main(String [] args){
		
		init();
		showMainMenu();
	} // main

	public static void init(){ // Initialize method

		reader = new Scanner(System.in); // I initialize the reader and the controller.
		controller = new WetlandController();
	} // initialize

	/**
	 * Description: Shows the main menu.
	 * pre: Does not apply
	 * pos: Does not apply
	 * @return Does not apply
	*/
	public static void showMainMenu(){

		System.out.println("\n\n- - - WELCOME TO THE WETLAND PROGRAM! - - -");
		
		boolean runFlag = true;

		while (runFlag) {

			System.out.println("\n"+"\n------------------------------------\n                MENU\n\nWhat do you want to do? \n\n1) Administrate the wetlands. \n2) See information of the wetlands. \n0) Exit.\n------------------------------------");
			int decision = reader.nextInt(); // I ask the user what he/she wants to do.

			switch (decision){

				case 1:
					administrateWetlands();
				break;

				case 2:
					seeInformationOfWetlands();
				break;

				case 0:
					System.out.println("Thank you for using our system! Have a good one.");
					runFlag = false;
				break;

				default:
					System.out.println("\nPlease, type a valid option.\n");
				break;
			} // switch
		} // while

	} // show the main menu


	/**
	 * Description: Shows the administrate wetlands menu.
	 * pre: Does not apply
	 * pos: Does not apply
	 * @return Does not apply
	*/
	public static void administrateWetlands(){

		boolean runFlag = true;

		while(runFlag) {
		
			System.out.println("\n\n------------------------------------\n      ADMINISTRATE WETLANDS\n\nI'm going to...\n\n1) Register a wetland. \n2) Register a species in a wetland. \n3) Register an event in a wetland. \n0) Get back. \n------------------------------------");
			int decision2 = reader.nextInt();

			switch (decision2){

			case 1:
				registerWetland();
			break;

			case 2:
				registerSpeciesInWetland();
			break;

			case 3:
				registerEventsInWetland();
			break;

			case 0:
				runFlag = false;
			break;

			default:
				System.out.println("\nPlease, type a valid option.\n");
			break;
			} // switch
		} // while

	} // administrate wetlands menu


	/**
	 * Description: Shows the see information of wetlands menu.
	 * pre: Does not apply
	 * pos: Does not apply
	 * @return Does not apply
	*/
	public static void seeInformationOfWetlands(){

		boolean runFlag = true;

		while(runFlag) {
		
			System.out.println("\n\n--------------------------------------------------------------\n                 SEE WETLANDS INFORMATION\n\nI would like to...\n\n1) See the amount of maintenances in a year in each wetland. \n2) See all the information of each wetland. \n3) Know in wich wetlands is a species. \n4) Know the wetland with less flora species.  \n5) Know the wetland with most fauna species. \n0) Get back.\n--------------------------------------------------------------");
			int decision2 = reader.nextInt();

			switch (decision2){

			case 1:
				amountOfMaintenancesOfAllWetlandsInAYear();
			break;

			case 2:
				showWetlandsInfo();
			break;

			case 3:
				whereWetlandSpecies();
			break;

			case 4:
				wetlandLessFlora();
			break;

			case 5:
				wetlandMostFauna();
			break;

			case 0:
				runFlag = false;
			break;

			default:
				System.out.println("\nPlease, type a valid option.\n");
			break;
			} // switch
		} // while
		
	} // see information of wetlands menu


	/**
	 * Description: Asks the user the necessary information to create a wetland. Calls the 'registerWetland' method of the controller.
	 * pre: The user in the main menu chose the action of register a wetland.
	 * pos: Shows a success message.
	 * @return Does not apply
	*/
	public static void registerWetland(){

		String villageName = "";
		String neighborhoodName = "";

		System.out.println("\nType the name of the wetland.");
		String name = reader.nextLine();
		name = reader.nextLine();
		System.out.println("\nType its ubication: \n1) Urban. \n2) Rural.");
		int ubicationZone = reader.nextInt();

		if (ubicationZone==1){
			System.out.println("\nWhat is the neighborhood name?");
			neighborhoodName = reader.nextLine();
			neighborhoodName = reader.nextLine();
			villageName = "";
		
		} else {
			System.out.println("\nWhat is the village name?");
			villageName = reader.nextLine();
			villageName = reader.nextLine();
			neighborhoodName = "";
		} // else

		System.out.println("\nWhich is its type? \n1) Private. \n2) Public.");
		int type = reader.nextInt();
		System.out.println("\nType its number of KM^2.");
		double numberKm2 = reader.nextDouble();
		System.out.println("\nType the URL of its pic.");
		String urlPic = reader.next();
		System.out.println("\nThe wetland is protected? \n1) Yes. \n0) No.");
		int isProtected = reader.nextInt();
		System.out.println("\nType the percentage (without %) of its environment management plan. (If it hasn't, type 0)");
		double environmentManagementPlan = reader.nextDouble();

		if (controller.registerWetland(name, ubicationZone, type, numberKm2, urlPic, isProtected, villageName, neighborhoodName, environmentManagementPlan)) {
			System.out.println("\n   ║ The " +name.toUpperCase()+ " wetland has been registered succesfully. ║");
		} else {
			System.out.println("\n   ║ The " +name.toUpperCase()+ " wetland failed to get registered. ║");
		} // if

	} // register wetland


	/**
	 * Description: Asks the user the necessary information to register a species in a wetland. Calls the 'showWetlands' and 'registerSpeciesInWetland' methods of the controller.
	 * pre: The user in the main menu chose the action of register a species in a wetland.
	 * pos: Shows a success message.
	 * @return Does not apply
	*/
	public static void registerSpeciesInWetland(){

		int type = 0;

		if (controller.showWetlands() != ""){
			System.out.println("\nIn wich wetland do you want to add a species?");
			System.out.println(controller.showWetlands());
			int wichWetland = reader.nextInt();
			System.out.println("\nType the name of the species.");
			String name = reader.nextLine();
			name = reader.nextLine();
			System.out.println("\nType its scientific name.");
			String scientificName = reader.nextLine();
			scientificName = reader.nextLine();
			System.out.println("\nIt's a migratory species? \n1) Yes. \n0) No.");
			int isMigratory = reader.nextInt();
			System.out.println("\nIt's a flora or fauna one? \n1) Flora. \n2) Fauna.");
			int floraOrFauna = reader.nextInt();

			if (floraOrFauna==1){

				System.out.println("\nWhich is its type? \n1) Land flora. \n2) Aquatic flora.");
				type = reader.nextInt();
			} else {

				System.out.println("\nWhich is its type? \n3) Bird. \n4) Mammal. \n5) Aquatic.");
				type = reader.nextInt();
			} // if
		

			if (controller.registerSpeciesInWetland(wichWetland, name, scientificName, isMigratory, floraOrFauna, type)){

				System.out.println("\n   ║ The species " +name.toUpperCase()+ " has been registered succesfully. ║");
			} else {

				System.out.println("\n   ║ The species " +name.toUpperCase()+ " failed to get registered. ║");
			}  // if

		} else {
			System.out.println("\n║ There are not wetlands registered. ║");
		} // if
	} // register species


	/**
	 * Description: Asks the user the necessary information to register an event in a wetland. Calls the 'showWetlandsInfo', 'showWetlands' and 'registerEventInWetland' methods of the controller.
	 * pre: The user in the main menu chose the action of register an event in a wetland.
	 * pos: Shows a success message.
	 * @return Does not apply
	*/
	public static void registerEventsInWetland(){

		if (controller.showWetlandsInfo() != ""){

			System.out.println("\nIn wich wetland do you want to add an event?");
			System.out.println(controller.showWetlands());
			int wichWetland = reader.nextInt();
			System.out.println("\nType the name of the owner of the event.");
			String owner = reader.nextLine();
			owner = reader.nextLine();
			System.out.println("\nType the cost of the event.");
			double cost = reader.nextDouble();
			System.out.println("\nType its description.");
			String description = reader.nextLine();
			description = reader.nextLine();
			System.out.println("\nIn wich day it was done?");
			int day = reader.nextInt();
			System.out.println("\nIn wich month it was done?");
			int month = reader.nextInt();
			System.out.println("\nIn wich year it was done?");
			int year = reader.nextInt();
			System.out.println("\nWhich is the type of the event? \n1) Maintenance. \n2) School visit. \n3) Improvement activity. \n4) Celebrations.");
			int type = reader.nextInt();

			if (controller.registerEventInWetland(wichWetland, owner, cost, description, day, month, year, type)){

				System.out.println("\n   ║ The event made by " +owner.toUpperCase()+ " has been registered succesfully. ║");
			} else {

				System.out.println("\n   ║ The event made by " +owner.toUpperCase()+ " failed to get registered. ║");
			} // if

		} else {
			System.out.println("\n   ║ There are not wetlands registered. ║");
		} // if
	} // register events


	/**
	 * Description: Shows the user the amount of maintenances of each wetland in a specific year, given by him/her. Calls the 'amountOfMaintenancesOfAllWetlandsInAYear' method of the controller.
	 * pre: The user in the main menu chose the action of see the amount of maintenances in a year for each wetland.
	 * pos: Shows the information message.
	 * @return Does not apply
	*/
	public static void amountOfMaintenancesOfAllWetlandsInAYear(){

		System.out.println("\nIn wich year do you want to consult the number of the maintenances of all the wetlands?");
		int search = reader.nextInt();

		if (controller.amountOfMaintenancesOfAllWetlandsInAYear(search) != ""){
			System.out.println("\nIn the " +search+ " year:");
			System.out.println(controller.amountOfMaintenancesOfAllWetlandsInAYear(search));
		} else {
			System.out.println("\n   ║ There are no maintenances in that year in any wetland. ║");
		} // if
	} // amount of maintenances


	/**
	 * Description: Shows the user the information of each registered wetland. Calls the 'showWetlandsInfo' method of the controller.
	 * pre: The user in the main menu chose the action of see the information of each wetland.
	 * pos: Shows the information message.
	 * @return Does not apply
	*/
	public static void showWetlandsInfo(){

		if (controller.showWetlandsInfo() != ""){
			
			System.out.println("\nThese are the currently registered wetlands:");
			System.out.println(controller.showWetlandsInfo());
		} else {

			System.out.println("\n   ║ There are not wetlands registered. ║");
		} // if
		
	} // show wetlands info


	/**
	 * Description: Shows the user in wich wetlands a species, given by him/her, is present. Calls the 'whereWetlandsSpecies' method of the controller.
	 * pre: The user in the main menu chose the action of see in wich wetlands a species is present.
	 * pos: Shows the information message.
	 * @return Does not apply
	*/
	public static void whereWetlandSpecies(){
		System.out.println("\nWich species do you want to search in the wetlands? \n1) Land flora. \n2) Aquatic flora. \n3) Bird. \n4) Mammal. \n5) Aquatic.");
		int search = reader.nextInt(); // I ask the user what species he/she wants to search

		if (controller.whereWetlandSpecies(search)!=""){ // call the where wetland species method from the controller, if the msg is void, there are
			// no wetlands with that species

			System.out.println("\nThat species is in the next wetlands: "+controller.whereWetlandSpecies(search) );
		} else {
			System.out.println("\n   ║ There are not wetlands with that species registered. ║");
		} // if

	} // where wetland


	/**
	 * Description: Shows the user wich wetland has the least amount of flora species. Calls the 'wetlandLessFlora' method of the controller.
	 * pre: The user in the main menu chose the action of see wich wetland has the least amount of flora species.
	 * pos: Shows the information message.
	 * @return Does not apply
	*/
	public static void wetlandLessFlora(){

		// I made a validation.
		if (controller.wetlandLessFlora() != ""){
			System.out.println("\nThe wetland with the least flora is "+controller.wetlandLessFlora());
		} else {
			System.out.println("\n   ║ There are not any wetlands with the least fauna. ║");
		}
	} // wetlands less flora


	/**
	 * Description: Shows the user wich wetland has the most amount of fauna species. Calls the 'wetlandMostFauna' method of the controller.
	 * pre: The user in the main menu chose the action of see wich wetland has the most amount of fauna species.
	 * pos: Shows the information message.
	 * @return Does not apply
	*/
	public static void wetlandMostFauna(){

		// I made a validation.
		if (controller.wetlandMostFauna()!= ""){
			System.out.println("\nThe wetland with the most fauna is "+controller.wetlandMostFauna());
		} else {
			System.out.println("\n   ║ There are not any wetlands with the most fauna. ║");
		}
		
	} // wetlands most fauna

} // class