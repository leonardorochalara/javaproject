package servico;

import dao.UsuarioDAO;
import modelo.Usuario;

public class LoginServico {
	public boolean verificarUsuario(Usuario usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario u = dao.validarLogin(usuario);
		
		if(u.getNome() != null) {
			return true;
		} else {
			return false;
		}
	}
}
