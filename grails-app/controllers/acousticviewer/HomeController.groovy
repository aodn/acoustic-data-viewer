package acousticviewer

class HomeController {

    def index() {
	
		[sites: Anmn_Acoustic_Sites.list()]
	}
}
