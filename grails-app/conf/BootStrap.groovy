import grails.converters.JSON
import acousticviewer.Acoustic_Spectrograms

class BootStrap {

    def init = { servletContext ->

		TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }
    def destroy = {
    }
}
