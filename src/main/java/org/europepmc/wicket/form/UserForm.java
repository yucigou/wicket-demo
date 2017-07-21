package org.europepmc.wicket.form;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

public class UserForm extends Form<UserFormData> {
    private static final long serialVersionUID = 1L;
    private UserFormData userFormData;

    private void initUserForm() {
        if (userFormData != null) {
            return;
        }
        
        userFormData = new UserFormData();
    }
    
    public UserForm(String id) {
        super(id);
        
        initUserForm();
        
        setDefaultModel(new CompoundPropertyModel<UserFormData>(userFormData));
        add(new TextField<String>("username").setRequired(true));
        add(new PasswordTextField("password"));
    }

    public final void onSubmit() {
        if (userFormData.getUsername().equals("test") && userFormData.getPassword().equals("test"))
            info("Congratulations!");
        else
            error("Wrong username or password!");
    }
}
