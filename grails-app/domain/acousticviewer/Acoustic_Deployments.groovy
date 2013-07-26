/*
 * Copyright 2013 IMOS
 *
 * The AODN/IMOS Portal is distributed under the terms of the GNU General Public License
 *
 */

package acousticviewer
import java.text.SimpleDateFormat

class Acoustic_Deployments {

	Integer id
	Integer curtinId
	String siteCode
	String loggerId
	String deploymentName
	Boolean isPrimary
	Date timeDeploymentStart
	Date timeDeploymentEnd
	String dataPath
	
	// this will stop writing to DB table. 
	/*
   transient beforeInsert = {
      throw new RuntimeException('create not allowed')
   }
   transient beforeUpdate = {
      throw new RuntimeException('update not allowed')
   }
   transient beforeDelete = {
      throw new RuntimeException('delete not allowed')
   }
   */


   static mapping = {
      cache usage: 'read-only'
      version false
	  table 'acoustic_deployments'
      id    column:'pkid', generator:'sequence', params:[sequence:'anmn_acoustic_deployments_pkid_seq']     

   } 
   def getStartTime() {
        return new SimpleDateFormat('dd-MM-yyyy').format(this.timeDeploymentStart);
    }

   String toString() {
	   return deploymentName + " - " +  getStartTime()
   }
   
}
