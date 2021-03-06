package sg.edu.rp.id19037610.demomusicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;

import java.io.File;

public class MyService extends Service {

    MediaPlayer player = new MediaPlayer();

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        try{
            File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile()
            + "/MyFolder", "music.mp3");

            // specify the path of the audio file
            player.setDataSource(file.getPath());
            player.prepare();

        }catch (Exception e){
            e.printStackTrace();
        }

        // providing the boolean value as true to play the audio on Loop
        player.setLooping(true);

        // starting the process
        player.start();

//        return super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // stopping the process
        player.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}