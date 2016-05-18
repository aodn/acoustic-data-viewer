


jQuery(document).ready(function () {

	// stop images being draggable inside the carousel in particular
	jQuery(document).on("mousedown", "img", function(event){ 		
		event.preventDefault();		
	});

    // setup fancy picker
	jQuery('#sitePicker').ddslick({
		width: 350,
		selectText: "  - Choose a Deployment - ",
		onSelected: function(x){
			if (x.selectedData.value != "") {
				toggleHelp();
				stepcarousel.loadcontent('mainspectrogram','acoustic_Spectrograms/list?deployment=' + x.selectedData.value);					
			}
			hideDetails();
		}   
	});
});

stepcarousel.setup({
	galleryid: 'mainspectrogram', //id of carousel DIV
	beltclass: 'belt', //class of inner "belt" DIV containing all the panel DIVs
	panelclass: 'panel', //class of panel DIVs each holding content
	panelbehavior: {
		speed:300, 
		wraparound:false, 
		persist:false
	},
	defaultbuttons: {
		enable: false, 
		moveby: 1, 
		leftnav: ['images/rewind.png', -50, -70], 
		rightnav: ['images/fast_forward.png', -90, -70]
	},
	statusvars: ['statusA', 'statusB', 'statusC'], // Register 3 "status" variables
	contenttype: ['ajax','acoustic_Spectrograms/list?deployment=init']
	,
	onpanelclick:function(){
	// easier to call the function with supplied parameters
	//console.log()
	},
	onslide:function(){
		// update mainspectrogram_clickDetails with start date?
		//console.log('get time at this point');
		//callresizeViewport();
		jQuery(window).trigger('resize');
	},
	
	oninit:function(){
		// oninit is for reloads as well
		loadCarouselSlider();
		lazyload('.lazyWrapper');
	}
});

function callresizeViewport() {
	var evt = document.createEvent('UIEvents');
	evt.initUIEvent('resize', true, false,window,0);
	window.dispatchEvent(evt);
}

function lazyload(parentSelector) {
	
	// lazy load of all images with class lazy.
	// images require a data-original="realimage.png" attribute
	jQuery(parentSelector + ' img.lazy').lazyload({
		effect: "fadeIn",
		skip_invisible: false
	});
}


function loadCarouselSlider() {
	
	// count the amount of panels
	var panels = jQuery('#mainspectrogram .panel').length;
	jQuery('#slider').slider("destroy");
	jQuery('#slider').slider({
		animate: 'normal',
		min: 1,
		max: panels,
		stop: function(event, ui) {
			var val = jQuery(this).slider( "value" );
			stepcarousel.moveTo('mainspectrogram', val);	
		}
	});
}


function toggleHelp(e,show) {
	if (show != undefined) {
		jQuery('#mainspectrogramSplash').show();
		jQuery('#mainspectrogramContainer').hide();
	}
	else {
		jQuery('#mainspectrogramSplash').hide();
		jQuery('#mainspectrogramContainer').show();
	}
}

function loadDetails(clickLeftPosition,spectrogramId) {	
	
	
	jQuery.ajax({
		type: "POST",
		url: "acoustic_Recordings",
		data: {
			acu_specId: spectrogramId, 
			x_coord: clickLeftPosition
		},
		dataType: "json",
		success: function(msg) { 

            // only test spec. audio is optional
			if (msg.specPath) {
				
				jQuery('#errorDetails').hide();
				
				jQuery('#mainspectrogramClickDetails').html( "Detailed information for <b>'" + msg.dateTime + "'</b>");				
				loadDetailControls(clickLeftPosition,spectrogramId);
				
				jQuery('#detailspectrogram').html('<img class="lazy" height="' + specDetailedImageHeight +'" src="' + msg.baseUrl + msg.specPath + '" />');
				jQuery('#detailsAudioImage').html('<img class="lazy" height="' + specDetailedImageHeight +'" src="' + msg.baseUrl + msg.audioPath + '" />');
				
				
				jQuery('.detailsOptional, #detailsHeader').show(); // options when details are sucessfully loaded
				jQuery('input:hidden[name=downloadDetailsAsJSON]').val(jQuery.param(msg));
					
			}
			else {
				// This should never happen.
				jQuery('#errorDetails').show();
				hideDetails();
			}
			
			
			
		}
	});
}

function hideDetails() {
	jQuery('#errorDetails').hide();
	jQuery('.detailsOptional, #detailsHeader').hide(); 
}

function download() {	 
	location =  "download/?" + jQuery('input:hidden[name=downloadDetailsAsJSON]').val();		
}



function loadDetailControls(clickLeftPosition,spectrogramId) {
	// handle errors in loadDetails
	var pos = parseInt(clickLeftPosition);
	jQuery('#detailsControlBack').attr('href',"javascript:loadDetails(" + (pos -1) + ", '" + spectrogramId + "')");	
	jQuery('#detailsControlForward').attr('href',"javascript:loadDetails(" + (pos +1) + ", '" + spectrogramId + "')");
	
}


function handleSpectroClick(e,spectrogramId) {

	// we need to know the position of the image
	// get the first parent with the class panel
	var containerPosition = jQuery("#mainspectrogram").position();
	var beltPosition = jQuery('#acoustic_Spectrogram-'+spectrogramId).parents('.belt').position(); //parent div of panel divs	
	var panelPosition = jQuery('#acoustic_Spectrogram-'+spectrogramId).parents('.panel').position(); //parent div of image
	var imageLeftPosition = panelPosition.left + containerPosition.left + beltPosition.left;
	var clickLeftPosition = e.clientX - imageLeftPosition;	
	
	loadDetails(clickLeftPosition,spectrogramId);
	
	//e.preventDefault(); causes IE bug
	return false;
}




