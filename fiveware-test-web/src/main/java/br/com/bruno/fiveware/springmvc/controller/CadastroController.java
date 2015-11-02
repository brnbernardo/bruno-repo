package br.com.bruno.fiveware.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bruno.fiveware.dao.UsuarioDAO;
import br.com.bruno.fiveware.model.Usuario;

@Controller
@RequestMapping("/")
public class CadastroController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String carregaFormulario(ModelMap model) {
    	UsuarioVO usuarioVO = new UsuarioVO();
    	List<String> sexos = new ArrayList<String>();
		sexos.add("M");
		sexos.add("F");
    	usuarioVO.setSexos(sexos);
        model.addAttribute("usuario", usuarioVO);
        return "formulario";
    }
 
    
    @RequestMapping(value="/formulario.web", method = RequestMethod.POST)
    public @ResponseBody UsuarioVO submittedFromData(@RequestBody UsuarioVO usuarioVo, HttpServletRequest request) {
    	Usuario u = new Usuario();
    	u.setNome(usuarioVo.getNome());
    	u.setFumante(usuarioVo.isFumante());
    	u.setProfissao(usuarioVo.getProfissao());
    	u.setSexo(usuarioVo.getSexo());
    	
    	UsuarioDAO.save(u);
    	
		return usuarioVo;
	}
    
}