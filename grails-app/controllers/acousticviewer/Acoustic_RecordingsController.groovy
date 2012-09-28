package acousticviewer
import grails.converters.JSON

class Acoustic_RecordingsController {

    def index() {
		
		def map = []
		
		if (params.containsKey('acu_specId') && params.containsKey('x_coord')) {			
			// acu_specId is the Acoustic_Spectrogram id
			
			def acoustic_SpectrogramInstance = Acoustic_Spectrograms.get(params.acu_specId)
			def acoustic_DeploymentInstance = Acoustic_Deployments.get(acoustic_SpectrogramInstance.acousticDeployFk)
			//print acoustic_DeploymentInstance.dump()
			def acoustic_recordingsList
			
			if (acoustic_SpectrogramInstance) {
				
				// findby acoustic_Spectrogram id and the pixel index
				acoustic_recordingsList = Acoustic_Recordings.findByAcousticSpecFkAndXCoord(params.acu_specId,params.x_coord)
				
				
				if (acoustic_recordingsList) {				
					print acoustic_recordingsList.dump()

					def trimmed_filename = acoustic_recordingsList.filename.trim()
					def pos = trimmed_filename.lastIndexOf('.');
					def extension = trimmed_filename.substring(pos+1)

					// path to files
					def path = acoustic_DeploymentInstance.dataPath.replaceAll('/$', "") // remove trailing slash	
					def wavPath = path + "/raw/"
					def specUrl =  path + '/recording_spec/' + trimmed_filename		
					def audioUrl = path + '/recording_wave/' + trimmed_filename
					
					/*
						raw/   for all the raw sound recordings
						deployment_spec/  for the whole-deployment spectrogram tiles to display on the viewer
						recording_spec/  with one spectrogram image for each recording
						recording_wave/  with a waveform image for each recording
					*/
					map = [ 'specUrl':specUrls ,'audioUrl':audioUrls, 'wavPath': wavPath, 'dateTime': acoustic_recordingsList.timeRecordingStart ]
				}
				
			}
			else {
				// this should never happen. Email admin?
				
			}
			render map as JSON
			
			
		}
		else {
			render text: "params not supplied", contentType: "text/html", encoding: "UTF-8", status: 500
		}
		
	}
}
