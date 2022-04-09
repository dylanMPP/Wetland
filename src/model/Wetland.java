package model;

public class Wetland {

	private int id;
	private String name;
	private UbicationZone ubicationZone;
	private WetlandType type;
	private double numberKm2;
	private String urlPic;
	private int isProtected;
	private String villageName;
	private String neighborhoodName;
	private double environmentManagementPlan;
	private Species [] species;
	private Event [] events;

	public Wetland(String name, int ubicationZone, int type, double numberKm2, String urlPic, int isProtected, String villageName, String neighborhoodName, double environmentManagementPlan) {

		this.id = 0;
		this.name = name;

		switch(ubicationZone){
		case 1:
			this.ubicationZone = UbicationZone.URBAN;
			break;

		case 2:
			this.ubicationZone = UbicationZone.RURAL;
		} // switch zone


		switch(type){
		case 1:
			this.type = WetlandType.PRIVATE;
			break;

		case 2:
			this.type = WetlandType.PUBLIC;
		} // switch type

		this.numberKm2 = numberKm2;
		this.urlPic = urlPic;
		this.isProtected = isProtected;
		this.villageName = villageName;
		this.neighborhoodName = neighborhoodName;
		this.environmentManagementPlan = environmentManagementPlan;

		species = new Species[50];
		events = new Event[50];

	} // wetland constructor

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UbicationZone getUbicationZone(){
		return ubicationZone;
	}

	public void setUbicationZone(int ubicationZone){

		switch(ubicationZone){
		case 1:
			this.ubicationZone = UbicationZone.URBAN;
			break;

		case 2:
			this.ubicationZone = UbicationZone.RURAL;
			break;
		} // switch zone
	}

	public WetlandType type(){
		return type;
	}

	public void setType(int type){

		switch(type){
		case 1:
			this.type = WetlandType.PRIVATE;
			break;

		case 2:
			this.type = WetlandType.PUBLIC;
		} // switch type
	}

	public double numberKm2(){
		return numberKm2;
	}

	public void numberKm2(double numberKm2){
		this.numberKm2 = numberKm2;
	}

	public String urlPic(){
		return urlPic;
	}

	public void setUrlPic(String urlPic){
		this.urlPic = urlPic;
	}


	public Species[] getSpecies() {
		return species;
	}

	public void setSpecies(Species[] species) {
		this.species = species;
	}


	/**
	 * Description: Creates a new 'Species' object and saves it in the species array of the wetland.
	 * pre: The user entered all the species attributes correctly.
	 * pos: The stopFlag variable changes to true or stay in false.
	 * @param name String.
	 * @param scientificName String.
	 * @param isMigratory int It has to be a valid option (0 or 1).
	 * @param faunaOrFlora int It has to be a valid option (1 or 2).
	 * @param type int It has to be a valid option (1, 2, 3, 4 or 5).
	 * @return stopFlag boolean If it it's true, then the process was correct, if it's false, the process was incorrect.
	*/
	public boolean registerSpecies(String name, String scientificName, int isMigratory, int faunaOrFlora, int type){

		boolean stopFlag = false;

		Species newSpecies = new Species(name, scientificName, isMigratory, faunaOrFlora, type);

		for (int i = 0; i<species.length && !stopFlag; i++){

			if (species[i] == null){

				species[i] = newSpecies; // I add the species in the species array (that array is in a wetland)
				stopFlag = true;
			} // if
		} // for

		return stopFlag;
	} // register species (create and save)


	/**
	 * Description: Creates a new 'Event' object and saves it in the events array of the wetland.
	 * pre: The user entered all the event attributes correctly.
	 * pos: The stopFlag variable changes to true or stay in false.
	 * @param owner String.
	 * @param cost double It has to be a valid double number.
	 * @param description String.
	 * @param day int It has to be a valid integer number.
	 * @param month int It has to be a valid integer number.
	 * @param year int It has to be a valid integer number.
	 * @param type int It has to be a valid option (1, 2, 3 or 4).
	 * @return stopFlag boolean If it it's true, then the process was correct, if it's false, the process was incorrect.
	*/
	public boolean registerEvent(String owner, double cost, String description, int day, int month, int year, int type){

		boolean stopFlag = false;

		Event newEvent = new Event(owner, cost, description, day, month, year, type);

		for (int i = 0; i<events.length && !stopFlag; i++){

			if (events[i] == null){

				events[i] = newEvent; // I add the event in the event array (that array is in a wetland)
				stopFlag = true;
			} // if
		} // for

		return stopFlag;
	} // register event (create and save)


