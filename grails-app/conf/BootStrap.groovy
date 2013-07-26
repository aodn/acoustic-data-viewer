/*
 * Copyright 2013 IMOS
 *
 * The AODN/IMOS Portal is distributed under the terms of the GNU General Public License
 *
 */

import grails.converters.JSON
import acousticviewer.Acoustic_Spectrograms

class BootStrap {

    def init = { servletContext ->

		TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }
    def destroy = {
    }
}
