package com.werken.werkflow.syntax.fundamental;

import com.werken.werkflow.action.Action;
import com.werken.werkflow.action.ActionLibrary;
import com.werken.werkflow.action.NoSuchActionException;
import com.werken.werkflow.action.DuplicateActionException;
import com.werken.werkflow.definition.MessageType;
import com.werken.werkflow.definition.MessageTypeLibrary;
import com.werken.werkflow.definition.NoSuchMessageTypeException;
import com.werken.werkflow.definition.DuplicateMessageTypeException;

public class Scope
{
    private Scope parent;
    private MessageTypeLibrary messageTypeLibrary;
    private ActionLibrary actionLibrary;

    public Scope()
    {
        this.messageTypeLibrary = new MessageTypeLibrary();
        this.actionLibrary      = new ActionLibrary();
    }

    public Scope(Scope parent)
    {
        this.parent = parent;

        this.messageTypeLibrary = new MessageTypeLibrary( parent.getMessageTypeLibrary() );
        this.actionLibrary = new ActionLibrary( parent.getActionLibrary() );
    }

    public Scope getParent()
    {
        return this.parent;
    }

    protected MessageTypeLibrary getMessageTypeLibrary()
    {
        return this.messageTypeLibrary;
    }

    protected ActionLibrary getActionLibrary()
    {
        return this.actionLibrary;
    }

    public Action getAction(String id)
        throws NoSuchActionException
    {
        return getActionLibrary().getAction( id );
    }

    public Action getDefaultAction()
    {
        return getActionLibrary().getDefaultAction();
    }

    public void setDefaultAction(Action action)
    {
        getActionLibrary().setDefaultAction( action );
    }

    public void addAction(String id,
                          Action action)
        throws DuplicateActionException
    {
        getActionLibrary().addAction( id,
                                      action );
    }

    public MessageType getMessageType(String id)
        throws NoSuchMessageTypeException
    {
        return getMessageTypeLibrary().getMessageType( id );
    }

    public void addMessageType(MessageType messageType)
        throws DuplicateMessageTypeException
    {
        getMessageTypeLibrary().addMessageType( messageType );
    }
}
