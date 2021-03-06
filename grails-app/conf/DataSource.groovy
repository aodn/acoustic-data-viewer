
/*
 * Copyright 2013 IMOS
 *
 * The AODN/IMOS Portal is distributed under the terms of the GNU General Public License
 *
 */

dataSource {
    pooled = true
			
    //configure DBCP to test connections before using them and evict old connections (as per http://sacharya.com/grails-dbcp-stale-connections/)
    properties {
	minEvictableIdleTimeMillis=1800000
	timeBetweenEvictionRunsMillis=1800000
	numTestsPerEvictionRun=3
    }
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}

// environment specific settings
environments {
	
    development {
	    dataSource {
            driverClassName = "org.postgresql.Driver"
            //dbCreate = "update"
            url = "jdbc:postgresql://localhost:5432/acoustic_data_viewer"
            username = "postgres"
            password = "postgres"
	    }
    }
	
    test {
        dataSource {
            driverClassName = "org.h2.Driver"
            dbCreate = "create-drop"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE"
        }
    }

    production {
	    dataSource {
	        jndiName = "java:comp/env/jdbc/acoustic_data_viewer"
	    }
    }
}
