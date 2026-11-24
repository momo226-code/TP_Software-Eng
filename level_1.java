public interface MusicPlayer {
    boolean play(String artist, String title);
}



class StreamingPlayer{
    public boolean stream(Track track){
        String track = track.artist + " - " + track.title ;
       
        if (track == null || track.trim().isEmpty()) {
            return false ;
        }

    System.out.println("[STREMING PLAYER] " + track);

    return true;

    }
}



class Track {
    String artist , title ;
    public Track(String artist, String title){
        this.artist = artist ;
        this.title = title ;
    }

}





class LegacyMusicPlayer {

    public int playTrack(String track) {
        if (track == null || track.trim().isEmpty()) {
            return 0;
        }

    System.out.println("[LEGACY PLAYER] " + track);

    return 1;
}
}


class MusicPlayerAdapter implements MusicPlayer{
    private LegacyMusicPlayer legacyMusicPlayer ;


    public MusicPlayerAdapter(){
        this.legacyMusicPlayer = new LegacyMusicPlayer(); 
    }

    public boolean play(String artist , String title){
            String track = artist.trim() + " - " + title.trim();
            if(legacyMusicPlayer.playTrack(track)){
                return true ;
            }
            else{
                return false;
            }
    }



}




class StreamingPlayerAdapter implements MusicPlayer{
    private StreamingPlayer streaming ;

    public StreamingPlayerAdapter(){
        this.streaming= new StreamingPlayer();
    }

    public boolean play(String ar , String t ){
        Track track = new Track(ar.trim(), t.trim());
        return streaming.stream(track) ;
    }
}



public class level_1{

    public static void main(String args){

        MusicPlayerAdapter player_1 = new MusicPlayerAdapter();
        player_1.play("Himra" , "Djorobite") ;

        StreamingPlayerAdapter player_2 = new StreamingPlayerAdapter();
        player_2.play("Himra" , "Djorobite");
        


    }
}