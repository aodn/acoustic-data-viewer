
<g:each in="${spectrogramList}" var="item">
  <div class="panel" style="width:${item.width}px;" >
	<a href="#" onclick="handleSpectroClick(event,'${item.id}');return false;" >
	  <img id="acoustic_Spectrogram-${item.id}"src="${deployment.dataPath}/${item.filename}"  />
	</a>
	<div class="panelinfo">|  <g:formatDate date="${item.timeStart}" type="datetime" style="MEDIUM" timeStyle="SHORT" /></div>
  </div>
</g:each>
