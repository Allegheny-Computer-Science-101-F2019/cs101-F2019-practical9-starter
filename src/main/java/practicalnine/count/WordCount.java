package practicalnine.count;

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/** A program that counts words in a document, printing the the key value pairs. */
public class WordCount {

  /** The file that contains the sentences. */
  private static final String SENTENCESFILE = "input/sentences.txt";

  // TODO: Try to understand how this course code creates the sorted lists
  // TODO: Can you find where this method is called in the main method?

  /** Create a sorted lists based on the values.
   * Reference:
   * https://stackoverflow.com/questions/2864840/treemap-sort-by-value */
  static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>>
      entriesSortedByValues(Map<K, V> map) {
    SortedSet<Map.Entry<K, V>> sortedEntries =
        new TreeSet<Map.Entry<K, V>>(new Comparator<Map.Entry<K, V>>() {
          @Override public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
            int res = e1.getValue().compareTo(e2.getValue());
            return res != 0 ? res : 1;
          }
        }
    );
    sortedEntries.addAll(map.entrySet());
    return sortedEntries;
  }

  // TODO: Make sure that you add lines of comments that illustrate you understand
  // how this method is reading and processing the file of sentences

  /** The main method for the WordCount program. */
  public static void main(String[] args) {
    // TODO: Please try this with a HashMap and see how the output differs
    // TODO: Can you explain why the output is different than with TreeMap?
    TreeMap<String, Integer> freq = new TreeMap<>();
    Scanner doc = null;
    // read in all of the words from the file
    System.out.println("Reading and tracking the words in the file ...");
    try {
      doc = new Scanner(new File(SENTENCESFILE)).useDelimiter("[^a-zA-Z]+");
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    // place the words inside of the TreeMap to count frequencies
    while (doc.hasNext()) {
      String word = doc.next().toLowerCase();
      Integer count = freq.get(word);
      if (count == null) {
        count = 0;
      }
      freq.put(word, 1 + count);
    }
    System.out.println("... Finished reading and tracking the words in the file.\n");
    System.out.println("Analysis of the words in the file ...\n");
    // display the key value pairs as they are stored in the TreeMap
    System.out.println("(key, value) pairs sorted by key:\n");
    System.out.println(freq);
    System.out.println();
    // display the key value pairs after they have been sorted by values
    System.out.println("(key, value) pairs sorted by value and key:\n");
    System.out.println(entriesSortedByValues(freq));
    System.out.println("\n... Finished the analysis of the words in the file.");
  }
}

// TODO: Add the output from running the program here

// TODO: Make sure that the lines are not too long,
// meaning that you may need "line wrap" the long lines
