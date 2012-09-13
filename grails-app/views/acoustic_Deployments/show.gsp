
<%@ page import="acousticviewer.Acoustic_Deployments" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'acoustic_Deployments.label', default: 'Acoustic_Deployments')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css" />
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css"/>
	</head>
	<body>
		<a href="#show-acoustic_Deployments" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-acoustic_Deployments" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list acoustic_Deployments">
			
				<g:if test="${acoustic_DeploymentsInstance?.curtinId}">
				<li class="fieldcontain">
					<span id="curtinId-label" class="property-label"><g:message code="acoustic_Deployments.curtinId.label" default="Curtin Id" /></span>
					
						<span class="property-value" aria-labelledby="curtinId-label"><g:fieldValue bean="${acoustic_DeploymentsInstance}" field="curtinId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${acoustic_DeploymentsInstance?.dataPath}">
				<li class="fieldcontain">
					<span id="dataPath-label" class="property-label"><g:message code="acoustic_Deployments.dataPath.label" default="Data Path" /></span>
					
						<span class="property-value" aria-labelledby="dataPath-label"><g:fieldValue bean="${acoustic_DeploymentsInstance}" field="dataPath"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${acoustic_DeploymentsInstance?.deploymentName}">
				<li class="fieldcontain">
					<span id="deploymentName-label" class="property-label"><g:message code="acoustic_Deployments.deploymentName.label" default="Deployment Name" /></span>
					
						<span class="property-value" aria-labelledby="deploymentName-label"><g:fieldValue bean="${acoustic_DeploymentsInstance}" field="deploymentName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${acoustic_DeploymentsInstance?.isPrimary}">
				<li class="fieldcontain">
					<span id="isPrimary-label" class="property-label"><g:message code="acoustic_Deployments.isPrimary.label" default="Is Primary" /></span>
					
						<span class="property-value" aria-labelledby="isPrimary-label"><g:formatBoolean boolean="${acoustic_DeploymentsInstance?.isPrimary}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${acoustic_DeploymentsInstance?.loggerId}">
				<li class="fieldcontain">
					<span id="loggerId-label" class="property-label"><g:message code="acoustic_Deployments.loggerId.label" default="Logger Id" /></span>
					
						<span class="property-value" aria-labelledby="loggerId-label"><g:fieldValue bean="${acoustic_DeploymentsInstance}" field="loggerId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${acoustic_DeploymentsInstance?.siteCode}">
				<li class="fieldcontain">
					<span id="siteCode-label" class="property-label"><g:message code="acoustic_Deployments.siteCode.label" default="Site Code" /></span>
					
						<span class="property-value" aria-labelledby="siteCode-label"><g:fieldValue bean="${acoustic_DeploymentsInstance}" field="siteCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${acoustic_DeploymentsInstance?.timeDeploymentEnd}">
				<li class="fieldcontain">
					<span id="timeDeploymentEnd-label" class="property-label"><g:message code="acoustic_Deployments.timeDeploymentEnd.label" default="Time Deployment End" /></span>
					
						<span class="property-value" aria-labelledby="timeDeploymentEnd-label"><g:formatDate date="${acoustic_DeploymentsInstance?.timeDeploymentEnd}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${acoustic_DeploymentsInstance?.timeDeploymentStart}">
				<li class="fieldcontain">
					<span id="timeDeploymentStart-label" class="property-label"><g:message code="acoustic_Deployments.timeDeploymentStart.label" default="Time Deployment Start" /></span>
					
						<span class="property-value" aria-labelledby="timeDeploymentStart-label"><g:formatDate date="${acoustic_DeploymentsInstance?.timeDeploymentStart}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${acoustic_DeploymentsInstance?.id}" />
					<g:link class="edit" action="edit" id="${acoustic_DeploymentsInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
