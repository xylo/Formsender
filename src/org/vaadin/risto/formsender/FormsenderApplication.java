package org.vaadin.risto.formsender;

import java.util.Map;

import com.vaadin.Application;
import com.vaadin.terminal.ParameterHandler;
import com.vaadin.ui.Label;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;
import com.vaadin.ui.LoginForm.LoginEvent;
import com.vaadin.ui.LoginForm.LoginListener;

public class FormsenderApplication extends Application implements
        ParameterHandler {

    private static final long serialVersionUID = 8564331787044638071L;
    private Window mainWindow;

    @Override
    public void init() {
        mainWindow = new Window("Formsender Application");

        mainWindow.addParameterHandler(this);

        Panel panel = new Panel();
        panel.setWidth("500px");

        final FormSender formSender = new FormSender();

        formSender.setFormMethod(FormSender.Method.POST);
        formSender.setFormTarget("");

        LoginForm loginForm = new LoginForm();
        loginForm.addListener(new LoginListener() {

            private static final long serialVersionUID = -7672714513229340441L;

            public void onLogin(LoginEvent event) {
                formSender.addValue("name", (String) event
                        .getLoginParameter("username"));
                formSender.addValue("password", event
                        .getLoginParameter("password"));

                formSender.submit();
            }
        });

        panel.addComponent(loginForm);
        mainWindow.addComponent(panel);
        mainWindow.addComponent(formSender);

        setMainWindow(mainWindow);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vaadin.terminal.ParameterHandler#handleParameters(java.util.Map)
     */
    public void handleParameters(Map<String, String[]> parameters) {
        if (parameters.containsKey("name")
                && parameters.containsKey("password")) {
            String name = parameters.get("name")[0];
            String password = parameters.get("password")[0];

            Label label = new Label("Name: " + name + " Password: " + password);

            mainWindow.addComponent(label);
        }
    }

}
