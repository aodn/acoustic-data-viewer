<%@ page import="acousticviewer.Anmn_Acoustic_Sites" %>



<div class="fieldcontain ${hasErrors(bean: anmn_Acoustic_SitesInstance, field: 'code', 'error')} ">
	<label for="code">
		<g:message code="anmn_Acoustic_Sites.code.label" default="Code" />
		
	</label>
	<g:textField name="code" value="${anmn_Acoustic_SitesInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: anmn_Acoustic_SitesInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="anmn_Acoustic_Sites.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${anmn_Acoustic_SitesInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: anmn_Acoustic_SitesInstance, field: 'id', 'error')} required">
	<label for="id">
		<g:message code="anmn_Acoustic_Sites.id.label" default="id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="id" type="number" value="${anmn_Acoustic_SitesInstance.id}" required=""/>
</div>

