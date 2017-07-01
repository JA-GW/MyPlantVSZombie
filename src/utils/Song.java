package utils;

import bean.Pea;
import bean.Plant;
import bean.Sun;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by gw on 2017/6/26.
 */
public class Song {

    private String path;
    private int state; // 0 未播放  1  播放  2  停止

    public Song(String path){
        this.path = "F:/IntelliJIDEAWorkspace/PlantsVSZombie/image/pvzimage/"+path;
        state = 0;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void stop(){
        state = 3;
    }

    public void play(){
        if(state == 1)return;
        state = 1;

        new Thread(new Runnable() {
            @Override
            public void run() {
                File file = new File(path);
                try {
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
                    AudioFormat format = inputStream.getFormat();
                    DataLine.Info info = new DataLine.Info(SourceDataLine.class,format);
                    SourceDataLine line = (SourceDataLine)AudioSystem.getLine(info);
                    byte buffer[] = new byte[1024];
                    line.open();
                    line.start();
                    int bytes = 0;
                    while(bytes != -1){
                        if(state == 3)break;
                        bytes = inputStream.read(buffer,0,buffer.length);
                        if(bytes >= 0){
                            line.write(buffer,0,bytes);
                        }

                    }
                    line.drain();
                    line.close();
                    state = 0;
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
