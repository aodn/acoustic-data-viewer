package acousticviewer

class HomeController {
	
	def grailsApplication
	
    def index() {				
		[deployments: Acoustic_Deployments.findByIsPrimary(true), config: grailsApplication.config]
	}
}
