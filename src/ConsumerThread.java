import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ConsumerThread will be responsible for taking words off of the queue and keeping a tally.
 * Once all words in the file have been tallied, it should also print out the most frequent word
 * in the file and display it on the screen with the frequency.
 *
 * @author Tyler Sherry
 */
public class ConsumerThread implements Runnable
{
    private final LinkedList<String> buffer;

    public ConsumerThread(LinkedList<String> buffer)
    {
        this.buffer = buffer;
    }

    @Override
    public void run(){
        int max = 0;
        int count = 0;
        String word = null;
        String maxWord = null;

        for (int i = 0; i < buffer.size(); i++)
        {
            word = buffer.get(i);

            for (int j = 0; j < buffer.size(); j++)
            {
                if (buffer.get(j).equals(word))
                {
                    count++;
                }
            }

            if (count > max)
            {
                max = count;
                maxWord = word;
            }
            count = 0;
        }

        System.out.println("The most frequent word is \"" + maxWord + "\", which occured " + max + " times.");
    }
}
