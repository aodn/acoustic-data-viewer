import javax.naming.InitialContext

/*
 * Copyright 2013 IMOS
 *
 * The AODN/IMOS Portal is distributed under the terms of the GNU General Public License
 *
 */

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    xml:           ['text/xml', 'application/xml']
]

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
    development {
        grails.logging.jul.usebridge = true

        // Google Analytics
        googleAnalytics.trackingId = null
		
    }
    production {
        grails.logging.jul.usebridge = false
        grails.serverURL = "https://acoustic.aodn.org.au"
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console appender:
    //
    appenders {
		//    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
		
		//disable stacktrace file
		'null' name:'stacktrace'
    }

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}

/*
	project config items
*/

specImageHeight = "240"
carouselHeight = "275"
specDetailedImageHeight = "300"
baseDirectory = "/tmp/acousticViewerDownloads/" // add a forward slash
helpPageUrl = "https://help.aodn.org.au/aodn-data-tools/acoustic-data-viewer/";
dataExtension = ".DAT";


if(!grails.config.locations || !(grails.config.locations instanceof List)) {
    grails.config.locations = []
}

try {
    configurationPath = new InitialContext().lookup("java:comp/env/aodn.configuration")
    grails.config.locations << "file:${configurationPath}"
}
catch (e) {
}

// If configurationPath unset, fall back to default path
defaultConfigPath =  "/etc/aodn-config/AcousticDataViewer.groovy"
defaultConfigExists = new File(defaultConfigPath).exists()
if (!configurationPath && defaultConfigExists) {
    grails.config.locations << "file:${defaultConfigPath}"
    println "Loading external config from '$defaultConfigPath'..."
} else {
    println "Not loading external config from '$defaultConfigPath'..."
}
