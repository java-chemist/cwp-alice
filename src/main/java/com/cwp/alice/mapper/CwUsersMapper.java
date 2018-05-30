/**
 * 
 */
package com.cwp.alice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cwp.alice.model.CwUsers;

/**
 * @author lugupta
 *
 */
public class CwUsersMapper implements RowMapper<CwUsers> {

	@Override
	public CwUsers mapRow(ResultSet rs, int rowNum) throws SQLException {

		CwUsers cwUsers = new CwUsers();

		cwUsers.setId(rs.getInt("cw_users_id"));
		cwUsers.setName(rs.getString("name"));
		cwUsers.setCwId(rs.getInt("cw_id"));
		cwUsers.setPassword(rs.getString("password"));
		cwUsers.setEmail(rs.getString("email"));
		cwUsers.setRole(rs.getString("role"));
		cwUsers.setDesignation(rs.getString("designation"));
		cwUsers.setDepartment(rs.getString("department"));
		cwUsers.setSessionId(rs.getString("sessionId"));

		return cwUsers;
	}

}