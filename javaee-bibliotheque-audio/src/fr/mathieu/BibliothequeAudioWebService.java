package fr.mathieu;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("bibliotheque")
public class BibliothequeAudioWebService {
	
	private static Bibliotheque bibliotheque = new Bibliotheque();
	private static Disque disc = new Disque("Ta mere","1");
	
	static {
		try {
			bibliotheque.generateRandomDiscsFromFile(50);
			
			Chanson song1 = new Chanson("string", 5);
			Chanson song2 = new Chanson("de guerre", 7);
			disc.getChansons().add(song1);
			disc.getChansons().add(song2);
			bibliotheque.getDisques().add(disc);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@GET
	@Path("disques")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Disque> getDisques(){
		return bibliotheque.getDisques();
	}
	
	@GET
	@Path("disques/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Disque getDisc(@PathParam("id") String barCode){
		return bibliotheque.getDiscWithBarcode(barCode);
	}
	
	@GET
	@Path("disques/{id}/duree")
	@Produces(MediaType.APPLICATION_JSON)
	public int getDiscDuration(@PathParam("id") String barCode){
		return bibliotheque.getDiscWithBarcode(barCode).getDuration();
	}
	
	@GET
	@Path("disques/{id}/chansons")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Chanson> getDiscSongs(@PathParam("id") String barCode){
		return bibliotheque.getDiscWithBarcode(barCode).getChansons();
	}
	
	@GET
	@Path("disques/{id}/chansons/{song}")
	@Produces(MediaType.APPLICATION_JSON)
	public Chanson getDiscSong(@PathParam("id") String barCode, @PathParam("song") int song){
		return bibliotheque.getDiscWithBarcode(barCode).getChansons().get(song);
	}
	
	
	@GET
	@Path("disques/search")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Disque> getDiscsContainingName(@QueryParam("name") String name){
		return bibliotheque.getDiscsByName(name);
	}
	
	
	@POST
	@Path("disques")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Disque addDisc(Disque disc){
		bibliotheque.getDisques().add(disc);
		return disc;
	}
	
	@POST
	@Path("disques/{id}/chansons")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Chanson addSong(@PathParam("id") String barCode, Chanson song){
		Disque disc = bibliotheque.getDiscWithBarcode(barCode);
		disc.getChansons().add(song);
		return song;
	}
	
	@DELETE
	@Path("disques/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Disque deleteDiscWithBarCode(@PathParam("id") String barCode){
		Disque disc = bibliotheque.getDiscWithBarcode(barCode);
		bibliotheque.deleteDiscBarCode(barCode);
		return disc;
	}
	
	
	@DELETE
	@Path("disques/{id}/chansons")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteSong(@QueryParam("name") String songName, @PathParam("id") String barCode){
		bibliotheque.getDiscWithBarcode(barCode).deleteSong(songName);
	}
	
	
	@PUT
	@Path("disques/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Disque modifyDiscName(@PathParam("id") String barCode, Disque disc){
		
		bibliotheque.getDiscWithBarcode(barCode).setTitle(disc.getTitle());
		bibliotheque.getDiscWithBarcode(barCode).setBarCode(disc.getBarCode());
		
		return bibliotheque.getDiscWithBarcode(barCode);
	}
	

}
