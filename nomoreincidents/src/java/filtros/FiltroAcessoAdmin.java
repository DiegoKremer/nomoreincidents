/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filtros;

import ManagedBeans.UsuarioMB;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego Kremer
 */

@WebFilter(filterName = "FiltroAcessoAdmin", urlPatterns = {"/faces/index_admin.xhtml"})
public class FiltroAcessoAdmin implements Filter {
    
    @Inject 
    private UsuarioMB usuarioMB;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        //Obtem o request e response para utilizacao Web
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //Se o usuário estiver logado 
        if (usuarioMB != null && usuarioMB.isLogado()) {            
            //deixa acessar o recurso
            chain.doFilter(request, response);
        } else {
            //redireciona para a página de login
            //getContextPath -> Caminho da aplicação
            resp.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
        }
        
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
