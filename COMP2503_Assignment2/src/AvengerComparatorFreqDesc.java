import java.util.Comparator;
/**
 * Avenger Comparator class to order the top 4 most frequently mentioned avengers, and handles tie breaks accordingly.
 * @author alyssalandeta
 *
 */
public class AvengerComparatorFreqDesc implements Comparator<Avenger> {
	@Override
	/** 
	 * This method orders the top 4 most frequently mentioned avengers ordered from most frequent to least, 
	 * then ascending alphabetical order of performer's last name.
	 */
	public int compare(Avenger a1, Avenger a2) {
		int result = 0;
		int freq1 = a1.getAliasFreq() + a1.getNameFreq() + a1.getPerformerFreq();
		int freq2 = a2.getAliasFreq() + a2.getNameFreq() + a2.getPerformerFreq();
		
		if (freq1 > freq2) {
			result = -1;
		}else if (freq1 < freq2) {
			result = 1;
		}else {
			result = a1.getPerformer().compareTo(a2.getPerformer());
		}
		return result;
	}

}
