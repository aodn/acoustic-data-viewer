<!doctype html>
<html>
  <head>
	<meta name="layout" content="main"/>
	<title>IMOS Acoustic Data Viewer</title>
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'app.css')}" type="text/css">
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'ddslick.css')}" type="text/css">
	<script type="text/javascript" src="${resource(dir:'js',file:'jquery-1.7.1.min.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js/carousel',file:'stepcarousel.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js',file:'ddslick.js')}"></script>
	<!--[if gte IE 9]>
	  <style type="text/css">
		.gradient {
		   filter: none;
		}
	  </style>
	<![endif]-->
  </head>
  <body>


	<div class="ui-layout-north" >
	  <img id="logo" src="images/IMOS_ANMN_Facility_6_logo.png" alt="IMOS ANMN Logo" width="400" />
	  <div id="floatingTitleDiv">
		<h1 id="title">IMOS Acoustic Data Viewer</h1>
		 <div id="sitePicker">

		  <g:select id="sitePicker" name="name" size="3"
					from="${sites}"
					value="${sites?.name}"
					optionKey="id"
					optionValue="name"				  
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
		
		<div id="mainSpectrographsSplash">
		  <h2>Using the IMOS Acoustic data viewer:</h2>
		  <ol>
			<li>Choose a Site/deployment from the picker above</li>			
			<li>You will be presented a set of Spectrographs for the deployment </li>			
			<li>Clicking on a Spectrograph will open below an expanded view of the time period</li>	
			<li>...</li>
		  </ol>
		  
		</div>
		<div id="mainSpectrographsContainer" style="display:none">



		  <div id="mainSpectrographsPicker" >Graph Picker: <a class="controls" href="javascript:stepcarousel.stepBy('mainSpectrographs', -1)"><img src="images/rewind.png" alt="Move back one" title="Move back one" /></a>
			<span id="mainSpectrographs-paginate" >
			  <img src="images/chart_unselected.png" data-over="images/chart_over.png" data-select="images/chart_selected_white.png" data-moveby="1" />
			</span>	 
			<a class="controls" href="javascript:stepcarousel.stepBy('mainSpectrographs', 1)" ><img src="images/fast_forward.png"  alt="Move forward one"  title="Move forward one" /></a> 
		  </div>

		<div id="mainSpectrographsLegend">&nbsp;</div>
		<div id="mainSpectrographs" class="stepcarousel">
		  <div class="belt">
		  </div>
		</div>

	  </div>

	  <p id="mainSpectrographsClickDetails">&nbsp;</p>
	  <div id="details" >
		<div id="detailSpectrograph" style="display:none">
		  
		</div>
		
	  </div>


	</div>
	<div class="footer" role="contentinfo"></div>

  </body>
</html>
