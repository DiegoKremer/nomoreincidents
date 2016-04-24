/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import ManagedBeans.UsuarioMB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import models.Usuario;

/**
 *
 * @author Diego Kremer
 */
@FacesConverter(value = "usuarioConverter")
public class UsuarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        UsuarioMB UsuarioBean = context.getApplication()
                .evaluateExpressionGet(context, "#{usuarioMB}",
                        UsuarioMB.class);
        Usuario usuario = UsuarioBean.pesquisaUsuario(value);
        return usuario;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String string = null;
        if (value instanceof Usuario) {
            string = ((Usuario) value).getNome();
        }
        return string;
    }
    
}
