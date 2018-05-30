<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
    <ul class="nav pull-right voice-icon">
        <li>
        	<a href="javascript:void(0);" id="voice-icon">
             <span class="fa-stack fa-2x">
              <i class="fa fa-weixin fa-stack-2x" style="color: #113f7e"></i>
         	</span>
        	</a>
        </li>
    </ul>
</div>
   
<div id="overlay"></div>
<div id="popup">
   <div class="app-container">
	   <div class="app-header">
	   		<img src="${pageContext.request.contextPath}/img/VoiceBot.png"/>	   		
	   		<h1>Alice at your help
	   		<span id="closeAlice"><i class="navig-icons fa fa-window-close"></i></span>
	   		<span id="minimizeAlice"><i class="navig-icons fa fa-window-minimize"></i></span></h1>
	   </div>
	   <div class="loaderDiv">
	   	 <div class="loader"></div>
	   </div>
	   <div class="app-content">
	   	  <c:if test="${ null == aliceConversationDetails }">
	      	<div class="time-indicator"><div class="time-indicator-content"></div><hr /></div>
	      </c:if>
	      <c:if test="${ null != aliceConversationDetails }">
		      <c:forEach items="${aliceConversationDetails}" var="element"> 
		      	<c:if test="${element.messageType.equalsIgnoreCase('TIME_INDICATOR')}">
		      		<div class="time-indicator"><div class="time-indicator-content">${element.getMessage()}</div><hr /></div>
		      	</c:if> 
		      	<c:if test="${element.messageType.equalsIgnoreCase('ITEM_BOT')}">
		      		<div class="item-container item-container-bot"><div class="item"><p>${element.getMessage()}</p></div></div>
			      	</c:if>
			      	<c:if test="${element.messageType.equalsIgnoreCase('ITEM_USER')}">
			      		<div class="item-container item-container-user"><div class="item"><p>${element.getMessage()}</p></div></div>
			      	</c:if>
				  </c:forEach>
		      </c:if>
		      
		</div>
		<div class="app-footer">
		      <div class="app-footer-inner">
			      	<div class="speech">
						<input type="text" name="s" id="transcript" placeholder="Speak" />
						<span id="transcriptButton"><i class="fa fa-paper-plane" aria-hidden="true"></i></span>
					</div>
			        <div class="mic">		          
			          <div class="ready"><a href="#" id="start"><img src="${pageContext.request.contextPath}/i/mic.svg" alt="Tap me to speak" style="height: 33px;"/></a></div>
			          <div class="listening" id="stop"><span class="listening-1">.</span><span class="listening-2">.</span><span class="listening-3">.</span></div>
			        </div>		
		      </div>
		</div>
	</div>
</div>