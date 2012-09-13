<%@ page import="acousticviewer.Acoustic_Deployments" %>



<div class="fieldcontain ${hasErrors(bean: acoustic_DeploymentsInstance, field: 'curtinId', 'error')} required">
	<label for="curtinId">
		<g:message code="acoustic_Deployments.curtinId.label" default="Curtin Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="curtinId" type="number" value="${acoustic_DeploymentsInstance.curtinId}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: acoustic_DeploymentsInstance, field: 'dataPath', 'error')} ">
	<label for="dataPath">
		<g:message code="acoustic_Deployments.dataPath.label" default="Data Path" />
		
	</label>
	<g:textField name="dataPath" value="${acoustic_DeploymentsInstance?.dataPath}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: acoustic_DeploymentsInstance, field: 'deploymentName', 'error')} ">
	<label for="deploymentName">
		<g:message code="acoustic_Deployments.deploymentName.label" default="Deployment Name" />
		
	</label>
	<g:textField name="deploymentName" value="${acoustic_DeploymentsInstance?.deploymentName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: acoustic_DeploymentsInstance, field: 'isPrimary', 'error')} ">
	<label for="isPrimary">
		<g:message code="acoustic_Deployments.isPrimary.label" default="Is Primary" />
		
	</label>
	<g:checkBox name="isPrimary" value="${acoustic_DeploymentsInstance?.isPrimary}" />
</div>

<div class="fieldcontain ${hasErrors(bean: acoustic_DeploymentsInstance, field: 'loggerId', 'error')} ">
	<label for="loggerId">
		<g:message code="acoustic_Deployments.loggerId.label" default="Logger Id" />
		
	</label>
	<g:textField name="loggerId" value="${acoustic_DeploymentsInstance?.loggerId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: acoustic_DeploymentsInstance, field: 'siteCode', 'error')} ">
	<label for="siteCode">
		<g:message code="acoustic_Deployments.siteCode.label" default="Site Code" />
		
	</label>
	<g:textField name="siteCode" value="${acoustic_DeploymentsInstance?.siteCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: acoustic_DeploymentsInstance, field: 'timeDeploymentEnd', 'error')} required">
	<label for="timeDeploymentEnd">
		<g:message code="acoustic_Deployments.timeDeploymentEnd.label" default="Time Deployment End" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="timeDeploymentEnd" precision="day"  value="${acoustic_DeploymentsInstance?.timeDeploymentEnd}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: acoustic_DeploymentsInstance, field: 'timeDeploymentStart', 'error')} required">
	<label for="timeDeploymentStart">
		<g:message code="acoustic_Deployments.timeDeploymentStart.label" default="Time Deployment Start" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="timeDeploymentStart" precision="day"  value="${acoustic_DeploymentsInstance?.timeDeploymentStart}"  />
</div>

