package reader.criteria;

public class AtLeastOne implements Criterion{
    
    private final Criterion[] criteria;
    
    public AtLeastOne(Criterion... criteria)
    {
        this.criteria = criteria;
    }
    
    @Override
    public boolean complies(String line)
    {
        for(Criterion c : criteria)
        {
            if(c.complies(line))
            {
                return true;
            }
        }
        return false;
    }
}