package fr.mathieu;


import java.util.ArrayList;
import java.util.List;

public class Disque {


    // Attributs //
    private String title;
    private String barCode;
    private List<Chanson> chansons = new ArrayList<>();

    
    
    
    public Disque() {
	}

	public Disque(String title, String barCode) {
		this.title = title;
		this.barCode = barCode;
	}

	// Setters/Getters //
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public List<Chanson> getChansons() {
        return chansons;
    }

    public void setChansons(List<Chanson> chansons) {
        this.chansons = chansons;
    }


    // Autres méthodes //
    public int getDuration() {
        int discDuration = 0;

        for (Chanson current : this.getChansons()) {
            discDuration += current.getDuration();
        }
        return discDuration;
    }



    /* Renvoie les Chanson dans une List dont le nom contient la chaine de caractères name
    * case sensitive*/
    public List<Chanson> getSongsByName(String name) {
        List<Chanson> results = new ArrayList<>();

        for (Chanson currentSong : this.getChansons()) {

            if (currentSong.getTitle().contains(name)) {
                results.add(currentSong);
            }

        }

        return results;

    }




    /* Créer une chanson */
    public Chanson createSong(String songTitle, int duration){

        Chanson song = new Chanson();
        song.setTitle(songTitle);
        song.setDuration(duration);

        return song;
    }


    /* Supprimer une chanson */
    public int deleteSong(String songTitle){

        int result = 0;
        List<Chanson> songs = this.getChansons();

        for (int i = 0; i < songs.size(); i++){

            if (songs.get(i).getTitle().equals(songTitle)){
                songs.remove(i);
                result = 1;
            }

        }

        return result;

    }



    @Override
    public String toString() {
        return this.title;
    }
}
