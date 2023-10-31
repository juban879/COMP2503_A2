import java.util.Comparator;

public class AvengerPerformerComparatorFreqDesc implements Comparator<Avenger> {
	@Override
	/**
	 * Overriden compare method that sorts the avengers by descending frequency, ascending order of name length if frequency is tied,
	 * then ascending alphabetical order of alias if another tie.
	 */
	public int compare(Avenger a1, Avenger a2) {
		
		int diff = a2.getPerformerFreq() - a1.getPerformerFreq();
		if (diff == 0) {
			diff = a1.getHeroName().length() - a2.getHeroName().length();
			if (diff == 0)
				return a1.getHeroAlias().compareTo(a2.getHeroAlias());
		}
		return diff;
	}

}
