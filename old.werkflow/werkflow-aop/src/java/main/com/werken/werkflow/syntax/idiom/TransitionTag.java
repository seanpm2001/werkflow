package com.werken.werkflow.syntax.idiom;

import com.werken.werkflow.definition.petri.IdiomDefinition;
import com.werken.werkflow.definition.petri.TransitionDefinition;

import org.apache.commons.jelly.XMLOutput;
import org.apache.commons.jelly.JellyTagException;

public class TransitionTag
    extends IdiomTagSupport
{
    private String id;
    private String action;
    private String waiter;
    private String documentation;

    public TransitionTag()
    {
        // intentionally left blank
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public String getAction()
    {
        return this.action;
    }

    public void setWaiter(String waiter)
    {
        this.waiter = waiter;
    }

    public String getWaiter()
    {
        return this.waiter;
    }

    public void setDocumentation(String documentation)
    {
        this.documentation = documentation;
    }

    public String getDocumentation()
    {
        return this.documentation;
    }

    public void doTag(XMLOutput output)
        throws JellyTagException
    {
        IdiomDefinition idiomDef = getCurrentIdiomDefinition();

        requireStringAttribute( "id",
                                getId() );

        invokeBody( output );

        TransitionDefinition transition = new TransitionDefinition( getId(),
                                                                    getDocumentation() );

        transition.setWaiter( getWaiter() );
        transition.setAction( getAction() );

        idiomDef.addTransition( transition );
    }
}
