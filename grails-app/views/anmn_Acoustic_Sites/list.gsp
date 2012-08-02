
<%@ page import="acousticviewer.Anmn_Acoustic_Sites" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'anmn_Acoustic_Sites.label', default: 'Anmn_Acoustic_Sites')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-anmn_Acoustic_Sites" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-anmn_Acoustic_Sites" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="code" title="${message(code: 'anmn_Acoustic_Sites.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'anmn_Acoustic_Sites.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="id" title="${message(code: 'anmn_Acoustic_Sites.id.label', default: 'id')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${anmn_Acoustic_SitesInstanceList}" status="i" var="anmn_Acoustic_SitesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${anmn_Acoustic_SitesInstance.id}">${fieldValue(bean: anmn_Acoustic_SitesInstance, field: "code")}</g:link></td>
					
						<td>${fieldValue(bean: anmn_Acoustic_SitesInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: anmn_Acoustic_SitesInstance, field: "id")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${anmn_Acoustic_SitesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
