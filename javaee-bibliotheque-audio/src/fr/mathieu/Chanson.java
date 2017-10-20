package fr.mathieu;

public class Chanson {

    // Attributs //
    private String title;
    private int duration;

    

    public Chanson() {
	}

	public Chanson(String title, int duration) {
		this.title = title;
		this.duration = duration;
	}

	// Setters/Getters //
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    // Autres méthodes //
    public void afficher(){
        System.out.println("\nTitre de la chanson : " + this.getTitle());
        System.out.println("Durée de la chanson (en minutes) : " + this.getDuration() + "\n");
    }


    @Override
    public String toString() {
        return this.title;
    }

}
