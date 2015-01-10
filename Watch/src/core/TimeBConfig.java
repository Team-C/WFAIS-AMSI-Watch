package core;
import enums.TimeBConfigState;
/**
 *
 * @author Konrad Welc
 */
public class TimeBConfig implements Config{

    TimeBConfigState configState;

    @Override
    public void increaseTimeValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cycleConfigState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TimeBConfig getConfigState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
