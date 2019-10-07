package application;

import javafx.embed.swing.JFXPanel;
import javax.swing.JFrame;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

class ddd {     
    static Media m;
    static MediaPlayer p;
    public static void main(String[] args)  {   
            
        JFXPanel panel = new JFXPanel();
                
        JFrame f = new JFrame("메인윈도우");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setSize(200,200);
        f.setVisible(true);  
                        
        m = new Media("file:/c:/musics/내목소리들리니-벤.mp3");
        p = new MediaPlayer(m);
        p.play();                   
        
    }
    
}