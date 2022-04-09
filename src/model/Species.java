package model;

public class Species {

	private String name;
	private String scientificName;
	private int isMigratory;
	private FaunaOrFlora faunaOrFlora;
	private SpeciesType type;

	public Species(String name, String scientificName, int isMigratory, int faunaOrFlora, int type) {

		this.name = name;
		this.scientificName = scientificName;
		this.isMigratory = isMigratory;

		switch(faunaOrFlora){
		case 1:
			this.faunaOrFlora = FaunaOrFlora.FLORA;
			break;

		case 2:
			this.faunaOrFlora = FaunaOrFlora.FAUNA;
		} // switch fauna or flora


		switch(type){
		case 1:
			this.type = SpeciesType.LAND_FLORA;
			break;

		case 2:
			this.type = SpeciesType.AQUATIC_FLORA;
			break;

		case 3:
			this.type = SpeciesType.BIRD;
			break;

		case 4:
			this.type = SpeciesType.MAMMAL;
			break;

		case 5:
			this.type = SpeciesType.AQUATIC;
			break;
		} // switch type

	} // species constructor

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public int getIsMigratory() {
		return isMigratory;
	}

	public void setIsMigratory(int isMigratory) {
		this.isMigratory = isMigratory;
	}

	public FaunaOrFlora getFaunaOrFlora(){
		return faunaOrFlora;
	}

	public void setFaunaOrFlora(int faunaOrFlora){

		switch(faunaOrFlora){
		case 1:
			this.faunaOrFlora = FaunaOrFlora.FLORA;
			break;

		case 2:
			this.faunaOrFlora = FaunaOrFlora.FAUNA;
		} // switch fauna or flora
	}

	public SpeciesType getType(){
		return type;
	}

	public void setType(int type){

		switch(type){
		case 1:
			this.type = SpeciesType.LAND_FLORA;
			break;

		case 2:
			this.type = SpeciesType.AQUATIC_FLORA;
			break;

		case 3:
			this.type = SpeciesType.BIRD;
			break;

		case 4:
			this.type = SpeciesType.MAMMAL;
			break;

		case 5:
			this.type = SpeciesType.AQUATIC;
			break;
		} // switch type
	}

	@Override
	public String toString() {

		return "This wetland has species " +name.toUpperCase()+ " is a " +faunaOrFlora+ " one and its type is " +type+ ".";
	}

}
