package com.werken.werkflow.definition.fundamental;

import com.werken.werkflow.definition.petri.DefaultNet;

import org.apache.commons.jelly.XMLOutput;

public class OutputTag
    extends FundamentalTagSupport
{
    private String to;

    public OutputTag()
    {

    }

    public void setTo(String to)
    {
        this.to = to;
    }

    public String getTo()
    {
        return this.to;
    }

    public void doTag(XMLOutput output)
        throws Exception
    {

        ProcessTag process = (ProcessTag) requiredAncestor( "process",
                                                            ProcessTag.class );
        
        TransitionTag transition = (TransitionTag) requiredAncestor( "transition",
                                                                     TransitionTag.class );
        
        requireStringAttribute( "to",
                                getTo() );

        DefaultNet net = process.getNet();

        net.connectTransitionToPlace( transition.getId(),
                                      getTo() );

        invokeBody( output );
    }
}
