package acousticviewer

class SpectrogramController {

	
    def index() { }
	
	def list() {
		
		print params.deployment
		def spectrogram
		if (params.deployment == '7') {
			spectrogram = [				
							[uid: 'deployment2_00', url: 'spec_00.png', width: '250', label: '24/02/1967 10:24am'],
							[uid: 'deployment2_01', url: 'test-images/spec_01.png', width: '170',  label: '25/02/1967 2:24am'],
							[uid: 'deployment2_02', url: 'test-images/spec_02.png', width: '600',  label: '26/02/1967 6:24pm'],
							[uid: 'deployment2_03', url: 'test-images/spec_03.png', width: '200', label: '24/02/1967 10:24am'],
							[uid: 'deployment2_04', url: 'test-images/spec_04.png', width: '170',  label: '25/02/1967 2:24am'],
							[uid: 'deployment2_05', url: 'test-images/spec_05.png', width: '20',  label: '26/02/1967 6:24pm'],
							[uid: 'deployment2_06', url: 'test-images/spec_06.png', width: '250', label: '24/02/1967 10:24am'],
							[uid: 'deployment2_07', url: 'test-images/spec_07.png', width: '170',  label: '25/02/1967 2:24am'],
							[uid: 'deployment2_08', url: 'test-images/spec_08.png', width: '200',  label: '26/02/1967 6:24pm'],
							[uid: 'deployment2_09', url: 'test-images/spec_09.png', width: '170',  label: '25/02/1967 2:24am'],
							[uid: 'deployment2_10', url: 'test-images/spec_10.png', width: '200',  label: '26/02/1967 6:24pm'],
							[uid: 'deployment2_11', url: 'test-images/spec_11.png', width: '200',  label: '26/02/1967 6:24pm'],
							[uid: 'deployment2_12', url: 'test-images/spec_12.png', width: '200',  label: '26/02/1967 6:24pm'],
							[uid: 'deployment2_13', url: 'test-images/spec_13.png', width: '200',  label: '26/02/1967 6:24pm'],
							[uid: 'deployment2_14', url: 'test-images/spec_14.png', width: '200',  label: '26/02/1967 6:24pm'],
							[uid: 'deployment2_15', url: 'test-images/spec_15.png', width: '200',  label: '26/02/1967 6:24pm'],
							[uid: 'deployment2_16', url: 'test-images/spec_16.png', width: '200',  label: '26/02/1967 6:24pm']
						]
		}
		else if(params.deployment == '5') {			

			spectrogram = [
				[uid: 'deployment5_00', url: 'test-images/spec_00.png', width: '250', label: '24/02/1967 10:24am'],
				[uid: 'deployment5_01', url: 'test-images/spec_01.png', width: '170',  label: '25/02/1967 2:24am'],
				[uid: 'deployment5_02', url: 'test-images/spec_02.png', width: '15',  label: '26/02/1967 6:24pm'],
				[uid: 'deployment5_03', url: 'test-images/spec_03.png', width: '200', label: '24/02/1967 10:24am'],
				[uid: 'deployment5_04', url: 'test-images/spec_04.png', width: '170',  label: '25/02/1967 2:24am'],
				[uid: 'deployment5_05', url: 'test-images/spec_05.png', width: '20',  label: '26/02/1967 6:24pm'],
				[uid: 'deployment5_06', url: 'test-images/spec_06.png', width: '250', label: '24/02/1967 10:24am'],
				[uid: 'deployment5_07', url: 'test-images/spec_07.png', width: '170',  label: '25/02/1967 2:24am'],
				[uid: 'deployment5_08', url: 'test-images/spec_08.png', width: '200',  label: '26/02/1967 6:24pm'],
				[uid: 'deployment5_09', url: 'test-images/spec_09.png', width: '170',  label: '25/02/1967 2:24am'],
				[uid: 'deployment5_10', url: 'test-images/spec_10.png', width: '200',  label: '26/02/1967 6:24pm'],
				[uid: 'deployment5_11', url: 'test-images/spec_11.png', width: '200',  label: '26/02/1967 6:24pm'],
				[uid: 'deployment5_12', url: 'test-images/spec_12.png', width: '200',  label: '26/02/1967 6:24pm'],
				[uid: 'deployment5_13', url: 'test-images/spec_13.png', width: '200',  label: '26/02/1967 6:24pm'],
				[uid: 'deployment5_14', url: 'test-images/spec_14.png', width: '200',  label: '26/02/1967 6:24pm'],
				[uid: 'deployment5_15', url: 'test-images/spec_15.png', width: '200',  label: '26/02/1967 6:24pm'],
				[uid: 'deployment5_16', url: 'test-images/spec_16.png', width: '200',  label: '26/02/1967 6:24pm']

			]
		}
		else {			

			spectrogram = [
				[uid: 'spec_00', url: 'test-images/spec_00.png', width: '250', label: '24/02/1967 10:24am'],
				[uid: 'spec_01', url: 'test-images/spec_01.png', width: '170',  label: '25/02/1967 2:24am'],
				[uid: 'spec_02', url: 'test-images/spec_02.png', width: '15',  label: '26/02/1967 6:24pm'],
				[uid: 'spec_03', url: 'test-images/spec_03.png', width: '200', label: '24/02/1967 10:24am']

			]
		}
		
		def model = [
            spectrogramList: spectrogram
        ]
		render template: "list", model: model	
	
	
	}
}
