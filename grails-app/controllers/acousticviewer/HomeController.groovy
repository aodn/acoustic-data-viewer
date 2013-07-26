/*
 * Copyright 2013 IMOS
 *
 * The AODN/IMOS Portal is distributed under the terms of the GNU General Public License
 *
 */

package acousticviewer

class HomeController {
	
	def grailsApplication
	
    def index() {		
		def deployments = Acoustic_Deployments.findAllByIsPrimaryAndDataPathIsNotNull(true, [ sort:"deploymentName", order:"asc"])
		
		[deployments: deployments, config: grailsApplication.config]
	}
}
