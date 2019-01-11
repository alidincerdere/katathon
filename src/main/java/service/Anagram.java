package service;

import java.util.List;

/**
 * Created by adere on 11.01.2019.
 */
public interface  Anagram {

    void perform();

    void writeResultsToFile(String outputFileName);

    List<String> getAnagrams();

    void calculateMaxLength();
}
