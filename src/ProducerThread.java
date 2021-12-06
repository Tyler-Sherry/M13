import java.io.*;
import java.util.LinkedList;

/**
 * The ProducerThread will be responsible for opening the file connection and for reading words off of the file.
 * It will then need to put words onto the queue.  The ProducerThread also closes the file connection when done.
 *
 * @author Tyler Sherry
 */
public class ProducerThread implements Runnable
{
    private final LinkedList<String> buffer;
    private final String filePath;

    public ProducerThread(String filePath, LinkedList<String> buffer)
    {
        this.buffer = buffer;
        this.filePath = filePath;
    }

    @Override
    public void run(){
        File file = new File(filePath);
        String stringFromFile;
        String[] individualWords;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));

            //Read in the txt file and store the strings into the buffer
            while((stringFromFile = br.readLine()) != null)
            {
                individualWords = stringFromFile.split(" ");
                for(int i = 0; i < individualWords.length; i++)
                {
                    buffer.add(individualWords[i].replaceAll("\\p{Punct}",""));
                }
            }

            br.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
