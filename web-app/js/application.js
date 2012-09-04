$(document).ready(function () {

	// stop images being draggable inside the carousel in particular
	$(document).on("mousedown", "img", function(event){ console.log("yep");event.preventDefault(); });
	//$(".panel").delegate('img', 'dragstart', function (event) { console.log("yep");event.preventDefault(); });


	$('#sitePicker').ddslick({
		width: 350,
		selectText: "  - Choose a Site - ",
		onSelected: function(x){
			if (x.selectedData.value != "") {
				stepcarousel.loadcontent('mainspectrogram','spectrogram/list?deployment=' + x.selectedData.value);
				toggleHelp();

			}
			
		}   
	});
 	

	
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
	contenttype: ['ajax','spectrogram/list?sites=all']
	,

	onslide:function(){
	// update mainspectrogram_clickDetails with start date?
	},
	oninit:function(){
	//custom code here
	}
});


//stepcarousel.loadcontent('mygallery', 'external2.htm');
	
if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}



function handleSpectroClick(e,imageId) {
	// we need to know the position of the image
	// get the first parent with the class panel
	var containerPosition = $("#mainspectrogram").position();
	var beltPosition = $('#'+imageId).parents('.belt').position(); //parent div of panel divs	
	var panelPosition = $('#'+imageId).parents('.panel').position(); //parent div of image
	var imageLeftPosition = panelPosition.left + containerPosition.left + beltPosition.left;
	var clickLeftPosition = e.clientX - imageLeftPosition;	
	
	var res = ""; //beltposition left = " +  beltPosition.left + "<BR>";
	//res += "panelposition left = " + panelPosition.left;	
	//res += "<BR>mainspectrogram left: " + containerPosition.left;
	//res += "<BR>imageLeftPosition: " + imageLeftPosition;
	//res += "<BR>clickLeftPosition: " + e.clientX + " - " + imageLeftPosition;
	
	$('#mainspectrogramClickDetails').html( res + "<BR>" + clickLeftPosition + " = pixels from the left of the image '" + imageId + "'");	
	e.preventDefault();
}


