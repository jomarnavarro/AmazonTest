package helpers;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

/**
 * Aids in sorting the articles.
 * @author omar.navarro
 *
 */
public class SortHelper {

	/**
	 * Sorts the articles by value.
	 * @param firstArticles
	 */
	public static void sortByValue(ArrayList<Article> firstArticles) {
		Collections.sort(firstArticles, new Comparator<Article>() {
			public int compare(Article a1, Article a2) {
				return a1.getValue() - a2.getValue();
			}
		});	
	}

	/**
	 * Sorts the articles by Price.
	 * @param firstArticles
	 */
	public static void sortByPrice(ArrayList<Article> firstArticles) {
		//sort by price.  since compare method requires an int, the double 
		//for the price value is converted to int after multiplied by 100
		//to provide an accurate comparison.
		Collections.sort(firstArticles, new Comparator<Article>() {
			public int compare(Article a1, Article a2) {
				return (int) (100 * (a1.getPrice() - a2.getPrice()));

			}
		});

	}

	/**
	 * Sorts articles by rating.
	 * @param firstArticles
	 */
	public static void sortByRating(ArrayList<Article> firstArticles) {
		//sort by rating.  same trick used above for price for accurate sorting.
		Collections.sort(firstArticles, new Comparator<Article>() {
			public int compare(Article a1, Article a2) {
				return (int) (10 * (a1.getRating() - a2.getRating()));

			}
		});

	}



}
