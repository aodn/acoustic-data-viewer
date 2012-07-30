

$(document).ready(function () {
	
	//$("#mainSpectrograms").click(function(e) {
	 // console.log(e.clientX);
	 // e.preventDefault();
	//});
	
});

function handleGraphCick(e,imageId) {
	// we need to know the position of the image
	// get the first parent with the class panel
	var panelPosition = $('#'+imageId).parents('.panel').position(); //parent div of image
	var containerPosition = $("#mainSpectrograms").position();
	var imageLeftPosition = panelPosition.left + containerPosition.left
	var clickLeftPosition = e.clientX - imageLeftPosition;
	console.log(clickLeftPosition + " = pixels from the left of the image '" + imageId + "'");	
	e.preventDefault();
}


stepcarousel.setup({
	galleryid: 'mainSpectrograms', //id of carousel DIV
	beltclass: 'belt', //class of inner "belt" DIV containing all the panel DIVs
	panelclass: 'panel', //class of panel DIVs each holding content
	panelbehavior: {speed:300, wraparound:true, persist:true},
	//defaultbuttons: {enable: true, moveby: 1, leftnav: ['arrowl.gif', -10, 100], rightnav: ['arrowr.gif', -10, 100]},
	defaultbuttons: {enable: false, moveby: 1, leftnav: ['arrowl.gif', -10, 100], rightnav: ['arrowr.gif', -10, 100]},
	statusvars: ['statusA', 'statusB', 'statusC'], // Register 3 "status" variables
	contenttype: ['inline']
	});
//stepcarousel.loadcontent('mygallery', 'external2.htm')



function buildBelt(json,reLoad) {

        if (json != "") {
            
            /*var html_content = "<div class=\"belt\">";
			

                html_content = html_content + "<div class=\"panel\"  id=\"auvpanel_" + rowcounter + "\" >";

                html_content = html_content + "<img src=\"" + imageURL + "\" />\n";
                html_content = html_content + "</a>\n";

                html_content = html_content + "<div class=\"panelinfo\">time here</div>"
 
                html_content = html_content + "</div>\n";
                rowcounter++;
		}
            // end div class=belt
            html_content = html_content + "</div>\n\n";                    

            
            
            var str = "<b>Viewing images for this track:</b> "  + minimum_index+ " to " + max_i+ " of " + imagesForTrack.length;                    
            jQuery('#sorted_status').html(str).show(); 

            jQuery('#mygallery').html(html_content);
            jQuery('div#mygallery').css("height","310");

            jQuery('#mygallery, #stepcarouselcontrols', '#mygallery-paginate').toggle(true);


            jQuery( '.trackSort').show(); // older - later links

  
            
            loadGallery(selected_image);

        }
        else {
            // probably a problem with all the fields or the button was visible when it shouldnt be
            alert("Javascript error: There was a problem discovering images along this track.");
        }*/
    }
}
