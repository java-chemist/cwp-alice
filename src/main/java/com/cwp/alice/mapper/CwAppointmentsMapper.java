/**
 * 
 */
package com.cwp.alice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cwp.alice.model.CwAppointments;

/**
 * @author lugupta
 *
 */
public class CwAppointmentsMapper implements RowMapper<CwAppointments> {

	@Override
	public CwAppointments mapRow(ResultSet rs, int rowNum) throws SQLException {

		CwAppointments cwAppointments = new CwAppointments();

		cwAppointments.setId(rs.getInt("cw_appointments_id"));
		cwAppointments.setCwId(rs.getInt("cw_id"));
		cwAppointments.setOrganizer(rs.getString("organizer"));
		cwAppointments.setSubject(rs.getString("subject"));
		cwAppointments.setLocation(rs.getString("location"));
		cwAppointments.setDate(rs.getString("start_date"));
		cwAppointments.setTime(rs.getString("start_time"));
		cwAppointments.setDuration(rs.getString("duration"));

		return cwAppointments;
	}

}