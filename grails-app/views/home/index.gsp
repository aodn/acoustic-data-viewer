<%--

 Copyright 2013 IMOS

 The AODN/IMOS Portal is distributed under the terms of the GNU General Public License

--%>

<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>IMOS Acoustic Data Viewer</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'app.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'ddslick.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css/ui-darkness', file: 'jquery-ui-1.8.23.custom.css')}" type="text/css">
    <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery-1.7.1.min.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery-ui-1.8.23.custom.min.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'lazyLoad1.8.3.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js/carousel', file: 'stepcarousel.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'ddslick.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'application.js')}"></script>
    <script type="text/javascript">
        var specImageHeight = "${config.specImageHeight}";
        var specDetailedImageHeight = "${config.specDetailedImageHeight}";
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

<div>
    <img id="logo" src="${resource(dir: 'images', file: 'IMOS_ANMN_Facility_6e-AcousticObservations_logo.png')}" alt="IMOS ANMN Logo" width="400"/>

    <div id="floatingTitleDiv">
        <h1 id="title">IMOS Acoustic Data Viewer</h1>

        <div id="sitePicker">
            <g:select id="sitePicker" name="name" size="3" from="${deployments}" value="${deployments?.deploymentName}" optionKey="id"/>
        </div>
    </div>

    <div class="toplinks">
        <a target="_blank" href="${grailsApplication.config.helpPageUrl}" title="Help using this page" class="leftmenu_ahref ">Help</a> -
        <a target="_blank" href="http://imos.org.au/aodn.html" title="Australian Ocean Data Network (AODN)" class="leftmenu_ahref ">AODN Home</a>
        <a target="_blank" href="http://www.imos.org.au" title="Integrated Marine Observing System" class="leftmenu_ahref ">IMOS Home</a>
    </div>

    <div class="clear"></div>


    <div id="mainbody">
        <div id="mainspectrogramSplash" >
            <p>The IMOS Acoustic Data Viewer provides access to sea noise recordings from the IMOS Australian National Mooring Network (ANMN) Passive Acoustic Observatories facility.</p>

            <h2>Choose a Site/deployment from the picker above</h2>

        </div>

        <div id="mainspectrogramContainer" style="display:none">

            <div id="mainspectrogramPicker">
                <div class="inline">Graph Picker: <a class="controls" href="javascript:stepcarousel.stepBy('mainspectrogram', -1)">
                    <img src="${resource(dir: 'images', file: 'rewind.png')}" alt="Move back one" title="Move back one"/></a>
                </div>

                <div class="inline" id="sliderContainer">
                    <div id="slider"></div>
                </div>

                <div class="inline">
                    <a class="controls" href="javascript:stepcarousel.stepBy('mainspectrogram', 1)"><img src="${resource(dir: 'images', file: 'fast_forward.png')}" alt="Move forward one" title="Move forward one"/>
                    </a>
                </div>
            </div>

            <div id="mainspectrogramLegend">&nbsp;</div>

            <div id="mainspectrogram" class="stepcarousel">
                <div class="belt">
                </div>
            </div>

        </div>

        <div id="errorDetails" style="display:none;">Detailed Spectrograms and data are not available for this time period</div>

        <div id="detailsHeader" style="display:none">
            <div class="first" id="mainspectrogramClickDetails">&nbsp;</div>

            <div class="detailsOptional smaller" id="detailsControls">
                <a id="detailsControlBack" class="controls" href="javascript:loadDetails(-1, 'specid')">
                    <img src="${resource(dir: 'images', file: 'rewind.png')}" alt="Move back one" title="Move back one time period"/></a>Adjust Time
                <a id="detailsControlForward" class="controls" href="javascript:loadDetails(+1, 'specid')">
                    <img src="${resource(dir: 'images', file: 'fast_forward.png')}" alt="Move forward one" title="Move forward one time period"/></a>
            </div>

            <div class="detailsOptional" style="display:block;">
                <input type="hidden" name="downloadDetailsAsJSON"/>
                <button class="download" onclick="download();
                return false;">Download Data</button>
                <a target="_blank" href="http://data.aodn.org.au/IMOS/ANMN/Acoustic/code/NL_load_logger_data_new.m">
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

<div id="footer">

    <div class="floatLeft first">
        <img class="logo left" alt="NCRIS Logo" target="_blank" src="https://static.emii.org.au/images/logo/NCRIS_Initiative_inline200.png" height="80" />
        <a href="http://www.utas.edu.au/" target="_blank"><img class="logo left" alt="UTAS Logo" src="https://static.emii.org.au/images/logo/utas/UTAS_MONO_Stacked_208w.png" height="85" /></a>
    </div>

    <div class="floatRight second">

        <p>IMOS is a national collaborative research infrastructure, supported by Australian Government. It is operated by a consortium of institutions as an unincorporated joint venture, with the <a target="_blank" class="external" title="UTAS home page" href="http://www.utas.edu.au/">University of Tasmania</a> as Lead Agent.
        </p>
        <p>
            <a href="https://help.aodn.org.au/user-guide-introduction/aodn-portal/data-use-acknowledgement/" target="_blank" title="Data usage acknowledgement">Acknowledgement</a>
            <b>|</b>
            <a href="https://help.aodn.org.au/user-guide-introduction/aodn-portal/disclaimer/" target="_blank" title="Disclaimer information">Disclaimer</a>
        </p>

    </div>
    <br style="clear:both;"/>
</div>

</body>
</html>
