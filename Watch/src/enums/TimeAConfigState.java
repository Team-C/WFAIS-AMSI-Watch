package enums;

/*______________________________________________________________________________

WARNING: Zmień ktoś formatowanie to uduszę :)

Author: Wit
 _____________________________________________________________________________*/

public enum TimeAConfigState
{
    DEFAULT,
    SECONDS,
    MINUTES,
    HOURS,
    TIMEMODE;
    
    public TimeAConfigState nextState()
    {
        if(this == DEFAULT)
            return SECONDS;
        else if(this == SECONDS)
            return MINUTES;
        else if(this == MINUTES)
            return HOURS;
        else if(this == HOURS)
            return TIMEMODE;
        else
            return DEFAULT;
    }
    
    public static String toString(TimeAConfigState state)
    {
        switch(state)
        {
            case DEFAULT:   return "DEFAULT";
            case SECONDS:   return "SECONDS";
            case MINUTES:   return "MINUTES";
            case HOURS:     return "HOURS";
            case TIMEMODE:  return "TIMEMODE";
            default:        return "UNKNOWN";      
        }
    }
    
    @Override
    public String toString()
    {
        return toString(this);
    }
}
