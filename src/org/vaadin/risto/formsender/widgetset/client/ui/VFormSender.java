package org.vaadin.risto.formsender.widgetset.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.FormElement;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;

public class VFormSender extends Widget implements Paintable {

    /** Set the CSS class name to allow styling. */
    public static final String CLASSNAME = "v-formsender";

    /** The client side widget identifier */
    protected String paintableId;

    /** Reference to the server connection object. */
    ApplicationConnection client;

    /**
     * The constructor should first call super() to initialize the component and
     * then handle any initialization relevant to Vaadin.
     */
    public VFormSender() {
        // TODO Example code is extending GWT Widget so it must set a root
        // element.
        // Change to proper element or remove if extending another widget
        setElement(Document.get().createDivElement());

        // This method call of the Paintable interface sets the component
        // style name in DOM tree
        setStyleName(CLASSNAME);
    }

    /**
     * Called whenever an update is received from the server
     */
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        // This call should be made first.
        // It handles sizes, captions, tooltips, etc. automatically.
        if (client.updateComponent(this, uidl, true)) {
            // If client.updateComponent returns true there has been no changes
            // and we
            // do not need to update anything.
            return;
        }

        // Save reference to server connection object to be able to send
        // user interaction later
        this.client = client;

        // Save the client side identifier (paintable id) for the widget
        paintableId = uidl.getId();

        if (uidl.hasAttribute("submit") && uidl.getBooleanAttribute("submit")) {

            FormElement formElement = createFormElement(uidl);

            getElement().appendChild(formElement);

            formElement.submit();

            // Document.get().removeChild(formElement);
        }
    }

    // create the form element to be submitted
    private FormElement createFormElement(UIDL uidl) {
        FormElement fe = Document.get().createFormElement();
        fe.setMethod(uidl.getStringAttribute("method"));
        fe.setAction(uidl.getStringAttribute("target"));

        for (String name : uidl.getChildUIDL(0).getAttributeNames()) {
            InputElement inputElement = Document.get()
                    .createHiddenInputElement();
            inputElement.setName(name);
            inputElement
                    .setValue(uidl.getChildUIDL(0).getStringAttribute(name));
            fe.appendChild(inputElement);
        }

        return fe;
    }
}
