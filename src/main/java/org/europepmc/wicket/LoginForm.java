package org.europepmc.wicket;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

public class LoginForm extends Form<LoginForm> {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    public LoginForm(String id) {
        super(id);
        setDefaultModel(new CompoundPropertyModel<LoginForm>(this));
        add(new TextField<String>("username").setRequired(true));
        add(new PasswordTextField("password"));
    }

    public final void onSubmit() {
        if (username.equals("test") && password.equals("test"))
            info("Congratulations!");
        else
            error("Wrong username or password!");
    }
}