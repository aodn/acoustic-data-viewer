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
	<div id="mainbody">

	  <div class="ui-layout-north" >
		<img src="images/IMOS_ANMN_Facility_6_logo.png" alt="IMOS ANMN Logo" />
		<div class="toplinks">


		  <a target="_blank" href="http://www.emii.org.au"  title="e-Marine Information Infrastructure" class="leftmenu_ahref " >eMII Home</a>
		  <a target="_blank" href="http://www.imos.org.au" title="Integrated Marine Observing System" class="leftmenu_ahref " >IMOS Home</a>
		</div>

		<h1>IMOS Acoustic Data Viewer</h1>



	  </div>
	  <div id="mainSpectrogramsContainer">

		<div id="mainSpectrograms" class="stepcarousel">

		  <div class="belt">

			<div class="panel"style="width:250px" >
			  <a href="#" onclick="handleGraphCick(event,'imageId');return false;" >
				<img id="imageId"src="http://i30.tinypic.com/531q3n.jpg" />
			  </a>
			  <div class="panelinfo">| a date</div>
			</div>
			<div class="panel" style="width:220px" >			
			  <a href="#" onclick="handleGraphCick(event,'imageId2');return false;" >
				<img id="imageId2" src="http://i29.tinypic.com/xp3hns.jpg" />
			  </a>			  
			  <div class="panelinfo">| another date</div>
			</div>		  
			<div class="panel"style="width:280px" >			
			  <a href="#" onclick="handleGraphCick(event,'imageId3');return false;" >
				<img id="imageId3" src="http://i26.tinypic.com/11l7ls0.jpg" />
			  </a>
			</div>
			<div class="panel" style="width:240px" >
			  <a href="#" onclick="handleGraphCick(event,'imageId4');return false;" >
				<img id="imageId4"src="http://i30.tinypic.com/531q3n.jpg" />
			  </a>
			</div>
			<div class="panel"style="width:235px" >			
			  <a href="#" onclick="handleGraphCick(event,'imageId5');return false;" >
				<img id="imageId5" src="http://i29.tinypic.com/xp3hns.jpg" />
			  </a>
			</div>		  
			<div class="panel" style="width:250px" >			
			  <a href="#" onclick="handleGraphCick(event,'imageId6');return false;" >
				<img id="imageId6" src="http://i26.tinypic.com/11l7ls0.jpg" />
			  </a>
			</div>

		  </div>
		</div>
	  </div>

	  <p>
		<b>Current Panel:</b> <span id="statusA"></span> <b style="margin-left: 30px">Total Panels:</b> <span id="statusC"></span>
	  </p>

	  <!--p id="mygallery-paginate" style="width: 250px; text-align:center">
		<img src="opencircle.png" data-over="graycircle.png" data-select="closedcircle.png" data-moveby="1" />
	  </p-->

	  <p>
		<a href="javascript:stepcarousel.stepBy('mainSpectrograms', -1)">Back 1 Panel</a> <a href="javascript:stepcarousel.stepBy('mainSpectrograms', 1)" style="margin-left: 80px">Forward 1 Panel</a> <br />

		<a href="javascript:stepcarousel.stepTo('mainSpectrograms', 1)">To 1st Panel</a> <a href="javascript:stepcarousel.stepBy('mainSpectrograms', 2)" style="margin-left: 80px">Forward 2 Panels</a>
	  </p>

	  <div class="footer" role="contentinfo"></div>

  </body>
</html>
