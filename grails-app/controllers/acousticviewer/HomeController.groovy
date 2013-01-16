package acousticviewer

class HomeController {
	
	def grailsApplication
	
    def index() {		
		def deployments = Acoustic_Deployments.findAllByIsPrimaryAndDataPathIsNotNull(true, [ sort:"deploymentName", order:"asc"])
		
		[deployments: deployments, config: grailsApplication.config]
	}
}
