/*
 * Copyright 2013 IMOS
 *
 * The AODN/IMOS Portal is distributed under the terms of the GNU General Public License
 *
 */

grails.project.dependency.resolver = "maven"
grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
//grails.project.work.dir = "target"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenLocal()
        mavenCentral()

        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        mavenRepo "https://mvnrepository.com/artifact"
        mavenRepo "http://repo.grails.org/grails/core"
        mavenRepo "http://repo.grails.org/grails/plugins"
        mavenRepo "https://repo.grails.org/grails/plugins"
    }
    dependencies {
		// Workarounds for Grails not shipping ant in WAR
		compile 'org.apache.ant:ant:1.8.4'
		compile 'org.apache.ant:ant-launcher:1.8.4'

        compile "cglib:cglib:2.2.2"
    }

    plugins {
        compile ":hibernate4:4.3.4"
        build   ":tomcat8:8.0.5"
    }
}
