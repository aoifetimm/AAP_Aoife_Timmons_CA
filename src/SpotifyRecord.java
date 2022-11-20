import java.io.Serializable;

public class SpotifyRecord implements Comparable<SpotifyRecord>, Serializable { //implement serializable so the file output stream will work

    private String title;
    private String artist;
    private String genre;
    private int year;
    private int bpm;
    private int energy;
    private int danceability;
    private int loudness;
    private int liveness;
    private int valence;
    private int length;
    private int acousticness;
    private int speechiness;
    private int popularity;

    public SpotifyRecord() {

    }
    public SpotifyRecord(String title, String artist, String genre, int year, int bpm, int energy, int danceability, int loudness, int liveness, int valence, int length, int acousticness, int speechiness, int popularity) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.bpm = bpm;
        this.energy = energy;
        this.danceability = danceability;
        this.loudness = loudness;
        this.liveness = liveness;
        this.valence = valence;
        this.length = length;
        this.acousticness = acousticness;
        this.speechiness = speechiness;
        this.popularity = popularity;
    }

    @Override
    public int compareTo(SpotifyRecord spotifyRecord) {
        // if value less than other thing return -1
        // if thing equal to other thing return 0
        // if thing greater than other thing return 1
        if(energy < spotifyRecord.getEnergy()){
            return -1;
        } else if (energy == spotifyRecord.getEnergy()) {
            return 0;
        }
        return 1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        //if statements to validate if user input is empty for question 5
        if(title.isEmpty()){
            System.out.println("You must enter a title for the song");
        }else{
            this.title = title;
        }
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if(artist.isEmpty()){
            System.out.println("You must enter the artist of the song");
        }else{
            this.artist = artist;
        }

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if(genre.isEmpty()){
            System.out.println("You must enter a genre for this song");
        }else{
            this.genre = genre;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year < 1920 || year > 2022){
            System.out.println("You must enter a valid year between 1920 and 2022");
        }else {
            this.year = year;
        }
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        if(bpm < 30 || bpm > 300){
            System.out.println("Please enter a valid value for BPM between 30 and 300");
        }else{
            this.bpm = bpm;
        }
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if(energy < 0 || energy > 100){
            System.out.println("Please enter a valid value for energy between 0 and 100.");
        }else{
            this.energy = energy;
        }
    }

    public int getDanceability() {
        return danceability;
    }

    public void setDanceability(int danceability) {
        if(danceability < 0 || danceability > 100){
            System.out.println("Please enter a valid value for danceability between 0 and 100.");
        }else{
            this.danceability = danceability;
        }
    }

    public int getLoudness() {
        return loudness;
    }

    public void setLoudness(int loudness) {
        if(loudness < -70 || loudness > 0){
            System.out.println("Please enter a valid value for loudness between -1 and -70");
        }else {
            this.loudness = loudness;
        }
    }

    public int getLiveness() {
        return liveness;
    }

    public void setLiveness(int liveness) {
        if(liveness < 0 || liveness > 80){
            System.out.println("Please enter a valid value for liveness between 0 and 80.");
        }else{
            this.liveness = liveness;
        }
    }

    public int getValence() {
        return valence;
    }

    public void setValence(int valence) {
        if(valence < 0 || valence > 100){
            System.out.println("please enter a valid value for valence between 0 and 100.");
        }else{
            this.valence = valence;
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if(length < 100 || length > 500){
            System.out.println("Please enter a valid value for length between 100 and 500.");
        }else{
            this.length = length;
        }
    }

    public int getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(int acousticness) {
        if(acousticness < 0 || acousticness > 100){
            System.out.println("Please enter a valid value for acousticness between 0 and 100.");
        }else{
            this.acousticness = acousticness;
        }
    }

    public int getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(int speechiness) {
        if(speechiness < 0 || speechiness > 50){
            System.out.println("Please enter a valid value for speechiness between 0 and 50.");
        }else{
            this.speechiness = speechiness;
        }
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        if(popularity < 0 || popularity > 100){
            System.out.println("Please enter a valid value for popularity between 0 and 100");
        }else {
            this.popularity = popularity;
        }
    }

    @Override
    public String toString(){
        return "Title: " + this.title + "\tArtist: " + this.artist + "\tGenre: " + this.genre + "\tYear: " + this.year +
                "\tBPM: " + this.bpm + "\tEnergy: " + this.energy + "\tDanceability: " + this.danceability +
                "\tLoudness: " + this.loudness + "\tLiveness: " + this.liveness + "\tValence: " + this.valence +
                "\tLength: " + this.length + "\tAcousticness: " + this.acousticness + "\tSpeechiness: " + this.speechiness +
                "\tPopularity: " + this.popularity;
    }
}
