package acousticviewer

class SpectrogramsController {

    def index() { }
	
	def list() {
	
	render """
			<div class="panel" style="width:250px" >
			  <a href="#" onclick="handleSpectroClick(event,'imageId');return false;" >
				<img id="imageId"src="http://i30.tinypic.com/531q3n.jpg" />
			  </a>
			  <div class="panelinfo">| a date</div>
			</div>
			<div class="panel" style="width:220px" >			
			  <a href="#" onclick="handleSpectroClick(event,'imageId2');return false;" >
				<img id="imageId2" src="http://i29.tinypic.com/xp3hns.jpg" />
			  </a>			  
			  <div class="panelinfo">| another date</div>
			</div>		  
			<div class="panel" style="width:280px" >			
			  <a href="#" onclick="handleSpectroClick(event,'imageId3');return false;" >
				<img id="imageId3" src="http://i26.tinypic.com/11l7ls0.jpg" />
			  </a>
			</div>
			<div class="panel" style="width:240px" >
			  <a href="#" onclick="handleSpectroClick(event,'imageId4');return false;" >
				<img id="imageId4"src="http://i30.tinypic.com/531q3n.jpg" />
			  </a>
			</div>
			<div class="panel" style="width:235px" >			
			  <a href="#" onclick="handleSpectroClick(event,'imageId5');return false;" >
				<img id="imageId5" src="http://i29.tinypic.com/xp3hns.jpg" />
			  </a>
			</div>		  
			<div class="panel" style="width:250px" >			
			  <a href="#" onclick="handleSpectroClick(event,'imageId6');return false;" >
				<img id="imageId6" src="http://i26.tinypic.com/11l7ls0.jpg" />
			  </a>
			</div>	
		
		"""
	
	
	
	}
}
