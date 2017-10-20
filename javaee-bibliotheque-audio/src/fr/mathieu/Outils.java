package fr.mathieu;

import java.io.*;
import java.util.List;

public class Outils {

    public BufferedReader readFileToBuffer(String fileName) throws IOException {

        File file = new File(fileName);
        FileReader fr = new FileReader(file);

        //Guard
        if (file.exists() == false){
            System.out.println("Le fichier à lire n'existe pas !");
            return null;
        }

        // fis va lire le fichier
        BufferedReader br = new BufferedReader(fr);
        //fr.close();

        return br;

    }


    public String chooseRandomStringInList(List<String> stringsList){

        int randomIndex = (int) (Math.random() * (stringsList.size() - 1));

        return stringsList.get(randomIndex);

    }

}
