/**
 * Created by cwiegers on 08.06.2016.
 */
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
public class Audioabspielen {
    static AudioClip clip;


    public static void main () {
        // URL vom Lied
        URL url = null;
        try {
            url = new URL("file:///D:/start.wav");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }

        //neues AudioClip element
        AudioClip clip = Applet.newAudioClip(url);

        //abspielen
        clip.play();
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
