package acousticviewer

class DownloadController {
	
	def grailsApplication

    def index() { 
		
		def datetimeHash = params.dateTime.replace(":","").replace("-","")
		def baseDir = grailsApplication.config.baseDirectory
		
		def zipFolder = baseDir + params.downloadFolderDescripter + "/"
		def destFolder = zipFolder + datetimeHash + "/"
		def destFile = baseDir + "/zips/" + params.downloadFolderDescripter + "_" + datetimeHash + ".zip"
		
		try {
			
			new File(destFolder).mkdirs() 

			def ant = new AntBuilder()

			// expecting valid URL's at this stage. User would have already seen errors
			ant.get(src: params.audioUrl, dest: destFolder)
			ant.get(src: params.specUrl, dest: destFolder)
			ant.get(src: params.wavPath, dest: destFolder)

			ant.zip(
			   destfile: destFile,
			   basedir:   destFolder
		   )
		   
			File zipFile = new File(destFile)
			
			if (zipFile.length() > 1){
				response.setHeader("Content-Type", "application/zip") 
				response.setHeader("Content-disposition", "attachment; filename=${zipFile.name}")
				response.outputStream << zipFile.newInputStream()
			}
			else{				
				render text: "ERROR: Problems occurred creating the Zip file. " + e , status: 404		
			}
			
		}
		catch (Exception e) {
			render text: "ERROR: Unable to create the Zip file. " + e , status: 404		
		}
		
	}

}
