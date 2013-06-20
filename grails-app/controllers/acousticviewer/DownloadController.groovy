package acousticviewer

class DownloadController {
	
	def grailsApplication

    def index() { 
		
		def datetimeHash = params.dateTime.replace(":","").replace("-","")
		def baseDir = grailsApplication.config.baseDirectory

        def downloadFolder = baseDir +  params.downloadFolderDescripter + "/" + datetimeHash + "/"

		def zipFolder    =  baseDir +  params.downloadFolderDescripter  + "/zips/"
		def downloadFile =  zipFolder + "IMOS_ANMN-PA_A_" + datetimeHash + "_" + params.downloadFolderDescripter + ".zip"
		

		
		try {

			new File(downloadFolder).mkdirs()
			new File(zipFolder).mkdirs()

			def ant = new AntBuilder()

			// expecting valid PATH's at this stage. User would have already seen errors
			ant.get(src: params.baseUrl + params.audioPath, ignoreerrors:true,
					dest: downloadFolder + params.audioFilename,
					verbose:true,
					usetimestamp: true)
			ant.get(src: params.baseUrl + params.specPath, ignoreerrors:true,
					dest: downloadFolder + params.specFilename,
					verbose:true,
					usetimestamp: true)
            ant.get(src: params.baseUrl + params.dataPath, ignoreerrors:true,
                    dest: downloadFolder + params.dataFilename,
                    verbose:true,
                    usetimestamp: true)

            ant.get(src: params.baseUrl + params.calibrationPath, ignoreerrors:true,
                    dest: downloadFolder + params.calibrationFilename,
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
                render status: 503, text: "ERROR: Problems occurred creating the Zip file. " + e
			}
			
		}
		catch (Exception e) {
			render status: 503, text: "ERROR: Unable to create the Zip file. " + e
		}
		
	}

}
