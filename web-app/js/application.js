$(document).ready(function () {


 	

	
});

	
	
stepcarousel.setup({
	galleryid: 'mainSpectrograms', //id of carousel DIV
	beltclass: 'belt', //class of inner "belt" DIV containing all the panel DIVs
	panelclass: 'panel', //class of panel DIVs each holding content
	panelbehavior: {
		speed:300, 
		wraparound:false, 
		persist:false
	},
	defaultbuttons: {
		enable: true, 
		moveby: 1, 
		leftnav: ['images/rewind.png', -30, -70], 
		rightnav: ['images/fast_forward.png', -60, -70]
	},
	statusvars: ['statusA', 'statusB', 'statusC'], // Register 3 "status" variables
	contenttype: ['ajax','spectrograms/list']
	,

	onslide:function(){
	// update mainSpectrograms_clickDetails with start date?
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



