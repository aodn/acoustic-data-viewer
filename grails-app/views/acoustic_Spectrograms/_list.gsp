
<g:each in="${spectrogramList}" var="item">
  <div class="panel" style="width:${item.width}px;" >
	<a href="#" onclick="handleSpectroClick(event,'${item.id}');return false;" >
	  <div style="width:${item.width}px;height:240px"   >
	  <img id="acoustic_Spectrogram-${item.id}"src="${deployment.dataPath}/${item.subdirectory}/${item.filename}"  />
	  </div>
	</a>
	<div class="panelinfo"><g:formatDate date="${item.timeStart}" format="E dd-MM-yyyy" /><BR/>
						  <g:formatDate date="${item.timeStart}" format="HH:mm z" /></div>
  </div>
</g:each>
