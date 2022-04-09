package model;

public class WetlandController {

	private Wetland [] wetlands; // Create the wetlands array

	public WetlandController(){

		wetlands = new Wetland[80];
	} // constructor

	/**
	 * Description: Creates a new 'Wetland' object and saves it in the wetlands array. Sets for each one an unique ID calling the 'setId' method of the 'Wetland' class.
	 * pre: The user entered all the wetland attributes correctly.
	 * pos: Creates a new 'Wetland' object and saves it in the wetlands array.
	 * @param name String.
	 * @param ubicationZone int It has to be a valid option of the ubication zone (1 or 2).
	 * @param type int It has to be a valid option of type (1 or 2).
	 * @param numberKm2 double It has to be a valid double number.
	 * @param urlPic String.
	 * @param isProtected int It has to be a valid option (0 or 1).
	 * @param villageName String.
	 * @param neighborhoodName String.
	 * @param environmentManagementPlan double It has to be a valid double number.
	 * @return stopFlag boolean If it it's true, then the process was correct, if it's false, the process was incorrect.
	*/
	public boolean registerWetland(String name, int ubicationZone, int type, double numberKm2, String urlPic, int isProtected, String villageName, String neighborhoodName, double environmentManagementPlan) {

		boolean stopFlag = false; // I create the stopflag to use it in the for cycle.

		Wetland newWetland = new Wetland(name, ubicationZone, type, numberKm2, urlPic, isProtected, villageName, neighborhoodName, environmentManagementPlan); // I create the object first.

		for (int i = 0; i<wetlands.length && !stopFlag ; i++){

			if (wetlands[i] == null){

					newWetland.setId(i + 1); // I create an unique id for each wetland, to make easier add species.
					wetlands[i] = newWetland;
					stopFlag = true;
			
			} // if
		} // for

		return stopFlag;

	} // constructor and saving of object Wetland


	/**
	 * Description: Creates the message that has the information of each registered wetland. Calls the 'getId' and 'toString' methods of the 'Wetland' class.
	 * pre: The user chose the action of see the wetlands information.
	 * pos: Creates the message that has all the wetlands information.
	 * @return msg String Has all the wetlands information.
	*/
	public String showWetlandsInfo() {

		String msg = ""; // make a msg to show the wetlands with their respective info.

		for (int i = 0; i < wetlands.length; i++) {

			if (wetlands[i] != null) {

				msg += "\n"+wetlands[i].getId()+") " + wetlands[i].toString(); // I create a message with the id and the wetland to string
				// so it gives me a lot of information specified in the toString method in wetland

			} // if
		} // for

		return msg;

	}


	/**
	 * Description: Creates the message that has the list of the registered wetlands, including its ID and name calling the 'getId' and 'getName' methods of the 'Wetland' class.
	 * pre: The user chose the action of register a species or an event in a wetland.
	 * pos: Creates the message that has the list of registered wetlands.
	 * @return msg String Has the list of wetlands.
	*/
	public String showWetlands() {

		String msg = ""; // make a msg to show the wetlands with their respective id.

		for (int i = 0; i < wetlands.length; i++) {

			if (wetlands[i] != null) {

				msg += "\n"+wetlands[i].getId()+") "+wetlands[i].getName()+"."; // I create a message with the ID and the name
				// of thw wetlands.
			}
		}

		return msg;

	}


	/**
	 * Description: Identificates in wich wetland the user wants to create a 'Species' object and saves it in the wetlands array in the respective wetland and calls the 'registerSpecies' method of the 'Wetland' class in the position of the wetland.
	 * pre: The user entered all the species attributes correctly.
	 * pos: The stopFlag variable changes to true or stay in false.
	 * @param wichWetland int It has to be an ID of a registered wetland.
	 * @param name String.
	 * @param scientificName String.
	 * @param isMigratory int It has to be a valid option (0 or 1).
	 * @param faunaOrFlora int It has to be a valid option (1 or 2).
	 * @param type int It has to be a valid option (1, 2, 3, 4 or 5).
	 * @return stopFlag boolean If it it's true, then the process was correct, if it's false, the process was incorrect.
	*/
	public boolean registerSpeciesInWetland(int wichWetland, String name, String scientificName, int isMigratory, int faunaOrFlora, int type) {

		boolean stopFlag = false;

		for (int i = 0; i < wetlands.length && !stopFlag; i++) {

			if (wetlands[i] != null) {

				if ((i + 1) == (wichWetland)) {

					stopFlag = wetlands[i].registerSpecies(name, scientificName, isMigratory, faunaOrFlora, type); // I save in the array
					// species and after that in the wetlands array (the species array)

				} // if
			} // if
		} // for
		return stopFlag;
	} // constructor and saving of object Species


