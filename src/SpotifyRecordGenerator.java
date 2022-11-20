import java.io.*;
import java.util.Scanner;

public class SpotifyRecordGenerator {
    public static void main(String[] args) throws Exception{
        //parsing and reading the CSV file data into the film (object) array
        // provide the path here...


        //STANDARD FILE
        Scanner sc = new Scanner(new File(".\\src\\Spotify top 50.csv"));
        SpotifyRecord[] spotifyRecords = new SpotifyRecord[603];



        //10 RECORD FILE
        /*Scanner sc = new Scanner(new File(".\\src\\Spotify top 50 (10).csv"));
        SpotifyRecord[] spotifyRecords = new SpotifyRecord[10];*/

        //100 RECORD FILE
        /*Scanner sc = new Scanner(new File(".\\src\\Spotify top 50 (100).csv"));
        SpotifyRecord[] spotifyRecords = new SpotifyRecord[100];*/

        //500 RECORD FILE
        /*Scanner sc = new Scanner(new File(".\\src\\Spotify top 50 (500).csv"));
        SpotifyRecord[] spotifyRecords = new SpotifyRecord[500];*/

        //1000 RECORD FILE
        /*Scanner sc = new Scanner(new File(".\\src\\Spotify top 50 (1000).csv"));
        SpotifyRecord[] spotifyRecords = new SpotifyRecord[1000];*/

        // this will just print the header in CSV file
        sc.nextLine();

        int i = 0; String st = "";

        while (sc.hasNextLine())  //returns a boolean value
        {
            st = sc.nextLine();
            String[] data = st.split(",");
            spotifyRecords[i] = new SpotifyRecord(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]), Integer.parseInt(data[10]), Integer.parseInt(data[11]), Integer.parseInt(data[12]), Integer.parseInt(data[13]));
            i++;
        }
        sc.close();  //closes the scanner
        long beginSort = System.nanoTime(); // change code to only take in 5, 10, etc lines then check time complexity - then change code back. Change the file to only have that many records in it - do diff versions of the file with that amount.
       quickSort(spotifyRecords, 0, spotifyRecords.length - 1);
        long endSort = System.nanoTime();
        long sortTime = endSort-beginSort;
        System.out.println("Elapsed time in nanoseconds for Quick Sort is: "+sortTime);

        long beginSearch = System.nanoTime();
        int energyKey = 86;
        int searchResult = binarySearch(spotifyRecords, energyKey, 0,spotifyRecords.length - 1);
        System.out.println(spotifyRecords[searchResult]);
        long endSearch = System.nanoTime();
        long searchTime = endSearch-beginSearch;
        System.out.println("Elapsed time in nanoseconds for Binary Search is: "+searchTime);

        // APPEND NEW RECORD
        /*FileOutputStream fos = new FileOutputStream(".\\src\\Spotify top 50.csv");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject( new SpotifyRecord("You Can Call Me Al", "Paul Simon", "Pop", 1987, 89, 86, 36, 52, 46, 24, 76, 97, 32, 98
        ));*/

        Scanner userInput = new Scanner(System.in);
        SpotifyRecord newRecord = new SpotifyRecord();

        System.out.println("Enter song title: ");
        String newRecordTitle = userInput.nextLine();
        newRecord.setTitle(newRecordTitle);
        System.out.println("Enter song artist: ");
        String newRecordArtist = userInput.nextLine();
        newRecord.setArtist(newRecordArtist);
        System.out.println("Enter song genre: ");
        String newRecordGenre = userInput.nextLine();
        newRecord.setGenre(newRecordGenre);
        System.out.println("Enter song year: ");
        Integer newRecordYear = Integer.parseInt(userInput.nextLine());
        newRecord.setYear(newRecordYear);
        System.out.println("Enter song BPM: ");
        Integer newRecordBpm = Integer.parseInt(userInput.nextLine());
        newRecord.setBpm(newRecordBpm);
        System.out.println("Enter song energy: ");
        Integer newRecordEnergy = Integer.parseInt(userInput.nextLine());
        newRecord.setEnergy(newRecordEnergy);
        System.out.println("Enter song danceability: ");
        Integer newRecordDanceability = Integer.parseInt(userInput.nextLine());
        newRecord.setDanceability(newRecordDanceability);
        System.out.println("Enter song loudness: ");
        Integer newRecordloudness = Integer.parseInt(userInput.nextLine());
        newRecord.setLoudness(newRecordloudness);
        System.out.println("Enter song liveness: ");
        Integer newRecordLiveness = Integer.parseInt(userInput.nextLine());
        newRecord.setLiveness(newRecordLiveness);
        System.out.println("Enter song valence: ");
        Integer newRecordValence = Integer.parseInt(userInput.nextLine());
        newRecord.setValence(newRecordValence);
        System.out.println("Enter song length: ");
        Integer newRecordLength = Integer.parseInt(userInput.nextLine());
        newRecord.setLength(newRecordLength);
        System.out.println("Enter song acousticness: ");
        Integer newRecordAcousticness = Integer.parseInt(userInput.nextLine());
        newRecord.setAcousticness(newRecordAcousticness);
        System.out.println("Enter song speechiness: ");
        Integer newRecordSpeechiness = Integer.parseInt(userInput.nextLine());
        newRecord.setSpeechiness(newRecordSpeechiness);
        System.out.println("Enter song popularity: ");
        Integer newRecordPopularity = Integer.parseInt(userInput.nextLine());
        newRecord.setPopularity(newRecordPopularity);


        //SpotifyRecord newRecord = new SpotifyRecord(newRecordTitle, "Paul Simon", "Pop", 1987, 89, 86, 36, 52, 46, 24, 76, 97, 32, 98);

        BufferedWriter writer = new BufferedWriter(new FileWriter(".\\src\\Spotify top 50.csv", true));
        writer.append("\n" + newRecord.getTitle() + "," + newRecord.getArtist() + "," + newRecord.getGenre() + "," + newRecord.getYear() + "," + newRecord.getBpm() + "," + newRecord.getEnergy() + "," + newRecord.getDanceability() + "," + newRecord.getLoudness() + "," + newRecord.getLiveness() + "," + newRecord.getValence() + "," + newRecord.getLength() + "," + newRecord.getAcousticness() + "," + newRecord.getSpeechiness() + "," + newRecord.getPopularity());
        writer.flush();
        writer.close();

    }

    //Quicksort
    static void swap(SpotifyRecord[] arr, int i, int j){
        System.out.println("swapping " + arr[i] + " " + arr[j]);
        SpotifyRecord temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    static int partition(SpotifyRecord[] arr, int low, int high){

        SpotifyRecord pivot = arr[high];
        System.out.println("The pivot is " + pivot);

        int i = (low - 1);

        for(int j = low; j <= high - 1; j++){

            System.out.println("Compare " + arr[j] + " pivot " + pivot);

            int sizeComparison = arr[j].compareTo(pivot); //size comparison is -1 if it is less than pivot, 0 if it is equals to pivot, 1 if it is greater than pivot

            if (sizeComparison == -1){
                i++;
                swap(arr, i, j);
                printArray(arr);
            }
        }
        System.out.println("Insert pivot in correct location");
        swap(arr, i + 1, high);
        printArray(arr);
        return (i + 1);
    }

    static void quickSort(SpotifyRecord[] arr, int low, int high){
        if (low >= high){
            System.out.println("End recursive call");
            return;
        }
        else{
            int pivotIndex = partition(arr, low, high);

            System.out.println("Left Recursive Call");
            System.out.println("LRC with low " + low + " high " + (pivotIndex-1));
            quickSort(arr, low, pivotIndex - 1);

            System.out.println("Right Recursive Call");
            System.out.println("RRC with low " + (pivotIndex + 1) + " high " + high);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static void printArray(SpotifyRecord[] arr){
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    //Binary Search
    public static int binarySearch(SpotifyRecord[] data, int energyKey, int low, int high){
        if(low >high) {
            return -1;
        }
        int middle = ((low + high) + 1)/2;
        if(energyKey == data[middle].getEnergy()) {
            return middle;
        }
        else if(energyKey < data[middle].getEnergy()){
            high = middle-1;
            return binarySearch(data, energyKey, low, high);
        }
        else{
            low = middle+1;
            return binarySearch(data, energyKey, low, high);
        }




    }

}