	/**
	 * Description: Calculate the total amount of maintenances in a year for each wetland. Calls the 'getType' and 'getYearEvent' methods of the 'Event' class.
	 * pre: The user entered correctly the year.
	 * pos: The variable changes to the amount of maintenances for a wetland, stays in 0 if it hasn't.
	 * @param search int It has to be a valid integer number (year).
	 * @return totalMaintenancesInYear int Has the amount of maintenances for a wetland in a year.
	*/
	public int calculateAmountOfMaintenancesInAYear(int search) {
		
		int totalMaintenancesInYear = 0;

		for (int i = 0; i<species.length; i++){ // I calculate the total maintenances in a year for a wetland

			if (events[i]!=null){

				if (events[i].getType().equals(EventType.MAINTENANCE) && events[i].getYearEvent()==search){ // I enter in the events array
					// and if in each position its type is equals to MAINTENANCE and its year is equals to the year entered by the user, I count it

					totalMaintenancesInYear++;
				} // if
			} // if
		} // for

		return totalMaintenancesInYear;
	} // total maintenances


	/**
	 * Description: Calculate the total amount of fauna species in a wetland. Calls the 'getFaunaOrFlora' method of the 'Species' class.
	 * pre: The user chose the action of see the information of each wetland, see the wetland with the mosth fauna species or see in wich wetland is a species present.
	 * pos: The variable changes to the total amount of fauna species, it stays in 0 if the wetland hasn't.
	 * @return totalFauna int Has the total amount of fauna species in a wetland.
	*/
	public int calculateTotalFauna() { // I calculate the total fauna of the wetland
		
		int totalFauna = 0;

		for (int i = 0; i<species.length; i++){

			if (species[i]!=null){

				if (species[i].getFaunaOrFlora().equals(FaunaOrFlora.FAUNA)){ // I enter in the species array and I compare each species object
					// seeing if it is fauna, if it is, I add 1 unit to the total fauna acumulated.

					totalFauna++;
				} // if
			} // if
		} // for

		return totalFauna;
	} // total flora


	/**
	 * Description: Calculate the total amount of flora species in a wetland. Calls the 'getFaunaOrFlora' method of the 'Species' class.
	 * pre: The user chose the action of see the information of each wetland, see the wetland with the least flora species or see in wich wetland is a species present.
	 * pos: The variable changes to the total amount of flora species, it stays in 0 if the wetland hasn't.
	 * @return totalFlora int Has the total amount of flora species in a wetland.
	*/
	public int calculateTotalFlora() {
		
		int totalFlora = 0;

		for (int i = 0; i<species.length; i++){ // I calculate the total flora of the wetland

			if (species[i]!=null){

				if (species[i].getFaunaOrFlora().equals(FaunaOrFlora.FLORA)){ // I enter in the species array and I compare each species object
					// seeing if it is flora, if it is, I add 1 unit to the total flora acumulated.

					totalFlora++;
				} // if
			} // if
		} // for

		return totalFlora;
	} // total flora


	/**
	 * Description: Calculate the total amount of land flora species in a wetland. Calls the 'getType' method of the 'Species' class.
	 * pre: The user chose the action of see the information of each wetland or see in wich wetland is a species present.
	 * pos: The variable changes to the total amount of land flora species, it stays in 0 if the wetland hasn't.
	 * @return totalLandFlora int Has the total amount of land flora species in a wetland.
	*/
	public int totalLandFlora() {
		
		int totalLandFlora = 0;

		for (int i = 0; i<species.length; i++){ // I calculate the total land flora of the wetland

			if (species[i]!=null){

				if (species[i].getType().equals(SpeciesType.LAND_FLORA)){ // I enter in the species array and I compare each species object
					// seeing if it is land flora, if it is, I add 1 unit to the total flora acumulated.

					totalLandFlora++;
				} // if
			} // if
		} // for

		return totalLandFlora;
	} // total land flora


	/**
	 * Description: Calculate the total amount of aquatic flora species in a wetland. Calls the 'getType' method of the 'Species' class.
	 * pre: The user chose the action of see the information of each wetland or see in wich wetland is a species present.
	 * pos: The variable changes to the total amount of aquatic flora species, it stays in 0 if the wetland hasn't.
	 * @return totalAquaticFlora int Has the total amount of aquatic flora species in a wetland.
	*/
	public int totalAquaticFlora() {
		
		int totalAquaticFlora = 0;

		for (int i = 0; i<species.length; i++){ // I calculate the total aquatic flora of the wetland

			if (species[i]!=null){

				if (species[i].getType().equals(SpeciesType.AQUATIC_FLORA)){ // I enter in the species array and I compare each species object
					// seeing if it is an aquatic flora, if it is, I add 1 unit to the total flora acumulated.

					totalAquaticFlora++;
				} // if
			} // if
		} // for

		return totalAquaticFlora;
	} // total aquatic flora


