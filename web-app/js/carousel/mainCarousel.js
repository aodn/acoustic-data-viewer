



function handleSpectroClick(e,imageId) {
	// we need to know the position of the image
	// get the first parent with the class panel
	var panelPosition = $('#'+imageId).parents('.panel').position(); //parent div of image
	var containerPosition = $("#mainSpectrograms").position();
	var imageLeftPosition = panelPosition.left + containerPosition.left
	var clickLeftPosition = e.clientX - imageLeftPosition;
	
	$('#mainSpectrogramsClickDetails').html(clickLeftPosition + " = pixels from the left of the image '" + imageId + "'");	
	e.preventDefault();
}






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
