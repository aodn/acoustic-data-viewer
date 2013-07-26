<%--

 Copyright 2013 IMOS

 The AODN/IMOS Portal is distributed under the terms of the GNU General Public License

--%>


<g:each in="${spectrogramList}" var="item">
  <div class="panel" style="width:${item.width}px;" >
	<a href="#" onclick="handleSpectroClick(event,'${item.id}');return false;" >
	  <div class="lazyWrapper" style="width:${item.width}px;height:${grailsApplication.config.specImageHeight}px"   >
	  <img class="lazy" id="acoustic_Spectrogram-${item.id}" src="images/loaderBelt.gif" data-original="${deployment.dataPath.replaceAll("/\$", "")}/${item.subdirectory}/${item.filename}"  />
	  </div>
	</a>
	<div class="panelinfo"><g:formatDate date="${item.timeStart}" format="E dd-MM-yyyy" /><BR/>
						  <g:formatDate date="${item.timeStart}" format="HH:mm z" /></div>
  </div>
</g:each>
