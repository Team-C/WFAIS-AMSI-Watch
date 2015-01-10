package core;
import enums.AlarmConfigState;

/**
 *
 * @author Konrad Welc
 */
public class AlarmConfig implements Config{

    AlarmConfigState configState;

    @Override
    public void increaseTimeValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cycleConfigState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AlarmConfigState getConfigState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void cycleAlarmStates(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
