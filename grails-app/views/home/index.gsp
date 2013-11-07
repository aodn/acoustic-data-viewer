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

<div>
    <img id="logo" src="images/IMOS_ANMN_Facility_6e-AcousticObservations_logo.png" alt="IMOS ANMN Logo" width="400"/>

    <div id="floatingTitleDiv">
        <h1 id="title">IMOS Acoustic Data Viewer</h1>

        <div id="sitePicker">
            <g:select id="sitePicker" name="name" size="3" from="${deployments}" value="${deployments?.deploymentName}" optionKey="id"/>
        </div>
    </div>

    <div class="toplinks">
        <a target="_blank" href="http://portalhelp.aodn.org.au/Portal2_help/?q=node/160" title="Help using this page" class="leftmenu_ahref ">Help</a> -
        <a target="_blank" href="http://www.emii.org.au" title="e-Marine Information Infrastructure" class="leftmenu_ahref ">eMII Home</a>
        <a target="_blank" href="http://www.imos.org.au" title="Integrated Marine Observing System" class="leftmenu_ahref ">IMOS Home</a>

        <!--a target="_blank" onclick="javascript:toggleHelp(event,true);" href="#" title="Using this site" class="leftmenu_ahref " >Help</a-->
    </div>

    <div class="clear"></div>


    <div id="mainbody">
        <div id="mainspectrogramSplash" style="display:none">
            <h4>The Acoustic Data Viewer provides access to sea noise recordings from the Australian National Mooring Network (ANMN) Passive Acoustic Observatories facility.</h4>

            <h2>Choose a Site/deployment from the picker above</h2>

        </div>

        <div id="mainspectrogramContainer" style="display:none">

            <div id="mainspectrogramPicker">
                <div class="inline">Graph Picker: <a class="controls" href="javascript:stepcarousel.stepBy('mainspectrogram', -1)">
                    <img src="images/rewind.png" alt="Move back one" title="Move back one"/></a>
                </div>

                <div class="inline" id="sliderContainer">
                    <div id="slider"></div>
                </div>

                <div class="inline">
                    <a class="controls" href="javascript:stepcarousel.stepBy('mainspectrogram', 1)"><img src="images/fast_forward.png" alt="Move forward one" title="Move forward one"/>
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
                    <img src="images/rewind.png" alt="Move back one" title="Move back one time period"/></a>Adjust Time
                <a id="detailsControlForward" class="controls" href="javascript:loadDetails(+1, 'specid')">
                    <img src="images/fast_forward.png" alt="Move forward one" title="Move forward one time period"/></a>
            </div>

            <div class="detailsOptional" style="display:block;">
                <input type="hidden" name="downloadDetailsAsJSON"/>
                <button class="download" onclick="download();
                return false;">Download Data</button>
                <a target="_blank" href="http://data.aodn.org.au/IMOS/public/ANMN/Acoustic/code/">
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

    <div class="first">
        <img class="logo left" alt="DIISTRE Logo" target="_blank" src="http://static.emii.org.au/images/logo/NCRIS_Initiative_inline300.png"/>
        <a href="http://www.utas.edu.au/" target="_blank"><img class="logo left" alt="UTAS Logo" src="images/Utas_vert.png"/>
        </a>
        <a class="external" title="Creative Commons License" href="http://creativecommons.org/licenses/by/3.0/au/" target="_blank"><img src="images/by.png" width="80">
        </a>
    </div>

    <div>

        <p>This site is licensed under a <a title="Creative Commons License" href="http://creativecommons.org/licenses/by/3.0/au/" target="_blank">Creative Commons Attribution 3.0 Australia License</a> &nbsp;

        <BR/>

        <a href="http://www.imos.org.au" title="Integrated Marine Observing System">IMOS</a> is a national collaborative research infrastructure, supported by Australian Government.  It is led by the <a href="http://www.utas.edu.au/">University of Tasmania</a> in partnership with the Australian marine & climate science community.<BR/>You accept all risks and responsibility for losses, damages, costs and other consequences resulting directly or indirectly from using this site and any information or material available from it.<BR/>If you have any concerns about the veracity of the data, please make enquiries via <a href="mailto:info@emii.org.au">info@emii.org.au</a> to be directed to the data custodian.<br/>IMOS data is made freely available under the <a href="http://imos.org.au/fileadmin/user_upload/shared/IMOS%20General/documents/internal/IMOS_Policy_documents/Policy-Acknowledgement_of_use_of_IMOS_data_11Jun09.pdf" title="conditions of use">Conditions of Use.</a><br/>
        Created by <a href="http://imos.org.au/emii.html" title="eMarine Information Infrastructure">eMII</a> &nbsp;
        <a href="http://www.imos.org.au" title="Integrated Marine Observing System">&copy; IMOS Australia</a>  &nbsp;
    Comments on this site? Contact us at <a href="mailto:info@emii.org.au">info@emii.org.au</a></p>

    </div>
</div>

</body>
</html>
