
	


$(document).ready(function () {
	
	
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
	
	// stop images being draggable inside the carousel in particular
	$(document).on("mousedown", "img", function(event){ 		
		event.preventDefault();		
	});


	$('#sitePicker').ddslick({
		width: 350,
		selectText: "  - Choose a Site - ",
		onSelected: function(x){
			if (x.selectedData.value != "") {
				stepcarousel.loadcontent('mainspectrogram','acoustic_Spectrograms/list?deployment=' + x.selectedData.value);
				toggleHelp();

			}			
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
	},
	oninit:function(){
	//custom code here
	}
});

function toggleHelp(e,show) {
	if (show) {
		$('#mainspectrogramSplash').show();
		$('#mainspectrogramContainer').hide();
	}
	else {
		$('#mainspectrogramSplash').hide();
		$('#mainspectrogramContainer').show();
	}
	if (e != undefined) {
		e.preventDefault();
	}
	
}

function load_detailsaudio(clickLeftPosition,spectrogramId) {
	$.ajax({
		type: "POST",
		url: "acoustic_Recordings",
		data: {acu_specId: spectrogramId, x_coord: clickLeftPosition},
		//contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(msg) { 
			
			// Insert the returned image HTML into the <div>
			// There should only be one which is the spectrogram for this time period? Throw an a little error?
			$('#detailspectrogram img').attr("src", msg.specUrls[0]);
			
		}
	});
}



function handleSpectroClick(e,spectrogramId) {

	// we need to know the position of the image
	// get the first parent with the class panel
	var containerPosition = $("#mainspectrogram").position();
	var beltPosition = $('#acoustic_Spectrogram-'+spectrogramId).parents('.belt').position(); //parent div of panel divs	
	var panelPosition = $('#acoustic_Spectrogram-'+spectrogramId).parents('.panel').position(); //parent div of image
	var imageLeftPosition = panelPosition.left + containerPosition.left + beltPosition.left;
	var clickLeftPosition = e.clientX - imageLeftPosition;	
	
	
	$('#mainspectrogramClickDetails').html( "<BR>" + clickLeftPosition + " = pixels from the left of the image '" + spectrogramId + "'");	
	load_detailsaudio(clickLeftPosition,spectrogramId);
	
	
	e.preventDefault();
}




