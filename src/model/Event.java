package model;

public class Event {

	private String owner;
	private double cost;
	private String description;
	private Date date;
	private EventType type;

	public Event(String owner, double cost, String description, int day, int month, int year, int type) {

		this.owner = owner;
		this.cost = cost;
		this.description = description;
		this.date = new Date(day, month, year);


		switch(type){
		case 1:
			this.type = EventType.MAINTENANCE;
			break;

		case 2:
			this.type = EventType.SCHOOL_VISIT;
			break;

		case 3:
			this.type = EventType.IMPROVEMENT_ACTIVITY;
			break;

		case 4:
			this.type = EventType.CELEBRATION;
			break;
		} // switch type

	} // event constructor

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getCost() {
		return cost;
	}

	public void cost(double cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYearEvent(){
		return date.getYear();
	}

	public EventType getType(){
		return type;
	}

	public void setType(int type){

		switch(type){
		case 1:
			this.type = EventType.MAINTENANCE;
			break;

		case 2:
			this.type = EventType.SCHOOL_VISIT;
			break;

		case 3:
			this.type = EventType.IMPROVEMENT_ACTIVITY;
			break;

		case 4:
			this.type = EventType.CELEBRATION;
			break;
		} // switch type
	}

	@Override
	public String toString() {
		return "\n    Event made by " +owner.toUpperCase()+ " is a " +type+ " one.";
	}

}
