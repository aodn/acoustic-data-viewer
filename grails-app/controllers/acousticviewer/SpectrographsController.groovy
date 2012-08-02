package acousticviewer

class SpectrographsController {

	
    def index() { }
	
	def list() {
		
		print params.site
		def spectrographs
		if (params.site == '7') {
			spectrographs = [				
							[uid: 'site2_00', url: 'test-images/spec_00.png', width: '250', date: '24/02/1967 10:24am'],
							[uid: 'site2_01', url: 'test-images/spec_01.png', width: '170',  date: '25/02/1967 2:24am'],
							[uid: 'site2_02', url: 'test-images/spec_02.png', width: '15',  date: '26/02/1967 6:24pm'],
							[uid: 'site2_03', url: 'test-images/spec_03.png', width: '200', date: '24/02/1967 10:24am'],
							[uid: 'site2_04', url: 'test-images/spec_04.png', width: '170',  date: '25/02/1967 2:24am'],
							[uid: 'site2_05', url: 'test-images/spec_05.png', width: '20',  date: '26/02/1967 6:24pm'],
							[uid: 'site2_06', url: 'test-images/spec_06.png', width: '250', date: '24/02/1967 10:24am'],
							[uid: 'site2_07', url: 'test-images/spec_07.png', width: '170',  date: '25/02/1967 2:24am'],
							[uid: 'site2_08', url: 'test-images/spec_08.png', width: '200',  date: '26/02/1967 6:24pm'],
							[uid: 'site2_09', url: 'test-images/spec_09.png', width: '170',  date: '25/02/1967 2:24am'],
							[uid: 'site2_10', url: 'test-images/spec_10.png', width: '200',  date: '26/02/1967 6:24pm'],
							[uid: 'site2_11', url: 'test-images/spec_11.png', width: '200',  date: '26/02/1967 6:24pm'],
							[uid: 'site2_12', url: 'test-images/spec_12.png', width: '200',  date: '26/02/1967 6:24pm'],
							[uid: 'site2_13', url: 'test-images/spec_13.png', width: '200',  date: '26/02/1967 6:24pm'],
							[uid: 'site2_14', url: 'test-images/spec_14.png', width: '200',  date: '26/02/1967 6:24pm'],
							[uid: 'site2_15', url: 'test-images/spec_15.png', width: '200',  date: '26/02/1967 6:24pm'],
							[uid: 'site2_16', url: 'test-images/spec_16.png', width: '200',  date: '26/02/1967 6:24pm']
						]
		}
		else if(params.site == '5') {			

			spectrographs = [
				[uid: 'site5_00', url: 'test-images/spec_00.png', width: '250', date: '24/02/1967 10:24am'],
				[uid: 'site5_01', url: 'test-images/spec_01.png', width: '170',  date: '25/02/1967 2:24am'],
				[uid: 'site5_02', url: 'test-images/spec_02.png', width: '15',  date: '26/02/1967 6:24pm'],
				[uid: 'site5_03', url: 'test-images/spec_03.png', width: '200', date: '24/02/1967 10:24am'],
				[uid: 'site5_04', url: 'test-images/spec_04.png', width: '170',  date: '25/02/1967 2:24am'],
				[uid: 'site5_05', url: 'test-images/spec_05.png', width: '20',  date: '26/02/1967 6:24pm'],
				[uid: 'site5_06', url: 'test-images/spec_06.png', width: '250', date: '24/02/1967 10:24am'],
				[uid: 'site5_07', url: 'test-images/spec_07.png', width: '170',  date: '25/02/1967 2:24am'],
				[uid: 'site5_08', url: 'test-images/spec_08.png', width: '200',  date: '26/02/1967 6:24pm'],
				[uid: 'site5_09', url: 'test-images/spec_09.png', width: '170',  date: '25/02/1967 2:24am'],
				[uid: 'site5_10', url: 'test-images/spec_10.png', width: '200',  date: '26/02/1967 6:24pm'],
				[uid: 'site5_11', url: 'test-images/spec_11.png', width: '200',  date: '26/02/1967 6:24pm'],
				[uid: 'site5_12', url: 'test-images/spec_12.png', width: '200',  date: '26/02/1967 6:24pm'],
				[uid: 'site5_13', url: 'test-images/spec_13.png', width: '200',  date: '26/02/1967 6:24pm'],
				[uid: 'site5_14', url: 'test-images/spec_14.png', width: '200',  date: '26/02/1967 6:24pm'],
				[uid: 'site5_15', url: 'test-images/spec_15.png', width: '200',  date: '26/02/1967 6:24pm'],
				[uid: 'site5_16', url: 'test-images/spec_16.png', width: '200',  date: '26/02/1967 6:24pm']

			]
		}
		else {			

			spectrographs = [
				[uid: 'spec_00', url: 'test-images/spec_00.png', width: '250', date: '24/02/1967 10:24am'],
				[uid: 'spec_01', url: 'test-images/spec_01.png', width: '170',  date: '25/02/1967 2:24am'],
				[uid: 'spec_02', url: 'test-images/spec_02.png', width: '15',  date: '26/02/1967 6:24pm'],
				[uid: 'spec_03', url: 'test-images/spec_03.png', width: '200', date: '24/02/1967 10:24am']

			]
		}
		
		def model = [
            spectrographsList: spectrographs
        ]
		render template: "list", model: model	
	
	
	}
}
