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
	<script type="text/javascript" src="${resource(dir:'js',file:'jquery.lazyload.min.js')}"></script>		
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
	  <img id="logo" src="images/IMOS_ANMN_Facility_6_logo.png" alt="IMOS ANMN Logo" width="400" />
	  <div id="floatingTitleDiv">
		<h1 id="title">IMOS Acoustic Data Viewer</h1>

		 <div id="sitePicker">
		  <g:select id="sitePicker" name="name" size="3"  
					from="${deployments}" 
					value="${deployments?.deploymentName}"
optionKey="id"
					/>
		</div>
	  </div>
	  
	  <div class="toplinks">
		<a target="_blank" href="http://www.emii.org.au"  title="e-Marine Information Infrastructure" class="leftmenu_ahref " >eMII Home</a>
		<a target="_blank" href="http://www.imos.org.au" title="Integrated Marine Observing System" class="leftmenu_ahref " >IMOS Home</a>
		<a target="_blank" onclick="javascript:toggleHelp(event,true);" href="#" title="Using this site" class="leftmenu_ahref " >Help</a>
	  </div>

	  <div class="clear"></div>

	 

	  <div id="mainbody">
		<div id="mainspectrogramSplash">
		  <h2>Using the IMOS Acoustic data viewer:</h2>
		  <ol>
			<li>Choose a Site/deployment from the picker above</li>			
			<li>You will be presented a set of spectrogram for the deployment </li>			
			<li>Clicking on a spectrogram will open below an expanded view of the time period</li>	
			<li>...</li>
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
	  <div id="detailsHeader" class="floatwrapper" >
		<div class="first"><p id="mainspectrogramClickDetails">&nbsp;</p>
		</div>
		<div id="download">download</div>
	  </div>
<div class="clear"></div>
	  <div id="details" >
		<div id="detailsaudio" style="display:none"></div>
		
		
		<div id="detailspectrogram" ></div>
		  
		</div>
		
	  </div>


	</div>
<div class="clear"></div>
	<div id="footer" class="floatwrapper" ><div class="first">
<img src="images/DIISRTE_Inline-PNGSmall_200.png"></div><div class="text" ><p>You accept all risks and responsibility for losses, damages, costs and other consequences resulting directly or indirectly from using this site and any information or material available from it. If you have any concerns about the veracity of the data, please make enquiries via <a href="mailto:info@imos.org.au">info@imos.org.au</a> to be directed to the data custodian.</p></div>

	</div>

  </body>
</html>
