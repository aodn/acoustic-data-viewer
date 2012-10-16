package acousticviewer

/*import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.regex.Pattern
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream*/
//import org.codehaus.groovy.grails.

class DownloadController {
	
	

    def index() { 
		println params.dump()
		
		def datetimeHash = params.dateTime.replace(":","").replace("-","")
		def baseDir = "/tmp/acousticViewerDownloads/"
		
		def zipFolder = baseDir + params.downloadFolderDescripter + "/"
		def destFolder = zipFolder + datetimeHash + "/"
		def destFile = baseDir + "/zips/" + params.downloadFolderDescripter + "_" + datetimeHash + ".zip"
		
		//try {
			
			new File(destFolder).mkdirs() 

			def ant = new AntBuilder()

			// expecting valid URL's at this stage. User would have already seen errors
			ant.get(src: params.audioUrl, dest: destFolder)
			ant.get(src: params.specUrl, dest: destFolder)
			ant.get(src: params.wavPath, dest: destFolder)

			ant.zip(
			   destfile: destFile,
			   include(name: '**/*.zip'),
			   basedir:   destFolder
		   )
		   
		    //def filePath = zipFolder + destFolder + ".zip"
			File zipFile = new File(destFile	)
			
			if (zipFile.length() > 1){
				response.setHeader("Content-Type", "application/zip") 
				response.setHeader("Content-disposition", "attachment; filename=${zipFile.name}")
				response.outputStream << zipFile.newInputStream()
				//render zipFile

			}
			else{
				
				render text: "ERROR: Problems occurred creating the Zip file. " + e , status: 404		
			}

			
		/*}
		catch (Exception e) {
			render text: "ERROR: Unable to create the Zip file. " + e , status: 404		
		}
		*/

		
	}
	
	/*
	def download(address)
	{
		def file = new FileOutputStream(address.tokenize("/")[-1])
		def out = new BufferedOutputStream(file)
		out << new URL(address).openStream()
		out.close()
	}
	*/
}
