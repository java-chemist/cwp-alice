/**
 * 
 */
package com.cwp.alice.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.cwp.alice.constants.GenericConstants;
import com.cwp.alice.dao.CaseWorkerPortalDAO;
import com.cwp.alice.exception.GlobalException;
import com.cwp.alice.mapper.CwAppointmentsMapper;
import com.cwp.alice.mapper.CwCasesMapper;
import com.cwp.alice.mapper.CwUsersMapper;
import com.cwp.alice.model.CwAppointments;
import com.cwp.alice.model.CwCases;
import com.cwp.alice.model.CwUsers;

/**
 * @author lugupta
 *
 */
@Repository
public class CaseWorkerPortalDAOImpl implements CaseWorkerPortalDAO {

	private static final Logger logger = Logger.getLogger(CaseWorkerPortalDAOImpl.class);
	public static final Logger errorLogger = Logger.getLogger(GenericConstants.LOGGER_ERROR_NAME);

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public CwUsers findCaseWorkerById(Integer cwId) throws GlobalException {
		Map<String, Object> params = new HashMap<>();
		params.put("cwId", cwId);
		String sql = "SELECT * FROM cw_users WHERE cw_id=:cwId";
		CwUsers cwUsersObj = null;

		try {
			cwUsersObj = namedParameterJdbcTemplate.queryForObject(sql, params, new CwUsersMapper());
		} catch (EmptyResultDataAccessException e) {
			errorLogger.error("No Case Worker found with this id: " + e);
			logger.error(e);
			return null;
		}

		return cwUsersObj;
	}

	@Override
	public List<CwCases> getAllCases() throws GlobalException {
		String sql = "SELECT * FROM cw_cases";
		return namedParameterJdbcTemplate.query(sql, new CwCasesMapper());
	}

	@Override
	public CwCases getCaseByCaseId(Integer caseId) throws GlobalException {
		Map<String, Object> params = new HashMap<>();
		params.put("caseId", caseId);
		String sql = "SELECT * FROM cw_cases WHERE cw_cases_id=:caseId";
		CwCases cwCasesObj = null;

		try {
			cwCasesObj = namedParameterJdbcTemplate.queryForObject(sql, params, new CwCasesMapper());
		} catch (EmptyResultDataAccessException e) {
			errorLogger.error("No Case(s) found with this id: " + e);
			logger.error(e);
			return null;
		}

		return cwCasesObj;
	}

	@Override
	public void saveCase(CwCases cwCase) throws GlobalException {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		String sql = "INSERT INTO cw_cases (cw_id, start_date, description, status, cw_assigned_name) "
				+ "VALUES ( :cwId, :date, :desc, :status, :assignedCwName)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(cwCase), keyHolder);
		cwCase.setId(keyHolder.getKey().intValue());
	}

	@Override
	public void updateCase(CwCases cwCase) throws GlobalException {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		String sql = "UPDATE cw_cases SET start_date=:date, description=:desc, status=:status, "
				+ "cw_assigned_name=:assignedCwName WHERE cw_cases_id=:id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(cwCase), keyHolder);
	}

	@Override
	public List<CwAppointments> getCwAppointments(Integer cwId) throws GlobalException {
		String sql = "SELECT * FROM cw_appointments where cw_id =" + cwId;
		return namedParameterJdbcTemplate.query(sql, new CwAppointmentsMapper());
	}

	private SqlParameterSource getSqlParameterByModel(CwCases cwCases) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		paramSource.addValue("id", cwCases.getId());
		paramSource.addValue("cwId", cwCases.getCwId());
		paramSource.addValue("date", cwCases.getDate());
		paramSource.addValue("desc", cwCases.getDesc());
		paramSource.addValue("status", cwCases.getStatus());
		paramSource.addValue("assignedCwName", cwCases.getAssignedCwName());

		return paramSource;
	}

	@Override
	public void updateUser(CwUsers cwUsers) throws GlobalException {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		String sql = "UPDATE cw_users SET name=:name, email=:email, role=:role, designation=:designation, department=:department, sessionId=:sessionId WHERE cw_id=:cwId";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByCwUserModel(cwUsers), keyHolder);
	}

	private SqlParameterSource getSqlParameterByCwUserModel(CwUsers cwUsers) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		paramSource.addValue("cwId", cwUsers.getCwId());
		paramSource.addValue("name", cwUsers.getName());
		paramSource.addValue("email", cwUsers.getEmail());
		paramSource.addValue("role", cwUsers.getRole());
		paramSource.addValue("designation", cwUsers.getDesignation());
		paramSource.addValue("department", cwUsers.getDepartment());
		paramSource.addValue("sessionId", cwUsers.getSessionId());

		return paramSource;
	}
}
