package acousticviewer

class HomeController {
	
	def grailsApplication
	
    def index() {		
		def deployments = Acoustic_Deployments.findAllByIsPrimaryAndDataPathIsNotNull(true)
		
		[deployments: deployments, config: grailsApplication.config]
	}
}
