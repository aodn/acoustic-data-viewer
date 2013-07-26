/*
 * Copyright 2013 IMOS
 *
 * The AODN/IMOS Portal is distributed under the terms of the GNU General Public License
 *
 */

package acousticviewer


import groovyx.net.http.*
import org.cyberneko.html.parsers.SAXParser


class HelpPageProxyController {

    def grailsApplication

    def index() {
        try {
            def html = grailsApplication.config.helpPageUrl.toURL().text
            render html
        } catch (IOException e) {
            render status: 404
        }
    }
}