	/**
	 * Description: Identificates in wich wetland the user wants to create an 'Event' object  and saves it in the wetlands array in the respective wetland and calls the 'registerEvent' method of the 'Wetland' class in the position of the wetland.
	 * pre: The user entered all the event attributes correctly.
	 * pos: The stopFlag variable changes to true or stay in false.
	 * @param wichWetland int It has to be an ID of a registered wetland.
	 * @param owner String.
	 * @param cost double It has to be a valid double number.
	 * @param description String.
	 * @param day int It has to be a valid integer number.
	 * @param month int It has to be a valid integer number.
	 * @param year int It has to be a valid integer number.
	 * @param type int It has to be a valid option (1, 2, 3 or 4).
	 * @return stopFlag boolean If it it's true, then the process was correct, if it's false, the process was incorrect.
	*/
	public boolean registerEventInWetland(int wichWetland, String owner, double cost, String description, int day, int month, int year, int type) {

		boolean stopFlag = false;

		for (int i = 0; i < wetlands.length && !stopFlag; i++) {

			if (wetlands[i] != null) {

				if ((i + 1) == (wichWetland)) {

					stopFlag = wetlands[i].registerEvent(owner, cost, description, day, month, year, type); // I save in the array
					// event and after that in the wetlands array (the events array)

				} // if
			} // if
		} // for
		return stopFlag;
	} // constructor and saving of object Event


	/**
	 * Description: Creates the message that contains the amount of maintenances in a year for each wetland. Calls the 'getName' and 'calculateAmountOfMaintenancesInAYear' methods of the 'Wetland' class.
	 * pre: The user entered correctly the year.
	 * pos: The message contains, for each wetland, the amount of maintenances in a year.
	 * @param search int It has to be a valid integer number (year).
	 * @return msg String It contains the amount of maintenances in a year for each wetland.
	*/
	public String amountOfMaintenancesOfAllWetlandsInAYear(int search){

		String msg = ""; // I enter in the wetlands array and in each wetland I run the calculate amount of maintenances in a year method,
		// if the result of that method is greater than 0, I add the name of the wetland to the message and its respective number of maintenances.

		for (int i=0; i < wetlands.length; i++){

			if(wetlands[i]!=null){

				msg += "\n    "+wetlands[i].getName()+ " has " +wetlands[i].calculateAmountOfMaintenancesInAYear(search)+ " maintenances.";
				
			} // if
		} // for

		return msg;
	} // amount of maintenances of all wetlands in an specific year


	/**
	 * Description: Creates the message that contains the name of the wetlands that has the species entered by the user. Calls the 'totalLandFlora', 'totalAquaticFlora', 'totalBirds', 'totalMammal', 'totalAquatic' and 'getName' methods of the 'Wetland' class.
	 * pre: The user entered correctly the species type.
	 * pos: The message contains the name of the wetlands that has the species type entered by the user.
	 * @param search int It has to be a valid integer number and a valid type option.
	 * @return msg String It contains the name of the wetlands that has a specific species type.
	*/
	public String whereWetlandSpecies(int search){

		String msg = "";

		for (int i = 0; i < wetlands.length; i++){

			if (wetlands[i]!=null){

			switch (search){

			case 1:
				if (wetlands[i].totalLandFlora()>0){
					msg += "\n    "+wetlands[i].getName();
					} // if
				break;

				case 2:
					if (wetlands[i].totalAquaticFlora()>0){
						msg += "\n    "+wetlands[i].getName();
					} // if
				break;

				case 3:
					if (wetlands[i].totalBirds()>0){
						msg += "\n    "+wetlands[i].getName();
					} // if
				break;

				case 4:
					if (wetlands[i].totalMammal()>0){
						msg += "\n    "+wetlands[i].getName();
					} // if
				break;

				case 5:
					if (wetlands[i].totalAquatic()>0){
						msg += "\n    "+wetlands[i].getName();
					} // if
				break;
				} // switch
			} // if
		} // for
		return msg;
	} // in where wetlands is a species.


	/**
	 * Description: Creates the message that contains the name of the wetland that has the least amount of flora species. Calls the 'calcuateTotalFlora' and 'getName' methods of the 'Wetland' class.
	 * pre: The user chose the option of see the wetland with the least amount of flora species.
	 * pos: The message contains the name of the wetland that has the least amount of flora species.
	 * @return msg String It contains the name of the wetland that has the least amount of flora species and its quantity.
	*/
	public String wetlandLessFlora(){

		String msg = "";
		int min = 1000; // I create an extremely high value, because I need the first wetland to be the min value, to comparate. 

		for (int i = 0; i < wetlands.length ; i++){

			if (wetlands[i] != null){
				if (wetlands[i].calculateTotalFlora()<min){ // call the total flora method in each wetland and compare it with the value of min.
					min = wetlands[i].calculateTotalFlora(); // if it is less, the min variable gets updated.
					msg = wetlands[i].getName()+ " with " +min+ " flora species."; // I add the message the wetland name and amount of species.
				} // if
			} // if
		} // for

		return msg;

	} // wetland with less flora


	/**
	 * Description: Creates the message that contains the name of the wetland that has the most amount of fauna species. Calls the 'calculateTotalFauna' and 'getName' methods of the 'Wetland' class.
	 * pre: The user chose the option of see the wetland with the most amount of fauna species.
	 * pos: The message contains the name of the wetland that has the most amount of fauna species.
	 * @return msg String It contains the name of the wetland that has the most amount of fauna species and its quantity.
	*/
	public String wetlandMostFauna(){

		String msg = "";
		int max = 0; // I create an extremely minimum value, because I need the first wetland to be the max value, to comparate. 

		for (int i = 0; i<wetlands.length; i++){

			if (wetlands[i] != null){
				if (wetlands[i].calculateTotalFauna()>max){
					max = wetlands[i].calculateTotalFauna();
					msg = wetlands[i].getName()+ " with " +max+ " fauna species.";
				} // if
			} // if
		} // for

		return msg;
	} // wetland with most fauna
}
