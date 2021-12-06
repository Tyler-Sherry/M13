import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Main class that instantiate a ProducerThread to read in strings from a file to a queue and a ConsumerThread
 * which will be taking words off of the queue and keeping a tally of the most frequent word.
 *
 * @author Tyler Sherry
 */
public class Main
{
    public static void main(String[] args) throws FileNotFoundException, InterruptedException
    {
        LinkedList<String> buffer = new LinkedList<>();
        Scanner scnr = new Scanner(System.in);
        String filePath;

        //Prompt for file path
        System.out.println("Please enter the file path:");
        filePath = scnr.nextLine();

        //Instantiate the objects
        ProducerThread producerThread = new ProducerThread(filePath, buffer);
        ConsumerThread consumerThread = new ConsumerThread(buffer);

        //Run the threads
        Thread myProducerThread = new Thread(producerThread);
        myProducerThread.start();
        myProducerThread.join();

        Thread myConsumerThread = new Thread(consumerThread);
        myConsumerThread.start();
    }
}
