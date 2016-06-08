/**
 * Created by cwiegers on 08.06.2016.
 */

import javax.sound.sampled.Clip;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class Audioabspielen {


    public void musik() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null;
                url = this.getClass().getResource("start.wav");
                //neues AudioClip element
                AudioClip clip = Applet.newAudioClip(url);

                //abspielen
                clip.loop();
                //clip.play();
                try {
                    Thread.sleep(50000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();


    }
}
