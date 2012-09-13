
<%@ page import="acousticviewer.Acoustic_Deployments" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'acoustic_Deployments.label', default: 'Acoustic_Deployments')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css" />
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css"/>
	</head>
	<body>
		<a href="#list-acoustic_Deployments" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-acoustic_Deployments" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="curtinId" title="${message(code: 'acoustic_Deployments.curtinId.label', default: 'Curtin Id')}" />
					
						<g:sortableColumn property="dataPath" title="${message(code: 'acoustic_Deployments.dataPath.label', default: 'Data Path')}" />
					
						<g:sortableColumn property="deploymentName" title="${message(code: 'acoustic_Deployments.deploymentName.label', default: 'Deployment Name')}" />
					
						<g:sortableColumn property="isPrimary" title="${message(code: 'acoustic_Deployments.isPrimary.label', default: 'Is Primary')}" />
					
						<g:sortableColumn property="loggerId" title="${message(code: 'acoustic_Deployments.loggerId.label', default: 'Logger Id')}" />
					
						<g:sortableColumn property="siteCode" title="${message(code: 'acoustic_Deployments.siteCode.label', default: 'Site Code')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${acoustic_DeploymentsInstanceList}" status="i" var="acoustic_DeploymentsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${acoustic_DeploymentsInstance.id}">${fieldValue(bean: acoustic_DeploymentsInstance, field: "curtinId")}</g:link></td>
					
						<td>${fieldValue(bean: acoustic_DeploymentsInstance, field: "dataPath")}</td>
					
						<td>${fieldValue(bean: acoustic_DeploymentsInstance, field: "deploymentName")}</td>
					
						<td><g:formatBoolean boolean="${acoustic_DeploymentsInstance.isPrimary}" /></td>
					
						<td>${fieldValue(bean: acoustic_DeploymentsInstance, field: "loggerId")}</td>
					
						<td>${fieldValue(bean: acoustic_DeploymentsInstance, field: "siteCode")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${acoustic_DeploymentsInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
