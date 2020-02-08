
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.ArrayList;

import com.ctre.phoenix.music.Orchestra;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
public class MusicSubsystem extends SubsystemBase {
/* The orchestra object that holds all the instruments */
Orchestra orchestra;

/* Talon FXs to play music through.  
More complex music MIDIs will contain several tracks, requiring multiple instruments.  */
public void musicSubsystem(int talon,int talon2,int talon3){
    TalonFX [] talons =  { new TalonFX(talon), new TalonFX(talon2) };
}

/* An array of songs that are available to be played, can you guess the song/artists? */
// .chrp files are in deploy
String[] songs = new String[] {
"Imperial_March.chrp"
/*,
"song2.chrp",
"song3.chrp",
"song4.chrp",
"song5.chrp",
"song6.chrp",
"song7.chrp",
"song8.chrp",
"song9.chrp", // the remaining songs play better with three or more FXs 
"song10.chrp",
"song11.chrp",
*/
};
public void playTheMarch(){
orchestra.loadMusic(songs[1]);
    } 

}

