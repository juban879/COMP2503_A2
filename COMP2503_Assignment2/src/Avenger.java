/**
 * This is the Avenger class that represents an avenger object.
 * @author alyssalandeta starlynrivas jannubana
 *
 */
public class Avenger implements Comparable<Avenger> {
	

	private String heroName;
	private String heroAlias;
	private String performer;
	
	private int nameFreq;
	private int aliasFreq;
	private int performerFreq;
	
	public Avenger(String alias, String heroName,  String performer) {
		this.heroName = heroName;
		this.heroAlias = alias;
		this.performer = performer;
		nameFreq = 0;
		aliasFreq = 0;
		performerFreq = 0;
	}
	
	@Override
	/**
	 * overrides compareTo() method to sort avengers by ascending alias name
	 */
	public int compareTo(Avenger a) { 
		int result = this.getHeroAlias().compareTo(a.getHeroAlias());
		return result;
	}
	
	/**
	 * Getter method for getting hero name
	 * @return String heroName hero's last name
	 */
	public String getHeroName() { 
		return heroName; 
	}
	/**
	 * Setter method for setting hero name
	 * @param String heroName hero's last name
	 */
	public void setHeroName(String heroName) { 
		this.heroName = heroName; 
	}
	/**
	 * Getting method for getting hero alias name
	 * @return String heroAlias hero's alias name
	 */
	public String getHeroAlias() { 
		return heroAlias; 	
	}
	/**
	 * Setting method for setting the hero alias name
	 * @param String heroAlias hero's alias name
	 */
	public void setHeroAlias(String heroAlias) { 
		this.heroAlias = heroAlias; 
	}
	/**
	 * Getting method for getting the performer last name
	 * @return String performer performer's last name
	 */
	public String getPerformer() { 
		return performer; 
	}
	/**
	 * Setting method for setting the performer name 
	 * @param String performer avenger's actor's last name
	 */
	public void setPerformer(String performer) { 
		this.performer = performer; 
	}
	/**
	 * Getting method for getting the name frequency of the avenger
	 * @return int nameFreq last name of avenger frequency
	 */
	public int getNameFreq() { 
		return nameFreq;
	}
	
	/**
	 * Setting method for incrementing the name frequency by 1
	 */
	public void setNameFreq() {
		this.nameFreq++;
	}
	/**
	 * Getting method for getting the alias frequency of the avenger
	 * @return int aliasFreq avenger alias frequency
	 */
	public int getAliasFreq() {
		return aliasFreq; 
	}
	/**
	 * Setting method for incrementing the alias frequency by 1
	 */
	public void setAliasFreq() {
		this.aliasFreq++;
	}
	/**
	 * Getting method for getting the performer last name frequency of the avenger
	 * @return int performerFreq avenger actor last name frequency
	 */
	public int getPerformerFreq() {
		return performerFreq;
	}
	/**
	 * Setting method for incrementing the performer last name frequency by 1
	 */
	public void setPerformerFreq() {
		this.performerFreq++;
	}
	
	/**
	 * This method checks if the word is alias, hero name, or performer name, then
	 * calls the setting frquency methods that increment the counters
	 * @param word String used to check if alias, hero name, or performer name
	 * @return boolean false, if not any of the above, true if else
	 */
	public boolean addFrequency(String word) {
		if (heroAlias.equals(word))
			setAliasFreq();
		else if (heroName.equals(word))
			setNameFreq();
		else if (performer.equals(word))
			setPerformerFreq();
		else
			return false;
		return true;
	}
	/**
	 * Overridden toString method to print avenger details according to output examples
	 */
	public String toString() { return heroAlias + " aka " + heroName + " performed by " + 
								performer + " mentioned " + "(n: " + nameFreq + " + a: " + 
								aliasFreq + " + p: " + performerFreq + ") " + "time(s)"; 
	
	}
	
	/**
	 * Overridden equals method to check if the avenger alias is equal to the other alias
	 * @param Avenger a avenger object
	 * @return boolean flag, returns true if objects are the same, false if else
	 */
	@Override 
	public boolean equals(Object a) {
		boolean flag = false;
		Avenger avg = (Avenger) a;
		if(this.getHeroAlias().equals(avg.getHeroAlias())) {
			flag = true;
		}
		
		return flag;
	}
}