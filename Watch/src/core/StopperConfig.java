package core;
import enums.StopperState;

/**
 *
 * @author Konrad Welc
 */
public class StopperConfig implements Config{
    
    StopperState configState;
    
    @Override
    public void increaseTimeValue() {
        throw new UnsupportedOperationException("Shit shouldn't happened."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cycleConfigState() {
        configState.nextState();
    }

    public StopperState getConfigState() {
        return configState;
    }
    
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
