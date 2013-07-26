/*
 * Copyright 2013 IMOS
 *
 * The AODN/IMOS Portal is distributed under the terms of the GNU General Public License
 *
 */

package acousticviewer

class Acoustic_Recordings {

	Long id
	String filename
	Integer xCoord
	Integer acousticSpecFk
	Date timeRecordingStart
	
	
	/*  pkid bigint NOT NULL DEFAULT nextval('anmn.anmn_acoustic_recordings_pkid_seq'::regclass),
  filename character(30) NOT NULL,
  x_coord integer,
  acoustic_spec_fk integer NOT NULL,
  time_recording_start timestamp with time zone NOT NULL,
  */
 
   transient beforeInsert = {
      throw new RuntimeException('create not allowed')
   }
   transient beforeUpdate = {
      throw new RuntimeException('update not allowed')
   }
   transient beforeDelete = {
      throw new RuntimeException('delete not allowed')
   }
   
   static mapping = {
      cache usage: 'read-only'
      version false
	  table 'acoustic_Recordings'
      id    column:'pkid', generator:'sequence', params:[sequence:'anmn_acoustic_recordings_pkid_seq']     

   } 
   
    static constraints = {
    }
}
