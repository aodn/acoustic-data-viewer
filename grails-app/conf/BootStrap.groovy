import grails.converters.JSON
import acousticviewer.Acoustic_Spectrograms

class BootStrap {

    def init = { servletContext ->
		
		/*JSON.registerObjectMarshaller(Acoustic_Spectrograms) {
            def returnArray = [:]
            returnArray['timeStart'] = it.timeStart
            returnArray['filename'] = it.filename
            return returnArray
        }*/
		
    }
    def destroy = {
    }
}
