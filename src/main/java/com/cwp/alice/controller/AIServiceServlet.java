/**
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cwp.alice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.AIServiceContext;
import ai.api.AIServiceContextBuilder;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

@Service
public class AIServiceServlet implements InitializingBean {
	private static final long serialVersionUID = 1L;

	/**
	 * Api.ai access token parameter name
	 */
	public static final String PARAM_API_AI_KEY = "apiaiKey";

	private AIDataService aiDataService;

	/**
	 * @see HttpServlet#init(ServletConfig config)
	 */
	/*
	 * @Override public void init(ServletConfig config) throws ServletException {
	 * super.init(config);
	 * 
	 * System.out.println("!!! Init Called !!!"); AIConfiguration aiConfig = new
	 * AIConfiguration(config.getInitParameter(PARAM_API_AI_KEY)); aiDataService =
	 * new AIDataService(aiConfig); }
	 */

	/**
	 * Perform request to AI data service
	 * 
	 * @param aiRequest
	 *            Request object. Cannot be <code>null</code>.
	 * @param serviceContext
	 *            Service context. If <code>null</code> then default context will be
	 *            used.
	 * @return Response object
	 * @throws AIServiceException
	 *             Thrown on server access error
	 */
	protected final AIResponse request(AIRequest aiRequest, AIServiceContext serviceContext) throws AIServiceException {
		return aiDataService.request(aiRequest, serviceContext);
	}

	/**
	 * Perform request to AI data service
	 * 
	 * @param query
	 *            Request plain text string. Cannot be <code>null</code>.
	 * @param serviceContext
	 *            Service context. If <code>null</code> then default context will be
	 *            used.
	 * @return Response object
	 * @throws AIServiceException
	 *             Thrown on server access error
	 */
	protected final AIResponse request(String query, AIServiceContext serviceContext) throws AIServiceException {
		return request(new AIRequest(query), serviceContext);
	}

	/**
	 * Perform request to AI data service
	 * 
	 * @param aiRequest
	 *            Request object. Cannot be <code>null</code>.
	 * @param session
	 *            Session object. If <code>null</code> then default context will be
	 *            used.
	 * @return Response object
	 * @throws AIServiceException
	 *             Thrown on server access error
	 */
	protected final AIResponse request(AIRequest aiRequest, HttpSession session) throws AIServiceException {
		return request(aiRequest,
				(session != null) ? AIServiceContextBuilder.buildFromSessionId(session.getId()) : null);
	}

	/**
	 * Perform request to AI data service
	 * 
	 * @param query
	 *            Request plain text string. Cannot be <code>null</code>.
	 * @param session
	 *            Session object. If <code>null</code> then default context will be
	 *            used.
	 * @return Response object
	 * @throws AIServiceException
	 *             Thrown on server access error
	 */
	protected final AIResponse request(String query, HttpSession session) throws AIServiceException {
		return request(new AIRequest(query),
				(session != null) ? AIServiceContextBuilder.buildFromSessionId(session.getId()) : null);
	}

	/**
	 * Perform request to AI data service
	 * 
	 * @param aiRequest
	 *            Request object. Cannot be <code>null</code>.
	 * @param sessionId
	 *            Session string id. If <code>null</code> then default context will
	 *            be used.
	 * @return Response object
	 * @throws AIServiceException
	 *             Thrown on server access error
	 */
	protected final AIResponse request(AIRequest aiRequest, String sessionId) throws AIServiceException {
		return request(aiRequest, (sessionId != null) ? AIServiceContextBuilder.buildFromSessionId(sessionId) : null);
	}

	/**
	 * Perform request to AI data service
	 * 
	 * @param query
	 *            Request plain text string. Cannot be <code>null</code>.
	 * @param sessionId
	 *            Session string id. If <code>null</code> then default context will
	 *            be used.
	 * @return Response object
	 * @throws AIServiceException
	 *             Thrown on server access error
	 */
	protected final AIResponse request(String query, String sessionId) throws AIServiceException {
		return request(new AIRequest(query),
				(sessionId != null) ? AIServiceContextBuilder.buildFromSessionId(sessionId) : null);
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		aiDataService = new AIDataService(new AIConfiguration("5f3b8d709f2242c6bef33649d92ac580"));
	}
}
