package core;
import enums.TimeAConfigState;

/**
 *
 * @author Konrad Welc
 */
public class TimeAConfig implements Config{

    static TimeAConfigState configState;
    
    
    @Override
    public void increaseTimeValue() {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cycleConfigState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TimeAConfigState getConfigState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void change24hMode(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
