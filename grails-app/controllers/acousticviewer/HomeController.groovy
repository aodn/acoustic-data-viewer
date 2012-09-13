package acousticviewer

class HomeController {

    def index() {
	
		[deployments: Acoustic_Deployments.list()]
	}
}
