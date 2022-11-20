import java.io.*;
import java.util.Scanner;

public class SpotifyRecordGenerator {
    public static void main(String[] args) throws Exception{
        //parsing and reading the CSV file data into the film (object) array
        // provide the path here...


        //STANDARD FILE
        /*Scanner sc = new Scanner(new File(".\\src\\Spotify top 50.csv"));
        SpotifyRecord[] spotifyRecords = new SpotifyRecord[603];*/

        //10, 100, 500 & 100 record files imported and commented out for ease of time complexity Qs

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
        Scanner sc = new Scanner(new File(".\\src\\Spotify top 50 (1000).csv"));
        SpotifyRecord[] spotifyRecords = new SpotifyRecord[1000];

        // this will just print the header in CSV file
        sc.nextLine();

        int i = 0; String st = "";

        while (sc.hasNextLine())  //returns a boolean value
        {
            //scans in the next line and reads the data split by , to read the csv
            st = sc.nextLine();
            String[] data = st.split(",");
            spotifyRecords[i] = new SpotifyRecord(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]), Integer.parseInt(data[10]), Integer.parseInt(data[11]), Integer.parseInt(data[12]), Integer.parseInt(data[13]));
            i++;
        }
        sc.close();  //closes the scanner

        //begin time for Quick sort
        long beginSort = System.nanoTime();

        //calling quicksort method to sort the csv
        quickSort(spotifyRecords, 0, spotifyRecords.length - 1);

        //end the time for quick sort
        long endSort = System.nanoTime();

        //calculate and print out time for quicksort
        long sortTime = endSort-beginSort;
        System.out.println("Elapsed time in nanoseconds for Quick Sort is: "+sortTime);

         //begin time for binary search
        long beginSearch = System.nanoTime();

        //energyKey is the value we are searching for
        int energyKey = 86;

        //calling binary search method and saving result as searchResult and printing that out
        int searchResult = binarySearch(spotifyRecords, energyKey, 0,spotifyRecords.length - 1);
        System.out.println("Your search result is: " + spotifyRecords[searchResult]);

        //end time for binary search
        long endSearch = System.nanoTime();

        //calculating elapsed time and printing it out
        long searchTime = endSearch-beginSearch;
        System.out.println("Elapsed time in nanoseconds for Binary Search is: "+searchTime);

        // APPEND NEW RECORD
        // I realised that this wouldn't work as it was writing over the whole file with the test record I was adding

        /*FileOutputStream fos = new FileOutputStream(".\\src\\Spotify top 50.csv");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject( new SpotifyRecord("You Can Call Me Al", "Paul Simon", "Pop", 1987, 89, 86, 36, 52, 46, 24, 76, 97, 32, 98
        ));*/

        //scanner for user input
        Scanner userInput = new Scanner(System.in);
        SpotifyRecord newRecord = new SpotifyRecord();

        //prompt for user input
        System.out.println("Enter song title: ");

        //user input recorded from the next line
        String newRecordTitle = userInput.nextLine();

        //setting the title for the new record input to be the title taken in from the user input
        newRecord.setTitle(newRecordTitle);

        //same methodology used for artist and genre

        System.out.println("Enter song artist: ");
        String newRecordArtist = userInput.nextLine();
        newRecord.setArtist(newRecordArtist);

        System.out.println("Enter song genre: ");
        String newRecordGenre = userInput.nextLine();
        newRecord.setGenre(newRecordGenre);

        //prompt for user input
        System.out.println("Enter song year between 1920 and 2022: ");

        //user input recorded from next line - parsing the answer as it will be an integer
        int newRecordYear = Integer.parseInt(userInput.nextLine());

        //setting the year for the new record input to be the year taken in from the user input
        newRecord.setYear(newRecordYear);

        //same methodology used for the rest of the values as they are all integers

        System.out.println("Enter song BPM value between 30 and 300: ");
        int newRecordBpm = Integer.parseInt(userInput.nextLine());
        newRecord.setBpm(newRecordBpm);

        System.out.println("Enter song energy value between 0 and 100: ");
        int newRecordEnergy = Integer.parseInt(userInput.nextLine());
        newRecord.setEnergy(newRecordEnergy);

        System.out.println("Enter song danceability value between 0 and 100: ");
        int newRecordDanceability = Integer.parseInt(userInput.nextLine());
        newRecord.setDanceability(newRecordDanceability);

        System.out.println("Enter song loudness value between -1 and -70: ");
        int newRecordloudness = Integer.parseInt(userInput.nextLine());
        newRecord.setLoudness(newRecordloudness);

        System.out.println("Enter song liveness value between 0 and 80: ");
        int newRecordLiveness = Integer.parseInt(userInput.nextLine());
        newRecord.setLiveness(newRecordLiveness);

        System.out.println("Enter song valence value between 0 and 100: ");
        int newRecordValence = Integer.parseInt(userInput.nextLine());
        newRecord.setValence(newRecordValence);

        System.out.println("Enter song length value between 100 and 500: ");
        int newRecordLength = Integer.parseInt(userInput.nextLine());
        newRecord.setLength(newRecordLength);

        System.out.println("Enter song acousticness value between 0 and 100: ");
        int newRecordAcousticness = Integer.parseInt(userInput.nextLine());
        newRecord.setAcousticness(newRecordAcousticness);

        System.out.println("Enter song speechiness value between 0 and 50: ");
        int newRecordSpeechiness = Integer.parseInt(userInput.nextLine());
        newRecord.setSpeechiness(newRecordSpeechiness);

        System.out.println("Enter song popularity value between 0 and 100: ");
        int newRecordPopularity = Integer.parseInt(userInput.nextLine());
        newRecord.setPopularity(newRecordPopularity);

        //I was using this to test that the append was working before I added the user input
        //SpotifyRecord newRecord = new SpotifyRecord("You can call me Al", "Paul Simon", "Pop", 1987, 89, 86, 36, 52, 46, 24, 76, 97, 32, 98);

        //using buffered writer to append the new record on as it will not overwrite the whole file - it will append to the end
        BufferedWriter writer = new BufferedWriter(new FileWriter(".\\src\\Spotify top 50.csv", true));
        writer.append
                //getting the file attributes that are to be added
                ("\n" + newRecord.getTitle() + "," + newRecord.getArtist() + "," + newRecord.getGenre() + "," + newRecord.getYear() + "," + newRecord.getBpm() + "," + newRecord.getEnergy() + "," + newRecord.getDanceability() + "," + newRecord.getLoudness() + "," + newRecord.getLiveness() + "," + newRecord.getValence() + "," + newRecord.getLength() + "," + newRecord.getAcousticness() + "," + newRecord.getSpeechiness() + "," + newRecord.getPopularity());
        writer.flush();
        writer.close();

    }

    //QUICK SORT
    //swap method to swap the two arrays from the partition to be in the correct order
    static void swap(SpotifyRecord[] arr, int i, int j){
        SpotifyRecord temp = arr[i];//setting arr i to temp
        arr[i] = arr[j];//setting arr i to arr j to swap them
        arr[j] = temp; //setting arr j to temp (which is the initial arr i value)
    }

    //partition to divide the array into two arrays to "divide and conquer"
    static int partition(SpotifyRecord[] arr, int low, int high){

        //set the pivot as the last item in the array
        SpotifyRecord pivot = arr[high];

        int i = (low - 1);

        for(int j = low; j <= high - 1; j++){

            //size comparison is -1 if it is less than pivot, 0 if it is equals to pivot, 1 if it is greater than pivot
            int sizeComparison = arr[j].compareTo(pivot);

            //moves elements small than pivot to the left
            if (sizeComparison == -1){
                i++;
                swap(arr, i, j);
            }
        }
        //insert pivot in correct location
        swap(arr, i + 1, high);
        return (i + 1);
    }

    //quicksort method with recursion to sort the two arrays split in partition
    static void quickSort(SpotifyRecord[] arr, int low, int high){
        //base case
        if (low >= high){
            return;
        }
        else{
            int pivotIndex = partition(arr, low, high);

            //left recursive call with low and high
            quickSort(arr, low, pivotIndex - 1);

            //right recursive call with low and high
            quickSort(arr, pivotIndex + 1, high);

            //printing sorted array
            printArray(arr);
        }
    }

    //printArray method to print out the spotify record array
    static void printArray(SpotifyRecord[] arr){
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    //Binary Search
    public static int binarySearch(SpotifyRecord[] data, int energyKey, int low, int high){
        //base case
        if(low >high) {
            return -1;
        }
        //setting middle item in array
        int middle = ((low + high) + 1)/2;

        //if what we are looking for is the middle return it
        if(energyKey == data[middle].getEnergy()) {
            return middle;
        }

        //if what we are looking for is less than the middle we give high a value of middle -1 and call the method again until we find what we are looking for or hit the base case
        else if(energyKey < data[middle].getEnergy()){
            high = middle-1;
            return binarySearch(data, energyKey, low, high);
        }

        //if what we are looking for is more than the middle we give low a value of middle +1 and call the method again until we find what we are looking for or hit the base case
        else{
            low = middle+1;
            return binarySearch(data, energyKey, low, high);
        }

    }

}
