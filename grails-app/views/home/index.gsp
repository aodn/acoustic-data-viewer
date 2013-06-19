<!doctype html>
<html>
  <head>
	<meta name="layout" content="main"/>
	<title>IMOS Acoustic Data Viewer</title>
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'app.css')}" type="text/css">
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'ddslick.css')}" type="text/css">
	<link rel="stylesheet" href="${resource(dir: 'css/ui-darkness', file: 'jquery-ui-1.8.23.custom.css')}" type="text/css">
	<script type="text/javascript" src="${resource(dir:'js',file:'jquery-1.7.1.min.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js',file:'jquery-ui-1.8.23.custom.min.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js',file:'lazyLoad1.8.3.js')}"></script>		
	<script type="text/javascript" src="${resource(dir:'js/carousel',file:'stepcarousel.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js',file:'ddslick.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js',file:'application.js')}"></script>
	<script type="text/javascript" >	  
			var specImageHeight = "${config.specImageHeight}"
			var specDetailedImageHeight = "${config.specDetailedImageHeight}"
	</script>
	<style type="text/css">
	  .stepcarousel {
	    height: ${config.carouselHeight}px;
	  }
	</style>
	<!--[if gte IE 9]>
	  <style type="text/css">
		.gradient {
		   filter: none;
		}
	  </style>
	<![endif]-->
  </head>
  <body>


	<div  >
	  <img id="logo" src="images/IMOS_ANMN_Facility_6e-AcousticObservations_logo.png" alt="IMOS ANMN Logo" width="400" />
	  <div id="floatingTitleDiv">
		<h1 id="title">IMOS Acoustic Data Viewer</h1>

		 <div id="sitePicker">
		  <g:select id="sitePicker" name="name" size="3"  from="${deployments}" value="${deployments?.deploymentName}"	optionKey="id"	/>
		</div>
	  </div>
	  
	  <div class="toplinks">
		<a target="_blank" href="http://www.emii.org.au"  title="e-Marine Information Infrastructure" class="leftmenu_ahref " >eMII Home</a>
		<a target="_blank" href="http://www.imos.org.au" title="Integrated Marine Observing System" class="leftmenu_ahref " >IMOS Home</a>
		<!--a target="_blank" onclick="javascript:toggleHelp(event,true);" href="#" title="Using this site" class="leftmenu_ahref " >Help</a-->
	  </div>

	  <div class="clear"></div>

	 

	  <div id="mainbody">
		<div id="mainspectrogramSplash">
		  <h2>Using the IMOS Acoustic data viewer:</h2>
		  <ol>
			<li>Choose a Site/deployment from the picker above</li>			
			<li>You will be presented a set of spectrograms for the deployment </li>			
			<li>Clicking on a spectrogram will open below an expanded view of the chosen time period</li>	
		  </ol>
		  
		</div>
		<div id="mainspectrogramContainer" style="display:none">

		  

		  <div id="mainspectrogramPicker" >
			<div class="inline">Graph Picker: <a class="controls" href="javascript:stepcarousel.stepBy('mainspectrogram', -1)">
				<img src="images/rewind.png" alt="Move back one" title="Move back one" /></a>
			</div>
			<div class="inline" id="sliderContainer">
			  <div id="slider"></div>			  
			</div>	
		  <div class="inline">
			<a class="controls" href="javascript:stepcarousel.stepBy('mainspectrogram', 1)" ><img src="images/fast_forward.png"  alt="Move forward one"  title="Move forward one" /></a> 
		  </div>
		  </div>

		<div id="mainspectrogramLegend">&nbsp;</div>
		<div id="mainspectrogram" class="stepcarousel">
		  <div class="belt" >
		  </div>
		</div>

	  </div>
	  <div id="errorDetails" style="display:none;" >Detailed Spectrograms and data are not available for this time period</div>
	  <div id="detailsHeader" style="display:none">
		<div class="first"  id="mainspectrogramClickDetails">&nbsp;</div>
		
		<div class="detailsOptional smaller" id="detailsControls"  >
			  <a  id="detailsControlBack" class="controls" href="javascript:loadDetails(-1, 'specid')">
				<img src="images/rewind.png" alt="Move back one" title="Move back one time period" /></a>Adjust Time
			  <a id="detailsControlForward" class="controls" href="javascript:loadDetails(+1, 'specid')">
				<img src="images/fast_forward.png" alt="Move forward one" title="Move forward one time period" /></a>
		</div>	
		<div class="detailsOptional"  style="display:block;" >
		  <input  type="hidden" name="downloadDetailsAsJSON" />
		  <button class="download" onclick="download();return false;" >Download Data</button>
          <a target="_blank" href="http://data.aodn.org.au/IMOS/public/ANMN/Acoustic/code/" >
                  <button>Matlab data reader</button>
          </a>
		</div>
	  </div>

	  <div class="clear"></div>

	  <div class="detailsOptional" id="details">
		<div id="detailsAudio"></div>
		<div id="detailsAudioImage"></div>
		<div id="detailspectrogram"></div>
		  
	  </div>
		
	  </div>


	</div>
<div class="clear"></div>
	<div id="footer" >

<div class="first">

	  <a href="http://www.innovation.gov.au/Section/AboutDIISR/FactSheets/Pages/NationalCollaborativeResearchInfrastructureStrategy%28NCRIS%29FactSheet.aspx">
<img alt="Close popup" class="left" src="images/DIISRTE-stacked-2012.png" /></a>
	  <a href="http://www.utas.edu.au/"><img alt="Close popup" class="left" src="images/Utas_vert.png" /></a>
	  


	</div>
	  <div>
 

		
            <p>IMOS data is made freely available under the <a href="http://imos.org.au/fileadmin/user_upload/shared/IMOS%20General/documents/internal/IMOS_Policy_documents/Policy-Acknowledgement_of_use_of_IMOS_data_11Jun09.pdf" title="Conditions of Use">Conditions of Use</a>. Both IMOS data and this site are licensed under a <a class="external" title="Creative Commons License" href="http://creativecommons.org/licenses/by/2.5/au/" target="_blank"><span>Creative Commons Attribution 2.5 Australia License</span></a> <a class="external" title="Creative Commons License" href="http://creativecommons.org/licenses/by/2.5/au/" target="_blank"><img src="images/by.png" width="65"></a><br/>You accept all risks and responsibility for losses, damages, costs and other consequences resulting directly or indirectly from using this site and any information or material available from it. If you have any concerns about the veracity of the data, please make enquiries via <a href="mailto:info@emii.org.au">info@emii.org.au</a> to be directed to the data custodian.IMOS is supported by the Australian Government through the National Collaborative Research Infrastructure Strategy and the Super Science Initiative. It is led by the University of Tasmania on behalf of the Australian marine &amp; climate science community.</p>
        
	  </div>
    </div>

  </body>
</html>
