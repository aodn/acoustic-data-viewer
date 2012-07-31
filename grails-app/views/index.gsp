<!doctype html>
<html>
  <head>
	<meta name="layout" content="main"/>
	<title>IMOS Acoustic Data Viewer</title>
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'app.css')}" type="text/css">
	<script type="text/javascript" src="${resource(dir:'js',file:'jquery-1.7.1.min.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js/carousel',file:'stepcarousel.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js/carousel',file:'mainCarousel.js')}"></script>

  </head>
  <body>
	

	  <div class="ui-layout-north" >
		<img src="images/IMOS_ANMN_Facility_6_logo.png" alt="IMOS ANMN Logo" />
		<div class="toplinks">


		  <a target="_blank" href="http://www.emii.org.au"  title="e-Marine Information Infrastructure" class="leftmenu_ahref " >eMII Home</a>
		  <a target="_blank" href="http://www.imos.org.au" title="Integrated Marine Observing System" class="leftmenu_ahref " >IMOS Home</a>
		</div>

		<h1 class="title">IMOS Acoustic Data Viewer</h1>



	  </div>
	<div id="mainbody">
	  <div id="mainSpectrogramsContainer">

		<div id="mainSpectrograms" class="stepcarousel">

		  <div class="belt">

		  </div>
		</div>
		
	  </div>

	  <p id="mainSpectrogramsClickDetails">&nbsp;
		
	  </p>
	  
 <p>Picker: <a class="controls" href="javascript:stepcarousel.stepBy('mainSpectrograms', -1)"><img src="images/rewind.png" alt="Move back one" title="Move back one" /></a>
	  <span id="mainSpectrograms-paginate"  text-align:center">
		<img src="images/chart_unselected.png" data-over="images/chart_over.png" data-select="images/chart_selected.png" data-moveby="1" />
	  </span>	 
		 <a class="controls" href="javascript:stepcarousel.stepBy('mainSpectrograms', 1)" ><img src="images/fast_forward.png"  alt="Move forward one"  title="Move forward one" /></a> 
	  </p>
	</div>
	  <div class="footer" role="contentinfo"></div>

  </body>
</html>
