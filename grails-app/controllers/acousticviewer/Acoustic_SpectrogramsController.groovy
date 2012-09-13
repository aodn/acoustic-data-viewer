package acousticviewer

class Acoustic_SpectrogramsController {

	
    def index() { }
	
	def list() {
		
		
		def spectrogram
		def deployment			
			
		if (params.deployment == 'init') {
			render template: "emptyStepcarouselBelt"
		}
		else {			

			spectrogram = Acoustic_Spectrograms.list(params)
			deployment = Acoustic_Deployments.get(params.deployment as int)
			def model = [
				spectrogramList: spectrogram, deployment: deployment
			]


			render template: "list", model: model	
		}
		
		
		
		
		
		
	
	
	}
}
