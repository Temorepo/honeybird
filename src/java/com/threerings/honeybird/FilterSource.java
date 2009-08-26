package com.threerings.honeybird;

public class FilterSource<T>
    implements Source
{
    protected FilterSource (String name)
    {
        _name = name;
    }

    public Filter eq (T value)
    {
        return expr("==", value);
    }

    public Filter neq (T value)
    {
        return expr("!=", value);
    }

    public String getName ()
    {
        return _name;
    }

    protected FilterExpression expr (String op, T value)
    {
        return new FilterExpression(this, op, value.toString());
    }

    protected final String _name;
}
