package acousticviewer

class DownloadController {
	
	def grailsApplication

    def index() { 
		
		def datetimeHash = params.dateTime.replace(":","").replace("-","")
		def baseDir = grailsApplication.config.baseDirectory 
		
		def downloadFolder = baseDir +  params.downloadFolderDescripter + "/" + datetimeHash + "/"
		def zipFolder =  baseDir +  params.downloadFolderDescripter  + "/zips/" 
		def downloadFile =   zipFolder + datetimeHash + ".zip"
		

		
		//try {
			
			new File(downloadFolder).mkdirs()
			new File(zipFolder).mkdirs()

			def ant = new AntBuilder()

			// expecting valid URL's at this stage. User would have already seen errors			
			ant.get(src: params.audioUrl, ignoreerrors:true,
					dest: downloadFolder + params.audioFilename, 
					verbose:true,
					usetimestamp: true)
			ant.get(src: params.specUrl, ignoreerrors:true,
					dest: downloadFolder + params.specFilename, 
					verbose:true,
					usetimestamp: true)
			ant.get(src: params.wavPath, ignoreerrors:true,
					dest: downloadFolder + params.wavFilename, 
					verbose:true,
					usetimestamp: true)

			ant.zip(
			   destfile: downloadFile,
			   basedir:  downloadFolder
		   )
		   
		   
			File zipFile = new File(downloadFile)
			
			if (zipFile.length() > 1){
				response.setHeader("Content-Type", "application/zip") 
				response.setHeader("Content-disposition", "attachment; filename=${zipFile.name}")
				response.outputStream << zipFile.newInputStream()
			}
			else{				
				render text: "ERROR: Problems occurred creating the Zip file. " //+ e , status: 404		
			}
			
		//}
		//catch (Exception e) {
		//	render text: "ERROR: Unable to create the Zip file. " + e , status: 404		
		//}
		
	}

}