	/**
	 * Description: Calculate the total amount of bird species in a wetland. Calls the 'getType' method of the 'Species' class.
	 * pre: The user chose the action of see the information of each wetland or see in wich wetland is a species present.
	 * pos: The variable changes to the total amount of bird species, it stays in 0 if the wetland hasn't.
	 * @return totalBirdFlora int Has the total amount of bird species in a wetland.
	*/
	public int totalBirds() {
		
		int totalBirds = 0;

		for (int i = 0; i<species.length; i++){ // I calculate the total birds of the wetland

			if (species[i]!=null){

				if (species[i].getType().equals(SpeciesType.BIRD)){ // I enter in the species array and I compare each species object
					// seeing if it is a BIRD , if it is, I add 1 unit to the total birds acumulated.

					totalBirds++;
				} // if
			} // if
		} // for

		return totalBirds;
	} // total birds


	/**
	 * Description: Calculate the total amount of mammal species in a wetland. Calls the 'getType' method of the 'Species' class.
	 * pre: The user chose the action of see the information of each wetland or see in wich wetland is a species present.
	 * pos: The variable changes to the total amount of mammal species, it stays in 0 if the wetland hasn't.
	 * @return totalMammalFlora int Has the total amount of mammal species in a wetland.
	*/
	public int totalMammal() {
		
		int totalMammal = 0;

		for (int i = 0; i<species.length; i++){ // I calculate the total mammal of the wetland

			if (species[i]!=null){

				if (species[i].getType().equals(SpeciesType.MAMMAL)){ // I enter in the species array and I compare each species object
					// seeing if it is a mammal , if it is, I add 1 unit to the total mammal acumulated.

					totalMammal++;
				} // if
			} // if
		} // for

		return totalMammal;
	} // total mammal


	/**
	 * Description: Calculate the total amount of aquatic species in a wetland. Calls the 'getType' method of the 'Species' class.
	 * pre: The user chose the action of see the information of each wetland or see in wich wetland is a species present.
	 * pos: The variable changes to the total amount of aquatic species, it stays in 0 if the wetland hasn't.
	 * @return totalAquaticFlora int Has the total amount of aquatic species in a wetland.
	*/
	public int totalAquatic() {
		
		int totalAquatic = 0;

		for (int i = 0; i<species.length; i++){ // I calculate the total Aquatic of the wetland

			if (species[i]!=null){

				if (species[i].getType().equals(SpeciesType.AQUATIC)){ // I enter in the species array and I compare each species object
					// seeing if it is a mAquatic , if it is, I add 1 unit to the total Aquatic acumulated.

					totalAquatic++;
				} // if
			} // if
		} // for

		return totalAquatic;
	} // total Aquatic


	@Override
	public String toString() {
		
		int isVoid = 0;
		int isVoid2 = 0;
		String msg = "";
		String speciesMsg = "";
		String eventsMsg = "";
		msg += "Wetland named " +name+ " is " +ubicationZone+ ", ubicated in " +villageName+neighborhoodName+ ", is " +type+ ", has an area of " +numberKm2+ " KM^2 and has an environment management plan of %"+environmentManagementPlan;

		for (int i = 0; i <species.length; i++){

			if (species[i] != null){

				speciesMsg = "\n\n    Amount of LAND FLORA: "+totalLandFlora()+"\n    Amount of AQUATIC FLORA: "+totalAquaticFlora()+"\n    Amount of BIRDS: "+totalBirds()+"\n    Amount of MAMMALS: "+totalMammal()+"\n    Amount of AQUATIC FAUNA: "+totalAquatic();
				isVoid = 1;
			} else {

				if (isVoid!=1){
					speciesMsg = "\n\n    Amount of LAND FLORA: 0\n    Amount of AQUATIC FLORA: 0\n    Amount of BIRDS: 0\n    Amount of MAMMALS: 0\n    Amount of AQUATIC FAUNA: 0";
				} // if
			} // if
		} // for
		

		for (int i = 0; i <events.length; i++){

			if (events[i] != null){
				eventsMsg = "\n\n    These are the currently Events:"+events[i].toString();
				isVoid2 = 1;
			}  else {

				if (isVoid2!=1){
					eventsMsg = "\n\n    There are not events registered in this wetland.";
				} // if
			}// if
		} // for

		return msg+speciesMsg+eventsMsg+"\n";
	}

}
