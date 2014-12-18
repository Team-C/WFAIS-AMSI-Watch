package enums;

/*______________________________________________________________________________

WARNING: Zmień ktoś formatowanie to uduszę :)

Author: Wit
 _____________________________________________________________________________*/

public enum TimeBConfigState
{
    DEFAULT,
    MINUTES,
    HOURS;
    
    public TimeBConfigState nextState()
    {
        if(this == DEFAULT)
            return MINUTES;
        else if(this == MINUTES)
            return HOURS;
        else
            return DEFAULT;
    }
    
    public static String toString(TimeBConfigState state)
    {
        switch(state)
        {
            case DEFAULT:   return "DEFAULT";
            case MINUTES:   return "MINUTES";
            case HOURS:     return "HOURS";
            default:        return "UNKNOWN";      
        }
    }
    
    @Override
    public String toString()
    {
        return toString(this);
    }

}
