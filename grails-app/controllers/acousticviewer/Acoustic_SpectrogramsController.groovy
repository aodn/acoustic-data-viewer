/*
 * Copyright 2013 IMOS
 *
 * The AODN/IMOS Portal is distributed under the terms of the GNU General Public License
 *
 */

package acousticviewer
import grails.converters.JSON

class Acoustic_SpectrogramsController {

	
    def index() { }
	
	def list() {
		
		
		def spectrograms
		def deployment			
			
		if (params.deployment == 'init') {
			render template: "emptyStepcarouselBelt"
		}
		else {			

			spectrograms = Acoustic_Spectrograms.findAllByAcousticDeployFk(params.deployment) 			
			deployment = Acoustic_Deployments.get(params.deployment as int)
			def model = [
				spectrogramList: spectrograms, deployment: deployment
			]
			render template: "list", model: model	
		}
		
	
	}
	def listasJSON() {
		def spectrograms
		def deployment			
			
		if (params.deployment != "")	{

			spectrograms = Acoustic_Spectrograms.findAllByAcousticDeployFk(params.deployment) 			
			deployment = Acoustic_Deployments.get(params.deployment as int)
			def model = [
				spectrogramList: spectrograms, deployment: deployment
			]
			render  model	as JSON
		}
		
		
	}
}
