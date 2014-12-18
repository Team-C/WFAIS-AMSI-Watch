package enums;

/*______________________________________________________________________________

WARNING: Zmień ktoś formatowanie to uduszę :)

Author: Wit
 _____________________________________________________________________________*/

public enum DateConfigState
{
    DEFAULT,
    DAY,
    MONTH;
    
    public DateConfigState nextState()
    {
        if(this == DEFAULT)
            return DAY;
        else if(this == DAY)
            return MONTH;
        else
            return DEFAULT;
    }
    
    public static String toString(DateConfigState state)
    {
        switch(state)
        {
            case DEFAULT:   return "DEFAULT";
            case DAY:       return "DAY";
            case MONTH:     return "MONTH";
            default:        return "UNKNOWN";      
        }
    }
    
    @Override
    public String toString()
    {
        return toString(this);
    }

}
