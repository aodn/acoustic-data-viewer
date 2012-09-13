package acousticviewer
import grails.converters.JSON

class Acoustic_RecordingsController {

    def index() {
		
		def imageFormats = ['png','jpg','jpeg','gif']
		def audioFormats = ['wav','mp3']
		def specUrls = []
		def audioUrls = []
		
		if (params.containsKey('acu_specId') && params.containsKey('x_coord')) {			
			// acu_specId is the Acoustic_Spectrogram id
			
			def acoustic_SpectrogramInstance = Acoustic_Spectrograms.get(params.acu_specId)
			def acoustic_DeploymentInstance = Acoustic_Deployments.get(acoustic_SpectrogramInstance.acousticDeployFk)
			//print acoustic_DeploymentInstance.dump()
			def acoustic_recordingsList
			
			if (acoustic_SpectrogramInstance) {
				
				// findby acoustic_Spectrogram id and the pixel index
				acoustic_recordingsList = Acoustic_Recordings.findByAcousticSpecFkAndXCoord(params.acu_specId,params.x_coord)
				// path to files
				def path = acoustic_DeploymentInstance.dataPath.replaceAll('/$', "") // remove trailing slash	
				
				acoustic_recordingsList?.list()?.each() {
					// expect audio files or the (single) spectrogram of the audio file
					def trimmed_filename = it.filename.trim()
					def pos = trimmed_filename.lastIndexOf('.');
					def extension = trimmed_filename.substring(pos+1)

					//print imageFormats.class
					for (s in imageFormats) {					
						if (s.equals(extension)){
							specUrls +=  path + '/recordings/images/' + trimmed_filename						
						}
					}
					for (s in audioFormats) {							
						if (s.equals(extension)){
							audioUrls +=   path + '/recordings/audio/' + trimmed_filename
						}
					}
				}
			}
			def map = [ 'specUrls':specUrls ,'audioUrls':audioUrls]
			render map as JSON
			
			
		}
		else {
			render text: "params not supplied", contentType: "text/html", encoding: "UTF-8", status: 500
		}
		
	}
}
