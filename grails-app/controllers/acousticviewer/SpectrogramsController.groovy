package acousticviewer

class SpectrogramsController {

    def index() { }
	
	def list() {
	
		def spectrograms = [
			[uid: '123', url: 'http://i30.tinypic.com/531q3n.jpg', width: '250', date: '24/02/1967 10:24am'],
			[uid: '124', url: 'http://i29.tinypic.com/xp3hns.jpg', width: '190',  date: '25/02/1967 2:24am'],
			[uid: '125', url: 'http://i26.tinypic.com/11l7ls0.jpg', width: '250',  date: '26/02/1967 6:24pm'],
			[uid: '126', url: 'http://i30.tinypic.com/531q3n.jpg', width: '200', date: '24/02/1967 10:24am'],
			[uid: '127', url: 'http://i29.tinypic.com/xp3hns.jpg', width: '170',  date: '25/02/1967 2:24am'],
			[uid: '128', url: 'http://i26.tinypic.com/11l7ls0.jpg', width: '20',  date: '26/02/1967 6:24pm']
			
		]
		
		def model = [
            spectrogramsList: spectrograms//,
            //deployment: 'test deployment'
			// blagh blah
        ]
		render template: "list", model: model	
	
	
	}
}
