
<%@ page import="acousticviewer.Anmn_Acoustic_Sites" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'anmn_Acoustic_Sites.label', default: 'Anmn_Acoustic_Sites')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-anmn_Acoustic_Sites" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-anmn_Acoustic_Sites" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list anmn_Acoustic_Sites">
			
				<g:if test="${anmn_Acoustic_SitesInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="anmn_Acoustic_Sites.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${anmn_Acoustic_SitesInstance}" field="code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${anmn_Acoustic_SitesInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="anmn_Acoustic_Sites.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${anmn_Acoustic_SitesInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${anmn_Acoustic_SitesInstance?.id}">
				<li class="fieldcontain">
					<span id="id-label" class="property-label"><g:message code="anmn_Acoustic_Sites.id.label" default="id" /></span>
					
						<span class="property-value" aria-labelledby="id-label"><g:fieldValue bean="${anmn_Acoustic_SitesInstance}" field="id"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${anmn_Acoustic_SitesInstance?.id}" />
					<g:link class="edit" action="edit" id="${anmn_Acoustic_SitesInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
