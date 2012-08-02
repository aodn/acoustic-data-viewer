
<g:each in="${spectrographsList}" var="item">
  <div class="panel" style="width:${item.width}px;" >
	<a href="#" onclick="handleSpectroClick(event,'graph${item.uid}');return false;" >
	  <img id="graph${item.uid}"src="${item.url}"  />
	</a>
	<div class="panelinfo">|  ${item.date}</div>
  </div>
</g:each>
