package enums;

/*______________________________________________________________________________

WARNING: Zmień ktoś formatowanie to uduszę :)

Author: Wit
 _____________________________________________________________________________*/

public enum StopperState
{
    RUNNING,
    STOPPED;
    
    public StopperState nextState()
    {
        if(this == RUNNING)
            return STOPPED;
        else
            return RUNNING;
    }
    
    public static String toString(StopperState state)
    {
        switch(state)
        {
            case RUNNING:   return "RUNNING";
            case STOPPED:   return "STOPPED";
            default:        return "UNKNOWN";      
        }
    }
    
    @Override
    public String toString()
    {
        return toString(this);
    }
}
