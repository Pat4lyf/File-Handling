package com.filereader;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConfigParser {
    private String filePath;
    private Map<String, String> map;
    private String url = "FileHandling-week2task/src/main/resources/";
    private String defaultFilePath = url + "config.txt";


    /**
     * defining a constructor that takes the name of the file
     *
     * @param nameOfFile name of the file
     */
    public ConfigParser(String nameOfFile) {
        this.filePath = this.url + nameOfFile;
        readFile();
    }


    /**
     * defining a constructor that takes no parameter
     */
    public ConfigParser() {
        this.filePath = this.defaultFilePath;
        readFile();
    }

    private void readFile() {
        File inputFile = new File(filePath);  //creating an object of the File class
        BufferedReader bufferedReader = null;
        String property1 = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            String line;
            map = new HashMap<>();
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();   // to remove any whitespaces (tab, space, newline)


                /**
                 * checking for empty lines
                 */

                if (line.length() == 0) {
                    property1 = "";
                    continue;
                }


                /**
                 * checking for headers
                 */
                else if (line.startsWith("[") && line.endsWith("]")) {
                    property1 = line.substring(line.indexOf("[") + 1, line.indexOf("]")) + ".";
                } else {
                    String property = line.substring(0, line.indexOf("="));
                    String value = line.substring(line.indexOf("=") + 1);

                    /**
                     * checking if the map already contains a given key
                     */
                    if (map.containsKey(property1 + property)) {
                        continue;
                    }
                    map.put(property1 + property, value);
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("No such file found");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * defining a method that takes a string as argument and returns the value of that string in the map
     *
     * @param key the name of the property
     * @return the value of the key passed
     */
    public String get(String key) {
        return map.get(key);
    }
}
