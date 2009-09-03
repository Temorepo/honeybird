package com.threerings.honeybird;

/**
 * A metric that returns double values between 0.0 and 1.0 representing a percentage.
 */
public class PercentageMetric extends DoubleMetric
{
    protected PercentageMetric (String name)
    {
        super(name);
    }
}
