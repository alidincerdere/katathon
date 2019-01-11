package service.impl;

import service.Anagram;
import util.FileOperator;
import util.impl.DefaultFileOperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adere on 11.01.2019.
 */
public class DefaultAnagram implements Anagram {

    private String fileName;
    private List<String> results;
    private List<String> inputWords;
    private List<List<String>> anagramArray;
    private List<List<String>> sortedAnagramArray;
    private FileOperator fileOperator;
    private int maxLength;

    public DefaultAnagram(String fileName) {

        fileOperator = new DefaultFileOperator(fileName);
        results = new ArrayList<String>();
        this.fileName = fileName;

        fileOperator.readContent();

        inputWords = fileOperator.getAllWords();
        maxLength = 0;
        anagramArray = new ArrayList<List<String>>();
        sortedAnagramArray = new ArrayList<List<String>>();
    }

    public void perform() {

        //algorithms


        calculateMaxLength();
        constructAnagramArrays();
        fulfillAnagramArray();
        setSortedAnagramArray();


    }

    public void writeResultsToFile(String outputFileName) {

        fileOperator.setOutputWords(results);
        fileOperator.writeWordsToFile(outputFileName);
    }

    public List<String> getAnagrams() {
        return results;
    }


    public void calculateMaxLength() {

        for (String current : inputWords) {
            if (current.length() > maxLength) {
                maxLength = current.length();
            }
        }
    }

    public void constructAnagramArrays() {

        for (int i = 0; i < maxLength; i++) {
            anagramArray.add(new ArrayList<String>());
            sortedAnagramArray.add(new ArrayList<String>());
        }
    }

    public void fulfillAnagramArray() {


        for (String current : inputWords) {

            if (current != null && current != "") {
                anagramArray.get(current.length()).add(current);
            }
        }

    }

    public void setSortedAnagramArray() {

        char tempArray[];

        for (int i= 0; i<maxLength; i++) {

            for(int j= 0; j < anagramArray.get(i).size(); j++) {

                tempArray = anagramArray.get(i).get(j).toCharArray();

                Arrays.sort(tempArray);

                sortedAnagramArray.get(i).add(new String(tempArray));


            }
        }
    }

    public void findAnagrams() {

        for (int i=0; i<maxLength; i++) {
            for (int j=0; j<sortedAnagramArray.get(i).size(); j++) {

                
            }
        }
    }

}
