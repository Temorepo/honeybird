package com.threerings.honeybird;

/**
 * A double metric that returns a value in the currency configured in your Analytics account.
 */
public class CurrencyMetric extends DoubleMetric
{
    protected CurrencyMetric (String name)
    {
        super(name);
    }
}
