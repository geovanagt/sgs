/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgs.filter;

import javax.servlet.Filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FiltroSeguranca implements Filter { 
@Override
    public void init(FilterConfig config) throws ServletException {


    } 
@Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
         
            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession session = req.getSession();
             
            String urlParaAutenticar = req.getServletPath();    
            // retorna null caso não esteja logado
            String userLogado = (String) session.getAttribute("sessaoUsuario");
             
            if (userLogado == null && !urlParaAutenticar.
                    equalsIgnoreCase("/login.html")){ // usuário não logado
                RequestDispatcher dispatcher = request.
                        getRequestDispatcher("/login.html");
                dispatcher.forward(request, response);
                return;// para o processo para redirecionar
            }
         
            // executa as ações do request e response
            chain.doFilter(request, response);
         
    }
@Override
    public void destroy() {


          }

    }