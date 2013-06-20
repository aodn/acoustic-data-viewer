package acousticviewer
import grails.converters.JSON

class Acoustic_RecordingsController {

    def index() {
		
		def map = []
		
		if (params.containsKey('acu_specId') && params.containsKey('x_coord')) {
			// acu_specId is the Acoustic_Spectrogram id
			//print params
			def acoustic_SpectrogramInstance = Acoustic_Spectrograms.get(params.acu_specId)
			def acoustic_DeploymentInstance = Acoustic_Deployments.get(acoustic_SpectrogramInstance.acousticDeployFk)
			//print acoustic_DeploymentInstance.dump()
			def acoustic_recordingsList
			
			if (acoustic_SpectrogramInstance) {
				
				// findby acoustic_Spectrogram id and the pixel index
				acoustic_recordingsList = Acoustic_Recordings.findByAcousticSpecFkAndXCoord(params.acu_specId,params.x_coord)				
				
				if (acoustic_recordingsList) {			

					def trimmed_filename = acoustic_recordingsList.filename.trim()
					def pos = trimmed_filename.lastIndexOf('.');
					
					def downloadFolderDescripter = acoustic_DeploymentInstance.siteCode + "-" + acoustic_DeploymentInstance.curtinId
					
					// path to files
					def baseUrl = acoustic_DeploymentInstance.dataPath.replaceAll('/$', "") // remove trailing slash
					def path = "/" + acoustic_SpectrogramInstance.subdirectory.replaceAll('/$', "")


                    def calibrationFilename = "t" + acoustic_DeploymentInstance.curtinId + "_calibration_data.mat"
                    def calibrationPath = "/extras/" + calibrationFilename
					
					def dataFilename = trimmed_filename + grailsApplication.config.dataExtension
					def dataPath = path + "/raw/" + dataFilename
					def specFilename = trimmed_filename + "SP.png"
					def specPath =  path + '/recording_spec/' + specFilename
					def audioFilename =  trimmed_filename + "WF.png"
					def audioPath = path + '/recording_wave/' + audioFilename
					
					/*
						raw/   for all the raw sound recordings
						deployment_spec/  for the whole-deployment spectrogram tiles to display on the viewer
						recording_spec/  with one spectrogram image for each recording
						recording_wave/  with a waveform image for each recording
					*/
					map = [
                            'baseUrl': baseUrl,
                            'dataFilename' : dataFilename,
							'specFilename': specFilename,
							'audioFilename': audioFilename, 
							'specPath':specPath ,
							'audioPath':audioPath, 
							'dataPath': dataPath,
							'dateTime': acoustic_recordingsList.timeRecordingStart,
                            'calibrationPath': calibrationPath,
                            'calibrationFilename': calibrationFilename,
							'downloadFolderDescripter': downloadFolderDescripter
                    ]
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
