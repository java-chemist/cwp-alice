/**
 * 
 */
package com.cwp.alice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cwp.alice.model.CwCases;

/**
 * @author lugupta
 *
 */
public class CwCasesMapper implements RowMapper<CwCases> {

	@Override
	public CwCases mapRow(ResultSet rs, int rowNum) throws SQLException {

		CwCases cwCases = new CwCases();

		cwCases.setId(rs.getInt("cw_cases_id"));
		cwCases.setCwId(rs.getInt("cw_id"));
		cwCases.setDate(rs.getString("start_date"));
		cwCases.setDesc(rs.getString("description"));
		cwCases.setStatus(rs.getString("status"));
		cwCases.setAssignedCwName(rs.getString("cw_assigned_name"));

		return cwCases;
	}

}