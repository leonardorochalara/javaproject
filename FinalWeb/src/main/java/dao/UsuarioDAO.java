package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuario;

public class UsuarioDAO {
	public Usuario validarLogin(Usuario usuario) {
		Connection cnx = Dao.getConexao();
		Usuario u = new Usuario();
		
		String sql = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";
		
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getSenha());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u.setId(rs.getInt("id"));
				u.setUsuario(rs.getString("usuario"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				u.setEmail(rs.getString("email"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
}
